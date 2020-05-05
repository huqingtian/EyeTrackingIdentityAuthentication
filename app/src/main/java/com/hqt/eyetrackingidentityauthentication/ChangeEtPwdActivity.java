package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import java.util.List;

public class ChangeEtPwdActivity extends AppCompatActivity {
    TextView txt_change_etclose, txt_change_etpwd0, txt_change_etpwd1, txt_change_etpwd2, txt_change_etpwd3, txt_change_etpwd4, txt_change_etpwd5, txt_change_etpwd6, txt_change_etpwd7, txt_change_etpwd8, txt_change_etpwd9, txt_change_showpwd1, txt_change_showpwd2, txt_change_showpwd3, txt_change_showpwd4, txt_change_tittle;
    ImageView img_change_cancelinput;
    String password = "";
    int number = 0, sec = 0;
    long exitTime;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_et_pwd);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        txt_change_etclose = findViewById(R.id.txt_change_etclose);
        txt_change_etpwd0 = findViewById(R.id.txt_change_etpwd0);
        txt_change_etpwd1 = findViewById(R.id.txt_change_etpwd1);
        txt_change_etpwd2 = findViewById(R.id.txt_change_etpwd2);
        txt_change_etpwd3 = findViewById(R.id.txt_change_etpwd3);
        txt_change_etpwd4 = findViewById(R.id.txt_change_etpwd4);
        txt_change_etpwd5 = findViewById(R.id.txt_change_etpwd5);
        txt_change_etpwd6 = findViewById(R.id.txt_change_etpwd6);
        txt_change_etpwd7 = findViewById(R.id.txt_change_etpwd7);
        txt_change_etpwd8 = findViewById(R.id.txt_change_etpwd8);
        txt_change_etpwd9 = findViewById(R.id.txt_change_etpwd9);
        txt_change_showpwd1 = findViewById(R.id.txt_change_showpwd1);
        txt_change_showpwd2 = findViewById(R.id.txt_change_showpwd2);
        txt_change_showpwd3 = findViewById(R.id.txt_change_showpwd3);
        txt_change_showpwd4 = findViewById(R.id.txt_change_showpwd4);
        txt_change_tittle = findViewById(R.id.txt_change_tittle);
        img_change_cancelinput = findViewById(R.id.img_change_cancelinput);
        txt_change_etclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersTable user = sqliteImplementer.getLoginedUser();
                if(user != null){
                    finish();
                }else{
                    Intent intent = new Intent(ChangeEtPwdActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        txt_change_etpwd0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "0";
                showPwdNum();
            }
        });
        txt_change_etpwd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "1";
                showPwdNum();
            }
        });
        txt_change_etpwd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "2";
                showPwdNum();
            }
        });
        txt_change_etpwd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "3";
                showPwdNum();
            }
        });
        txt_change_etpwd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "4";
                showPwdNum();
            }
        });
        txt_change_etpwd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "5";
                showPwdNum();
            }
        });
        txt_change_etpwd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "6";
                showPwdNum();
            }
        });
        txt_change_etpwd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "7";
                showPwdNum();
            }
        });
        txt_change_etpwd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "8";
                showPwdNum();
            }
        });
        txt_change_etpwd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "9";
                showPwdNum();
            }
        });
        img_change_cancelinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = 0;
                password = "";
                showPwdNum();
            }
        });
    }
    void showPwdNum(){
        if(number == 0){
            txt_change_showpwd1.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_change_showpwd2.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_change_showpwd3.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_change_showpwd4.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        }else if(number == 1){
            txt_change_showpwd1.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else if(number == 2){
            txt_change_showpwd2.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else if(number == 3){
            txt_change_showpwd3.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else{
            txt_change_showpwd4.setBackgroundResource(R.drawable.inputedpwd_shape);
            checkPwd();
        }
    }
    void checkPwd(){
        UsersTable user = sqliteImplementer.getLoginedUser();
        String username = user.username;
        String etpwd = user.etpwd;
        if(sec == 0){
            if(etpwd.equals(password)){
                txt_change_tittle.setText("请输入新的眼动密码");
                number = 0;
                password = "";
                showPwdNum();
                sec++;
            }else{
                Toast.makeText(ChangeEtPwdActivity.this, "眼动密码错误", Toast.LENGTH_SHORT).show();
                number = 0;
                password = "";
                showPwdNum();
            }
        }else{
            Toast.makeText(ChangeEtPwdActivity.this, "眼动密码修改成功", Toast.LENGTH_SHORT).show();
            sqliteImplementer.changeETPwd(username, password);
            finish();
        }
    }
}
