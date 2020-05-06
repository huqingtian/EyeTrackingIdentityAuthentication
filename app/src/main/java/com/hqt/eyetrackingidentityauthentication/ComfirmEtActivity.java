package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class ComfirmEtActivity extends AppCompatActivity {
    TextView txt_comfirm_showpwd1, txt_comfirm_showpwd2, txt_comfirm_showpwd3, txt_comfirm_showpwd4;
    String password = "";
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    int number;
    private float rawX ;
    private float rawY ;
    boolean flag = true;
    int num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, num_close, num_cancel;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag){
                if(msg.what == 1){
                    if(rawX >= 151 && rawX <= 399 && rawY >= 656 && rawY <= 904){       // 数字键1位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }else if(rawX >= 586 && rawX <= 834 && rawY >= 656 && rawY <= 904){     //数字键2位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler2.sendMessageDelayed(message,0);
                    }else if(rawX >= 1021 && rawX <= 1269 && rawY >= 656 && rawY <= 904){     //数字键3位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler3.sendMessageDelayed(message,0);
                    }else if(rawX >= 151 && rawX <= 399 && rawY >= 1096 && rawY <= 1344){     //数字键4位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,0);
                    }else if(rawX >= 586 && rawX <= 834 && rawY >= 1096 && rawY <= 1344){     //数字键5位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler5.sendMessageDelayed(message,0);
                    }else if(rawX >= 1021 && rawX <= 1269 && rawY >= 1096 && rawY <= 1344){     //数字键6位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler6.sendMessageDelayed(message,0);
                    }else if(rawX >= 151 && rawX <= 399 && rawY >= 1536 && rawY <= 1784){     //数字键7位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler7.sendMessageDelayed(message,0);
                    }else if(rawX >= 586 && rawX <= 834 && rawY >= 1536 && rawY <= 1784){     //数字键8位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler8.sendMessageDelayed(message,0);
                    }else if(rawX >= 1021 && rawX <= 1269 && rawY >= 1536 && rawY <= 1784){     //数字键9位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler9.sendMessageDelayed(message,0);
                    }else if(rawX >= 586 && rawX <= 834 && rawY >= 1976 && rawY <= 2224){     //数字键0位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler0.sendMessageDelayed(message,0);
                    }else if(rawX >= 1160 && rawX <= 1290 && rawY >= 2290 && rawY <= 2350){     //文本框-"取消"位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_close.sendMessageDelayed(message,0);
                    }else if(rawX >= 1200 && rawX <= 1330 && rawY >= 395 && rawY <= 465){     //图片"撤销密码"位置
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_cancel.sendMessageDelayed(message,0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num1 == 0){
                    num1++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler1.sendMessageDelayed(message,250);
                }else if(num1 == 1){
                    if(rawX >= 151 && rawX <= 399 && rawY >= 656 && rawY <= 904) {
                        num1++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,250);
                    }else{
                        num1 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 151 && rawX <= 399 && rawY >= 656 && rawY <= 904) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler1.sendMessageDelayed(message,0);
                        number++;
                        password += "1";
                        showPwdNum();
                    }else{
                        num1 = 0;
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
    Handler leave_handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 151 && rawX <= 399 && rawY >= 656 && rawY <= 904){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler1.sendMessageDelayed(message,300);
                }else{
                    num1 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num2 == 0){
                    num2++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler2.sendMessageDelayed(message,250);
                }else if(num2 == 1){
                    if(rawX >= 586 && rawX <= 834 && rawY >= 656 && rawY <= 904) {
                        num2++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler2.sendMessageDelayed(message,250);
                    }else{
                        num2 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 586 && rawX <= 834 && rawY >= 656 && rawY <= 904) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler2.sendMessageDelayed(message,0);
                        number++;
                        password += "2";
                        showPwdNum();
                    }else{
                        num2 = 0;
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
    Handler leave_handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 586 && rawX <= 834 && rawY >= 656 && rawY <= 904){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler2.sendMessageDelayed(message,300);
                }else{
                    num2 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler3 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num3 == 0){
                    num3++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler3.sendMessageDelayed(message,250);
                }else if(num3 == 1){
                    if(rawX >= 1021 && rawX <= 1269 && rawY >= 656 && rawY <= 904) {
                        num3++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler3.sendMessageDelayed(message,250);
                    }else{
                        num3 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1021 && rawX <= 1269 && rawY >= 656 && rawY <= 904) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler3.sendMessageDelayed(message,0);
                        number++;
                        password += "3";
                        showPwdNum();
                    }else{
                        num3 = 0;
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
    Handler leave_handler3 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1021 && rawX <= 1269 && rawY >= 656 && rawY <= 904){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler3.sendMessageDelayed(message,300);
                }else{
                    num3 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler4 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num4 == 0){
                    num4++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler4.sendMessageDelayed(message,250);
                }else if(num4 == 1){
                    if(rawX >= 151 && rawX <= 399 && rawY >= 1096 && rawY <= 1344) {
                        num4++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,250);
                    }else{
                        num4 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 151 && rawX <= 399 && rawY >= 1096 && rawY <= 1344) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler4.sendMessageDelayed(message,0);
                        number++;
                        password += "4";
                        showPwdNum();
                    }else{
                        num4 = 0;
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
    Handler leave_handler4 = new Handler(){
        @Override
        public void handleMessage( Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 151 && rawX <= 399 && rawY >= 1096 && rawY <= 1344){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler4.sendMessageDelayed(message,300);
                }else{
                    num4 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler5 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num5 == 0){
                    num5++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler5.sendMessageDelayed(message,250);
                }else if(num5 == 1){
                    if(rawX >= 586 && rawX <= 834 && rawY >= 1096 && rawY <= 1344) {
                        num5++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler5.sendMessageDelayed(message,250);
                    }else{
                        num5 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 586 && rawX <= 834 && rawY >= 1096 && rawY <= 1344) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler5.sendMessageDelayed(message,0);
                        number++;
                        password += "5";
                        showPwdNum();
                    }else{
                        num5 = 0;
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
    Handler leave_handler5 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 586 && rawX <= 834 && rawY >= 1096 && rawY <= 1344){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler5.sendMessageDelayed(message,300);
                }else{
                    num5 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler6 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num6 == 0){
                    num6++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler6.sendMessageDelayed(message,250);
                }else if(num6 == 1){
                    if(rawX >= 1021 && rawX <= 1269 && rawY >= 1096 && rawY <= 1344) {
                        num6++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler6.sendMessageDelayed(message,250);
                    }else{
                        num6 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1021 && rawX <= 1269 && rawY >= 1096 && rawY <= 1344) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler6.sendMessageDelayed(message,0);
                        number++;
                        password += "6";
                        showPwdNum();
                    }else{
                        num6 = 0;
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
    Handler leave_handler6 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1021 && rawX <= 1269 && rawY >= 1096 && rawY <= 1344){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler6.sendMessageDelayed(message,300);
                }else{
                    num6 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler7 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num7 == 0){
                    num7++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler7.sendMessageDelayed(message,250);
                }else if(num7 == 1){
                    if(rawX >= 151 && rawX <= 399 && rawY >= 1536 && rawY <= 1784) {
                        num7++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler7.sendMessageDelayed(message,250);
                    }else{
                        num7 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 151 && rawX <= 399 && rawY >= 1536 && rawY <= 1784) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler7.sendMessageDelayed(message,0);
                        number++;
                        password += "7";
                        showPwdNum();
                    }else{
                        num7 = 0;
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
    Handler leave_handler7 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 151 && rawX <= 399 && rawY >= 1536 && rawY <= 1784){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler7.sendMessageDelayed(message,300);
                }else{
                    num7 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler8 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num8 == 0){
                    num8++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler8.sendMessageDelayed(message,250);
                }else if(num8 == 1){
                    if(rawX >= 586 && rawX <= 834 && rawY >= 1536 && rawY <= 1784) {
                        num8++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler8.sendMessageDelayed(message,250);
                    }else{
                        num8 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 586 && rawX <= 834 && rawY >= 1536 && rawY <= 1784) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler8.sendMessageDelayed(message,0);
                        number++;
                        password += "8";
                        showPwdNum();
                    }else{
                        num8 = 0;
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
    Handler leave_handler8 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 586 && rawX <= 834 && rawY >= 1536 && rawY <= 1784){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler8.sendMessageDelayed(message,300);
                }else{
                    num8 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler9 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num9 == 0){
                    num9++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler9.sendMessageDelayed(message,250);
                }else if(num9 == 1){
                    if(rawX >= 1021 && rawX <= 1269 && rawY >= 1536 && rawY <= 1784) {
                        num9++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler9.sendMessageDelayed(message,250);
                    }else{
                        num9 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1021 && rawX <= 1269 && rawY >= 1536 && rawY <= 1784) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler9.sendMessageDelayed(message,0);
                        number++;
                        password += "9";
                        showPwdNum();
                    }else{
                        num9 = 0;
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
    Handler leave_handler9 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1021 && rawX <= 1269 && rawY >= 1536 && rawY <= 1784){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler9.sendMessageDelayed(message,300);
                }else{
                    num9 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler0 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num0 == 0){
                    num0++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler0.sendMessageDelayed(message,250);
                }else if(num0 == 1){
                    if(rawX >= 586 && rawX <= 834 && rawY >= 1976 && rawY <= 2224) {
                        num0++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler0.sendMessageDelayed(message,250);
                    }else{
                        num0 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 586 && rawX <= 834 && rawY >= 1976 && rawY <= 2224) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler0.sendMessageDelayed(message,0);
                        number++;
                        password += "0";
                        showPwdNum();
                    }else{
                        num0 = 0;
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
    Handler leave_handler0 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 586 && rawX <= 834 && rawY >= 1976 && rawY <= 2224){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler0.sendMessageDelayed(message,300);
                }else{
                    num0 = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_close = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_close == 0){
                    num_close++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_close.sendMessageDelayed(message,250);
                }else if(num_close == 1){
                    if(rawX >= 1160 && rawX <= 1290 && rawY >= 2290 && rawY <= 2350) {
                        num_close++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_close.sendMessageDelayed(message,250);
                    }else{
                        num_close = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1160 && rawX <= 1290 && rawY >= 2290 && rawY <= 2350) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_close.sendMessageDelayed(message,0);
                        finish();
                    }else{
                        num_close = 0;
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
    Handler leave_handler_close = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1160 && rawX <= 1290 && rawY >= 2290 && rawY <= 2350){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_close.sendMessageDelayed(message,300);
                }else{
                    num_close = 0;
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
                    if(rawX >= 1200 && rawX <= 1330 && rawY >= 395 && rawY <= 465) {
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
                    if(rawX >= 1200 && rawX <= 1330 && rawY >= 395 && rawY <= 465) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_cancel.sendMessageDelayed(message,0);
                        number = 0;
                        password = "";
                        showPwdNum();
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
    Handler leave_handler_cancel = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1200 && rawX <= 1330 && rawY >= 395 && rawY <= 465){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_cancel.sendMessageDelayed(message,300);
                }else{
                    num_cancel = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm_et);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        txt_comfirm_showpwd1 = findViewById(R.id.txt_comfirm_showpwd1);
        txt_comfirm_showpwd2 = findViewById(R.id.txt_comfirm_showpwd2);
        txt_comfirm_showpwd3 = findViewById(R.id.txt_comfirm_showpwd3);
        txt_comfirm_showpwd4 = findViewById(R.id.txt_comfirm_showpwd4);
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
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
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rawX = ev.getRawX();
        rawY = ev.getRawY();
        return super.dispatchTouchEvent(ev);
    }
}
