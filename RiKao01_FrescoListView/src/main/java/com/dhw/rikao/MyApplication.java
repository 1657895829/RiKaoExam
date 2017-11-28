package com.dhw.rikao;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 初始化Fresco并做配置
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
