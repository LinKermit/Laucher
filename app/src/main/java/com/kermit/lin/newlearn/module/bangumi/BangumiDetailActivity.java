package com.kermit.lin.newlearn.module.bangumi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;
import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.api.RetrofitHelper;
import com.kermit.lin.newlearn.base.RxBaseActivity;
import com.kermit.lin.newlearn.module.bangumi.adapter.InduceAdapter;
import com.kermit.lin.newlearn.module.bangumi.adapter.SelectionAdapter;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiDetailsBean;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiFollowBean;
import com.kermit.lin.newlearn.module.bangumi.bean.CommentBean;
import com.kermit.lin.newlearn.module.bangumi.bean.DetailsRecommend;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Lin on 2017/5/25.
 * 番剧详情界面
 */

public class BangumiDetailActivity extends RxBaseActivity {
    private static final String TAG = "BangumiDetailActivity";
    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;

    @BindView(R.id.iv_bangumi_bg)
    ImageView ivBg;
    @BindView(R.id.iv_bangumi_left)
    ImageView ivLeft;
    @BindView(R.id.tv_selection)
    TextView tvSelection;

    @BindView(R.id.tv_check)
    TextView tvCheck;

    @BindView(R.id.rec_selection)
    RecyclerView seleRecyclerView;
    @BindView(R.id.rec_induce)
    RecyclerView induceRecyclerView;
    @BindView(R.id.rec_comment)
    RecyclerView commentRecyclerView;

    @BindView(R.id.tv_comment)
    TextView comment;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bangumi_details_introduction)
    TextView introduction;

    @BindView(R.id.bangumi_title)
    TextView title;
    @BindView(R.id.bangumi_play)
    TextView playCount;

    @BindView(R.id.ib_bangumi_follow)
    ImageButton follow;


    List<BangumiDetailsBean.ResultBean.EpisodesBean> episodes = new ArrayList<>();//全集列表
    String evaluate = new String();//简介
    String mTitle,mCount;
    float bangumi_id;
    String imageUrl,sImage;//图片;
    List<DetailsRecommend.ResultBean.ListBean> recommendList = new ArrayList<>();
    CommentBean.DataBean data = new CommentBean.DataBean();//评论的总数据
    @Override
    public int getLayoutId() {
        return R.layout.activity_bangumi_detail;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        setToolBarTrans();
        getDataFromNet();
        follow();
    }

    private void follow() {
        //缓存到数据库
        final BangumiFollowBean followBean = new BangumiFollowBean();
        followBean.setNewest_ep_id(bangumi_id);
        followBean.setTitle(mTitle);
        followBean.setTotal_count(mCount);
        followBean.setUrl("http://192.168.1.111:8080/bili/bangumi_home_detail.json");
        followBean.setFollowed(isFollowed);
        followBean.save();

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFollowed){
                    follow.setImageResource(R.drawable.ic_bangumi_followed);
                    isFollowed = false;

                    followBean.setFollowed(isFollowed);
                    followBean.save();

                }else {
                    follow.setImageResource(R.drawable.ic_bangumi_follow1);
                    isFollowed = true;

                    followBean.setFollowed(isFollowed);
                    followBean.save();
                }
            }
        });
    }

    private boolean isFollowed = false;

    private void setToolBarTrans() {
        toolbar.setBackgroundColor(Color.argb(0,63,81,181));
        final float imageHeight = getResources().getDimension(R.dimen.bangumi_details_top_layout_height);
        final float toolBarHeight = getResources().getDimension(R.dimen.action_bar_default_height);
        //为滑动设置监听
        nestedScrollView.setNestedScrollingEnabled(true);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                float offsetY = toolBarHeight - imageHeight;
                //计算滑动距离的偏移量
                float offset = 1 - Math.max((offsetY - scrollY) / offsetY, 0f);
                float absOffset = Math.abs(offset);
                //如果滑动距离大于1就设置完全不透明度
                if (absOffset >= 1) {
                    absOffset = 1;
                }
                toolbar.setBackgroundColor(Color.argb((int) (absOffset * 255),63,81,181));
            }
        });
    }


    private void getDataFromNet() {
        RetrofitHelper.getBangumiHomeApi().getBangumiDetails()
                .compose(this.<BangumiDetailsBean>bindToLifecycle())
                .flatMap(new Func1<BangumiDetailsBean, Observable<DetailsRecommend>>() {
                    @Override
                    public Observable<DetailsRecommend> call(BangumiDetailsBean bangumiDetailsBean) {
                        episodes = bangumiDetailsBean.getResult().getEpisodes();
                        evaluate = bangumiDetailsBean.getResult().getEvaluate();
                        bangumi_id = Float.valueOf(bangumiDetailsBean.getResult().getNewest_ep_id());
                        mTitle = bangumiDetailsBean.getResult().getTitle();
                        mCount = bangumiDetailsBean.getResult().getPlay_count();
                        imageUrl = bangumiDetailsBean.getResult().getCover();
                        sImage = bangumiDetailsBean.getResult().getSquareCover();
                        return RetrofitHelper.getBangumiHomeApi().getDtailRecommend();
                    }
                }).compose(this.<DetailsRecommend>bindToLifecycle())
                .map(new Func1<DetailsRecommend, List<DetailsRecommend.ResultBean.ListBean>>() {
                    @Override
                    public List<DetailsRecommend.ResultBean.ListBean> call(DetailsRecommend detailsRecommend) {
                        recommendList = detailsRecommend.getResult().getList();
                        return recommendList;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<DetailsRecommend.ResultBean.ListBean>>() {
                    @Override
                    public void call(List<DetailsRecommend.ResultBean.ListBean> listBeen) {
                        finishTask();
                    }
                });
    }

    private void finishTask() {
        //高斯背景模糊图片
        Glide.with(this).load(imageUrl)
                .bitmapTransform(new BlurTransformation(this))
                .into(ivBg);
        Glide.with(this).load(sImage).into(ivLeft);
        title.setText(mTitle);
        playCount.setText(mCount);
        introduction.setText(evaluate);

        //初始化选集列表
        initSelectionRecy();
        //初始化推荐列表
        initInduceRecy();
        //初始化评论列表
        initCommentRecy();
    }


    private void initSelectionRecy() {
        seleRecyclerView.setHasFixedSize(false);
        seleRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        seleRecyclerView.setLayoutManager(manager);
        final SelectionAdapter adapter = new SelectionAdapter(this,episodes);
        seleRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(new SelectionAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                adapter.getPosition(position);
            }
        });
    }

    private void initInduceRecy() {
        induceRecyclerView.setHasFixedSize(false);
        induceRecyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        induceRecyclerView.setLayoutManager(manager);
        InduceAdapter adapter = new InduceAdapter(this,recommendList);
        induceRecyclerView.setAdapter(adapter);
    }


    private void initCommentRecy() {
        commentRecyclerView.setHasFixedSize(false);
        commentRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        commentRecyclerView.setLayoutManager(manager);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("番剧详情");
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
