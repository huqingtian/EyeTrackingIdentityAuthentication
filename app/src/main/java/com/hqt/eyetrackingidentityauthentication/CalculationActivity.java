package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.ScriptGroup;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.regex.Pattern;

public class CalculationActivity extends AppCompatActivity {
    int operator1, operator2, num1, num2, num3;
    int answer = -1, num_refresh, num_answer;
    String op1, op2, inputAnswer;
    TextView txt_cal_ques;
    private float rawX;
    private float rawY;
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        txt_cal_ques = findViewById(R.id.txt_cal_ques);
        txt_cal_ques.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        while(answer < 0){
            answer = getAnswer();
        }
        initQuestion();
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,300);
    }
    int getAnswer(){
        int answer = 0;
        Random random = new Random(System.nanoTime());
        operator1 = random.nextInt(3) + 1;
        operator2 = random.nextInt(3) + 1;
        num1 = random.nextInt(13);
        num2 = random.nextInt(13);
        num3 = random.nextInt(13);
        if(operator2 >= 3){
            op2 = "*";
            if(operator1 == 1){
                answer = num1 + num2 * num3;
                op1 = "+";
            }else if(operator1 == 2){
                answer = num1 - num2 * num3;
                op1 = "-";
            }else if(operator1 >= 3){
                answer = num1 * num2 * num3;
                op1 = "*";
            }
        }else if(operator2 == 2){
            op2 = "-";
            if(operator1 == 1){
                answer = num1 + num2 - num3;
                op1 = "+";
            }else if(operator1 == 2){
                answer = num1 - num2 - num3;
                op1 = "-";
            }else if(operator1 >= 3){
                answer = num1 * num2 - num3;
                op1 = "*";
            }
        }else{
            op2 = "+";
            if(operator1 == 1){
                answer = num1 + num2 + num3;
                op1 = "+";
            }else if(operator1 == 2){
                answer = num1 - num2 + num3;
                op1 = "-";
            }else if(operator1 >= 3){
                answer = num1 * num2 + num3;
                op1 = "*";
            }
        }
        return answer;
    }
    void initQuestion(){
        String ques = "";
        ques = num1 + " " + op1 + " " + num2 + " " + op2 + " " + num3 + " " + "=" + " ?";
        txt_cal_ques.setText(ques);
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
                    if(rawX >= 630 && rawX <= 810 && rawY >= 1850 && rawY <= 2020){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_refresh.sendMessageDelayed(message,0);
                    }else if(rawX >= 450 && rawX <= 970 && rawY >= 1290 && rawY <= 1530){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_answer.sendMessageDelayed(message,0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_refresh = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_refresh == 0){
                    num_refresh++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_refresh.sendMessageDelayed(message,250);
                }else if(num_refresh == 1){
                    if(rawX >= 630 && rawX <= 810 && rawY >= 1850 && rawY <= 2020) {
                        num_refresh++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_refresh.sendMessageDelayed(message,250);
                    }else{
                        num_refresh = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 630 && rawX <= 810 && rawY >= 1850 && rawY <= 2020) {
                        setResult(112);
                        finish();
                    }else{
                        num_refresh = 0;
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
    Handler handler_answer = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_answer == 0){
                    num_answer++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_answer.sendMessageDelayed(message,250);
                }else if(num_answer == 1){
                    if(rawX >= 450 && rawX <= 970 && rawY >= 1290 && rawY <= 1530) {
                        num_answer++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_answer.sendMessageDelayed(message,250);
                    }else{
                        num_answer = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 450 && rawX <= 970 && rawY >= 1290 && rawY <= 1530) {
                        Intent intent = new Intent(CalculationActivity.this, InputActivity.class);
                        startActivityForResult(intent,111);
                    }else{
                        num_answer = 0;
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 111) {
            inputAnswer = data.getStringExtra("key");
            if(isInteger(inputAnswer)){
                if(answer == Integer.parseInt(inputAnswer)){
                    setResult(111);
                    finish();
                }else{
                    Toast.makeText(CalculationActivity.this, "答案错误", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(CalculationActivity.this, "答案错误", Toast.LENGTH_SHORT).show();
            }
        }
        flag = true;
        rawX = 0;
        rawY = 0;
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
