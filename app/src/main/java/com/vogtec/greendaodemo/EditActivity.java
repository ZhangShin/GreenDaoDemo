package com.vogtec.greendaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vogtec.greendaodemo.entity.UserInfo;
import com.vogtec.greendaodemo.greendao.DaoManager;
import com.vogtec.greendaodemo.greendao.UserInfoDao;

import java.util.List;

/**
 * Created by zx on 2017/4/20.
 */

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_watt;
    private EditText et_km;
    private EditText et_kcal;
    private String login_user;
    private UserInfoDao userInfoDao;
    private int watt;
    private double km;
    private double kcal;
    private TextView tv_show;
    private StringBuilder mStringBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent intent = getIntent();
        login_user = intent.getStringExtra("login_user");
        Log.e("tag",login_user);
        DaoManager daoManager = DaoManager.getInstance();
        userInfoDao = daoManager.getDaoSession().getUserInfoDao();
        initView();
    }

    private void initView() {
        et_watt = (EditText) findViewById(R.id.et_watt);
        et_km = (EditText) findViewById(R.id.et_km);
        et_kcal = (EditText) findViewById(R.id.et_kcal);
        Button btn_submit = (Button) findViewById(R.id.btn_submit);
        Button btn_check = (Button) findViewById(R.id.btn_check);
        tv_show = (TextView) findViewById(R.id.tv_show);
        btn_submit.setOnClickListener(this);
        btn_check.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_submit:
                watt = Integer.parseInt(et_watt.getText().toString());
                km = Double.parseDouble(et_km.getText().toString());
                kcal = Double.parseDouble(et_kcal.getText().toString());
                UserInfo userInfo = new UserInfo(null,login_user,watt,km,kcal,"10");
                userInfoDao.insert(userInfo);
                break;
            case R.id.btn_check:
                 List<UserInfo> list = userInfoDao.queryBuilder().where(UserInfoDao.Properties.Username.eq(login_user)).list();
                Log.e("tag",list.size()+"");
                for (UserInfo info:list){
                     Log.e("tag",info.toString());
                 }
                break;
        }
    }

}
