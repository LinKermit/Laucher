package com.kermit.lin.newlearn.module.bangumi.bean;


import org.litepal.crud.DataSupport;

/**
 * Created by Lin on 2017/6/20.
 */

public class BangumiFollowBean extends DataSupport {

    private float newest_ep_id;
    private String title;
    private String total_count;
    private String image_url;
    private String url;
    private boolean isFollowed;

    public float getNewest_ep_id() {
        return newest_ep_id;
    }

    public void setNewest_ep_id(float newest_ep_id) {
        this.newest_ep_id = newest_ep_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }
}
