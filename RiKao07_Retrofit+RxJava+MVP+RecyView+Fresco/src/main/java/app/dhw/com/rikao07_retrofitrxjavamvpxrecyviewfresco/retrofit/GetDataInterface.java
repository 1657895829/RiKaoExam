package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.retrofit;

import java.util.Map;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.bean.Bean;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 网络接口数据的请求类
 * 接口：APIKEY=‘71e58b5b2f930eaf1f937407acde08fe’
        http://api.tianapi.com/nba/?key=APIKEY&num=10
 */
public interface GetDataInterface {
    /*
     * 简单使用Retrofit的get请求数据 不传递参数
     */
    @GET("/nba/?key=18e883dd6b316eb1d97fd86338abbf06&num=10")
    Call<Bean> get1();

    /**
     * 使用Retrofit的get请求数据，使用@QueryMap注解传递集合参数
     */
    @POST("/nba")
    Call<Bean> get2(@QueryMap Map<String,String> map);

    /**
     * 使用Retrofit的get请求数据，使用@QueryMap注解传递集合参数
     */
    @GET("/nba")
    Observable<Bean> get(@QueryMap Map<String,String> map);

    /**
     * 使用Retrofit的post请求数据，使用@FieldMap注解传递集合参数
     * 但是此接口不能使用post请求，因为该接口返回的数据只有get方式,所以下面的注解不能用（可以参照引用能用post方式的接口）
     */
    @FormUrlEncoded
    @POST("/nba")
    Observable<Bean> post(@FieldMap Map<String,String> map);
}
