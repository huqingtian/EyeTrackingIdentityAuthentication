package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class ComfirmEtActivity extends AppCompatActivity {
    TextView txt_comfirm_etclose, txt_comfirm_etpwd0, txt_comfirm_etpwd1, txt_comfirm_etpwd2, txt_comfirm_etpwd3, txt_comfirm_etpwd4, txt_comfirm_etpwd5, txt_comfirm_etpwd6, txt_comfirm_etpwd7, txt_comfirm_etpwd8, txt_comfirm_etpwd9, txt_comfirm_showpwd1, txt_comfirm_showpwd2, txt_comfirm_showpwd3, txt_comfirm_showpwd4;
    ImageView img_comfirm_cancelinput;
    String password = "";
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm_et);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        txt_comfirm_etclose = findViewById(R.id.txt_comfirm_etclose);
        txt_comfirm_etpwd0 = findViewById(R.id.txt_comfirm_etpwd0);
        txt_comfirm_etpwd1 = findViewById(R.id.txt_comfirm_etpwd1);
        txt_comfirm_etpwd2 = findViewById(R.id.txt_comfirm_etpwd2);
        txt_comfirm_etpwd3 = findViewById(R.id.txt_comfirm_etpwd3);
        txt_comfirm_etpwd4 = findViewById(R.id.txt_comfirm_etpwd4);
        txt_comfirm_etpwd5 = findViewById(R.id.txt_comfirm_etpwd5);
        txt_comfirm_etpwd6 = findViewById(R.id.txt_comfirm_etpwd6);
        txt_comfirm_etpwd7 = findViewById(R.id.txt_comfirm_etpwd7);
        txt_comfirm_etpwd8 = findViewById(R.id.txt_comfirm_etpwd8);
        txt_comfirm_etpwd9 = findViewById(R.id.txt_comfirm_etpwd9);
        txt_comfirm_showpwd1 = findViewById(R.id.txt_comfirm_showpwd1);
        txt_comfirm_showpwd2 = findViewById(R.id.txt_comfirm_showpwd2);
        txt_comfirm_showpwd3 = findViewById(R.id.txt_comfirm_showpwd3);
        txt_comfirm_showpwd4 = findViewById(R.id.txt_comfirm_showpwd4);
        img_comfirm_cancelinput = findViewById(R.id.img_comfirm_cancelinput);
        txt_comfirm_etclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txt_comfirm_etpwd0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "0";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "1";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "2";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "3";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "4";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "5";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "6";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "7";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "8";
                showPwdNum();
            }
        });
        txt_comfirm_etpwd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                password += "9";
                showPwdNum();
            }
        });
        img_comfirm_cancelinput.setOnClickListener(new View.OnClickListener() {
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
            txt_comfirm_showpwd1.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_comfirm_showpwd2.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_comfirm_showpwd3.setBackgroundResource(R.drawable.eyetrackpwd_shape);
            txt_comfirm_showpwd4.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        }else if(number == 1){
            txt_comfirm_showpwd1.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else if(number == 2){
            txt_comfirm_showpwd2.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else if(number == 3){
            txt_comfirm_showpwd3.setBackgroundResource(R.drawable.inputedpwd_shape);
        }else{
            txt_comfirm_showpwd4.setBackgroundResource(R.drawable.inputedpwd_shape);
            checkPwd();
        }
    }
    void checkPwd(){
        UsersTable user = sqliteImplementer.getLoginedUser();
        String username = user.username;
        if(password.equals(user.etpwd)){
            setResult(0x111);
            finish();
        }else{
            Toast.makeText(ComfirmEtActivity.this, "眼动密码错误", Toast.LENGTH_SHORT).show();
            number = 0;
            password = "";
            showPwdNum();
        }
    }
}
