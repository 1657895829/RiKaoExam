package app.com.fengzhuang.bean;

import java.util.List;

/**
 * http://api.tianapi.com/meinv/?key=18e883dd6b316eb1d97fd86338abbf06&num=10
 */

public class Bean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"【美D共享】◆ Elma梦 明媚的Gir","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/01/15/201511011523276361-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6834353-0-1.html"},{"ctime":"2016-03-06 14:11","title":"[贴图]小美女模特小龙女","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/31/09/201510310930417491-4217076.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6833006-0-1.html"},{"ctime":"2016-03-06 14:11","title":"[贴图]美女那朵","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/31/10/201510311008039621-4217076.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6834101-0-1.html"},{"ctime":"2016-03-06 14:11","title":"美腿秀274（爱秀015 贝贝 2015.11.01）","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/01/20/201511012047296151-2285289.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6834721-0-1.html"},{"ctime":"2016-03-06 14:11","title":"白色蕾丝连体衣绮里嘉户外阳光秀","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_fe9bea92980bb30c7fb9cc3c33c992048-760x500.jpg","url":"http://m.xxxiao.com/582"},{"ctime":"2016-03-06 14:11","title":"【美D共享】◆ 小芳姑娘","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/02/17/201511021717186911-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6838099-0-1.html"},{"ctime":"2016-03-06 14:11","title":"【壁纸长廊】\u2015\u2015亚洲美女壁纸选（691）【28P】[分享]","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/03/10/201511031057114331-1988454.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6837391-0-1.html"},{"ctime":"2016-03-06 14:11","title":"【美D共享】◆ 单车少女","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/02/16/201511021656198951-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6837933-0-1.html"},{"ctime":"2016-03-06 14:11","title":"【梅子】  -  [分享]","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/04/13/201511041316497721-3182465.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6838880-0-1.html"},{"ctime":"2016-03-06 14:11","title":"【小妍妍】   -   （07）    [分享]","description":"华声美女","picUrl":"http://image.hnol.net/bbs/uface/a/2014-11/11/09/2014111109330752354.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6838896-0-1.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2016-03-06 14:11
         * title : 【美D共享】◆ Elma梦 明媚的Gir
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2015-11/01/15/201511011523276361-2089977.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-6834353-0-1.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "NewslistBean{" +
                    "ctime='" + ctime + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
