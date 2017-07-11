package com.kermit.lin.newlearn.module.bangumi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.module.bangumi.bean.DetailsRecommend;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lin on 2017/5/26.
 */

public class InduceAdapter extends RecyclerView.Adapter<InduceAdapter.InduceViewHolder>{
    private Context mContext;
    private  List<DetailsRecommend.ResultBean.ListBean> recommendList;
    public InduceAdapter(Context mContext, List<DetailsRecommend.ResultBean.ListBean> recommendList) {
        this.mContext = mContext;
        this.recommendList = recommendList;
    }

    @Override
    public InduceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_bangumi_item,null);
        return new InduceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InduceViewHolder holder, int position) {

        if (recommendList.size()>0&& recommendList!=null){

            Glide.with(mContext).load(recommendList.get(position).getCover()).into(holder.icon);
            holder.itemPlay.setText(recommendList.get(position).getFollow()+"人追番");
            holder.itemTitle.setText(recommendList.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    public class InduceViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item)
        ImageView icon;
        @BindView(R.id.item_play)
        TextView itemPlay;
        @BindView(R.id.item_title)
        TextView itemTitle;

        public InduceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
