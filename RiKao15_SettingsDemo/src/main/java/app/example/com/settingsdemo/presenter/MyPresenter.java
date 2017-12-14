package app.example.com.settingsdemo.presenter;

import app.example.com.settingsdemo.bean.VersionBean;
import app.example.com.settingsdemo.model.ModelCallBack;
import app.example.com.settingsdemo.model.MyModel;
import app.example.com.settingsdemo.view.MyView;

/**
 * presenter层
 */
public class MyPresenter {
    private MyView myView;
    private MyModel model;

    public MyPresenter(MyView myView) {
        this.myView = myView;
        this.model = new MyModel();
    }

    public void get(int type){
        model.getData(type, new ModelCallBack() {
            @Override
            public void onSuccess(VersionBean bean) {
                if (myView != null){
                    myView.onSuccess(bean);
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (myView != null){
                    myView.onFailure(e);
                }
            }
        });
    }
}
