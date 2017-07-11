package com.kermit.lin.newlearn.module.bangumi.bean;

import java.util.List;

/**
 * Created by Lin on 2017/5/26.
 */

public class DetailsRecommend {

    /**
     * code : 0
     * message : success
     * result : {"from":0,"list":[{"bangumi_id":"3326","cover":"http://i0.hdslb.com/bfs/bangumi/dcbf3c193f4f8c0433d8dee2ee02580de15948b6.jpg","follow":"115514","isfinish":"1","newest_ep_index":"13","pub_time":"2016-10-03 03:05:00","season_id":"5538","tags":[{"tag_name":"泡面"},{"tag_name":"猎奇"},{"tag_name":"游戏改"}],"title":"青鬼","total_count":"13"},{"bangumi_id":"3331","cover":"http://i0.hdslb.com/bfs/bangumi/c74ba43e76c346476c8c09e653d35de69073cc49.jpg","follow":"120132","isfinish":"1","newest_ep_index":"OVA","pub_time":"2016-10-03 00:00:00","season_id":"5543","tags":[{"tag_name":"泡面"},{"tag_name":"搞笑"},{"tag_name":"基腐"},{"tag_name":"校园"},{"tag_name":"游戏改"}],"title":"学园Handsome","total_count":"12"},{"bangumi_id":"2995","cover":"http://i0.hdslb.com/bfs/bangumi/e2b46584e29f2349748b48c5fb26ce02fcbca4e8.jpg","follow":"777312","isfinish":"1","newest_ep_index":"12","pub_time":"2016-07-12 00:30:00","season_id":"5058","tags":[{"tag_name":"热血"},{"tag_name":"奇幻"},{"tag_name":"战斗"}],"title":"路人超能100(灵能百分百)","total_count":"12"},{"bangumi_id":"2047","cover":"http://i0.hdslb.com/bfs/bangumi/16a9b2958e18ce0491dade97da59e93a7610da15.jpg","follow":"39344","isfinish":"1","newest_ep_index":"33","pub_time":"2015-12-12 00:00:00","season_id":"3236","tags":[{"tag_name":"日常"}],"title":"矶部矶兵卫物语","total_count":"34"},{"bangumi_id":"1872","cover":"http://i0.hdslb.com/bfs/bangumi/48b4bd607f04a580a44322a61fe09eca3bf2fb87.jpg","follow":"18486","isfinish":"1","newest_ep_index":"SP","pub_time":"2016-12-13 14:30:00","season_id":"5763","tags":[{"tag_name":"日常"},{"tag_name":"搞笑"}],"title":"阿松 SP 赛马轶事","total_count":"1"},{"bangumi_id":"3230","cover":"http://i0.hdslb.com/bfs/bangumi/26f499a175f2154564f487fa211ef0f713e6b120.jpg","follow":"1241","isfinish":"1","newest_ep_index":"25","pub_time":"2016-07-08 00:00:00","season_id":"5385","tags":[{"tag_name":"萌系"}],"title":"猪猪秀","total_count":"6"}],"season_id":"5070","title":"齐木楠雄的灾难（日播&精选版）"}
     */

    private int code;
    private String message;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * from : 0
         * list : [{"bangumi_id":"3326","cover":"http://i0.hdslb.com/bfs/bangumi/dcbf3c193f4f8c0433d8dee2ee02580de15948b6.jpg","follow":"115514","isfinish":"1","newest_ep_index":"13","pub_time":"2016-10-03 03:05:00","season_id":"5538","tags":[{"tag_name":"泡面"},{"tag_name":"猎奇"},{"tag_name":"游戏改"}],"title":"青鬼","total_count":"13"},{"bangumi_id":"3331","cover":"http://i0.hdslb.com/bfs/bangumi/c74ba43e76c346476c8c09e653d35de69073cc49.jpg","follow":"120132","isfinish":"1","newest_ep_index":"OVA","pub_time":"2016-10-03 00:00:00","season_id":"5543","tags":[{"tag_name":"泡面"},{"tag_name":"搞笑"},{"tag_name":"基腐"},{"tag_name":"校园"},{"tag_name":"游戏改"}],"title":"学园Handsome","total_count":"12"},{"bangumi_id":"2995","cover":"http://i0.hdslb.com/bfs/bangumi/e2b46584e29f2349748b48c5fb26ce02fcbca4e8.jpg","follow":"777312","isfinish":"1","newest_ep_index":"12","pub_time":"2016-07-12 00:30:00","season_id":"5058","tags":[{"tag_name":"热血"},{"tag_name":"奇幻"},{"tag_name":"战斗"}],"title":"路人超能100(灵能百分百)","total_count":"12"},{"bangumi_id":"2047","cover":"http://i0.hdslb.com/bfs/bangumi/16a9b2958e18ce0491dade97da59e93a7610da15.jpg","follow":"39344","isfinish":"1","newest_ep_index":"33","pub_time":"2015-12-12 00:00:00","season_id":"3236","tags":[{"tag_name":"日常"}],"title":"矶部矶兵卫物语","total_count":"34"},{"bangumi_id":"1872","cover":"http://i0.hdslb.com/bfs/bangumi/48b4bd607f04a580a44322a61fe09eca3bf2fb87.jpg","follow":"18486","isfinish":"1","newest_ep_index":"SP","pub_time":"2016-12-13 14:30:00","season_id":"5763","tags":[{"tag_name":"日常"},{"tag_name":"搞笑"}],"title":"阿松 SP 赛马轶事","total_count":"1"},{"bangumi_id":"3230","cover":"http://i0.hdslb.com/bfs/bangumi/26f499a175f2154564f487fa211ef0f713e6b120.jpg","follow":"1241","isfinish":"1","newest_ep_index":"25","pub_time":"2016-07-08 00:00:00","season_id":"5385","tags":[{"tag_name":"萌系"}],"title":"猪猪秀","total_count":"6"}]
         * season_id : 5070
         * title : 齐木楠雄的灾难（日播&精选版）
         */

        private int from;
        private String season_id;
        private String title;
        private List<ListBean> list;

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bangumi_id : 3326
             * cover : http://i0.hdslb.com/bfs/bangumi/dcbf3c193f4f8c0433d8dee2ee02580de15948b6.jpg
             * follow : 115514
             * isfinish : 1
             * newest_ep_index : 13
             * pub_time : 2016-10-03 03:05:00
             * season_id : 5538
             * tags : [{"tag_name":"泡面"},{"tag_name":"猎奇"},{"tag_name":"游戏改"}]
             * title : 青鬼
             * total_count : 13
             */

            private String bangumi_id;
            private String cover;
            private String follow;
            private String isfinish;
            private String newest_ep_index;
            private String pub_time;
            private String season_id;
            private String title;
            private String total_count;
            private List<TagsBean> tags;

            public String getBangumi_id() {
                return bangumi_id;
            }

            public void setBangumi_id(String bangumi_id) {
                this.bangumi_id = bangumi_id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public String getIsfinish() {
                return isfinish;
            }

            public void setIsfinish(String isfinish) {
                this.isfinish = isfinish;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public String getPub_time() {
                return pub_time;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public String getSeason_id() {
                return season_id;
            }

            public void setSeason_id(String season_id) {
                this.season_id = season_id;
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

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * tag_name : 泡面
                 */

                private String tag_name;

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }
            }
        }
    }
}
