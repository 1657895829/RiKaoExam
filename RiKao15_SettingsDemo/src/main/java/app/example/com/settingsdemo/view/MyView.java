package app.example.com.settingsdemo.view;

import app.example.com.settingsdemo.bean.VersionBean;

/**
 * view接口层
 */

public interface MyView {
    void onSuccess(VersionBean bean);
    void onFailure(Exception e);
}
