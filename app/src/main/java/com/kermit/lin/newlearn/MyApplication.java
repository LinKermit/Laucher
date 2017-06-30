package com.kermit.lin.newlearn;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

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
        LeakCanary.install(this);
    }
    public static Context getAppInstance(){
        return mContext;
    }
}
