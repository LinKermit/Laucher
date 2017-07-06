package com.kermit.lin.newlearn.module.fragment;

import android.os.Bundle;
import android.util.Log;

import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.base.RxLazyFragment;

/**
 * Created by Lin on 2017/5/18.
 * 主界面分区界面
 */

public class UserFragment extends RxLazyFragment {

    private static final String TAG = "RegionFragment";
    public static UserFragment newInstance(){
        return new UserFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_attention;
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
        Log.e(TAG, "lazyLoad: ");
    }
}
