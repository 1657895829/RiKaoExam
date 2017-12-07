package app.com.rika09.model;

import app.com.rika09.bean.Bean;

/**
 * model层接口类
 */
public interface ModelCallBack {
    public void onSuccess(Bean   bean);
    public void onFailure(Exception e);
}
