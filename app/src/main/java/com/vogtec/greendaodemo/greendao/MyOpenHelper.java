package com.vogtec.greendaodemo.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vogtec.greendaodemo.greendao.DaoMaster.OpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by zx on 2017/4/22.
 */

public class MyOpenHelper extends OpenHelper {
    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /***
     * 数据库更新
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //操作数据库的更新 所有表都必须传入到下面 否则数据会被清空
        MigrationHelper.getInstance().migrate(db,UserDao.class,UserInfoDao.class);
    }
}
