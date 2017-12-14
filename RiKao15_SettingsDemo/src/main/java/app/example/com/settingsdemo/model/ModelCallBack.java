package app.example.com.settingsdemo.model;

import app.example.com.settingsdemo.bean.VersionBean;

/**
 * model层接口
 */
public interface ModelCallBack {
    void onSuccess(VersionBean bean);
    void onFailure(Exception e);
}
