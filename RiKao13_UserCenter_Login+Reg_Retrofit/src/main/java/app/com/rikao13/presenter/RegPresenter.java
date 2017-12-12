package app.com.rikao13.presenter;


import app.com.rikao13.bean.RegBean;
import app.com.rikao13.model.ModelCallBack;
import app.com.rikao13.model.RegModel;
import app.com.rikao13.view.MyView;

/**
 * 注册p层
 */

public class RegPresenter {
    RegModel regModel = new RegModel();
    MyView.RegView regView;
    public RegPresenter(MyView.RegView regView) {
        this.regView = regView;
    }

    public void getData(String tel, String pwd) {
        regModel.getRegData(tel,pwd, new ModelCallBack.RegCallBack() {

            @Override
            public void success(RegBean regBean) {
                regView.sucess(regBean);
                System.out.println("注册p数据："+regBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("注册p错误："+code);
            }
        });
    }
}
