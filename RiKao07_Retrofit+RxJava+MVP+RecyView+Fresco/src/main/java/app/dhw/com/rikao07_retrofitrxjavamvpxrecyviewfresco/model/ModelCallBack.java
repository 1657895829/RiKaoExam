package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.model;

import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.bean.Bean;

/**
 * model层接口，成功和失败的方法
 */
public interface ModelCallBack {
    public void onSuccess(Bean bean);
    public void onFailure(Exception e);
}
