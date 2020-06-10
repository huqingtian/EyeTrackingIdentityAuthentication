package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HumanCheckActivity extends AppCompatActivity {
    ImageView img_hc;
    private float rawX;
    private float rawY;
    int x, y;
    boolean flag = true, tag_move = false;
    int num_pic, num_refresh, num_close, num_target;
    Bitmap bitmap, temp;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_check);
        img_hc = findViewById(R.id.img_hc);
        Random random = new Random(System.nanoTime());
        int n = random.nextInt(7) + 1;
        x = random.nextInt(999) + 1;
        y = random.nextInt(599) + 1;
        changePic(n,x,y);
        draw(x, y);
        final HumanCheckView hat = new HumanCheckView(HumanCheckActivity.this, bitmap);
        hat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(tag_move){
                    hat.X = rawX - 195;
                    hat.Y = rawY - 225;
                    hat.invalidate();
                }
                return true;
            }
        });
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
        FrameLayout relativeLayout = findViewById(R.id.fl_humancheck);
        relativeLayout.addView(hat);
    }
    void draw(int x, int y){
        Paint paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.FILL);
        Canvas canvas = new Canvas(temp);
        canvas.drawRect(x, y, x + 350, y + 350, paint);
        img_hc.setImageBitmap(temp);
    }
    void move(){
        tag_move = true;
        Message message = Message.obtain();
        message.what = 1;
        handler2.sendMessageDelayed(message,0);
    }
    void changePic(int n, int x, int y){
        if(n == 1){
            img_hc.setImageResource(R.drawable.img_human_check1);
        }else if(n == 2){
            img_hc.setImageResource(R.drawable.img_human_check2);
        }else if(n == 3){
            img_hc.setImageResource(R.drawable.img_human_check3);
        }else if(n == 4){
            img_hc.setImageResource(R.drawable.img_human_check4);
        }else if(n == 5){
            img_hc.setImageResource(R.drawable.img_human_check5);
        }else if(n == 6){
            img_hc.setImageResource(R.drawable.img_human_check6);
        }else if(n == 7){
            img_hc.setImageResource(R.drawable.img_human_check7);
        }else if(n == 8){
            img_hc.setImageResource(R.drawable.img_human_check8);
        }
        Bitmap b = drawableToBitmap(img_hc.getDrawable());
        temp = b;
        bitmap = Bitmap.createBitmap(b, x, y, 350, 350);
    }
    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap( 1430, 950,
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, 1430, 950);
        drawable.draw(canvas);
        return bitmap;
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
                if(rawX >= 543 && rawX <= 890 && rawY >= 1600 && rawY <= 1900){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_pic.sendMessageDelayed(message,0);
                }else if(rawX >= 0 && rawX <= 210 && rawY >= 1520 && rawY <= 1680){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_refresh.sendMessageDelayed(message,0);
                }else if(rawX >= 1270 && rawX <= 1420 && rawY >= 1520 && rawY <= 1680){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_close.sendMessageDelayed(message,0);
                }
                Message message = Message.obtain();
                message.what = 1;
                handler.sendMessageDelayed(message,300);
            }
        }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_pic = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_pic == 0){
                    num_pic++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_pic.sendMessageDelayed(message,250);
                }else if(num_pic == 1){
                    if(rawX >= 543 && rawX <= 890 && rawY >= 1600 && rawY <= 1900) {
                        num_pic++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_pic.sendMessageDelayed(message,250);
                    }else{
                        num_pic = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 543 && rawX <= 890 && rawY >= 1600 && rawY <= 1900) {
                        move();
                    }else{
                        num_pic = 0;
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
                    if(rawX >= 0 && rawX <= 210 && rawY >= 1520 && rawY <= 1680) {
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
                    if(rawX >= 0 && rawX <= 210 && rawY >= 1520 && rawY <= 1680) {
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
                    if(rawX >= 1270 && rawX <= 1420 && rawY >= 1520 && rawY <= 1680) {
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
                    if(rawX >= 1270 && rawX <= 1420 && rawY >= 1520 && rawY <= 1680) {
                        setResult(112);
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
    Handler handler_target = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_target == 0){
                    num_target++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_target.sendMessageDelayed(message,250);
                }else if(num_target == 1){
                    if(rawX >= x + 120 && rawX <= x + 230 && rawY >= y + 530 && rawY <= y + 640) {
                        num_target++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_target.sendMessageDelayed(message,250);
                    }else{
                        num_target = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= x + 120 && rawX <= x + 230 && rawY >= y + 530 && rawY <= y + 640) {
                        num_target = 0;
                        rawX = 0;
                        rawY = 0;
                        flag = false;
                        Toast.makeText(HumanCheckActivity.this, "认证成功", Toast.LENGTH_SHORT).show();
                        setResult(111);
                        finish();
                    }else{
                        num_target = 0;
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
    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 0 && rawX <= 210 && rawY >= 1520 && rawY <= 1680){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_refresh.sendMessageDelayed(message,0);
                }else if(rawX >= 1270 && rawX <= 1420 && rawY >= 1520 && rawY <= 1680){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_close.sendMessageDelayed(message,0);
                }else if(rawX >= x + 120 && rawX <= x + 230 && rawY >= y + 530 && rawY <= y + 640){
                    flag = false;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_target.sendMessageDelayed(message,0);
                }
                Message message = Message.obtain();
                message.what = 1;
                handler2.sendMessageDelayed(message,300);
            }
        }
    };
}
