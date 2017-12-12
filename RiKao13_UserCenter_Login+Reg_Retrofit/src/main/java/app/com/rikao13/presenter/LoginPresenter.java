package app.com.rikao13.presenter;

import app.com.rikao13.bean.LoginBean;
import app.com.rikao13.model.LoginModel;
import app.com.rikao13.model.ModelCallBack;
import app.com.rikao13.view.MyView;

/**
 * 登录p层
 */

public class LoginPresenter {

    LoginModel loginModel = new LoginModel();
    MyView.LoginView loginView;
    public LoginPresenter(MyView.LoginView loginView) {
        this.loginView = loginView;
    }

    public void getData(String tel, String pwd) {
        loginModel.getLoginData(tel,pwd, new ModelCallBack.LoginCallBack() {
            @Override
            public void success(LoginBean dengluBean) {
                loginView.success(dengluBean);
                System.out.println("登录p数据："+dengluBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("登录p错误："+code);
            }
        });
    }
}
