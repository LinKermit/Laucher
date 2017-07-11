package com.kermit.lin.newlearn.module.bangumi.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiDetailsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lin on 2017/5/26.
 */

public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.SeleViewHolder>{
    private Context mContext;
    private List<BangumiDetailsBean.ResultBean.EpisodesBean> episodes;

    private int currentPosition = 0;
    public SelectionAdapter(Context mContext,List<BangumiDetailsBean.ResultBean.EpisodesBean> episodes){
        this.mContext = mContext;
        this.episodes = episodes;
    }
    @Override
    public SeleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_bangumi_detail_selection,null);
        return new SeleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SeleViewHolder holder, final int position) {
        if (episodes.size()>0 && episodes!=null){
            holder.title.setText("第"+episodes.get(episodes.size()-position-1).getIndex()+"话");
            holder.content.setText(episodes.get(episodes.size()-position-1).getIndex_title());

            if (position == currentPosition){
                holder.mCardView.setForeground(
                        mContext.getResources().getDrawable(R.drawable.shape_red_bg));
                holder.title.setTextColor(
                        mContext.getResources().getColor(R.color.colorAccent));
                holder.content.setTextColor(
                        mContext.getResources().getColor(R.color.colorAccent));
            }else {
                holder.mCardView.setForeground(
                        mContext.getResources().getDrawable(R.drawable.shape_white_bg));
                holder.title.setTextColor(
                        mContext.getResources().getColor(R.color.black_light));
                holder.content.setTextColor(
                        mContext.getResources().getColor(R.color.black_40));
            }
            if (onItemClickListner!=null){
                holder.mCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListner.onItemClick(position);
                    }
                });
            }
        }
    }

    public void getPosition(int position){
        currentPosition = position;//写个接口，当点击cardview，将当前位置传入，并刷新适配器
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public class SeleViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_content)
        TextView content;
        @BindView(R.id.card_view)
        CardView mCardView;
        public SeleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface OnItemClickListner{//1、定义一个接口和方法
        public void onItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    OnItemClickListner onItemClickListner;//2、初始化接口
}
