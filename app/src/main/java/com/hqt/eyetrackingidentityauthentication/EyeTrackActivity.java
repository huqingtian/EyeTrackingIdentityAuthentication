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

public class EyeTrackActivity extends AppCompatActivity {
    TextView txt_etclose, txt_etpwd0, txt_etpwd1, txt_etpwd2, txt_etpwd3, txt_etpwd4, txt_etpwd5, txt_etpwd6, txt_etpwd7, txt_etpwd8, txt_etpwd9, txt_showpwd1, txt_showpwd2, txt_showpwd3, txt_showpwd4, txt_tittle;
    ImageView img_cancelinput;
    String password = "";
    int number = 0, tag_EtPwd = 0;
    long exitTime;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_track);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        if("0".equals(user.ettag)){
            finish();
        }
        txt_etclose = findViewById(R.id.txt_etclose);
        txt_etpwd0 = findViewById(R.id.txt_etpwd0);
        txt_etpwd1 = findViewById(R.id.txt_etpwd1);
        txt_etpwd2 = findViewById(R.id.txt_etpwd2);
        txt_etpwd3 = findViewById(R.id.txt_etpwd3);
        txt_etpwd4 = findViewById(R.id.txt_etpwd4);
        txt_etpwd5 = findViewById(R.id.txt_etpwd5);
        txt_etpwd6 = findViewById(R.id.txt_etpwd6);
        txt_etpwd7 = findViewById(R.id.txt_etpwd7);
        txt_etpwd8 = findViewById(R.id.txt_etpwd8);
        txt_etpwd9 = findViewById(R.id.txt_etpwd9);
        txt_showpwd1 = findViewById(R.id.txt_showpwd1);
        txt_showpwd2 = findViewById(R.id.txt_showpwd2);
        txt_showpwd3 = findViewById(R.id.txt_showpwd3);
        txt_showpwd4 = findViewById(R.id.txt_showpwd4);
        txt_tittle = findViewById(R.id.txt_tittle);
        img_cancelinput = findViewById(R.id.img_cancelinput);
        txt_etclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersTable user = sqliteImplementer.getLoginedUser();
                if(!"".equals(user.username)){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(EyeTrackActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        txt_etpwd0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "0";
                showPwdNum();
            }
        });
        txt_etpwd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "1";
                showPwdNum();
            }
        });
        txt_etpwd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "2";
                showPwdNum();
            }
        });
        txt_etpwd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "3";
                showPwdNum();
            }
        });
        txt_etpwd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "4";
                showPwdNum();
            }
        });
        txt_etpwd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "5";
                showPwdNum();
            }
        });
        txt_etpwd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "6";
                showPwdNum();
            }
        });
        txt_etpwd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "7";
                showPwdNum();
            }
        });
        txt_etpwd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "8";
                showPwdNum();
            }
        });
        txt_etpwd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "9";
                showPwdNum();
            }
        });
        img_cancelinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = 0;
                password = "";
                showPwdNum();
            }
        });

        if(user.etpwd == null){
            tag_EtPwd = 1;
            txt_tittle.setText("请创建新的眼动密码");
        }
    }
    void showPwdNum(){
        if(number == 0){
            txt_showpwd1.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_showpwd2.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_showpwd3.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_showpwd4.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        }else if(number == 1){
            txt_showpwd1.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else if(number == 2){
            txt_showpwd2.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else if(number == 3){
            txt_showpwd3.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else{
            txt_showpwd4.setBackgroundResource(R.drawable.inputedpwd_shape);
            checkPwd();
        }
    }
    void checkPwd(){
        if(tag_EtPwd == 0){
            if(user.etpwd.equals(password)){
                finish();
                number = 0;
                password = "";
                showPwdNum();
            }else{
                Toast.makeText(EyeTrackActivity.this, "眼动密码错误", Toast.LENGTH_SHORT).show();
                number = 0;
                password = "";
                showPwdNum();
            }
        }else{
            sqliteImplementer.changeETPwd(user.username, password);
            finish();
        }
    }
}
