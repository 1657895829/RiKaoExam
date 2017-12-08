package app.com.rikao10.model;

import java.util.List;
import java.util.concurrent.TimeUnit;
import app.com.rikao10.bean.ChildBean;
import app.com.rikao10.bean.LeftBean;
import app.com.rikao10.bean.RightBean;
import app.com.rikao10.retrofit.GetDataInterface;
import app.com.rikao10.util_retrofit_rxjava_okhttp.LoggingInterceptor;
import app.com.rikao10.util_retrofit_rxjava_okhttp.RetrofitUnitl;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

/**
 * 分类页面model层实现类
 */
public class FenLeiModel {
    //左边请求接口获取分类数据  https://www.zhaoapi.cn/product/getCatagory
    public void getLeftModel(final FenLeiModelCallBack callBack){
        //使用okhttp请求,添加拦截器时把下面代码解释
        OkHttpClient ok = new OkHttpClient.Builder()
                .connectTimeout(20000, TimeUnit.SECONDS)
                .writeTimeout(20000,TimeUnit.SECONDS)
                .readTimeout(20000,TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();

        RetrofitUnitl.getInstance("https://www.zhaoapi.cn",ok)
                .setCreate(GetDataInterface.class)
                .getLeftCall()
                .subscribeOn(Schedulers.io())              //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread()) //最后在主线程中执行

        //进行事件的订阅，使用Consumer实现
        .subscribe(new Consumer<LeftBean>() {
            @Override
            public void accept(LeftBean leftBean) throws Exception {
                //获取返回数据
                List<LeftBean.DataBean> data = leftBean.getData();
                callBack.LeftCallBack(data);
                System.out.println("Model层左边数据成功返回"+data.toString());
            }
        });
    }


    //右边请求接口获取分类数据,根据cid页数获取数据  https://www.zhaoapi.cn/product/getProductCatagory?cid=1
    public void getRightModel(int count,final FenLeiModelCallBack callBack){
        //使用okhttp请求,添加拦截器时把下面代码解释
        OkHttpClient ok = new OkHttpClient.Builder()
                .connectTimeout(20000, TimeUnit.SECONDS)
                .writeTimeout(20000,TimeUnit.SECONDS)
                .readTimeout(20000,TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();

        RetrofitUnitl.getInstance("https://www.zhaoapi.cn", ok)
                .setCreate(GetDataInterface.class)
                .getRightCall(count)
                .subscribeOn(Schedulers.io())              //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread()) //最后在主线程中执行

        //进行事件的订阅，使用Consumer实现
        .subscribe(new Consumer<RightBean>() {
            @Override
            public void accept(RightBean rightBean) throws Exception {
                //获取返回数据
                List<RightBean.DataBean> data = rightBean.getData();
                callBack.RightCallBack(data);
                System.out.println("Model层右边数据成功返回"+data.toString());
            }
        });
    }


    //子分类下面的列表 https://www.zhaoapi.cn/product/getProducts?pscid==1
    public void getChildModel(int count, final FenLeiModelCallBack callBack){
        //使用okhttp请求,添加拦截器时把下面代码解释
        OkHttpClient ok = new OkHttpClient.Builder()
                .connectTimeout(20000, TimeUnit.SECONDS)
                .writeTimeout(20000,TimeUnit.SECONDS)
                .readTimeout(20000,TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();

        RetrofitUnitl.getInstance("https://www.zhaoapi.cn" + count, ok)
                .setCreate(GetDataInterface.class)
                .getChildCall(count)
                .subscribeOn(Schedulers.io())              //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread()) //最后在主线程中执行

        //进行事件的订阅，使用Consumer实现
        .subscribe(new Consumer<ChildBean>() {
            @Override
            public void accept(ChildBean childBean) throws Exception {
                //获取返回数据
                List<ChildBean.DataBean> data = childBean.getData();
                callBack.ChildCallBack(data);
                System.out.println("子分类数据成功返回"+data.toString());
            }
        });
    }
}
