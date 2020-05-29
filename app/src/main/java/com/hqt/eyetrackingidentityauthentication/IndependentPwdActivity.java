package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import java.math.BigInteger;
import java.security.MessageDigest;

public class IndependentPwdActivity extends AppCompatActivity {
    TextView txt_ind_show;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    private float rawX ;
    private float rawY ;
    String password = "";
    boolean flag = true, hav_indpwd;
    int num_pwd, num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, num_0, num_submit, num_return, num_a, num_b, num_c, num_d, num_e;
    int num_f, num_g, num_h, num_i, num_j, num_k, num_l, num_m, num_n, num_o, num_p, num_q, num_r, num_s, num_t, num_u, num_v, num_w, num_x, num_y, num_z;
    int tag_a, tag_b, tag_c, tag_d, tag_e, tag_f, tag_g, tag_h, tag_i, tag_j, tag_k, tag_l, tag_m, tag_n, tag_o, tag_p, tag_q, tag_r, tag_s, tag_t;
    int tag_u, tag_v, tag_w, tag_x, tag_y, tag_z, tag_1, tag_2, tag_3, tag_4, tag_5, tag_6, tag_7, tag_8, tag_9, tag_0, num_mistake;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
        super.handleMessage(msg);
            if(flag) {
                if (msg.what == 1) {
                    if (rawX >= 45 && rawX <= 260 && rawY >= 125 && rawY <= 340) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_a.sendMessageDelayed(message, 0);
                    } else if (rawX >= 320 && rawX <= 535 && rawY >= 125 && rawY <= 340) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_b.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 125 && rawY <= 340) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_c.sendMessageDelayed(message, 0);
                    } else if (rawX >= 870 && rawX <= 1085 && rawY >= 125 && rawY <= 340) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_d.sendMessageDelayed(message, 0);
                    } else if (rawX >= 1145 && rawX <= 1360 && rawY >= 125 && rawY <= 340) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_e.sendMessageDelayed(message, 0);
                    } else if (rawX >= 45 && rawX <= 260 && rawY >= 410 && rawY <= 625) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_f.sendMessageDelayed(message, 0);
                    } else if (rawX >= 320 && rawX <= 535 && rawY >= 410 && rawY <= 625) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_g.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 410 && rawY <= 625) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_h.sendMessageDelayed(message, 0);
                    } else if (rawX >= 870 && rawX <= 1085 && rawY >= 410 && rawY <= 625) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_i.sendMessageDelayed(message, 0);
                    } else if (rawX >= 1145 && rawX <= 1360 && rawY >= 410 && rawY <= 625) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_j.sendMessageDelayed(message, 0);
                    } else if (rawX >= 45 && rawX <= 260 && rawY >= 690 && rawY <= 910) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_k.sendMessageDelayed(message, 0);
                    } else if (rawX >= 320 && rawX <= 535 && rawY >= 690 && rawY <= 910) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_l.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 690 && rawY <= 910) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_m.sendMessageDelayed(message, 0);
                    } else if (rawX >= 870 && rawX <= 1085 && rawY >= 690 && rawY <= 910) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_n.sendMessageDelayed(message, 0);
                    } else if (rawX >= 1145 && rawX <= 1360 && rawY >= 690 && rawY <= 910) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_o.sendMessageDelayed(message, 0);
                    } else if (rawX >= 45 && rawX <= 260 && rawY >= 970 && rawY <= 1200) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_p.sendMessageDelayed(message, 0);
                    } else if (rawX >= 320 && rawX <= 535 && rawY >= 970 && rawY <= 1200) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_q.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 970 && rawY <= 1200) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_r.sendMessageDelayed(message, 0);
                    } else if (rawX >= 870 && rawX <= 1085 && rawY >= 970 && rawY <= 1200) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_s.sendMessageDelayed(message, 0);
                    } else if (rawX >= 1145 && rawX <= 1360 && rawY >= 970 && rawY <= 1200) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_t.sendMessageDelayed(message, 0);
                    } else if (rawX >= 45 && rawX <= 260 && rawY >= 1250 && rawY <= 1470) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_u.sendMessageDelayed(message, 0);
                    } else if (rawX >= 320 && rawX <= 535 && rawY >= 1250 && rawY <= 1470) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_v.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 1250 && rawY <= 1470) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_w.sendMessageDelayed(message, 0);
                    } else if (rawX >= 870 && rawX <= 1085 && rawY >= 1250 && rawY <= 1470) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_x.sendMessageDelayed(message, 0);
                    } else if (rawX >= 1145 && rawX <= 1360 && rawY >= 1250 && rawY <= 1470) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_y.sendMessageDelayed(message, 0);
                    } else if (rawX >= 45 && rawX <= 260 && rawY >= 1520 && rawY <= 1750) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_z.sendMessageDelayed(message, 0);
                    } else if (rawX >= 320 && rawX <= 535 && rawY >= 1520 && rawY <= 1750) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_1.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 1520 && rawY <= 1750) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_2.sendMessageDelayed(message, 0);
                    } else if (rawX >= 870 && rawX <= 1085 && rawY >= 1520 && rawY <= 1750) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_3.sendMessageDelayed(message, 0);
                    } else if (rawX >= 1145 && rawX <= 1360 && rawY >= 1520 && rawY <= 1750) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_4.sendMessageDelayed(message, 0);
                    }else if (rawX >= 45 && rawX <= 260 && rawY >= 1800 && rawY <= 2030) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_5.sendMessageDelayed(message, 0);
                    } else if (rawX >= 320 && rawX <= 535 && rawY >= 1800 && rawY <= 2030) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_6.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 1800 && rawY <= 2030) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_7.sendMessageDelayed(message, 0);
                    } else if (rawX >= 870 && rawX <= 1085 && rawY >= 1800 && rawY <= 2030) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_8.sendMessageDelayed(message, 0);
                    } else if (rawX >= 1145 && rawX <= 1360 && rawY >= 1800 && rawY <= 2030) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_9.sendMessageDelayed(message, 0);
                    } else if (rawX >= 595 && rawX <= 810 && rawY >= 2080 && rawY <= 2310) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_0.sendMessageDelayed(message, 0);
                    }else if (rawX >= 40 && rawX <= 235 && rawY >= 2285 && rawY <= 2365) {
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_submit.sendMessageDelayed(message, 0);
                    }else if (rawX >= 1200 && rawX <= 1390 && rawY >= 2285 && rawY <= 2365) {
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
                    if(rawX >= 1200 && rawX <= 1390 && rawY >= 2285 && rawY <= 2365) {
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
                    if(rawX >= 1200 && rawX <= 1390 && rawY >= 2285 && rawY <= 2365) {
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
                if(rawX >= 1200 && rawX <= 1390 && rawY >= 2285 && rawY <= 2365) {
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
                    if(rawX >= 40 && rawX <= 235 && rawY >= 2285 && rawY <= 2365) {
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
                    if(rawX >= 40 && rawX <= 235 && rawY >= 2285 && rawY <= 2365) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_submit.sendMessageDelayed(message,0);
                        checkPwd();
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
                if(rawX >= 40 && rawX <= 235 && rawY >= 2285 && rawY <= 2365) {
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
    Handler handler_0 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_0 == 0){
                    num_0++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_0.sendMessageDelayed(message,250);
                }else if(num_0 == 1){
                    if(rawX >= 595 && rawX <= 810 && rawY >= 2080 && rawY <= 2310) {
                        num_0++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_0.sendMessageDelayed(message,250);
                    }else{
                        num_0 = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 595 && rawX <= 810 && rawY >= 2080 && rawY <= 2310) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_0.sendMessageDelayed(message,0);
                        if(0 == tag_0){
                            plus();
                            tag_0 = 1;
                        }else{
                            reduce();
                            tag_0 = 0;
                        }
                    }else{
                        num_0 = 0;
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
    Handler leave_handler_0 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 595 && rawX <= 810 && rawY >= 2080 && rawY <= 2310) {
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_0.sendMessageDelayed(message,300);
                }else{
                    num_0 = 0;
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
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 1800 && rawY <= 2030) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_9.sendMessageDelayed(message,0);
                        if(0 == tag_9){
                            plus();
                            tag_9 = 1;
                        }else{
                            reduce();
                            tag_9 = 0;
                        }
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
                if(rawX >= 1145 && rawX <= 1360 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 1800 && rawY <= 2030) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_8.sendMessageDelayed(message,0);
                        if(0 == tag_8){
                            plus();
                            tag_8 = 1;
                        }else{
                            reduce();
                            tag_8 = 0;
                        }
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
                if(rawX >= 870 && rawX <= 1085 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 595 && rawX <= 810 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 595 && rawX <= 810 && rawY >= 1800 && rawY <= 2030) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_7.sendMessageDelayed(message,0);
                        if(0 == tag_7){
                            plus();
                            tag_7 = 1;
                        }else{
                            reduce();
                            tag_7 = 0;
                        }
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
                if(rawX >= 595 && rawX <= 810 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 320 && rawX <= 535 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 320 && rawX <= 535 && rawY >= 1800 && rawY <= 2030) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_6.sendMessageDelayed(message,0);
                        if(0 == tag_6){
                            plus();
                            tag_6 = 1;
                        }else{
                            reduce();
                            tag_6 = 0;
                        }
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
                if(rawX >= 320 && rawX <= 535 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 45 && rawX <= 260 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 45 && rawX <= 260 && rawY >= 1800 && rawY <= 2030) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_5.sendMessageDelayed(message,0);
                        if(0 == tag_5){
                            plus();
                            tag_5 = 1;
                        }else{
                            reduce();
                            tag_5 = 0;
                        }
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
                if(rawX >= 45 && rawX <= 260 && rawY >= 1800 && rawY <= 2030) {
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
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 1520 && rawY <= 1750) {
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
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 1520 && rawY <= 1750) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_4.sendMessageDelayed(message,0);
                        if(0 == tag_4){
                            plus();
                            tag_4 = 1;
                        }else{
                            reduce();
                            tag_4 = 0;
                        }
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
                if(rawX >= 1145 && rawX <= 1360 && rawY >= 1520 && rawY <= 1750) {
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
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 1520 && rawY <= 1750) {
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
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 1520 && rawY <= 1750) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_3.sendMessageDelayed(message,0);
                        if(0 == tag_3){
                            plus();
                            tag_3 = 1;
                        }else{
                            reduce();
                            tag_3 = 0;
                        }
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
                if(rawX >= 870 && rawX <= 1085 && rawY >= 1520 && rawY <= 1750) {
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
                    if(rawX >= 595 && rawX <= 810 && rawY >= 1520 && rawY <= 1750) {
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
                    if(rawX >= 595 && rawX <= 810 && rawY >= 1520 && rawY <= 1750) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_2.sendMessageDelayed(message,0);
                        if(0 == tag_2){
                            plus();
                            tag_2 = 1;
                        }else{
                            reduce();
                            tag_2 = 0;
                        }
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
                if(rawX >= 595 && rawX <= 810 && rawY >= 1520 && rawY <= 1750) {
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
                    if(rawX >= 320 && rawX <= 535 && rawY >= 1520 && rawY <= 1750) {
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
                    if(rawX >= 320 && rawX <= 535 && rawY >= 1520 && rawY <= 1750) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_1.sendMessageDelayed(message,0);
                        if(0 == tag_1){
                            plus();
                            tag_1 = 1;
                        }else{
                            reduce();
                            tag_1 = 0;
                        }
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
                if(rawX >= 320 && rawX <= 535 && rawY >= 1520 && rawY <= 1750) {
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
    Handler handler_z = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_z == 0){
                    num_z++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_z.sendMessageDelayed(message,250);
                }else if(num_z == 1){
                    if(rawX >= 45 && rawX <= 260 && rawY >= 1520 && rawY <= 1750) {
                        num_z++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_z.sendMessageDelayed(message,250);
                    }else{
                        num_z = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 45 && rawX <= 260 && rawY >= 1520 && rawY <= 1750) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_z.sendMessageDelayed(message,0);
                        if(0 == tag_z){
                            plus();
                            tag_z = 1;
                        }else{
                            reduce();
                            tag_z = 0;
                        }
                    }else{
                        num_z = 0;
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
    Handler leave_handler_z = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 45 && rawX <= 260 && rawY >= 1520 && rawY <= 1750) {
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_z.sendMessageDelayed(message,300);
                }else{
                    num_z = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_y = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_y == 0){
                    num_y++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_y.sendMessageDelayed(message,250);
                }else if(num_y == 1){
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 1250 && rawY <= 1470) {
                        num_y++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_y.sendMessageDelayed(message,250);
                    }else{
                        num_y = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 1250 && rawY <= 1470) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_y.sendMessageDelayed(message,0);
                        if(0 == tag_y){
                            plus();
                            tag_y = 1;
                        }else{
                            reduce();
                            tag_y = 0;
                        }
                    }else{
                        num_y = 0;
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
    Handler leave_handler_y = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1145 && rawX <= 1360 && rawY >= 1250 && rawY <= 1470) {
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_y.sendMessageDelayed(message,300);
                }else{
                    num_y = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_x = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_x == 0){
                    num_x++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_x.sendMessageDelayed(message,250);
                }else if(num_x == 1){
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 1250 && rawY <= 1470) {
                        num_x++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_x.sendMessageDelayed(message,250);
                    }else{
                        num_x = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 1250 && rawY <= 1470) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_x.sendMessageDelayed(message,0);
                        if(0 == tag_x){
                            plus();
                            tag_x = 1;
                        }else{
                            reduce();
                            tag_x = 0;
                        }
                    }else{
                        num_x = 0;
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
    Handler leave_handler_x = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 870 && rawX <= 1085 && rawY >= 1250 && rawY <= 1470) { 
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_x.sendMessageDelayed(message,300);
                }else{
                    num_x = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_w = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_w == 0){
                    num_w++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_w.sendMessageDelayed(message,250);
                }else if(num_w == 1){
                    if(rawX >= 595 && rawX <= 810 && rawY >= 1250 && rawY <= 1470) {
                        num_w++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_w.sendMessageDelayed(message,250);
                    }else{
                        num_w = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 595 && rawX <= 810 && rawY >= 1250 && rawY <= 1470) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_w.sendMessageDelayed(message,0);
                        if(0 == tag_w){
                            plus();
                            tag_w = 1;
                        }else{
                            reduce();
                            tag_w = 0;
                        }
                    }else{
                        num_w = 0;
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
    Handler leave_handler_w = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 595 && rawX <= 810 && rawY >= 1250 && rawY <= 1470){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_w.sendMessageDelayed(message,300);
                }else{
                    num_w = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_v = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_v == 0){
                    num_v++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_v.sendMessageDelayed(message,250);
                }else if(num_v == 1){
                    if(rawX >= 320 && rawX <= 535 && rawY >= 1250 && rawY <= 1470) {
                        num_v++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_v.sendMessageDelayed(message,250);
                    }else{
                        num_v = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 320 && rawX <= 535 && rawY >= 1250 && rawY <= 1470) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_v.sendMessageDelayed(message,0);
                        if(0 == tag_v){
                            plus();
                            tag_v = 1;
                        }else{
                            reduce();
                            tag_v = 0;
                        }
                    }else{
                        num_v = 0;
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
    Handler leave_handler_v = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 320 && rawX <= 535 && rawY >= 1250 && rawY <= 1470){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_v.sendMessageDelayed(message,300);
                }else{
                    num_v = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_u = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_u == 0){
                    num_u++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_u.sendMessageDelayed(message,250);
                }else if(num_u == 1){
                    if(rawX >= 45 && rawX <= 260 && rawY >= 1250 && rawY <= 1470) {
                        num_u++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_u.sendMessageDelayed(message,250);
                    }else{
                        num_u = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 45 && rawX <= 260 && rawY >= 1250 && rawY <= 1470) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_u.sendMessageDelayed(message,0);
                        if(0 == tag_u){
                            plus();
                            tag_u = 1;
                        }else{
                            reduce();
                            tag_u = 0;
                        }
                    }else{
                        num_u = 0;
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
    Handler leave_handler_u = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 45 && rawX <= 260 && rawY >= 1250 && rawY <= 1470){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_u.sendMessageDelayed(message,300);
                }else{
                    num_u = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_t = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_t == 0){
                    num_t++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_t.sendMessageDelayed(message,250);
                }else if(num_t == 1){
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 980 && rawY <= 1200) {
                        num_t++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_t.sendMessageDelayed(message,250);
                    }else{
                        num_t = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 980 && rawY <= 1200) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_t.sendMessageDelayed(message,0);
                        if(0 == tag_t){
                            plus();
                            tag_t = 1;
                        }else{
                            reduce();
                            tag_t = 0;
                        }
                    }else{
                        num_t = 0;
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
    Handler leave_handler_t = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1145 && rawX <= 1360 && rawY >= 980 && rawY <= 1200){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_t.sendMessageDelayed(message,300);
                }else{
                    num_t = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_s = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_s == 0){
                    num_s++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_s.sendMessageDelayed(message,250);
                }else if(num_s == 1){
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 980 && rawY <= 1200) {
                        num_s++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_s.sendMessageDelayed(message,250);
                    }else{
                        num_s = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 980 && rawY <= 1200) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_s.sendMessageDelayed(message,0);
                        if(0 == tag_s){
                            plus();
                            tag_s = 1;
                        }else{
                            reduce();
                            tag_s = 0;
                        }
                    }else{
                        num_s = 0;
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
    Handler leave_handler_s = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 870 && rawX <= 1085 && rawY >= 980 && rawY <= 1200){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_s.sendMessageDelayed(message,300);
                }else{
                    num_s = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_r = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_r == 0){
                    num_r++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_r.sendMessageDelayed(message,250);
                }else if(num_r == 1){
                    if(rawX >= 595 && rawX <= 810 && rawY >= 980 && rawY <= 1200) {
                        num_r++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_r.sendMessageDelayed(message,250);
                    }else{
                        num_r = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 595 && rawX <= 810 && rawY >= 980 && rawY <= 1200) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_r.sendMessageDelayed(message,0);
                        if(0 == tag_r){
                            plus();
                            tag_r = 1;
                        }else{
                            reduce();
                            tag_r = 0;
                        }
                    }else{
                        num_r = 0;
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
    Handler leave_handler_r = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 595 && rawX <= 810 && rawY >= 980 && rawY <= 1200){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_r.sendMessageDelayed(message,300);
                }else{
                    num_r = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_q = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_q == 0){
                    num_q++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_q.sendMessageDelayed(message,250);
                }else if(num_q == 1){
                    if(rawX >= 320 && rawX <= 535 && rawY >= 980 && rawY <= 1200) {
                        num_q++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_q.sendMessageDelayed(message,250);
                    }else{
                        num_q = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 320 && rawX <= 535 && rawY >= 980 && rawY <= 1200) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_q.sendMessageDelayed(message,0);
                        if(0 == tag_q){
                            plus();
                            tag_q = 1;
                        }else{
                            reduce();
                            tag_q = 0;
                        }
                    }else{
                        num_q = 0;
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
    Handler leave_handler_q = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 320 && rawX <= 535 && rawY >= 980 && rawY <= 1200){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_q.sendMessageDelayed(message,300);
                }else{
                    num_q = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_p = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_p == 0){
                    num_p++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_p.sendMessageDelayed(message,250);
                }else if(num_p == 1){
                    if(rawX >= 45 && rawX <= 260 && rawY >= 980 && rawY <= 1200) {
                        num_p++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_p.sendMessageDelayed(message,250);
                    }else{
                        num_p = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 45 && rawX <= 260 && rawY >= 980 && rawY <= 1200) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_p.sendMessageDelayed(message,0);
                        if(0 == tag_p){
                            plus();
                            tag_p = 1;
                        }else{
                            reduce();
                            tag_p = 0;
                        }
                    }else{
                        num_p = 0;
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
    Handler leave_handler_p = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 45 && rawX <= 260 && rawY >= 980 && rawY <= 1200){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_p.sendMessageDelayed(message,300);
                }else{
                    num_p = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_a = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_a == 0){
                    num_a++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_a.sendMessageDelayed(message,250);
                }else if(num_a == 1){
                    if(rawX >= 45 && rawX <= 260 && rawY >= 125 && rawY <= 340) {
                        num_a++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_a.sendMessageDelayed(message,250);
                    }else{
                        num_a = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 45 && rawX <= 260 && rawY >= 125 && rawY <= 340) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_a.sendMessageDelayed(message,0);
                        if(0 == tag_a){
                            plus();
                            tag_a = 1;
                        }else{
                            reduce();
                            tag_a = 0;
                        }
                    }else{
                        num_a = 0;
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
    Handler leave_handler_a = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 45 && rawX <= 260 && rawY >= 125 && rawY <= 340){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_a.sendMessageDelayed(message,300);
                }else{
                    num_a = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_b = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_b == 0){
                    num_b++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_b.sendMessageDelayed(message,250);
                }else if(num_b == 1){
                    if(rawX >= 320 && rawX <= 545 && rawY >= 125 && rawY <= 340) {
                        num_b++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_b.sendMessageDelayed(message,250);
                    }else{
                        num_b = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 320 && rawX <= 545 && rawY >= 125 && rawY <= 340) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_b.sendMessageDelayed(message,0);
                        if(0 == tag_b){
                            plus();
                            tag_b = 1;
                        }else{
                            reduce();
                            tag_b = 0;
                        }
                    }else{
                        num_b = 0;
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
    Handler leave_handler_b = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 320 && rawX <= 545 && rawY >= 125 && rawY <= 340){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_b.sendMessageDelayed(message,300);
                }else{
                    num_b = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_c = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_c == 0){
                    num_c++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_c.sendMessageDelayed(message,250);
                }else if(num_c == 1){
                    if(rawX >= 595 && rawX <= 810 && rawY >= 125 && rawY <= 340) {
                        num_c++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_c.sendMessageDelayed(message,250);
                    }else{
                        num_c = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 595 && rawX <= 810 && rawY >= 125 && rawY <= 340) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_c.sendMessageDelayed(message,0);
                        if(0 == tag_c){
                            plus();
                            tag_c = 1;
                        }else{
                            reduce();
                            tag_c = 0;
                        }
                    }else{
                        num_c = 0;
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
    Handler leave_handler_c = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 595 && rawX <= 810 && rawY >= 125 && rawY <= 340){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_c.sendMessageDelayed(message,300);
                }else{
                    num_c = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_d = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_d == 0){
                    num_d++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_d.sendMessageDelayed(message,250);
                }else if(num_d == 1){
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 125 && rawY <= 340) {
                        num_d++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_d.sendMessageDelayed(message,250);
                    }else{
                        num_d = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 125 && rawY <= 340) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_d.sendMessageDelayed(message,0);
                        if(0 == tag_d){
                            plus();
                            tag_d = 1;
                        }else{
                            reduce();
                            tag_d = 0;
                        }
                    }else{
                        num_d = 0;
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
    Handler leave_handler_d = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 870 && rawX <= 1085 && rawY >= 125 && rawY <= 340){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_d.sendMessageDelayed(message,300);
                }else{
                    num_d = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_e = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_e == 0){
                    num_e++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_e.sendMessageDelayed(message,250);
                }else if(num_e == 1){
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 125 && rawY <= 340) {
                        num_e++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_e.sendMessageDelayed(message,250);
                    }else{
                        num_e = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 125 && rawY <= 340) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_e.sendMessageDelayed(message,0);
                        if(0 == tag_e){
                            plus();
                            tag_e = 1;
                        }else{
                            reduce();
                            tag_e = 0;
                        }
                    }else{
                        num_e = 0;
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
    Handler leave_handler_e = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1145 && rawX <= 1360 && rawY >= 125 && rawY <= 340){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_e.sendMessageDelayed(message,300);
                }else{
                    num_e = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_f = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_f == 0){
                    num_f++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_f.sendMessageDelayed(message,250);
                }else if(num_f == 1){
                    if(rawX >= 45 && rawX <= 260 && rawY >= 410 && rawY <= 625) {
                        num_f++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_f.sendMessageDelayed(message,250);
                    }else{
                        num_f = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 45 && rawX <= 260 && rawY >= 410 && rawY <= 625) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_f.sendMessageDelayed(message,0);
                        if(0 == tag_f){
                            plus();
                            tag_f = 1;
                        }else{
                            reduce();
                            tag_f = 0;
                        }
                    }else{
                        num_f = 0;
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
    Handler leave_handler_f = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 45 && rawX <= 260 && rawY >= 410 && rawY <= 625){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_f.sendMessageDelayed(message,300);
                }else{
                    num_f = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_g = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_g == 0){
                    num_g++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_g.sendMessageDelayed(message,250);
                }else if(num_g == 1){
                    if(rawX >= 320 && rawX <= 535 && rawY >= 410 && rawY <= 625) {
                        num_g++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_g.sendMessageDelayed(message,250);
                    }else{
                        num_g = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 320 && rawX <= 535 && rawY >= 410 && rawY <= 625) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_g.sendMessageDelayed(message,0);
                        if(0 == tag_g){
                            plus();
                            tag_g = 1;
                        }else{
                            reduce();
                            tag_g = 0;
                        }
                    }else{
                        num_g = 0;
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
    Handler leave_handler_g = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 320 && rawX <= 535 && rawY >= 410 && rawY <= 625){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_g.sendMessageDelayed(message,300);
                }else{
                    num_g = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_h == 0){
                    num_h++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_h.sendMessageDelayed(message,250);
                }else if(num_h == 1){
                    if(rawX >= 595 && rawX <= 810 && rawY >= 410 && rawY <= 625) {
                        num_h++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_h.sendMessageDelayed(message,250);
                    }else{
                        num_h = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 595 && rawX <= 810 && rawY >= 410 && rawY <= 625) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_h.sendMessageDelayed(message,0);
                        if(0 == tag_h){
                            plus();
                            tag_h = 1;
                        }else{
                            reduce();
                            tag_h = 0;
                        }
                    }else{
                        num_h = 0;
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
    Handler leave_handler_h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 595 && rawX <= 810 && rawY >= 410 && rawY <= 625){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_h.sendMessageDelayed(message,300);
                }else{
                    num_h = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_i = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_i == 0){
                    num_i++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_i.sendMessageDelayed(message,250);
                }else if(num_i == 1){
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 410 && rawY <= 625) {
                        num_i++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_i.sendMessageDelayed(message,250);
                    }else{
                        num_i = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 410 && rawY <= 625) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_i.sendMessageDelayed(message,0);
                        if(0 == tag_i){
                            plus();
                            tag_i = 1;
                        }else{
                            reduce();
                            tag_i = 0;
                        }
                    }else{
                        num_i = 0;
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
    Handler leave_handler_i = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 870 && rawX <= 1085 && rawY >= 410 && rawY <= 625){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_i.sendMessageDelayed(message,300);
                }else{
                    num_i = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_j = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_j == 0){
                    num_j++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_j.sendMessageDelayed(message,250);
                }else if(num_j == 1){
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 410 && rawY <= 625) {
                        num_j++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_j.sendMessageDelayed(message,250);
                    }else{
                        num_j = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 410 && rawY <= 625) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_j.sendMessageDelayed(message,0);
                        if(0 == tag_j){
                            plus();
                            tag_j = 1;
                        }else{
                            reduce();
                            tag_j = 0;
                        }
                    }else{
                        num_j = 0;
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
    Handler leave_handler_j = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1145 && rawX <= 1360 && rawY >= 410 && rawY <= 625){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_j.sendMessageDelayed(message,300);
                }else{
                    num_j = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_k = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_k == 0){
                    num_k++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_k.sendMessageDelayed(message,250);
                }else if(num_k == 1){
                    if(rawX >= 45 && rawX <= 260 && rawY >= 690 && rawY <= 910) {
                        num_k++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_k.sendMessageDelayed(message,250);
                    }else{
                        num_k = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 45 && rawX <= 260 && rawY >= 690 && rawY <= 910) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_k.sendMessageDelayed(message,0);
                        if(0 == tag_k){
                            plus();
                            tag_k = 1;
                        }else{
                            reduce();
                            tag_k = 0;
                        }
                    }else{
                        num_k = 0;
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
    Handler leave_handler_k = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 45 && rawX <= 260 && rawY >= 690 && rawY <= 910){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_k.sendMessageDelayed(message,300);
                }else{
                    num_k = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_l = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_l == 0){
                    num_l++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_l.sendMessageDelayed(message,250);
                }else if(num_l == 1){
                    if(rawX >= 320 && rawX <= 535 && rawY >= 690 && rawY <= 910) {
                        num_l++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_l.sendMessageDelayed(message,250);
                    }else{
                        num_l = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 320 && rawX <= 535 && rawY >= 690 && rawY <= 910) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_l.sendMessageDelayed(message,0);
                        if(0 == tag_l){
                            plus();
                            tag_l = 1;
                        }else{
                            reduce();
                            tag_l = 0;
                        }
                    }else{
                        num_l = 0;
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
    Handler leave_handler_l = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 320 && rawX <= 535 && rawY >= 690 && rawY <= 910){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_l.sendMessageDelayed(message,300);
                }else{
                    num_l = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_m = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_m == 0){
                    num_m++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_m.sendMessageDelayed(message,250);
                }else if(num_m == 1){
                    if(rawX >= 595 && rawX <= 810 && rawY >= 690 && rawY <= 910) {
                        num_m++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_m.sendMessageDelayed(message,250);
                    }else{
                        num_m = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 595 && rawX <= 810 && rawY >= 690 && rawY <= 910) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_m.sendMessageDelayed(message,0);
                        if(0 == tag_m){
                            plus();
                            tag_m = 1;
                        }else{
                            reduce();
                            tag_m = 0;
                        }
                    }else{
                        num_m = 0;
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
    Handler leave_handler_m = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 595 && rawX <= 810 && rawY >= 690 && rawY <= 910){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_m.sendMessageDelayed(message,300);
                }else{
                    num_m = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_n = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_n == 0){
                    num_n++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_n.sendMessageDelayed(message,250);
                }else if(num_n == 1){
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 690 && rawY <= 910) {
                        num_n++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_n.sendMessageDelayed(message,250);
                    }else{
                        num_n = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 870 && rawX <= 1085 && rawY >= 690 && rawY <= 910) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_n.sendMessageDelayed(message,0);
                        if(0 == tag_n){
                            plus();
                            tag_n = 1;
                        }else{
                            reduce();
                            tag_n = 0;
                        }
                    }else{
                        num_n = 0;
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
    Handler leave_handler_n = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 870 && rawX <= 1085 && rawY >= 690 && rawY <= 910){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_n.sendMessageDelayed(message,300);
                }else{
                    num_n = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_o = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_o == 0){
                    num_o++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_o.sendMessageDelayed(message,250);
                }else if(num_o == 1){
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 690 && rawY <= 910) {
                        num_o++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_o.sendMessageDelayed(message,250);
                    }else{
                        num_o = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1145 && rawX <= 1360 && rawY >= 690 && rawY <= 910) {
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_o.sendMessageDelayed(message,0);
                        if(0 == tag_o){
                            plus();
                            tag_o = 1;
                        }else{
                            reduce();
                            tag_o = 0;
                        }
                    }else{
                        num_o = 0;
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
    Handler leave_handler_o = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1145 && rawX <= 1360 && rawY >= 690 && rawY <= 910){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_o.sendMessageDelayed(message,300);
                }else{
                    num_o = 0;
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
        setContentView(R.layout.activity_independent_pwd);
        init();
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rawX = ev.getRawX();
        rawY = ev.getRawY();
       // System.out.println(rawX+"---"+rawY);
        return super.dispatchTouchEvent(ev);
    }
    void init(){
        txt_ind_show = findViewById(R.id.txt_ind_show);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        if((sqliteImplementer.getIndPwd(user.username) == null)){
            hav_indpwd = false;
            AlertDialog alertDialog = new AlertDialog.Builder(IndependentPwdActivity.this).create();
            alertDialog.setIcon(R.drawable.img_warning);
            alertDialog.setTitle("提示");
            alertDialog.setMessage("此次为您第一次登陆，请选择若干个相应的字符作为独立密码");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }else{
            hav_indpwd = true;
        }
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    void plus(){
        num_pwd++;
        txt_ind_show.setText("已选"+num_pwd+"个字符");
    }
    void reduce(){
        num_pwd--;
        txt_ind_show.setText("已选"+num_pwd+"个字符");
    }
    void reset(){
        num_pwd = 0;
        txt_ind_show.setText("已选"+num_pwd+"个字符");
        tag_a = 0;
        tag_b = 0;
        tag_c = 0;
        tag_d = 0;
        tag_e = 0;
        tag_f = 0;
        tag_g = 0;
        tag_h = 0;
        tag_i = 0;
        tag_j = 0;
        tag_k = 0;
        tag_l = 0;
        tag_m = 0;
        tag_n = 0;
        tag_o = 0;
        tag_p = 0;
        tag_q = 0;
        tag_r = 0;
        tag_s = 0;
        tag_t = 0;
        tag_u = 0;
        tag_v = 0;
        tag_w = 0;
        tag_x = 0;
        tag_y = 0;
        tag_z = 0;
        tag_1 = 0;
        tag_2 = 0;
        tag_3 = 0;
        tag_4 = 0;
        tag_5 = 0;
        tag_6 = 0;
        tag_7 = 0;
        tag_8 = 0;
        tag_9 = 0;
        tag_0 = 0;
    }
    void checkPwd(){
        if(tag_a == 1){
            password += "a";
        }
        if(tag_b == 1){
            password += "b";
        }
        if(tag_c == 1){
            password += "c";
        }
        if(tag_d == 1){
            password += "d";
        }
        if(tag_e == 1){
            password += "e";
        }
        if(tag_f == 1){
            password += "f";
        }
        if(tag_g == 1){
            password += "g";
        }
        if(tag_h == 1){
            password += "h";
        }
        if(tag_i == 1){
            password += "i";
        }
        if(tag_j == 1){
            password += "j";
        }
        if(tag_k == 1){
            password += "k";
        }
        if(tag_l == 1){
            password += "l";
        }
        if(tag_m == 1){
            password += "m";
        }
        if(tag_n == 1){
            password += "n";
        }
        if(tag_o == 1){
            password += "o";
        }
        if(tag_p == 1){
            password += "p";
        }
        if(tag_q == 1){
            password += "q";
        }
        if(tag_r == 1){
            password += "r";
        }
        if(tag_s == 1){
            password += "s";
        }
        if(tag_t == 1){
            password += "t";
        }
        if(tag_u == 1){
            password += "u";
        }
        if(tag_v == 1){
            password += "v";
        }
        if(tag_w == 1){
            password += "w";
        }
        if(tag_x == 1){
            password += "x";
        }
        if(tag_y == 1){
            password += "y";
        }
        if(tag_z == 1){
            password += "z";
        }
        if(tag_1 == 1){
            password += "1";
        }
        if(tag_2 == 1){
            password += "2";
        }
        if(tag_3 == 1){
            password += "3";
        }
        if(tag_4 == 1){
            password += "4";
        }
        if(tag_5 == 1){
            password += "5";
        }
        if(tag_6 == 1){
            password += "6";
        }
        if(tag_7 == 1){
            password += "7";
        }
        if(tag_8 == 1){
            password += "8";
        }
        if(tag_9 == 1){
            password += "9";
        }
        if(tag_0 == 1){
            password += "0";
        }
        if(!hav_indpwd){
            if(!"".equals(password)) {
                sqliteImplementer.changeIndPwd(user.username, getMD5String(password));
                Intent intent2 = new Intent(IndependentPwdActivity.this, ChatHisActivity.class);
                startActivity(intent2);
                finish();
            }else{
                Toast.makeText(IndependentPwdActivity.this, "至少需要选择一个字符", Toast.LENGTH_SHORT).show();
            }
        }else{
            if (sqliteImplementer.getIndPwd(user.username).equals(getMD5String(password))) {
                Intent intent2 = new Intent(IndependentPwdActivity.this, ChatHisActivity.class);
                startActivity(intent2);
                finish();
            }else{
                num_mistake++;
                if(num_mistake == 3){
                    Intent intent = new Intent(IndependentPwdActivity.this, HumanCheckActivity.class);
                    startActivityForResult(intent,111);
                }
                Toast.makeText(IndependentPwdActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                reset();
            }
        }
        password = "";
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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 111) {
            num_mistake = 0;
        }
        if (requestCode == 111 && resultCode == 112) {
            Intent intent = new Intent(IndependentPwdActivity.this, HumanCheckActivity.class);
            startActivityForResult(intent,111);
        }
    }
}
