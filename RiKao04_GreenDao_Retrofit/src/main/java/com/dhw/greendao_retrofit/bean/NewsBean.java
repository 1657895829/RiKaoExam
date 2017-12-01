package com.dhw.greendao_retrofit.bean;

import java.util.List;

/**
 * http://api.tianapi.com/wxnew/?key=18e883dd6b316eb1d97fd86338abbf06&num=10
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-12-01","title":"纳兰词中的冬天，那么美，那么悲凉","description":"南山子春秋","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-43314672.static/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086412&signature=qEIbdRZjDzeA4Zu60cUJwwnPhKqaJtbSoLzgqlZopHf3x6wVguz020y*0YdF31*uuECJqPsDk58HrbGbISRMMeC*RCOGURiMoZIQWGMaWKQ="},{"ctime":"2017-12-01","title":"张大千画松，清心超然！","description":"南山子春秋","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-43314672.static/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086411&signature=bRsfwK-i-f*SdrIh2og2gzHIdOZArA4UaCxQFYdt8EiMjy9AZIBlV5XACndAmiGr06WHLdIqdKNoW2hdHIYuQLCzWqzHFs3DgkfpunJ5syU="},{"ctime":"2017-12-01","title":"经典古文 | 口技","description":"古诗词赏析","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60599451.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086411&signature=7TBixbvpWTYbutZmkal1hc8ZfgMTFsxIULcAz7T*DLdcEv3721-UBTxhj2H10CoQ1SxwG*oO8NXopWSpWY5cpHKHt8Tj8GhNtWRmqhHcab0="},{"ctime":"2017-12-01","title":"每日背诗 | 别老母","description":"古诗词赏析","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60444342.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086411&signature=PWjDENVpUq80v5S0luxX9HqQ4PQ68V8DL74R0sRLW6yTBwFyrRjwkURpqzu0A*nLJZKVZ8IIWWbsushImtQJG9XqQ-5BFuzhGp6moxtQ6NM="},{"ctime":"2017-12-01","title":"唐诗三百首 | 章台夜思","description":"古诗词赏析","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-7586114.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086411&signature=9ngBj7dJb8bFyZsXyLEsCOJxREmNU9loUElA4Q0R3CA2i88baFHFD8ifGA-UAUthbGTYWrIgQ98qy9SKgYXEE2HOiubLoQZJV3t2MF116Hs="},{"ctime":"2017-12-01","title":"『修行问答』念经可以把身体的气脉打通吗？","description":"姑苏云","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60599350.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086410&signature=pht4Jll2hMCs8*hvCXoCWZPHhJquijYttYeZui8J0xgbLRZxmUNDkRzZ4W2AXxGhiGpzzwIxnJ7TjyViAw0mJJIY5*DSzfO1bDgpftrtSeg="},{"ctime":"2017-12-01","title":"跟着古书画穿越历史，掌握探究式学习方法","description":"外滩教育","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60599428.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086410&signature=AnTIqeHwaChkQCmBKKWdGcCl9j-Zho0n1DF0kLeatglh6eD5R1Bcqg2XlR55D*bR2P35PRk6zRhn77-LhBR87HPLQ2W2RFTl7CRyoX0f*3E="},{"ctime":"2017-12-01","title":"酒有什么好喝的？这是我见过最好的回答！","description":"读史","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60599152.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086410&signature=F1lYSM*hWQy-l66N-yvuOKswyZJ9D7qhVQqJ9DEIVWcNWurhX-jykR2sJ5N7mn85hARz5r1I*4HDBmVTNK9DU0-h83PGOqZrJ4fmaCL6YyA="},{"ctime":"2017-12-01","title":"中华传统文化精华版，汇集珍藏，送给你，不谢！","description":"读史","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60599183.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512086409&signature=-Pn37hj3diFX2VE8uF5Nou32gpXlkDPneUq9GpJBxZQ5vHtjD9jbH36QQshxqzsGTKiS0E7fUETqow1Eb2s8l71K73lJpRvKiZqkebZU9lw="},{"ctime":"2017-12-01","title":"欧阳老师的思维课堂 | 第13讲 实战：记叙文写作中思维运用的方法","description":"作文合唱团","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-59971767.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=521&timestamp=1512082809&signature=TKboNgz37dX2omWUokeMp4erz5fuwjLUNlONENxRjbdujd5XKYfG5tKXI79hXTt4ZJrCmpXXtxwvVLTY4J6V3jYkvbzhucBE0rJigaP3ME8="}]
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
}
