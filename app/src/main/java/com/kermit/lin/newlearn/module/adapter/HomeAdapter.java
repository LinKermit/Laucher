package com.kermit.lin.newlearn.module.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.bean.ImageInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lin on 2017/7/5.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<ImageInfo.ResultsBean> resultsBeen;

    public HomeAdapter(Context mContext, List<ImageInfo.ResultsBean> resultsBeen) {
        this.mContext = mContext;
        this.resultsBeen = resultsBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_home,null);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ImageViewHolder){
            ImageInfo.ResultsBean resultData = resultsBeen.get(position);
            ImageViewHolder holder1 = (ImageViewHolder) holder;
            Glide.with(mContext).load(resultData.getUrl()).into(holder1.mImage);
            holder1.mShowTime.setText(resultData.getDesc());

            holder1.mImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return resultsBeen.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardView)
        CardView mCardView;
        @BindView(R.id.iv_home_item)
        ImageView mImage;
        @BindView(R.id.iv_collection)
        ImageView mCollect;
        @BindView(R.id.tv_ShowTime)
        TextView mShowTime;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    OnItemClickListener onItemClickListener;
}
