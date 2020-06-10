package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.Toast;
import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import java.math.BigInteger;
import java.security.MessageDigest;

public class LoginActivity extends AppCompatActivity {
    EditText edt_password;
    EditText edt_username;
    private float rawX ;
    private float rawY ;
    boolean flag = true;
    int num_username, num_password, num_register, num_login;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    String pwd = "";
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if(flag){
            if(msg.what == 1){
                if(rawX >= 140 && rawX <= 1300 && rawY >= 940 && rawY <= 1040){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_username.sendMessageDelayed(message,0);
                }else if(rawX >= 140 && rawX <= 1300 && rawY >= 1200 && rawY <= 1300){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_password.sendMessageDelayed(message,0);
                }else if(rawX >= 800 && rawX <= 1100 && rawY >= 2100 && rawY <= 2400){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_register.sendMessageDelayed(message,0);
                }else if(rawX >= 570 && rawX <= 810 && rawY >= 1560 && rawY <= 1820){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_login.sendMessageDelayed(message,0);
                }
                Message message = Message.obtain();
                message.what = 1;
                handler.sendMessageDelayed(message,300);
            }
        }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_username = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_username == 0){
                    num_username++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_username.sendMessageDelayed(message,350);
                }else if(num_username == 1){
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 940 && rawY <= 1040) {
                        num_username++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_username.sendMessageDelayed(message,350);
                    }else{
                        num_username = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 940 && rawY <= 1040) {
                        num_username = 0;
                        Intent intent = new Intent(LoginActivity.this, InputActivity.class);
                        startActivityForResult(intent,111);
                    }else{
                        num_username = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_password = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_password == 0){
                    num_password++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_password.sendMessageDelayed(message,350);
                }else if(num_password == 1){
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 1200 && rawY <= 1300) {
                        num_password++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_password.sendMessageDelayed(message,350);
                    }else{
                        num_password = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 1200 && rawY <= 1300) {
                        num_password = 0;
                        Intent intent = new Intent(LoginActivity.this, InputActivity.class);
                        startActivityForResult(intent, 112);
                    }else{
                        num_password = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_register = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_register == 0){
                    num_register++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_register.sendMessageDelayed(message,250);
                }else if(num_register == 1){
                    if(rawX >= 800 && rawX <= 1100 && rawY >= 2100 && rawY <= 2400) {
                        num_register++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_register.sendMessageDelayed(message,250);
                    }else{
                        num_register = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 800 && rawX <= 1100 && rawY >= 2100 && rawY <= 2400) {
                        num_register = 0;
                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivityForResult(intent,113);
                        edt_password.setText("");
                    }else{
                        num_register = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_login = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_login == 0){
                    num_login++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_login.sendMessageDelayed(message,350);
                }else if(num_login == 1){
                    if(rawX >= 570 && rawX <= 810 && rawY >= 1560 && rawY <= 1820) {
                        num_login++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_login.sendMessageDelayed(message,350);
                    }else{
                        num_login = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 570 && rawX <= 810 && rawY >= 1560 && rawY <= 1820) {
                        num_login = 0;
                        login();
                    }else{
                        num_login = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_password = findViewById(R.id.edt_password);
        edt_username = findViewById(R.id.edt_username);
        edt_password.setInputType(InputType.TYPE_NULL);
        edt_username.setInputType(InputType.TYPE_NULL);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        if(user != null){
            if(user.logined.equals("1")){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                Intent intent2 = new Intent(LoginActivity.this, EyeTrackActivity.class);
                startActivity(intent2);
                finish();
            }
        }
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rawX = ev.getRawX();
        rawY = ev.getRawY();
        return super.dispatchTouchEvent(ev);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 111) {
            String username = data.getStringExtra("key");
            edt_username.setText(username);
        }
        if (requestCode == 112 && resultCode == 111) {
            String password = data.getStringExtra("key");
            String temp = "";
            for(int i = 0; i < password.length(); i++){
                temp += "●";
            }
            edt_password.setText(temp);
            pwd = password;
        }
        rawX = 0;
        rawY = 0;
        flag = true;
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    void login(){
        String username = edt_username.getText().toString();
        String password =  getMD5String(pwd);
        UsersTable table = sqliteImplementer.getUser(username);
        if(!"".equals(table.password)) {
            if (password.equals(table.password)) {
                sqliteImplementer.changeUserLoginTag(username, "1");
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                Intent intent2 = new Intent(LoginActivity.this, EyeTrackActivity.class);
                startActivity(intent2);
                finish();
            }
            else{
                Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
        rawX = 0;
        rawY = 0;
        flag = true;
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
