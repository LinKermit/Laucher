package com.kermit.lin.newlearn.module.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.api.RetrofitHelper;
import com.kermit.lin.newlearn.base.RxLazyFragment;
import com.kermit.lin.newlearn.module.bangumi.adapter.BangumiAdapter;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiHomeInfo;
import com.kermit.lin.newlearn.utils.Settings;
import com.kermit.lin.newlearn.weight.CustomEmptyView;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Lin on 2017/5/18.
 * 首页番剧界面
 */

public class BangumiFragment extends RxLazyFragment {
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.rec_bang)
    RecyclerView mRecyclerView;

    @BindView(R.id.empty_view)
    CustomEmptyView emptyView;

    private static final String TAG = "BangumiFragment";
    public static BangumiFragment newInstance(){
        return new BangumiFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_bangumi;
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
        initSwipeRefresh();
        initRecyclerView();
        isPrepared = false;
    }

    private void initRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(mContext,3);
        mRecyclerView.setLayoutManager(manager);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getSpanSize(position);
            }
        });
    }

    private void initSwipeRefresh() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        if (Settings.auto_refresh){
            mSwipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshLayout.setRefreshing(true);
                    loadData();
                }
            });
        }else {
            //从本地加载数据，如果没有，显示emptyView
            showEmptyView();
        }
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    private BangumiHomeInfo.ResultBean resultBean = new BangumiHomeInfo.ResultBean();
    @Override
    public void loadData() {
        super.loadData();
        RetrofitHelper.getBangumiHomeApi().getBangumiHomeInfo()
                .compose(this.<BangumiHomeInfo>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BangumiHomeInfo>() {
                    @Override
                    public void call(BangumiHomeInfo bangumiHomeInfo) {
                        resultBean = bangumiHomeInfo.getResult();
                        finishTask();
                    }
                }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                showEmptyView();
            }
        });
    }

    private BangumiAdapter adapter;
    @Override
    public void finishTask() {
        super.finishTask();
        hideEmptyView();
        mSwipeRefreshLayout.setRefreshing(false);
        adapter = new BangumiAdapter(mContext,resultBean);
        mRecyclerView.setAdapter(adapter);
    }


    /**
     * 数据加载失败
     */
    private void showEmptyView() {
        mSwipeRefreshLayout.setRefreshing(false);
        mRecyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        emptyView.setEmptyImage(R.drawable.img_tips_error_load_error);
        emptyView.setEmptyText("加载失败~(≧▽≦)~啦啦啦.");
    }

    public void hideEmptyView() {
        mSwipeRefreshLayout.setRefreshing(false);
        emptyView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }
}
