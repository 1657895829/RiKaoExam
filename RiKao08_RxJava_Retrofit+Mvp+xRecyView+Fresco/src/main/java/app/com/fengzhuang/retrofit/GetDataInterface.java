package app.com.fengzhuang.retrofit;

import java.util.Map;
import app.com.fengzhuang.bean.Bean;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 网络接口请求类
 * http://api.tianapi.com/meinv/?key=18e883dd6b316eb1d97fd86338abbf06&num=10
 */

public interface GetDataInterface {
    /*
     * 简单使用Retrofit的get请求数据 不传递参数
     */
    @GET("/meinv/?key=18e883dd6b316eb1d97fd86338abbf06&num=10")
    Call<Bean> get1();

    /**
     * 使用Retrofit的post请求数据，使用@QueryMap注解传递集合参数
     */
    @POST("/meinv")         //此时使用@POST也可用
    Call<Bean> get2(@QueryMap Map<String,String> map);

    /**
     * 使用Retrofit的get请求数据，使用@QueryMap注解传递集合参数
     */
    @GET("/meinv")
    Observable<Bean> get(@QueryMap Map<String,String> map);
}
