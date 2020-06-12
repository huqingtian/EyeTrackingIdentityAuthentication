package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    TextView txt_input_show, txt_input_1, txt_input_2, txt_input_3, txt_input_4, txt_input_5, txt_input_6, txt_input_7, txt_input_8, txt_input_9;
    private float rawX ;
    private float rawY ;
    String password = "";
    int pwd_code1, pwd_code2;
    boolean flag = true, flag_chose = false, isPwd = false;
    int num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, num_submit, num_return, num_clear, num_chose_1, num_chose_2, num_chose_3, num_chose_4, num_chose_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Intent intent = getIntent();
        String str = intent.getStringExtra("isPwd");
        if("1".equals(str)){
            isPwd = true;
        }else {
            isPwd = false;
        }
        txt_input_show = findViewById(R.id.txt_input_show);
        txt_input_1 = findViewById(R.id.txt_input_1);
        txt_input_2 = findViewById(R.id.txt_input_2);
        txt_input_3 = findViewById(R.id.txt_input_3);
        txt_input_4 = findViewById(R.id.txt_input_4);
        txt_input_5 = findViewById(R.id.txt_input_5);
        txt_input_6 = findViewById(R.id.txt_input_6);
        txt_input_7 = findViewById(R.id.txt_input_7);
        txt_input_8 = findViewById(R.id.txt_input_8);
        txt_input_9 = findViewById(R.id.txt_input_9);
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    void submit(){
        Intent intent = new Intent();
        intent.putExtra("key", password);
        setResult(111, intent);
        finish();
    }
    void toPwd(){
        if(pwd_code1 == 1){
            if(pwd_code2 == 1){
                password += "1";
            }else if(pwd_code2 == 2){
                password += "a";
            }else if(pwd_code2 == 3){
                password += "b";
            }else if(pwd_code2 == 4){
                password += "c";
            }
        }else if(pwd_code1 == 2){
            if(pwd_code2 == 1){
                password += "2";
            }else if(pwd_code2 == 2){
                password += "d";
            }else if(pwd_code2 == 3){
                password += "e";
            }else if(pwd_code2 == 4){
                password += "f";
            }
        }else if(pwd_code1 == 3){
            if(pwd_code2 == 1){
                password += "3";
            }else if(pwd_code2 == 2){
                password += "g";
            }else if(pwd_code2 == 3){
                password += "h";
            }else if(pwd_code2 == 4){
                password += "i";
            }
        }else if(pwd_code1 == 4){
            if(pwd_code2 == 1){
                password += "4";
            }else if(pwd_code2 == 2){
                password += "j";
            }else if(pwd_code2 == 3){
                password += "k";
            }else if(pwd_code2 == 4){
                password += "l";
            }
        }else if(pwd_code1 == 5){
            if(pwd_code2 == 1){
                password += "5";
            }else if(pwd_code2 == 2){
                password += "m";
            }else if(pwd_code2 == 3){
                password += "n";
            }else if(pwd_code2 == 4){
                password += "o";
            }
        }else if(pwd_code1 == 6){
            if(pwd_code2 == 1){
                password += "6";
            }else if(pwd_code2 == 2){
                password += "p";
            }else if(pwd_code2 == 3){
                password += "q";
            }else if(pwd_code2 == 4){
                password += "r";
            }
        }else if(pwd_code1 == 7){
            if(pwd_code2 == 1){
                password += "7";
            }else if(pwd_code2 == 2){
                password += "s";
            }else if(pwd_code2 == 3){
                password += "t";
            }else if(pwd_code2 == 4){
                password += "u";
            }
        }else if(pwd_code1 == 8){
            if(pwd_code2 == 1){
                password += "8";
            }else if(pwd_code2 == 2){
                password += "v";
            }else if(pwd_code2 == 3){
                password += "w";
            }else if(pwd_code2 == 4){
                password += "x";
            }
        }else if(pwd_code1 == 9){
            if(pwd_code2 == 1){
                password += "9";
            }else if(pwd_code2 == 2){
                password += "y";
            }else if(pwd_code2 == 3){
                password += "z";
            }else if(pwd_code2 == 4){
                password += "0";
            }
        }
        String temp = "";
        if(isPwd){
            for(int i = 0; i < password.length(); i++){
                temp += "●";
            }
        }else{
            temp = password;
        }
        changeLayout(false,"","","","");
        pwd_code1 = pwd_code2 = 0;
        txt_input_show.setText(temp);
    }
    void changeLayout(boolean flag, String s1, String s2, String s3, String s4){
        if(flag){
            txt_input_1.setText("");
            txt_input_2.setText(s1);
            txt_input_3.setText("");
            txt_input_4.setText(s2);
            txt_input_5.setText("×");
            txt_input_6.setText(s4);
            txt_input_7.setText("");
            txt_input_8.setText(s3);
            txt_input_9.setText("");
        }else{
            txt_input_1.setText("1\nABC");
            txt_input_2.setText("2\nDEF");
            txt_input_3.setText("3\nGHI");
            txt_input_4.setText("4\nJKL");
            txt_input_5.setText("5\nMNO");
            txt_input_6.setText("6\nPQR");
            txt_input_7.setText("7\nSTU");
            txt_input_8.setText("8\nWVX");
            txt_input_9.setText("9\nYZ0");
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
            if(flag) {
                if (msg.what == 1) {
                    if (rawX >= 40 && rawX <= 450 && rawY >= 540 && rawY <= 950) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_1.sendMessageDelayed(message, 0);
                    } else if (rawX >= 510 && rawX <= 920 && rawY >= 540 && rawY <= 950) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_2.sendMessageDelayed(message, 0);
                    } else if (rawX >= 980 && rawX <= 1390 && rawY >= 540 && rawY <= 950) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_3.sendMessageDelayed(message, 0);
                    } else if (rawX >= 40 && rawX <= 450 && rawY >= 1025 && rawY <= 1450) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_4.sendMessageDelayed(message, 0);
                    } else if (rawX >= 510 && rawX <= 920 && rawY >= 1025 && rawY <= 1450) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_5.sendMessageDelayed(message, 0);
                    } else if (rawX >= 980 && rawX <= 1390 && rawY >= 1025 && rawY <= 1450) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_6.sendMessageDelayed(message, 0);
                    } else if (rawX >= 40 && rawX <= 450 && rawY >= 1520 && rawY <= 1940) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_7.sendMessageDelayed(message, 0);
                    } else if (rawX >= 510 && rawX <= 920 && rawY >= 1520 && rawY <= 1940) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_8.sendMessageDelayed(message, 0);
                    } else if (rawX >= 980 && rawX <= 1390 && rawY >= 1520 && rawY <= 1940) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_9.sendMessageDelayed(message, 0);
                    } else if (rawX >= 0 && rawX <= 350 && rawY >= 2040 && rawY <= 2250) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_submit.sendMessageDelayed(message, 0);
                    }else if (rawX >= 1070 && rawX <= 1440 && rawY >= 2040 && rawY <= 2250) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_return.sendMessageDelayed(message, 0);
                    }else if (rawX >= 1100 && rawX <= 1400 && rawY >= 120 && rawY <= 400) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_clear.sendMessageDelayed(message, 0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message, 300);
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
                    if(rawX >= 1070 && rawX <= 1440 && rawY >= 2040 && rawY <= 2250) {
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
                    if(rawX >= 1070 && rawX <= 1440 && rawY >= 2040 && rawY <= 2250) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_return.sendMessageDelayed(message,0);
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
    Handler leave_handler_return = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1070 && rawX <= 1440 && rawY >= 2040 && rawY <= 2250) {
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_return.sendMessageDelayed(message,300);
                }else{
                    num_return = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
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
                    if(rawX >= 0 && rawX <= 350 && rawY >= 2040 && rawY <= 2250) {
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
                    if(rawX >= 0 && rawX <= 350 && rawY >= 2040 && rawY <= 2250) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_submit.sendMessageDelayed(message,0);
                        submit();
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
                if(rawX >= 0 && rawX <= 350 && rawY >= 2040 && rawY <= 2250) {
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
                    if(rawX >= 40 && rawX <= 450 && rawY >= 540 && rawY <= 950) {
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
                    if(rawX >= 40 && rawX <= 450 && rawY >= 540 && rawY <= 950) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_1 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 1;
                        changeLayout(true,"1","A","B","C");
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
                    if(rawX >= 510 && rawX <= 920 && rawY >= 540 && rawY <= 950) {
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
                    if(rawX >= 510 && rawX <= 920 && rawY >= 540 && rawY <= 950) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_2 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 2;
                        changeLayout(true,"2","D","E","F");
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
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 540 && rawY <= 950) {
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
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 540 && rawY <= 950) {
                        Message message = Message.obtain();
                        message.what = 1;
                        rawX = rawY = 0;
                        num_3 = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 3;
                        changeLayout(true,"3","G","H","I");
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
                    if(rawX >= 40 && rawX <= 450 && rawY >= 1025 && rawY <= 1450) {
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
                    if(rawX >= 40 && rawX <= 450 && rawY >= 1025 && rawY <= 1450) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_4 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 4;
                        changeLayout(true,"4","J","K","L");
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
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1025 && rawY <= 1450) {
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
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1025 && rawY <= 1450) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_5 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 5;
                        changeLayout(true,"5","M","N","O");
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
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 1025 && rawY <= 1450) {
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
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 1025 && rawY <= 1450) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_6 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 6;
                        changeLayout(true,"6","P","Q","R");
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
                    if(rawX >= 40 && rawX <= 450 && rawY >= 1520 && rawY <= 1940) {
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
                    if(rawX >= 40 && rawX <= 450 && rawY >= 1520 && rawY <= 1940) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_7 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 7;
                        changeLayout(true,"7","S","T","U");
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
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1520 && rawY <= 1940) {
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
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1520 && rawY <= 1940) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_8 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 8;
                        changeLayout(true,"8","V","W","X");
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
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 1520 && rawY <= 1940) {
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
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 1520 && rawY <= 1940) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_9 = 0;
                        rawX = rawY = 0;
                        flag_chose = true;
                        handler_chose.sendMessageDelayed(message,0);
                        pwd_code1 = 9;
                        changeLayout(true,"9","Y","Z","0");
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
    Handler handler_clear = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_clear == 0){
                    num_clear++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_clear.sendMessageDelayed(message,250);
                }else if(num_clear == 1){
                    if(rawX >= 1100 && rawX <= 1400 && rawY >= 120 && rawY <= 400) {
                        num_clear++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_clear.sendMessageDelayed(message,250);
                    }else{
                        num_clear = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1100 && rawX <= 1400 && rawY >= 120 && rawY <= 400) {
                        Message message = Message.obtain();
                        message.what = 1;
                        num_clear = 0;
                        password = "";
                        pwd_code1 = pwd_code2 = 0;
                        rawX = rawY = 0;
                        txt_input_show.setText("");
                        flag = true;
                        flag_chose = false;
                        changeLayout(false,"","","","");
                        handler.sendMessageDelayed(message,0);
                    }else{
                        num_clear = 0;
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
    Handler handler_chose = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag_chose) {
                if (msg.what == 1) {
                    if (rawX >= 510 && rawX <= 920 && rawY >= 540 && rawY <= 950) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_1.sendMessageDelayed(message, 0);
                    } else if (rawX >= 40 && rawX <= 450 && rawY >= 1025 && rawY <= 1450) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_2.sendMessageDelayed(message, 0);
                    } else if (rawX >= 510 && rawX <= 920 && rawY >= 1520 && rawY <= 1940) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_3.sendMessageDelayed(message, 0);
                    } else if (rawX >= 980 && rawX <= 1390 && rawY >= 1025 && rawY <= 1450) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_4.sendMessageDelayed(message, 0);
                    } else if (rawX >= 510 && rawX <= 920 && rawY >= 1025 && rawY <= 1450) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_return.sendMessageDelayed(message, 0);
                    } else if (rawX >= 0 && rawX <= 350 && rawY >= 2040 && rawY <= 2250) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_submit.sendMessageDelayed(message, 0);
                    }else if (rawX >= 1070 && rawX <= 1440 && rawY >= 2040 && rawY <= 2250) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_return.sendMessageDelayed(message, 0);
                    }else if (rawX >= 1100 && rawX <= 1400 && rawY >= 120 && rawY <= 400) {
                        flag_chose = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_clear.sendMessageDelayed(message, 0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_chose.sendMessageDelayed(message, 300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_chose_1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_chose_1 == 0){
                    num_chose_1++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_chose_1.sendMessageDelayed(message,250);
                }else if(num_chose_1 == 1){
                    if(rawX >= 510 && rawX <= 920 && rawY >= 540 && rawY <= 950) {
                        num_chose_1++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_1.sendMessageDelayed(message,250);
                    }else{
                        num_chose_1 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 510 && rawX <= 920 && rawY >= 540 && rawY <= 950) {
                        flag = true;
                        rawX = rawY = 0;
                        num_chose_1 = 0;
                        Message message = Message.obtain();
                        message.what = 1;
                        pwd_code2 = 1;
                        toPwd();
                        handler.sendMessageDelayed(message,0);
                    }else{
                        num_chose_1 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_chose_2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_chose_2 == 0){
                    num_chose_2++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_chose_2.sendMessageDelayed(message,250);
                }else if(num_chose_2 == 1){
                    if(rawX >= 40 && rawX <= 450 && rawY >= 1025 && rawY <= 1450) {
                        num_chose_2++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_2.sendMessageDelayed(message,250);
                    }else{
                        num_chose_2 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 40 && rawX <= 450 && rawY >= 1025 && rawY <= 1450) {
                        flag = true;
                        rawX = rawY = 0;
                        num_chose_2 = 0;
                        Message message = Message.obtain();
                        message.what = 1;
                        pwd_code2 = 2;
                        toPwd();
                        handler.sendMessageDelayed(message,0);
                    }else{
                        num_chose_2 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_chose_3 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_chose_3 == 0){
                    num_chose_3++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_chose_3.sendMessageDelayed(message,250);
                }else if(num_chose_3 == 1){
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1520 && rawY <= 1940) {
                        num_chose_3++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_3.sendMessageDelayed(message,250);
                    }else{
                        num_chose_3 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1520 && rawY <= 1940) {
                        flag = true;
                        num_chose_3 = 0;
                        rawX = rawY = 0;
                        Message message = Message.obtain();
                        message.what = 1;
                        pwd_code2 = 3;
                        toPwd();
                        handler.sendMessageDelayed(message,0);
                    }else{
                        num_chose_3 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_chose_4 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_chose_4 == 0){
                    num_chose_4++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_chose_4.sendMessageDelayed(message,250);
                }else if(num_chose_4 == 1){
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 1025 && rawY <= 1450) {
                        num_chose_4++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_4.sendMessageDelayed(message,250);
                    }else{
                        num_chose_4 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 980 && rawX <= 1390 && rawY >= 1025 && rawY <= 1450) {
                        flag = true;
                        rawX = rawY = 0;
                        num_chose_4 = 0;
                        Message message = Message.obtain();
                        message.what = 1;
                        pwd_code2 = 4;
                        toPwd();
                        handler.sendMessageDelayed(message,0);
                    }else{
                        num_chose_4 = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_chose_return = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_chose_return == 0){
                    num_chose_return++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_chose_return.sendMessageDelayed(message,250);
                }else if(num_chose_return == 1){
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1025 && rawY <= 1450) {
                        num_chose_return++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose_return.sendMessageDelayed(message,250);
                    }else{
                        num_chose_return = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 510 && rawX <= 920 && rawY >= 1025 && rawY <= 1450) {
                        pwd_code1 = pwd_code2 = 0;
                        rawX = rawY = 0;
                        changeLayout(false,"","","","");
                        flag = true;
                        num_chose_return = 0;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }else{
                        num_chose_return = 0;
                        flag_chose = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_chose.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
}
