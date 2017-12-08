package app.com.rikao10.retrofit;

import app.com.rikao10.bean.ChildBean;
import app.com.rikao10.bean.LeftBean;
import app.com.rikao10.bean.RightBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 网络接口数据的请求类
 */
public interface GetDataInterface {
    /*
     * 使用Observable被观察者模式下的请求左边数据 https://www.zhaoapi.cn/product/getCatagory
     */
    @GET("/product/getCatagory")
    Observable<LeftBean> getLeftCall();

    /*
     * 使用Observable被观察者模式下的请求右边数据 https://www.zhaoapi.cn/product/getProductCatagory?cid=1
     */
    @GET("/product/getProductCatagory")
    Observable<RightBean> getRightCall(@Query("cid") int cid);

    /*
     * 使用Observable被观察者模式下的请求子分类数据 https://www.zhaoapi.cn/product/getProducts?pscid==1
     */
    @GET("/product/getProducts")
    Observable<ChildBean> getChildCall(@Query("pscid") int pscid);
}
