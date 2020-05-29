package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class ChatHisActivity extends AppCompatActivity {
    private float rawX ;
    private float rawY ;
    boolean flag = true;
    int num_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_his);
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message, 300);
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
            if (flag) {
                if (msg.what == 1) {
                    if (rawX >= 10 && rawX <= 110 && rawY >= 10 && rawY <= 220) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_return.sendMessageDelayed(message, 0);
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
}
