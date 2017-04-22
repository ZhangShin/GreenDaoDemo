package com.vogtec.greendaodemo;

import android.app.Application;

/**
 * Created by zx on 2017/4/21.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
    public static MyApplication getInstance(){
        return myApplication;
    }
}
