package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.view;

import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.bean.Bean;

/**
 * view层接口类，请求成功与失败的方法
 */
public interface MyView {
    public void onSuccess(Bean bean);
    public void onFailure(Exception e);
}
