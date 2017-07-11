package com.kermit.lin.newlearn.module.bangumi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.module.bangumi.bean.DetailsRecommend;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lin on 2017/5/26.
 */

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static int TYPE_NOTICE = 0;
    private static int TYPE_MORE = 1;
    private static int TYPE_BODY = 2;

    private Context mContext;
    private List<DetailsRecommend.ResultBean.ListBean> recommendList;
    public CommentAdapter(Context mContext, List<DetailsRecommend.ResultBean.ListBean> recommendList) {
        this.mContext = mContext;
        this.recommendList = recommendList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_bangumi_item,null);
        return new ComViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    public class ComViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item)
        ImageView icon;
        @BindView(R.id.item_play)
        TextView itemPlay;
        @BindView(R.id.item_title)
        TextView itemTitle;

        public ComViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
