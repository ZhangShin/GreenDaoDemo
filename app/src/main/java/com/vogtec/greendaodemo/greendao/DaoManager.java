package com.vogtec.greendaodemo.greendao;

import com.vogtec.greendaodemo.MyApplication;

/**
 * Created by zx on 2017/4/21.
 */

public class DaoManager {
    private static DaoManager mDaoManager;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    public static DaoManager getInstance(){
        if (mDaoManager == null){
            mDaoManager = new DaoManager();
        }
        return  mDaoManager;
    }
    private DaoManager(){
//        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(
//                MyApplication.getInstance().getApplicationContext(),"green_db",null);
//        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        MyOpenHelper helper = new MyOpenHelper(MyApplication.getInstance().getApplicationContext(),"green_db",null);
        daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();

    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
