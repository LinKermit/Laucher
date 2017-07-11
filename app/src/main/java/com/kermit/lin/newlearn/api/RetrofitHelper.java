package com.kermit.lin.newlearn.api;

import com.kermit.lin.newlearn.utils.Constans;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lin on 2017/7/5.
 */

public class RetrofitHelper {


    public static GankApi getGankApi() {
        return createApi(GankApi.class, Constans.BASE_URL);
    }

    public static GankApi getBangumiHomeApi() {
        return createApi(GankApi.class, Constans.BILI_URL);
    }

    private static OkHttpClient mOkHttpClient = new OkHttpClient();
    /**
     * 根据传入的baseUrl，和api创建retrofit
     */
    private static <T> T createApi(Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }
}
