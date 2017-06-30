package com.kermit.lin.newlearn.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.kermit.lin.newlearn.MyApplication;

/**
 * Created by Lin on 2017/6/14.
 */

public class Settings {
    private static final String SHARED_NAME = "settings";

    private static Settings instance;
    private SharedPreferences sp;

    private Settings(Context context){
        sp = context.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
    }

    public static Settings getInstance(){
        if (instance == null){
            instance = new Settings(MyApplication.getAppInstance());
        }
        return instance;
    }
    //搜索的初始值
    public static int searchID = 0;
    public static final String KEY_SEARCH = "key_search";
    //按两次退出
    public static boolean doubleExit = true;
    public static final String KEY_EXIT = "key_exit";

    //夜间模式
    public static boolean isNight = false;
    public static final String KEY_NIGHT = "key_night";

    //无图模式
    public static boolean noPicMode = false;
    public static final String KEY_NO_PIC = "key_no_pic";

    //自动刷新
    public static boolean auto_refresh = true;
    public static final String KEY_REFRESH = "key_refresh";

    /**
     * 存取boolen变量
     */
    public boolean getBoolen(String key, boolean def){
        return sp.getBoolean(key,def);
    }

    public void putBoolen(String key,boolean value){
        sp.edit().putBoolean(key,value).commit();
    }

    //存取int值
    public int getInt(String key,int def){
        return sp.getInt(key, def);
    }
    public void putInt(String key,int value){
        sp.edit().putInt(key, value).commit();
    }

    public String getString(String key,String def){
        return sp.getString(key, def);
    }
    public void putString(String key,String value){
        sp.edit().putString(key, value).commit();
    }
}
