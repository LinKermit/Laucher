package com.kermit.lin.newlearn.module.bangumi.bean;

import java.util.List;

/**
 * Created by Lin on 2017/5/24.
 */

public class BangumiHomeInfo {

    /**
     * code : 0
     * message : success
     * result : {"ad":{"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/20638f651d4288dde18bcb5d42f2d84a44548a1b.jpg","link":"http://bangumi.bilibili.com/anime/5996","pub_time":"2017-05-19 02:35:00","title":"恋爱暴君"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/2744f99f270ef32dbb20b49df545d15d06c4af0a.jpg","link":"http://bangumi.bilibili.com/anime/5991","pub_time":"2017-05-19 02:30:00","title":"青春歌舞伎"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/c578b05785ecc90a7caeb69522fb26aee77fd6e5.jpg","link":"http://bangumi.bilibili.com/anime/5992","pub_time":"2017-05-18 00:00:00","title":"樱花任务"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/e4706c83ba2fe460d33fac059c6a459593d42a1e.jpg","link":"http://bangumi.bilibili.com/anime/5978","pub_time":"2017-05-17 17:55:00","title":"博人传"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/e92d4347facddd68ca554eeec372e0a3378ecd4b.jpg","link":"http://bangumi.bilibili.com/anime/5977","pub_time":"2017-05-17 03:00:00","title":"夏目友人帐 陆"}]},"previous":{"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/320a6c9893a874e7db755ecb7316a0d0abccec49.jpg","favourites":"2223279","is_finish":1,"last_time":1491410100,"newest_ep_index":"13","pub_time":1484148600,"season_id":5800,"season_status":2,"title":"小林家的龙女仆","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/7b9a5a6e6c5ca157a4c18b01093a7bb1701f4606.jpg","favourites":"1040138","is_finish":1,"last_time":1490626802,"newest_ep_index":"12","pub_time":1483974000,"season_id":5793,"season_status":2,"title":"珈百璃的堕落","watching_count":0},{"badge":"付费观看","cover":"http://i0.hdslb.com/bfs/bangumi/2d86f338ec4c17d5c61a103a3de01a1b27ec184e.jpg","favourites":"895189","is_finish":1,"last_time":1490407202,"newest_ep_index":"12","pub_time":1483718400,"season_id":5851,"season_status":6,"title":"斗破苍穹","watching_count":0}],"season":1,"year":2017},"serializing":[{"cover":"http://i0.hdslb.com/bfs/bangumi/8aa87787edd29b84c4091e8e483ae48422b7bbd0.jpg","favourites":"801125","is_finish":0,"is_started":1,"last_time":1495132500,"newest_ep_index":"7","pub_time":1491503700,"season_id":5996,"season_status":2,"title":"恋爱暴君","watching_count":3758},{"cover":"http://i0.hdslb.com/bfs/bangumi/6fccd08f6f747343c2d3bbcd54e4912a9fa51418.jpg","favourites":"150151","is_finish":0,"is_started":1,"last_time":1495132080,"newest_ep_index":"7","pub_time":1491503280,"season_id":5991,"season_status":2,"title":"青春歌舞伎","watching_count":187},{"cover":"http://i0.hdslb.com/bfs/bangumi/5ce66f68d54052e3a305524b9b06a76977e974fc.jpg","favourites":"608393","is_finish":0,"is_started":1,"last_time":1495119602,"newest_ep_index":"6.5","pub_time":1491490800,"season_id":5989,"season_status":2,"title":"月色真美","watching_count":1008},{"cover":"http://i0.hdslb.com/bfs/bangumi/6010758330efe7ad646d7cad9dd80cc84d8d5c3a.jpg","favourites":"24173","is_finish":0,"is_started":1,"last_time":1495087200,"newest_ep_index":"62","pub_time":1477411200,"season_id":5935,"season_status":2,"title":"我差点就信了 第二季","watching_count":9},{"cover":"http://i0.hdslb.com/bfs/bangumi/c1fc543021733e096104b277bd3469dbd3fd107d.jpg","favourites":"259001","is_finish":0,"is_started":1,"last_time":1495078566,"newest_ep_index":"22","pub_time":1466697600,"season_id":5291,"season_status":2,"title":"武庚纪","watching_count":116},{"cover":"http://i0.hdslb.com/bfs/bangumi/6bf4ed92c56f6d9cb51d8e88f8eb8c599476b47b.jpg","favourites":"16572","is_finish":0,"is_started":1,"last_time":1495078005,"newest_ep_index":"21","pub_time":1482940800,"season_id":6022,"season_status":2,"title":"菊叔5岁画","watching_count":17}]}
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
         * ad : {"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/20638f651d4288dde18bcb5d42f2d84a44548a1b.jpg","link":"http://bangumi.bilibili.com/anime/5996","pub_time":"2017-05-19 02:35:00","title":"恋爱暴君"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/2744f99f270ef32dbb20b49df545d15d06c4af0a.jpg","link":"http://bangumi.bilibili.com/anime/5991","pub_time":"2017-05-19 02:30:00","title":"青春歌舞伎"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/c578b05785ecc90a7caeb69522fb26aee77fd6e5.jpg","link":"http://bangumi.bilibili.com/anime/5992","pub_time":"2017-05-18 00:00:00","title":"樱花任务"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/e4706c83ba2fe460d33fac059c6a459593d42a1e.jpg","link":"http://bangumi.bilibili.com/anime/5978","pub_time":"2017-05-17 17:55:00","title":"博人传"},{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/e92d4347facddd68ca554eeec372e0a3378ecd4b.jpg","link":"http://bangumi.bilibili.com/anime/5977","pub_time":"2017-05-17 03:00:00","title":"夏目友人帐 陆"}]}
         * previous : {"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/320a6c9893a874e7db755ecb7316a0d0abccec49.jpg","favourites":"2223279","is_finish":1,"last_time":1491410100,"newest_ep_index":"13","pub_time":1484148600,"season_id":5800,"season_status":2,"title":"小林家的龙女仆","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/7b9a5a6e6c5ca157a4c18b01093a7bb1701f4606.jpg","favourites":"1040138","is_finish":1,"last_time":1490626802,"newest_ep_index":"12","pub_time":1483974000,"season_id":5793,"season_status":2,"title":"珈百璃的堕落","watching_count":0},{"badge":"付费观看","cover":"http://i0.hdslb.com/bfs/bangumi/2d86f338ec4c17d5c61a103a3de01a1b27ec184e.jpg","favourites":"895189","is_finish":1,"last_time":1490407202,"newest_ep_index":"12","pub_time":1483718400,"season_id":5851,"season_status":6,"title":"斗破苍穹","watching_count":0}],"season":1,"year":2017}
         * serializing : [{"cover":"http://i0.hdslb.com/bfs/bangumi/8aa87787edd29b84c4091e8e483ae48422b7bbd0.jpg","favourites":"801125","is_finish":0,"is_started":1,"last_time":1495132500,"newest_ep_index":"7","pub_time":1491503700,"season_id":5996,"season_status":2,"title":"恋爱暴君","watching_count":3758},{"cover":"http://i0.hdslb.com/bfs/bangumi/6fccd08f6f747343c2d3bbcd54e4912a9fa51418.jpg","favourites":"150151","is_finish":0,"is_started":1,"last_time":1495132080,"newest_ep_index":"7","pub_time":1491503280,"season_id":5991,"season_status":2,"title":"青春歌舞伎","watching_count":187},{"cover":"http://i0.hdslb.com/bfs/bangumi/5ce66f68d54052e3a305524b9b06a76977e974fc.jpg","favourites":"608393","is_finish":0,"is_started":1,"last_time":1495119602,"newest_ep_index":"6.5","pub_time":1491490800,"season_id":5989,"season_status":2,"title":"月色真美","watching_count":1008},{"cover":"http://i0.hdslb.com/bfs/bangumi/6010758330efe7ad646d7cad9dd80cc84d8d5c3a.jpg","favourites":"24173","is_finish":0,"is_started":1,"last_time":1495087200,"newest_ep_index":"62","pub_time":1477411200,"season_id":5935,"season_status":2,"title":"我差点就信了 第二季","watching_count":9},{"cover":"http://i0.hdslb.com/bfs/bangumi/c1fc543021733e096104b277bd3469dbd3fd107d.jpg","favourites":"259001","is_finish":0,"is_started":1,"last_time":1495078566,"newest_ep_index":"22","pub_time":1466697600,"season_id":5291,"season_status":2,"title":"武庚纪","watching_count":116},{"cover":"http://i0.hdslb.com/bfs/bangumi/6bf4ed92c56f6d9cb51d8e88f8eb8c599476b47b.jpg","favourites":"16572","is_finish":0,"is_started":1,"last_time":1495078005,"newest_ep_index":"21","pub_time":1482940800,"season_id":6022,"season_status":2,"title":"菊叔5岁画","watching_count":17}]
         */

