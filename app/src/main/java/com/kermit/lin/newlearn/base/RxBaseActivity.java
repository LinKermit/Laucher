package com.kermit.lin.newlearn.base;

import android.os.Bundle;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lin on 2017/5/18.
 * Activity的基类，继承RxLife  通过compose操作符，严格控制由于发布了一个订阅后，由于没有及时取消
 * 注册解绑ButterKnife
 * 1加载布局
 * 2初始化ButterKnife
 * 3初始化控件
 * 4初始化toolbar
 */

public abstract class RxBaseActivity extends RxAppCompatActivity {

    private Unbinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化布局
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        binder = ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
    }
    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initToolBar();

    public void loadData() {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binder.unbind();
    }

}
