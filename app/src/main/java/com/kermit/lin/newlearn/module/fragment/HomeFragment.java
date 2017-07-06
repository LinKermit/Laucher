package com.kermit.lin.newlearn.module.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.activity.ImageSelectActivity;
import com.kermit.lin.newlearn.api.RetrofitHelper;
import com.kermit.lin.newlearn.base.RxLazyFragment;
import com.kermit.lin.newlearn.bean.ImageInfo;
import com.kermit.lin.newlearn.module.adapter.HomeAdapter;
import com.kermit.lin.newlearn.weight.CustomEmptyView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Lin on 2017/5/18.
 * 主界面分区界面
 */

public class HomeFragment extends RxLazyFragment {

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recycler_home)
    RecyclerView mRecyclerView;

    @BindView(R.id.customEmpty_view)
    CustomEmptyView mCustomEmptyView;

    private static final String TAG = "HomeFragment";
    private HomeAdapter adapter;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void finishCreateView(Bundle state) {
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        if (!isPrepared || !isVisible) {
            return;
        }
        isPrepared = false;
        /**
         * 开始初始化数据
         */
        initSwipeRefresh();
    }

    //初始化刷新
    private void initSwipeRefresh() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                loadData();
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    //初始化RecyclerView
    private void setmRecyclerView() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(mContext, ImageSelectActivity.class);
                intent.putStringArrayListExtra("imageUrls", (ArrayList<String>) imageUrls);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    List<ImageInfo.ResultsBean> resultsBeen = new ArrayList<>();

    @Override
    public void loadData() {
        RetrofitHelper.getGankApi().getImageInfo()
                .compose(this.<ImageInfo>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ImageInfo>() {
                    @Override
                    public void call(ImageInfo imageInfo) {
                        resultsBeen = imageInfo.getResults();
                        finishTask();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        showEmptyView();
                    }
                });
    }

    private List<String> imageUrls = new ArrayList<>();
    @Override
    public void finishTask() {
        hideEmptyView();
        adapter = new HomeAdapter(mContext,resultsBeen);
        for (int i =0; i<resultsBeen.size();i++){
            String imageUrl = new String();
            imageUrl = resultsBeen.get(i).getUrl();
            imageUrls.add(imageUrl);
        }
        setmRecyclerView();
    }


    //数据加载失败
    private void showEmptyView() {
        mSwipeRefreshLayout.setRefreshing(false);
        mRecyclerView.setVisibility(View.GONE);
        mCustomEmptyView.setVisibility(View.VISIBLE);
        mCustomEmptyView.setEmptyImage(R.drawable.home_view);
        mCustomEmptyView.setEmptyText("No Data!!");
    }

    public void hideEmptyView() {
        mSwipeRefreshLayout.setRefreshing(false);
        mCustomEmptyView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }
}
