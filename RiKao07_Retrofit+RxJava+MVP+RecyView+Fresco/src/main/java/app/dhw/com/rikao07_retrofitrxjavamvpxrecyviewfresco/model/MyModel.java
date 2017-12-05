package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.model;

import java.util.HashMap;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.app.MyApplication;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.bean.Bean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//model接口实现类
public class MyModel {
    /**
     * 简单使用Retrofit的get请求, 不传递参数
     * @param callBack
     */
    public void getData1(final ModelCallBack callBack){
        //设置接口请求的key值
        Call<Bean> call = MyApplication.request.get1();

        //发起异步请求
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                //获取响应的数据
                Bean bean = response.body();

                //请求成功时返回数据
                callBack.onSuccess(bean);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                //请求失败时返回数据
                callBack.onFailure(new Exception(""));
            }
        });
    }

    /**
     * 简单使用Retrofit的get请求, 使用@QueryMap注解传递集合参数
     * @param callBack
     */
    public void getData2(final ModelCallBack callBack){
        //设置接口请求的集合参数
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "18e883dd6b316eb1d97fd86338abbf06");
        map.put("num", "10");

        Call<Bean> call = MyApplication.request.get2(map);

        //发起异步请求
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                //获取响应的数据
                Bean bean = response.body();

                //请求成功时返回数据
                callBack.onSuccess(bean);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                //请求失败时返回数据
                callBack.onFailure(new Exception(""));
            }
        });
    }


    /**
     * 使用Retrofit结合RxJava的get请求数据，使用@QueryMap注解传递集合参数
     * @param callBack
     */
    public void getData(final ModelCallBack callBack) {
        //设置接口请求的集合参数
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "18e883dd6b316eb1d97fd86338abbf06");
        map.put("num", "10");

        MyApplication.request.get(map)                      //获取Observable对象
                .subscribeOn(Schedulers.io())               //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())  //最后在主线程中执行

                //进行事件的订阅，使用Consumer实现
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        //请求成功时返回数据
                        callBack.onSuccess(bean);
                        System.out.println(bean.toString());
                    }
                });
    }

}
