package com.kermit.lin.newlearn.module.bangumi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiHomeInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lin on 2017/5/24.
 */

public class BangumiItemAdapter extends RecyclerView.Adapter<BangumiItemAdapter.ItemViewHolder> {

    private Context mContext;
    private BangumiHomeInfo.ResultBean resultBean;

    public BangumiItemAdapter(Context mContext,BangumiHomeInfo.ResultBean resultBean) {
        this.mContext = mContext;
        this.resultBean = resultBean;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_bangumi_recyclerview,null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (resultBean!= null){
            Glide.with(mContext).load(resultBean.getSerializing().get(position).getCover()).into(holder.imageView);
            holder.title.setText(resultBean.getSerializing().get(position).getTitle());
            holder.des.setText("更新到第"+resultBean.getSerializing().get(position).getSeason_status()+"话");
        }
    }

    @Override
    public int getItemCount() {
        return resultBean.getSerializing().size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_rec_icom)
        ImageView imageView;
        @BindView(R.id.tv_rec_title)
        TextView title;
        @BindView(R.id.tv_rec_des)
        TextView des;
        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
