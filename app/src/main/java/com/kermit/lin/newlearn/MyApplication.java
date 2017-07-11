package com.kermit.lin.newlearn;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import org.litepal.LitePal;

/**
 * Created by Lin on 2017/6/29.
 */

public class MyApplication extends Application{

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);//内存泄露检测初始化

        LitePal.initialize(this);//数据库初始化
    }
    public static Context getAppInstance(){
        return mContext;
    }
}
