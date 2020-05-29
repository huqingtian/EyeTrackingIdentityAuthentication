package com.hqt.eyetrackingidentityauthentication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class ChangePwdActivity extends AppCompatActivity {
    ImageView img_openET;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    String tag;
    private float rawX ;
    private float rawY ;
    boolean flag = true;
    int num_change_loginpwd, num_change_etpwd, num_return, num_openEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        img_openET = findViewById(R.id.img_openET);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        tag = user.ettag;
        if (!"1".equals(tag)) {
            img_openET.setImageResource(R.drawable.img_btnclose);
        }else{
            img_openET.setImageResource(R.drawable.img_btnopen);
        }
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 111 && resultCode == 111){
            img_openET.setImageResource(R.drawable.img_btnclose);
            sqliteImplementer.changeEtTag(user.username, "0");
            tag = "0";
        }
        flag = true;
        rawX = 0;
        rawY = 0;
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
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag){
                if(msg.what == 1){
                    if(rawX >= 10 && rawX <= 110 && rawY >= 10 && rawY <= 220){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_return.sendMessageDelayed(message,0);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 1400 && rawY <= 1630){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_change_loginpwd.sendMessageDelayed(message,0);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 1650 && rawY <= 1880){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_change_etpwd.sendMessageDelayed(message,0);
                    }else if(rawX >= 1120 && rawX <= 1430 && rawY >= 1985 && rawY <= 2210){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_openEt.sendMessageDelayed(message,0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_return = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_return == 0){
                    num_return++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_return.sendMessageDelayed(message,250);
                }else if(num_return == 1){
                    if(rawX >= 10 && rawX <= 110 && rawY >= 10 && rawY <= 220) {
                        num_return++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_return.sendMessageDelayed(message,250);
                    }else{
                        num_return = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 10 && rawX <= 110 && rawY >= 10 && rawY <= 220) {
                        finish();
                    }else{
                        num_return = 0;
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
    Handler handler_change_loginpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_change_loginpwd == 0){
                    num_change_loginpwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_change_loginpwd.sendMessageDelayed(message,250);
                }else if(num_change_loginpwd == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1400 && rawY <= 1630) {
                        num_change_loginpwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_change_loginpwd.sendMessageDelayed(message,250);
                    }else{
                        num_change_loginpwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1400 && rawY <= 1630) {
                        Intent intent = new Intent(ChangePwdActivity.this, ChangeLoginPwdActivity.class);
                        startActivityForResult(intent,111);
                    }else{
                        num_change_loginpwd = 0;
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
    Handler handler_change_etpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_change_etpwd == 0){
                    num_change_etpwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_change_etpwd.sendMessageDelayed(message,250);
                }else if(num_change_etpwd == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1650 && rawY <= 1880) {
                        num_change_etpwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_change_etpwd.sendMessageDelayed(message,250);
                    }else{
                        num_change_etpwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1650 && rawY <= 1880) {
                        Intent intent = new Intent(ChangePwdActivity.this, ChangeEtPwdActivity.class);
                        startActivityForResult(intent,111);
                    }else{
                        num_change_etpwd = 0;
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
    Handler handler_openEt = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_openEt == 0){
                    num_openEt++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_openEt.sendMessageDelayed(message,250);
                }else if(num_openEt == 1){
                    if(rawX >= 1120 && rawX <= 1430 && rawY >= 1985 && rawY <= 2210) {
                        num_openEt++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_openEt.sendMessageDelayed(message,250);
                    }else{
                        num_openEt = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1120 && rawX <= 1430 && rawY >= 1985 && rawY <= 2210) {
                        if("1".equals(tag)){
                            Intent intent = new Intent(ChangePwdActivity.this, ComfirmEtActivity.class);
                            startActivityForResult(intent,111);
                        }else{
                            img_openET.setImageResource(R.drawable.img_btnopen);
                            sqliteImplementer.changeEtTag(user.username, "1");
                            tag = "1";
                            Message message = Message.obtain();
                            message.what = 1;
                            leave_handler_openEt.sendMessageDelayed(message,0);
                        }
                    }else{
                        num_openEt = 0;
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
    Handler leave_handler_openEt = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1120 && rawX <= 1430 && rawY >= 1985 && rawY <= 2210){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_openEt.sendMessageDelayed(message,300);
                }else{
                    num_openEt = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
}
