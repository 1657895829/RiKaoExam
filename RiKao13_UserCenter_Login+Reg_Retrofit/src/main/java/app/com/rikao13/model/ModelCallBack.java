package app.com.rikao13.model;

import app.com.rikao13.bean.LoginBean;
import app.com.rikao13.bean.PersonInfoBean;
import app.com.rikao13.bean.RegBean;

/**
 * MVP的三层编写步骤：
 * 1. 先写model层接口类，进行数据的存取
 */

public interface ModelCallBack {
    public interface LoginCallBack{
        //登录时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(LoginBean loginBean);
        //登录时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface RegCallBack {
        //注册时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(RegBean regBean);
        //注册时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    //个人中心
    public interface PersonCallBack{
        void success(PersonInfoBean personBean);
        void failed(Throwable code);
    }
}
