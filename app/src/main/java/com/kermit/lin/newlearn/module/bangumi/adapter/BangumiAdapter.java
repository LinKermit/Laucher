package com.kermit.lin.newlearn.module.bangumi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.module.bangumi.BangumiDetailActivity;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiHomeInfo;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lin on 2017/5/24.
 */

public class BangumiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //番剧页Banner
    private static final int TYPE_BANNER = 0;
    //番剧分类入口
    private static final int TYPE_ENTRANCE = 1;

    //新番连载
    private static final int TYPE_ITEM = 2;

    //番剧标题
    private static final int TYPE_HEAD = 3;
    //番剧推荐
    private static final int TYPE_RECOMMOND = 4;

    private Context mContext;
    private BangumiHomeInfo.ResultBean resultBean;

    public BangumiAdapter(Context mContext,BangumiHomeInfo.ResultBean resultBean) {
        this.mContext = mContext;
        this.resultBean = resultBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_BANNER:
                view = View.inflate(mContext, R.layout.item_recommend_banner, null);
                return new BannerViewHolder(view);
            case TYPE_ENTRANCE:
                view = View.inflate(mContext, R.layout.item_bangumi_entrance, null);
                return new EntranceViewHolder(view);
            case TYPE_HEAD:
                view = View.inflate(mContext, R.layout.item_bangumi_head, null);
                return new HeadViewHolder(view);
            case TYPE_ITEM:
                view = View.inflate(mContext, R.layout.item_bangumi_item, null);
                return new ItemViewHolder(view);
            case TYPE_RECOMMOND:
                view = View.inflate(mContext, R.layout.item_bangumi_recommond, null);
                return new RecommondHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder){
            BannerViewHolder holder0 = (BannerViewHolder) holder;
            final List<String> imageUrls = new ArrayList<>();
            for (int i=0; i< resultBean.getAd().getHead().size(); i++){
                String imageUrl = resultBean.getAd().getHead().get(i).getImg();
                imageUrls.add(imageUrl);
            }
            holder0.banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
            holder0.banner.setBannerAnimation(Transformer.Accordion);
            holder0.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(mContext).load(path)
                            .into(imageView);
                }
            });
            holder0.banner.setImages(imageUrls);
            holder0.banner.start();

        }else if (holder instanceof EntranceViewHolder){
            EntranceViewHolder holder1 = (EntranceViewHolder) holder;
            holder1.itemBang1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"zhuifan",Toast.LENGTH_SHORT).show();
                }
            });
        }else if (holder instanceof HeadViewHolder){
            HeadViewHolder holder2 = (HeadViewHolder) holder;
            if (position != 2){
                holder2.iv_head.setImageResource(R.drawable.bangumi_home_ic_season_1);
                holder2.head_left.setText(resultBean.getPrevious().getSeason()+"月新番");
                holder2.head_right.setText("分季新番");
            }
        }else if (holder instanceof ItemViewHolder){
            ItemViewHolder holder3 = (ItemViewHolder) holder;
            if (position>2&&position<(4 + resultBean.getSerializing().size())){
                final int total = position - 3;
                Glide.with(mContext).load(resultBean.getSerializing().get(total).getCover()).into(holder3.item_icon);
                holder3.item_play.setText(resultBean.getSerializing().get(total).getWatching_count()+"人在看");
                holder3.item_title.setText(resultBean.getSerializing().get(total).getTitle());
                //番剧详情界面
                holder3.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,BangumiDetailActivity.class);
                        intent.putExtra("title",resultBean.getSerializing().get(total).getTitle());
                        mContext.startActivity(intent);
                    }
                });
            }else {
                int total = position - 4 - resultBean.getSerializing().size();

                Glide.with(mContext).load(resultBean.getPrevious().getList().get(total).getCover()).into(holder3.item_icon);
                holder3.item_play.setText(resultBean.getPrevious().getList().get(total).getFavourites()+"人在追番");
                holder3.item_title.setText(resultBean.getPrevious().getList().get(total).getTitle());
            }

        }else {
            RecommondHolder holder4 = (RecommondHolder) holder;
            BangumiItemAdapter itemAdapter = new BangumiItemAdapter(mContext,resultBean);
            holder4.recyclerView.setNestedScrollingEnabled(false);//解决在子recyclerView滑动刷新问题
            holder4.recyclerView.setAdapter(itemAdapter);
            LinearLayoutManager manager = new LinearLayoutManager(mContext);
            holder4.recyclerView.setLayoutManager(manager);
        }
    }

    @Override
    public int getItemCount() {//1+1+2个head
        return 4 +resultBean.getSerializing().size()+resultBean.getPrevious().getList().size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_BANNER;
        }else if (position == 1){
            return TYPE_ENTRANCE;
        }else if (isHead(position)){//posion =2
            return TYPE_HEAD;
        }else if (position > 2 && position< (4+resultBean.getSerializing().size()+resultBean.getPrevious().getList().size())){
            return TYPE_ITEM;
        }else {
            return TYPE_RECOMMOND;
        }
    }

    private boolean isHead(int pos) {
        if (pos == 2 ){
            return true;
        }if (pos == 3 +resultBean.getSerializing().size()){
            return true;
        }
        return false;
    }


    class BannerViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.banner)
        Banner banner;
        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    class EntranceViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_bangumi1)
        TextView itemBang1;
        @BindView(R.id.tv_bangumi2)
        TextView itemBang2;
        @BindView(R.id.tv_bangumi3)
        TextView itemBang3;
        public EntranceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class HeadViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_bangumi_head)
        ImageView iv_head;
        @BindView(R.id.tv_bangumi_head_left)
        TextView head_left;
        @BindView(R.id.tv_bangumi_head_right)
        TextView head_right;
        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item)
        ImageView item_icon;
        @BindView(R.id.item_play)
        TextView item_play;
        @BindView(R.id.item_title)
        TextView item_title;
        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class RecommondHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.home_bangumi_recommend_recycler)
        RecyclerView recyclerView;
        public RecommondHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }



    /**
     * 返回每行多少列，有2列和5列，所以总数为10
     * @param pos
     * @return
     */
    public int getSpanSize(int pos) {

        int viewType = getItemViewType(pos);
        switch (viewType) {
            case TYPE_ITEM:
                return 1;
            case TYPE_RECOMMOND:
                return 3;
            default:
                return 3;
        }
    }
}
