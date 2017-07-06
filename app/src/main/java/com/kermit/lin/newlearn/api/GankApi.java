package com.kermit.lin.newlearn.api;

import com.kermit.lin.newlearn.bean.ImageInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Lin on 2017/7/5.
 */

public interface GankApi {

    /**
     * 干货图片
     */
    @GET("data/福利/10/1")
    Observable<ImageInfo> getImageInfo();
}
