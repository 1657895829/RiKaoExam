package app.com.rika09.view;

import app.com.rika09.bean.Bean;
/**
 * view层
 */

public interface MyView {
    public void onSuccess(Bean bean);
    public void onFailure(Exception e);
}