        private AdBean ad;
        private PreviousBean previous;
        private List<SerializingBean> serializing;

        public AdBean getAd() {
            return ad;
        }

        public void setAd(AdBean ad) {
            this.ad = ad;
        }

        public PreviousBean getPrevious() {
            return previous;
        }

        public void setPrevious(PreviousBean previous) {
            this.previous = previous;
        }

        public List<SerializingBean> getSerializing() {
            return serializing;
        }

        public void setSerializing(List<SerializingBean> serializing) {
            this.serializing = serializing;
        }

        public static class AdBean {
            private List<?> body;
            private List<HeadBean> head;

            public List<?> getBody() {
                return body;
            }

            public void setBody(List<?> body) {
                this.body = body;
            }

            public List<HeadBean> getHead() {
                return head;
            }

            public void setHead(List<HeadBean> head) {
                this.head = head;
            }

            public static class HeadBean {
                /**
                 * id : 0
                 * img : http://i0.hdslb.com/bfs/bangumi/20638f651d4288dde18bcb5d42f2d84a44548a1b.jpg
                 * link : http://bangumi.bilibili.com/anime/5996
                 * pub_time : 2017-05-19 02:35:00
                 * title : 恋爱暴君
                 */

                private int id;
                private String img;
                private String link;
                private String pub_time;
                private String title;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getPub_time() {
                    return pub_time;
                }

