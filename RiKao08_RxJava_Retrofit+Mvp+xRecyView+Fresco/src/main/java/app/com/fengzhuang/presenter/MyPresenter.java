package app.com.fengzhuang.presenter;

import app.com.fengzhuang.base.BasePresenter;
import app.com.fengzhuang.bean.Bean;
import app.com.fengzhuang.model.ModelCallBack;
import app.com.fengzhuang.model.MyModel;
import app.com.fengzhuang.view.MyView;

// Presenter层继承自定义的泛型Presenter层（持有view层接口），进行view层与model数据的交互
public class MyPresenter extends BasePresenter<MyView> {
    private MyModel myModel;
    public MyPresenter() {
        this.myModel = new MyModel();
    }

    /**
     * 简单使用Retrofit的get请求, 不传递参数
     */
    public void get1(){
        myModel.getData1(new ModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onFailure(new Exception("e"));
                }
            }
        });
    }

    /**
     * 简单使用Retrofit的get请求, 使用@QueryMap注解传递集合参数
     * 传递页数num
     */
    public void get2(String num){
        myModel.getData2(num,new ModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onFailure(new Exception("e"));
                }
            }
        });
    }

    /**
     * 简单使用Retrofit结合RxJava的get请求数据, 使用@QueryMap注解传递集合参数
     */
    public void get(){
        myModel.getData(new ModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                //数据交互时，为防止内存泄露，设置view层数据为空
                if (view != null){
                    view.onFailure(new Exception("e"));
                }
            }
        });
    }

    //取消p层与v层的绑定，防止内存泄露
    public void detach(){
        this.view = null;
    }
}
