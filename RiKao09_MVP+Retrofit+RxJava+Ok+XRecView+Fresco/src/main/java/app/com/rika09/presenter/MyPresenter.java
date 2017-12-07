package app.com.rika09.presenter;

import app.com.rika09.base.BasePresenter;
import app.com.rika09.bean.Bean;
import app.com.rika09.model.ModelCallBack;
import app.com.rika09.model.MyModel;
import app.com.rika09.view.MyView;

/**
 * Presenter层,继承自定义的泛型Presenter层（持有view层接口），进行view层与model数据的交互
 */
public class MyPresenter extends BasePresenter<MyView>{
    //声明model层
    private MyModel myModel;

    public MyPresenter() {
        this.myModel = new MyModel();
    }

    //获取数据的方法
    public void get(){
        myModel.getData(new ModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFailure(Exception e) {
                view.onFailure(e);
            }
        });
    }

    //取消绑定，防止内存泄露
    public void detach(){
        view = null;
    }
}
