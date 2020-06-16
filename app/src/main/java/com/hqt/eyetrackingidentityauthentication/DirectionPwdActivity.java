package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import java.math.BigInteger;
import java.security.MessageDigest;

public class DirectionPwdActivity extends AppCompatActivity {
    TextView txt_dir_tittle;
    FrameLayout fl_dir;
    private float rawX;
    private float rawY;
    boolean flag = true, hav_dirPwd = true;
    int num_cancel, num_top, num_left, num_bottom, num_right, num_pwd;
    String password = "";
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction_pwd);
        txt_dir_tittle = findViewById(R.id.txt_dir_tittle);
        fl_dir = findViewById(R.id.fl_dir);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        if(user.dirpwd == null){
            hav_dirPwd = false;
            AlertDialog alertDialog = new AlertDialog.Builder(DirectionPwdActivity.this).create();
            alertDialog.setIcon(R.drawable.img_warning);
            alertDialog.setTitle("提示");
            alertDialog.setMessage("此次为您第一次登陆，请创建您的方向密码");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,300);
    }
    void show(){
        if(num_pwd == 1){
            txt_dir_tittle.setText("请选择第二个方向");
            fl_dir.setBackgroundColor(Color.argb(80, 114, 211, 255));
        }else if(num_pwd == 2){
            txt_dir_tittle.setText("请选择第三个方向");
            fl_dir.setBackgroundColor(Color.argb(80, 246, 238, 163));
        }else if(num_pwd == 3){
            txt_dir_tittle.setText("请选择第四个方向");
            fl_dir.setBackgroundColor(Color.argb(80, 255, 188, 167));
        }else if(num_pwd == 4){
            if(hav_dirPwd){
                if(getMD5String(password).equals(user.dirpwd)){
                    Toast.makeText(DirectionPwdActivity.this, "认证成功", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(DirectionPwdActivity.this, "方向密码错误", Toast.LENGTH_SHORT).show();
                    password = "";
                    num_pwd = 0;
                    txt_dir_tittle.setText("请选择第一个方向");
                    fl_dir.setBackgroundColor(Color.WHITE);
                }
            }else{
                Toast.makeText(DirectionPwdActivity.this, "创建方向密码成功", Toast.LENGTH_SHORT).show();
                sqliteImplementer.changeDirPwd(user.username, getMD5String(password));
                finish();
            }
        }
    }
    public static String getMD5String(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rawX = ev.getRawX();
        rawY = ev.getRawY();
        return super.dispatchTouchEvent(ev);
    }
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag){
                if(msg.what == 1){
                    if(rawX >= 1130 && rawX <= 1395 && rawY >= 1890 && rawY <= 2020){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_cancel.sendMessageDelayed(message,0);
                    }else if(rawX >= 600 && rawX <= 850 && rawY >= 670 && rawY <= 890){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_top.sendMessageDelayed(message,0);
                    }else if(rawX >= 120 && rawX <= 370 && rawY >= 1120 && rawY <= 1340){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_left.sendMessageDelayed(message,0);
                    }else if(rawX >= 600 && rawX <= 850 && rawY >= 1570 && rawY <= 1790){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_bottom.sendMessageDelayed(message,0);
                    }else if(rawX >= 1060 && rawX <= 1320 && rawY >= 1130 && rawY <= 1350){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_right.sendMessageDelayed(message,0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_cancel = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_cancel == 0){
                    num_cancel++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_cancel.sendMessageDelayed(message,250);
                }else if(num_cancel == 1){
                    if(rawX >= 1130 && rawX <= 1395 && rawY >= 1890 && rawY <= 2020) {
                        num_cancel++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_cancel.sendMessageDelayed(message,250);
                    }else{
                        num_cancel = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1130 && rawX <= 1395 && rawY >= 1890 && rawY <= 2020) {
                        finish();
                    }else{
                        num_cancel = 0;
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
    Handler handler_top = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_top == 0){
                    num_top++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_top.sendMessageDelayed(message,250);
                }else if(num_top == 1){
                    if(rawX >= 600 && rawX <= 850 && rawY >= 670 && rawY <= 890) {
                        num_top++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_top.sendMessageDelayed(message,250);
                    }else{
                        num_top = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 600 && rawX <= 850 && rawY >= 670 && rawY <= 890) {
                        num_pwd++;
                        password += "0";
                        show();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_top.sendMessageDelayed(message,300);
                    }else{
                        num_top = 0;
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
    Handler leave_handler_top = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 600 && rawX <= 850 && rawY >= 670 && rawY <= 890){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_top.sendMessageDelayed(message,300);
                }else{
                    num_top = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_left = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_left == 0){
                    num_left++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_left.sendMessageDelayed(message,250);
                }else if(num_left == 1){
                    if(rawX >= 120 && rawX <= 370 && rawY >= 1120 && rawY <= 1340) {
                        num_left++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_left.sendMessageDelayed(message,250);
                    }else{
                        num_left = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 120 && rawX <= 370 && rawY >= 1120 && rawY <= 1340) {
                        num_pwd++;
                        password += "1";
                        show();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_left.sendMessageDelayed(message,300);
                    }else{
                        num_left = 0;
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
    Handler leave_handler_left = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 120 && rawX <= 370 && rawY >= 1120 && rawY <= 1340){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_left.sendMessageDelayed(message,300);
                }else{
                    num_left = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_bottom = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_bottom == 0){
                    num_bottom++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_bottom.sendMessageDelayed(message,250);
                }else if(num_bottom == 1){
                    if(rawX >= 600 && rawX <= 850 && rawY >= 1570 && rawY <= 1790) {
                        num_bottom++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_bottom.sendMessageDelayed(message,250);
                    }else{
                        num_bottom = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 600 && rawX <= 850 && rawY >= 1570 && rawY <= 1790) {
                        num_pwd++;
                        password += "2";
                        show();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_bottom.sendMessageDelayed(message,300);
                    }else{
                        num_bottom = 0;
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
    Handler leave_handler_bottom = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 600 && rawX <= 850 && rawY >= 1570 && rawY <= 1790){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_bottom.sendMessageDelayed(message,300);
                }else{
                    num_bottom = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_right = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_right == 0){
                    num_right++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_right.sendMessageDelayed(message,250);
                }else if(num_right == 1){
                    if(rawX >= 1060 && rawX <= 1320 && rawY >= 1130 && rawY <= 1350) {
                        num_right++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_right.sendMessageDelayed(message,250);
                    }else{
                        num_right = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1060 && rawX <= 1320 && rawY >= 1130 && rawY <= 1350) {
                        num_pwd++;
                        password += "3";
                        show();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_right.sendMessageDelayed(message,300);
                    }else{
                        num_right = 0;
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
    Handler leave_handler_right = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1060 && rawX <= 1320 && rawY >= 1130 && rawY <= 1350){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_right.sendMessageDelayed(message,300);
                }else{
                    num_right = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
}
