package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class GesturePwdActivity extends AppCompatActivity {
    FrameLayout fl_ges;
    TextView txt_ges_1, txt_ges_2, txt_ges_3, txt_ges_4, txt_ges_5, txt_ges_6, txt_ges_7, txt_ges_8, txt_ges_9;
    int num_pwd, num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, num_cancel, num_submit;
    private float rawX;
    private float rawY;
    boolean flag = true, hav_gespwd = true, tag_1 = true, tag_2 = true, tag_3 = true, tag_4 = true, tag_5 = true, tag_6 = true, tag_7 = true, tag_8 = true, tag_9 = true;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    String password = "";
    ArrayList<Integer> list_x = new ArrayList<Integer>();
    ArrayList<Integer> list_y = new ArrayList<Integer>();
    ArrayList<GesDrawView> list_view = new ArrayList<GesDrawView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_pwd);
        init();
    }
    void draw(int n){
        num_pwd++;
        if(num_pwd == 1){
            changeColor(n);
        }else if(num_pwd >=2){
            changeColor(n);
            GesDrawView g = new GesDrawView(this, list_x.get(num_pwd - 2), list_y.get(num_pwd - 2), list_x.get(num_pwd - 1), list_y.get(num_pwd - 1));
            list_view.add(num_pwd - 2, g);
            fl_ges.addView(g);
            System.out.println(password);
        }
    }
    void checkPwd(){
        if(hav_gespwd){
            if(getMD5String(password).equals(user.gespwd)){
                Toast.makeText(GesturePwdActivity.this, "认证成功", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(GesturePwdActivity.this, "手势密码错误", Toast.LENGTH_SHORT).show();
                reset();
            }
        }else{
            Toast.makeText(GesturePwdActivity.this, "创建手势密码成功", Toast.LENGTH_SHORT).show();
            sqliteImplementer.changeGesPwd(user.username, getMD5String(password));
            finish();
        }
    }
    void reset(){
        txt_ges_1.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_2.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_3.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_4.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_5.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_6.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_7.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_8.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        txt_ges_9.setBackgroundResource(R.drawable.eyetrackpwd_shape);
        tag_1 = tag_2 = tag_3 = tag_4 = tag_5 = tag_6 = tag_7 = tag_8 = tag_9 = true;
        list_x.clear();
        list_y.clear();
        if(num_pwd >= 2){
            for(int i = 0; i < num_pwd - 1; i++){
                GesDrawView g = list_view.get(i);
                fl_ges.removeView(g);
            }
        }
        num_pwd = 0;
        password = "";
    }
    void changeColor(int n){
        if(n == 1){
            txt_ges_1.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 2){
            txt_ges_2.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 3){
            txt_ges_3.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 4){
            txt_ges_4.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 5){
            txt_ges_5.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 6){
            txt_ges_6.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 7){
            txt_ges_7.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 8){
            txt_ges_8.setBackgroundResource(R.drawable.gespwd_shape);
        }else if(n == 9){
            txt_ges_9.setBackgroundResource(R.drawable.gespwd_shape);
        }
    }
    void init(){
        fl_ges = findViewById(R.id.fl_ges);
        txt_ges_1 = findViewById(R.id.txt_ges_1);
        txt_ges_2 = findViewById(R.id.txt_ges_2);
        txt_ges_3 = findViewById(R.id.txt_ges_3);
        txt_ges_4 = findViewById(R.id.txt_ges_4);
        txt_ges_5 = findViewById(R.id.txt_ges_5);
        txt_ges_6 = findViewById(R.id.txt_ges_6);
        txt_ges_7 = findViewById(R.id.txt_ges_7);
        txt_ges_8 = findViewById(R.id.txt_ges_8);
        txt_ges_9 = findViewById(R.id.txt_ges_9);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        if(user.gespwd == null){
            hav_gespwd = false;
            AlertDialog alertDialog = new AlertDialog.Builder(GesturePwdActivity.this).create();
            alertDialog.setIcon(R.drawable.img_warning);
            alertDialog.setTitle("提示");
            alertDialog.setMessage("此次为您第一次登陆，请创建您的眼势密码");
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
                    if(rawX >= 95 && rawX <= 325 && rawY >= 590 && rawY <= 810){
                       if(tag_1){
                           flag = false;
                           Message message = Message.obtain();
                           message.what = 1;
                           handler_1.sendMessageDelayed(message,0);
                       }
                    }else if(rawX >= 600 && rawX <= 840 && rawY >= 590 && rawY <= 810){
                        if(tag_2) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_2.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 1100 && rawX <= 1350 && rawY >= 590 && rawY <= 810){
                        if(tag_3) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_3.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 95 && rawX <= 325 && rawY >= 1115 && rawY <= 1345){
                        if(tag_4) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_4.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 600 && rawX <= 840 && rawY >= 1115 && rawY <= 1345){
                        if(tag_5) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_5.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 1100 && rawX <= 1350 && rawY >= 1115 && rawY <= 1345){
                        if(tag_6) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_6.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 95 && rawX <= 325 && rawY >= 1645 && rawY <= 1890){
                        if(tag_7) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_7.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 600 && rawX <= 840 && rawY >= 1645 && rawY <= 1890){
                        if(tag_8) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_8.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 1100 && rawX <= 1350 && rawY >= 1645 && rawY <= 1890){
                        if(tag_9) {
                            flag = false;
                            Message message = Message.obtain();
                            message.what = 1;
                            handler_9.sendMessageDelayed(message, 0);
                        }
                    }else if(rawX >= 70 && rawX <= 270 && rawY >= 2070 && rawY <= 2170){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_submit.sendMessageDelayed(message, 0);
                    }else if(rawX >= 1150 && rawX <= 1350 && rawY >= 2070 && rawY <= 2170){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_cancel.sendMessageDelayed(message, 0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_1 == 0){
                    num_1++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_1.sendMessageDelayed(message,250);
                }else if(num_1 == 1){
                    if(rawX >= 95 && rawX <= 325 && rawY >= 590 && rawY <= 810) {
                        num_1++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_1.sendMessageDelayed(message,250);
                    }else{
                        num_1 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 95 && rawX <= 325 && rawY >= 590 && rawY <= 810) {
                        tag_1 = false;
                        list_x.add(num_pwd, 210);
                        list_y.add(num_pwd, 650);
                        password += "1";
                        draw(1);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_1.sendMessageDelayed(message,250);
                    }else{
                        num_1 = 0;
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
    Handler leave_handler_1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 95 && rawX <= 325 && rawY >= 590 && rawY <= 810){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_1.sendMessageDelayed(message,300);
                }else{
                    num_1 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_2 == 0){
                    num_2++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_2.sendMessageDelayed(message,250);
                }else if(num_2 == 1){
                    if(rawX >= 600 && rawX <= 840 && rawY >= 590 && rawY <= 810) {
                        num_2++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_2.sendMessageDelayed(message,250);
                    }else{
                        num_2 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 600 && rawX <= 840 && rawY >= 590 && rawY <= 810) {
                        tag_2 = false;
                        list_x.add(num_pwd, 720);
                        list_y.add(num_pwd, 650);
                        password += "2";
                        draw(2);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_2.sendMessageDelayed(message,250);
                    }else{
                        num_2 = 0;
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
    Handler leave_handler_2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 600 && rawX <= 840 && rawY >= 590 && rawY <= 810){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_2.sendMessageDelayed(message,300);
                }else{
                    num_2 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_3 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_3 == 0){
                    num_3++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_3.sendMessageDelayed(message,250);
                }else if(num_3 == 1){
                    if(rawX >= 1100 && rawX <= 1350 && rawY >= 590 && rawY <= 810) {
                        num_3++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_3.sendMessageDelayed(message,250);
                    }else{
                        num_3 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1100 && rawX <= 1350 && rawY >= 590 && rawY <= 810) {
                        tag_3 = false;
                        list_x.add(num_pwd, 1225);
                        list_y.add(num_pwd, 650);
                        password += "3";
                        draw(3);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_3.sendMessageDelayed(message,250);
                    }else{
                        num_3 = 0;
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
    Handler leave_handler_3 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1100 && rawX <= 1350 && rawY >= 590 && rawY <= 810){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_3.sendMessageDelayed(message,300);
                }else{
                    num_3 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_4 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_4 == 0){
                    num_4++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_4.sendMessageDelayed(message,250);
                }else if(num_4 == 1){
                    if(rawX >= 95 && rawX <= 325 && rawY >= 1115 && rawY <= 1345) {
                        num_4++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_4.sendMessageDelayed(message,250);
                    }else{
                        num_4 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 95 && rawX <= 325 && rawY >= 1115 && rawY <= 1345) {
                        tag_4 = false;
                        list_x.add(num_pwd, 210);
                        list_y.add(num_pwd, 1180);
                        password += "4";
                        draw(4);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_4.sendMessageDelayed(message,250);
                    }else{
                        num_4 = 0;
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
    Handler leave_handler_4 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 95 && rawX <= 325 && rawY >= 1115 && rawY <= 1345){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_4.sendMessageDelayed(message,300);
                }else{
                    num_4 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_5 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_5 == 0){
                    num_5++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_5.sendMessageDelayed(message,250);
                }else if(num_5 == 1){
                    if(rawX >= 600 && rawX <= 840 && rawY >= 1115 && rawY <= 1345) {
                        num_5++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_5.sendMessageDelayed(message,250);
                    }else{
                        num_5 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 600 && rawX <= 840 && rawY >= 1115 && rawY <= 1345) {
                        tag_5 = false;
                        list_x.add(num_pwd, 720);
                        list_y.add(num_pwd, 1180);
                        password += "5";
                        draw(5);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_5.sendMessageDelayed(message,250);
                    }else{
                        num_5 = 0;
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
    Handler leave_handler_5 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 600 && rawX <= 840 && rawY >= 1115 && rawY <= 1345){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_5.sendMessageDelayed(message,300);
                }else{
                    num_5 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_6 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_6 == 0){
                    num_6++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_6.sendMessageDelayed(message,250);
                }else if(num_6 == 1){
                    if(rawX >= 1100 && rawX <= 1350 && rawY >= 1115 && rawY <= 1345) {
                        num_6++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_6.sendMessageDelayed(message,250);
                    }else{
                        num_6 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1100 && rawX <= 1350 && rawY >= 1115 && rawY <= 1345) {
                        tag_6 = false;
                        list_x.add(num_pwd, 1225);
                        list_y.add(num_pwd, 1180);
                        password += "6";
                        draw(6);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_6.sendMessageDelayed(message,250);
                    }else{
                        num_6 = 0;
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
    Handler leave_handler_6 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1100 && rawX <= 1350 && rawY >= 1115 && rawY <= 1345){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_6.sendMessageDelayed(message,300);
                }else{
                    num_6 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_7 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_7 == 0){
                    num_7++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_7.sendMessageDelayed(message,250);
                }else if(num_7 == 1){
                    if(rawX >= 95 && rawX <= 325 && rawY >= 1645 && rawY <= 1890) {
                        num_7++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_7.sendMessageDelayed(message,250);
                    }else{
                        num_7 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 95 && rawX <= 325 && rawY >= 1645 && rawY <= 1890) {
                        tag_7 = false;
                        list_x.add(num_pwd, 210);
                        list_y.add(num_pwd, 1700);
                        password += "7";
                        draw(7);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_7.sendMessageDelayed(message,250);
                    }else{
                        num_7 = 0;
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
    Handler leave_handler_7 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 95 && rawX <= 325 && rawY >= 1645 && rawY <= 1890){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_7.sendMessageDelayed(message,300);
                }else{
                    num_7 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_8 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_8 == 0){
                    num_8++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_8.sendMessageDelayed(message,250);
                }else if(num_8 == 1){
                    if(rawX >= 600 && rawX <= 840 && rawY >= 1645 && rawY <= 1890) {
                        num_8++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_8.sendMessageDelayed(message,250);
                    }else{
                        num_8 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 600 && rawX <= 840 && rawY >= 1645 && rawY <= 1890) {
                        tag_8 = false;
                        list_x.add(num_pwd, 720);
                        list_y.add(num_pwd, 1700);
                        password += "8";
                        draw(8);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_8.sendMessageDelayed(message,250);
                    }else{
                        num_8 = 0;
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
    Handler leave_handler_8 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 600 && rawX <= 840 && rawY >= 1645 && rawY <= 1890){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_8.sendMessageDelayed(message,300);
                }else{
                    num_8 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_9 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_9 == 0){
                    num_9++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_9.sendMessageDelayed(message,250);
                }else if(num_9 == 1){
                    if(rawX >= 1100 && rawX <= 1350 && rawY >= 1645 && rawY <= 1890) {
                        num_9++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_9.sendMessageDelayed(message,250);
                    }else{
                        num_9 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1100 && rawX <= 1350 && rawY >= 1645 && rawY <= 1890) {
                        tag_9 = false;
                        list_x.add(num_pwd, 1225);
                        list_y.add(num_pwd, 1700);
                        password += "9";
                        draw(9);
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_9.sendMessageDelayed(message,250);
                    }else{
                        num_9 = 0;
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
    Handler leave_handler_9 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1100 && rawX <= 1350 && rawY >= 1645 && rawY <= 1890){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_9.sendMessageDelayed(message,300);
                }else{
                    num_9 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
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
                    if(rawX >= 1150 && rawX <= 1350 && rawY >= 2070 && rawY <= 2170) {
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
                    if(rawX >= 1150 && rawX <= 1350 && rawY >= 2070 && rawY <= 2170) {
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
    Handler handler_submit = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_submit == 0){
                    num_submit++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_submit.sendMessageDelayed(message,250);
                }else if(num_submit == 1){
                    if(rawX >= 70 && rawX <= 270 && rawY >= 2070 && rawY <= 2170) {
                        num_submit++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_submit.sendMessageDelayed(message,250);
                    }else{
                        num_submit = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 70 && rawX <= 270 && rawY >= 2070 && rawY <= 2170) {
                        checkPwd();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_submit.sendMessageDelayed(message,250);
                    }else{
                        num_submit = 0;
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
    Handler leave_handler_submit = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 70 && rawX <= 270 && rawY >= 2070 && rawY <= 2170){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_submit.sendMessageDelayed(message,300);
                }else{
                    num_submit = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
}
