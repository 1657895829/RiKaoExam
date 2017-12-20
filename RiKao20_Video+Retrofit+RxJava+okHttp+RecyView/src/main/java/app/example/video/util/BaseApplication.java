package app.example.video.util;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

//全局初始化Application类
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //用于全局配置初始化Fresco 图片加载
        Fresco.initialize(this,Fresco_ImagePipelineConfigUtil.getDefaultImagePipelineConfig(this));

    }

}
