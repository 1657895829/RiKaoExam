package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.retrofit.GetDataInterface;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 用于全局配置初始化异步加载类
 */
public class MyApplication extends Application {
    //设置公共变量
    public static  GetDataInterface request;

    @Override
    public void onCreate() {
        super.onCreate();
        //1.  用于全局配置初始化Fresco 图片加载
        Fresco.initialize(this);

        //2.  用于全局配置初始化Retrofit 网络请求  RxJava结合Retrofit
        //构建Retrofit类，初始化参数
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                // call 转化成 Observerable
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //创建网络请求接口实例
        request = retrofit.create(GetDataInterface.class);
    }
}
