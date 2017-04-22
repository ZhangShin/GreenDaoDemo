package com.vogtec.greendaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vogtec.greendaodemo.entity.User;
import com.vogtec.greendaodemo.greendao.DaoManager;
import com.vogtec.greendaodemo.greendao.UserDao;

import org.greenrobot.greendao.query.Query;

public class MainActivity extends AppCompatActivity {

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaoManager daoManager = DaoManager.getInstance();
        userDao = daoManager.getDaoSession().getUserDao();
        initView();
    }

    private void initView() {
        final EditText et_username = (EditText) findViewById(R.id.et_username);
        final EditText et_password = (EditText) findViewById(R.id.et_password);
        Button btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                Query query = userDao.queryBuilder().where(UserDao.Properties.Username.eq(username)).build();
                if (query.unique() != null){
                    Toast.makeText(MainActivity.this,"用户名已注册",Toast.LENGTH_SHORT).show();
                }else {
                    User user = new User(null,username,password);
                    userDao.insert(user);
                    Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                Query query = userDao.queryBuilder().where(UserDao.Properties.Password.eq(password)
                        , UserDao.Properties.Username.eq(username)).build();
                if (query.unique() != null){
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,EditActivity.class);
                    intent.putExtra("login_user",username);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
