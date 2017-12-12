package app.com.rikao13.retrofit;

import java.util.Map;
import app.com.rikao13.bean.LoginBean;
import app.com.rikao13.bean.PersonInfoBean;
import app.com.rikao13.bean.RegBean;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 网络接口数据的请求类
 */
public interface GetDataInterface {

    //注册的接口
    //https://www.zhaoapi.cn/user/reg?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("/user/reg")
    Observable<RegBean> reg(@FieldMap Map<String,String> map);

    //登录的接口
    //https://www.zhaoapi.cn/user/login?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("/user/login")
    Observable<LoginBean> login(@FieldMap Map<String,String> map);

    //个人中心接口：
    //https://www.zhaoapi.cn/user/getUserInfo?uid=100
    @GET("/user/getUserInfo")
    Observable<PersonInfoBean> person(@Query("uid") int uid);
}
