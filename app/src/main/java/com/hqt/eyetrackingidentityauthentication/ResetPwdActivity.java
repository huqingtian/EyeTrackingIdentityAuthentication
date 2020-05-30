package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class ResetPwdActivity extends AppCompatActivity {
    private float rawX;
    private float rawY;
    boolean flag = true;
    int num_return, num_reset_indpwd, num_reset_dirpwd, num_reset_gespwd;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,300);
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
                    } else if(rawX >= 0 && rawX <= 1430 && rawY >= 295 && rawY <= 525){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset_indpwd.sendMessageDelayed(message,0);
                    } else if(rawX >= 0 && rawX <= 1430 && rawY >= 605 && rawY <= 835){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset_dirpwd.sendMessageDelayed(message,0);
                    }else if(rawX >= 1120 && rawX <= 1430 && rawY >= 905 && rawY <= 1145){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset_gespwd.sendMessageDelayed(message,0);
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
    Handler handler_reset_indpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_reset_indpwd == 0){
                    num_reset_indpwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_reset_indpwd.sendMessageDelayed(message,250);
                }else if(num_reset_indpwd == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 295 && rawY <= 525) {
                        num_reset_indpwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset_indpwd.sendMessageDelayed(message,250);
                    }else{
                        num_reset_indpwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 295 && rawY <= 525) {
                        AlertDialog alertDialog = new AlertDialog.Builder(ResetPwdActivity.this).setCancelable(false).create();
                        alertDialog.setIcon(R.drawable.img_warning);
                        alertDialog.setTitle("提示");
                        alertDialog.setMessage("确定要重置独立密码吗?");
                        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sqliteImplementer.changeIndPwd(user.username, null);
                                Toast.makeText(ResetPwdActivity.this, "重置独立密码成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                
                            }
                        });
                        alertDialog.show();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_reset_indpwd.sendMessageDelayed(message,0);
                    }else{
                        num_reset_indpwd = 0;
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
    Handler leave_handler_reset_indpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 0 && rawX <= 1430 && rawY >= 295 && rawY <= 525){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_reset_indpwd.sendMessageDelayed(message,300);
                }else{
                    num_reset_indpwd = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_reset_dirpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_reset_dirpwd == 0){
                    num_reset_dirpwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_reset_dirpwd.sendMessageDelayed(message,250);
                }else if(num_reset_dirpwd == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 605 && rawY <= 835) {
                        num_reset_dirpwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset_dirpwd.sendMessageDelayed(message,250);
                    }else{
                        num_reset_dirpwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 605 && rawY <= 835) {
                        AlertDialog alertDialog = new AlertDialog.Builder(ResetPwdActivity.this).setCancelable(false).create();
                        alertDialog.setIcon(R.drawable.img_warning);
                        alertDialog.setTitle("提示");
                        alertDialog.setMessage("确定要重置方向密码吗?");
                        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sqliteImplementer.changeDirPwd(user.username, null);
                                Toast.makeText(ResetPwdActivity.this, "重置方向密码成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alertDialog.show();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_reset_dirpwd.sendMessageDelayed(message,0);
                    }else{
                        num_reset_dirpwd = 0;
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
    Handler leave_handler_reset_dirpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 0 && rawX <= 1430 && rawY >= 605 && rawY <= 835){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_reset_dirpwd.sendMessageDelayed(message,300);
                }else{
                    num_reset_dirpwd = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_reset_gespwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_reset_gespwd == 0){
                    num_reset_gespwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_reset_gespwd.sendMessageDelayed(message,250);
                }else if(num_reset_gespwd == 1){
                    if(rawX >= 1120 && rawX <= 1430 && rawY >= 905 && rawY <= 1145) {
                        num_reset_gespwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset_gespwd.sendMessageDelayed(message,250);
                    }else{
                        num_reset_gespwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1120 && rawX <= 1430 && rawY >= 905 && rawY <= 1145) {
                        AlertDialog alertDialog = new AlertDialog.Builder(ResetPwdActivity.this).setCancelable(false).create();
                        alertDialog.setIcon(R.drawable.img_warning);
                        alertDialog.setTitle("提示");
                        alertDialog.setMessage("确定要重置手势密码吗?");
                        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sqliteImplementer.changeGesPwd(user.username, null);
                                Toast.makeText(ResetPwdActivity.this, "重置手势密码成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alertDialog.show();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_reset_gespwd.sendMessageDelayed(message,0);
                    }else{
                        num_reset_gespwd = 0;
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
    Handler leave_handler_reset_gespwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1120 && rawX <= 1430 && rawY >= 905 && rawY <= 1145){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_reset_gespwd.sendMessageDelayed(message,300);
                }else{
                    num_reset_gespwd = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
}
