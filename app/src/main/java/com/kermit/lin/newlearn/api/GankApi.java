package com.kermit.lin.newlearn.api;

import com.kermit.lin.newlearn.bean.ImageInfo;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiDetailsBean;
import com.kermit.lin.newlearn.module.bangumi.bean.BangumiHomeInfo;
import com.kermit.lin.newlearn.module.bangumi.bean.CommentBean;
import com.kermit.lin.newlearn.module.bangumi.bean.DetailsRecommend;

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


    //番剧
    /**
     * 首页番剧
     */
    @GET("api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios")
    Observable<BangumiHomeInfo> getBangumiHomeInfo();
    /**
     * 首页番剧详情
     */
    @GET("api/season_v4?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&season_id=5070&sign=3e5d4d7460961d9bab5da2341fd98dc1&ts=1477898526&type=bangumi")
    Observable<BangumiDetailsBean> getBangumiDetails();
    /**
     * 首页番剧详情推荐
     */
    @GET("api/season/recommend/5070.json?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&season_id=5070&sign=744e3a3f52829e4344c33908f7a0c1ef&ts=1477898527")
    Observable<DetailsRecommend> getDtailRecommend();
    /**
     * 首页番剧详情评论
     */
    @GET("/bili/bangumi/bangumiDetails/bangumi_comment_detail.htm")
    Observable<CommentBean> getComment();
}
