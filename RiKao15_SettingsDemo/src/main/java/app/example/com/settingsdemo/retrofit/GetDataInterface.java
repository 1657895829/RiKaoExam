package app.example.com.settingsdemo.retrofit;

import app.example.com.settingsdemo.bean.VersionBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 网络接口数据的请求类
 *   版本更新接口
     https://www.zhaoapi.cn/version/getVersion?type=0
     请求参数说明：
     type 类型字段 String类型 必传
     返回参数说明：
     versionCode 版本号
     versionName版本名称
     apkUrl  apk地址
 */
public interface GetDataInterface {
    /*
     * 使用Observable被观察者模式下的的get请求数据 @Query注解传递参数
     */
    @GET("/version/getVersion")
    Observable<VersionBean> getData(@Query("type") int type);
}
