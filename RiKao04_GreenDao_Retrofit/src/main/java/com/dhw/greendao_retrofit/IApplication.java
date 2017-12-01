package com.dhw.greendao_retrofit;

import android.app.Application;
import com.dhw.greendao_retrofit.dao.DaoMaster;
import com.dhw.greendao_retrofit.dao.DaoSession;
import org.greenrobot.greendao.database.Database;

/**
 * 新建IApplication类，继承Application类，实现数据库的初始化全局配置
 */
public class IApplication extends Application {

    //设置session为公用
    public static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "rikao");

        //获取数据库
        //Database database = helper.getEncryptedWritableDb("rikao4");
        Database db = helper.getWritableDb();

        //操作数据库,等于打开数据库
        session = new DaoMaster(db).newSession();

    }
}