                public void setPub_time(String pub_time) {
                    this.pub_time = pub_time;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class PreviousBean {
            /**
             * list : [{"cover":"http://i0.hdslb.com/bfs/bangumi/320a6c9893a874e7db755ecb7316a0d0abccec49.jpg","favourites":"2223279","is_finish":1,"last_time":1491410100,"newest_ep_index":"13","pub_time":1484148600,"season_id":5800,"season_status":2,"title":"小林家的龙女仆","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/7b9a5a6e6c5ca157a4c18b01093a7bb1701f4606.jpg","favourites":"1040138","is_finish":1,"last_time":1490626802,"newest_ep_index":"12","pub_time":1483974000,"season_id":5793,"season_status":2,"title":"珈百璃的堕落","watching_count":0},{"badge":"付费观看","cover":"http://i0.hdslb.com/bfs/bangumi/2d86f338ec4c17d5c61a103a3de01a1b27ec184e.jpg","favourites":"895189","is_finish":1,"last_time":1490407202,"newest_ep_index":"12","pub_time":1483718400,"season_id":5851,"season_status":6,"title":"斗破苍穹","watching_count":0}]
             * season : 1
             * year : 2017
             */

            private int season;
            private int year;
            private List<ListBean> list;

            public int getSeason() {
                return season;
            }

            public void setSeason(int season) {
                this.season = season;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * cover : http://i0.hdslb.com/bfs/bangumi/320a6c9893a874e7db755ecb7316a0d0abccec49.jpg
                 * favourites : 2223279
                 * is_finish : 1
                 * last_time : 1491410100
                 * newest_ep_index : 13
                 * pub_time : 1484148600
                 * season_id : 5800
                 * season_status : 2
                 * title : 小林家的龙女仆
                 * watching_count : 0
                 * badge : 付费观看
                 */

                private String cover;
                private String favourites;
                private int is_finish;
                private int last_time;
                private String newest_ep_index;
                private int pub_time;
                private int season_id;
                private int season_status;
                private String title;
                private int watching_count;
                private String badge;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getFavourites() {
                    return favourites;
                }

                public void setFavourites(String favourites) {
                    this.favourites = favourites;
                }

                public int getIs_finish() {
                    return is_finish;
                }

                public void setIs_finish(int is_finish) {
                    this.is_finish = is_finish;
                }

                public int getLast_time() {
                    return last_time;
                }

                public void setLast_time(int last_time) {
                    this.last_time = last_time;
                }

                public String getNewest_ep_index() {
                    return newest_ep_index;
                }

                public void setNewest_ep_index(String newest_ep_index) {
                    this.newest_ep_index = newest_ep_index;
                }

                public int getPub_time() {
                    return pub_time;
                }

                public void setPub_time(int pub_time) {
                    this.pub_time = pub_time;
                }

                public int getSeason_id() {
                    return season_id;
                }

                public void setSeason_id(int season_id) {
                    this.season_id = season_id;
                }

                public int getSeason_status() {
                    return season_status;
                }

                public void setSeason_status(int season_status) {
                    this.season_status = season_status;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getWatching_count() {
                    return watching_count;
                }

                public void setWatching_count(int watching_count) {
                    this.watching_count = watching_count;
                }

                public String getBadge() {
                    return badge;
                }

                public void setBadge(String badge) {
                    this.badge = badge;
                }
            }
        }

        public static class SerializingBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/8aa87787edd29b84c4091e8e483ae48422b7bbd0.jpg
             * favourites : 801125
             * is_finish : 0
             * is_started : 1
             * last_time : 1495132500
             * newest_ep_index : 7
             * pub_time : 1491503700
             * season_id : 5996
             * season_status : 2
             * title : 恋爱暴君
             * watching_count : 3758
             */

            private String cover;
            private String favourites;
            private int is_finish;
            private int is_started;
            private int last_time;
            private String newest_ep_index;
            private int pub_time;
            private int season_id;
            private int season_status;
            private String title;
            private int watching_count;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getFavourites() {
                return favourites;
            }

            public void setFavourites(String favourites) {
                this.favourites = favourites;
            }

            public int getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(int is_finish) {
                this.is_finish = is_finish;
            }

            public int getIs_started() {
                return is_started;
            }

            public void setIs_started(int is_started) {
                this.is_started = is_started;
            }

            public int getLast_time() {
                return last_time;
            }

            public void setLast_time(int last_time) {
                this.last_time = last_time;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }

            public int getSeason_id() {
                return season_id;
            }

            public void setSeason_id(int season_id) {
                this.season_id = season_id;
            }

            public int getSeason_status() {
                return season_status;
            }

            public void setSeason_status(int season_status) {
                this.season_status = season_status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }
        }
    }
}
