package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.security.MessageDigest;

public class ChangeLoginPwdActivity extends AppCompatActivity {
    ImageView img_showpwd;
    EditText edt_oldpwd;
    EditText edt_newpwd;
    TextView txt_tip;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    boolean showTag = true;
    Drawable drawable;
    ColorStateList hintColor;
    UsersTable user;
    private float rawX ;
    private float rawY ;
    boolean flag = true;
    int num_return, num_oldpwd, num_newpwd, num_btn, num_showpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_login_pwd);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        txt_tip = findViewById(R.id.txt_change_tip);
        img_showpwd = findViewById(R.id.img_showpwd);
        edt_oldpwd = findViewById(R.id.edt_oldpwd);
        edt_newpwd = findViewById(R.id.edt_newpwd);
        drawable = edt_newpwd.getBackground();
        hintColor = edt_newpwd.getHintTextColors();
        edt_oldpwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!"".equals(edt_oldpwd.getText().toString())){
                    edt_oldpwd.setBackground(drawable);
                    edt_oldpwd.setHintTextColor(hintColor);
                    edt_oldpwd.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        edt_newpwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!"".equals(edt_newpwd.getText().toString())){
                    edt_newpwd.setBackground(drawable);
                    edt_newpwd.setHintTextColor(hintColor);
                    txt_tip.setText("");
                }
            }
        });
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
    }
    void showpwd(){
        if(showTag){
            img_showpwd.setImageResource(R.drawable.img_cbxunchecked);
            edt_newpwd.setInputType(0x00000081);
            edt_oldpwd.setInputType(0x00000081);
            showTag = false;
        }else{
            img_showpwd.setImageResource(R.drawable.img_cbxchecked);
            edt_newpwd.setInputType(0x00000001);
            edt_oldpwd.setInputType(0x00000001);
            showTag = true;
        }
    }
    void change(){
        if("".equals(edt_oldpwd.getText().toString())){
            edt_oldpwd.setBackgroundResource(R.drawable.edt_shape);
            edt_oldpwd.setHintTextColor(Color.parseColor("#FF0000"));
        }
        if("".equals(edt_newpwd.getText().toString())){
            edt_newpwd.setBackgroundResource(R.drawable.edt_shape);
            edt_newpwd.setHintTextColor(Color.parseColor("#FF0000"));
        }else{
            if(isLetterDigit(edt_newpwd.getText().toString()) && edt_newpwd.getText().toString().length() >= 8 && edt_newpwd.getText().toString().length() <= 16){
                if(user.password.equals(getMD5String(edt_oldpwd.getText().toString()))){
                    String password = edt_newpwd.getText().toString();
                    sqliteImplementer.changeLoginPwd(user.username, getMD5String(password));
                    Toast.makeText(ChangeLoginPwdActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    edt_oldpwd.setBackgroundResource(R.drawable.edt_shape);
                    edt_oldpwd.setTextColor(Color.parseColor("#FF0000"));
                    Toast.makeText(ChangeLoginPwdActivity.this, "旧密码错误", Toast.LENGTH_SHORT).show();
                }
            }else{
                txt_tip.setText("密码必须为包含数字以及字符的8-16位组合");
                edt_newpwd.setBackgroundResource(R.drawable.edt_shape);
                edt_newpwd.setHintTextColor(Color.parseColor("#FF0000"));
            }
        }
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
    public static boolean isLetterDigit(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLetter(str.charAt(i))) {  //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        String regex = "^[a-zA-Z0-9]+$";
        boolean isRight = isDigit && isLetter && str.matches(regex);
        return isRight;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rawX = ev.getRawX();
        rawY = ev.getRawY();
        return super.dispatchTouchEvent(ev);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 111) {
            String oldpwd = data.getStringExtra("key");
            edt_oldpwd.setText(oldpwd);
        }
        if (requestCode == 112 && resultCode == 111) {
            String newpwd = data.getStringExtra("key");
            edt_newpwd.setText(newpwd);
        }
        flag = true;
        rawX = 0;
        rawY = 0;
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
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
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 480 && rawY <= 690){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_oldpwd.sendMessageDelayed(message,0);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 890 && rawY <= 1090){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_newpwd.sendMessageDelayed(message,0);
                    }else if(rawX >= 60 && rawX <= 1370 && rawY >= 1320 && rawY <= 1540){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_btn.sendMessageDelayed(message,0);
                    }else if(rawX >= 65 && rawX <= 490 && rawY >= 1745 && rawY <= 1845){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_showpwd.sendMessageDelayed(message,0);
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
    Handler handler_oldpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_oldpwd == 0){
                    num_oldpwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_oldpwd.sendMessageDelayed(message,250);
                }else if(num_oldpwd == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 480 && rawY <= 690) {
                        num_oldpwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_oldpwd.sendMessageDelayed(message,250);
                    }else{
                        num_oldpwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 480 && rawY <= 690) {
                        Intent intent = new Intent(ChangeLoginPwdActivity.this, InputActivity.class);
                        startActivityForResult(intent,111);
                    }else{
                        num_oldpwd = 0;
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
    Handler handler_newpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_newpwd == 0){
                    num_newpwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_newpwd.sendMessageDelayed(message,250);
                }else if(num_newpwd == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 890 && rawY <= 1090) {
                        num_newpwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_newpwd.sendMessageDelayed(message,250);
                    }else{
                        num_newpwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 890 && rawY <= 1090) {
                        Intent intent = new Intent(ChangeLoginPwdActivity.this, InputActivity.class);
                        startActivityForResult(intent,112);
                    }else{
                        num_newpwd = 0;
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
    Handler handler_btn = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_btn == 0){
                    num_btn++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_btn.sendMessageDelayed(message,250);
                }else if(num_btn == 1){
                    if(rawX >= 60 && rawX <= 1370 && rawY >= 1320 && rawY <= 1540) {
                        num_btn++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_btn.sendMessageDelayed(message,250);
                    }else{
                        num_btn = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 60 && rawX <= 1370 && rawY >= 1320 && rawY <= 1540) {
                        change();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_btn.sendMessageDelayed(message,0);
                    }else{
                        num_btn = 0;
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
    Handler leave_handler_btn = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 60 && rawX <= 1370 && rawY >= 1320 && rawY <= 1540){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_btn.sendMessageDelayed(message,300);
                }else{
                    num_btn = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_showpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_showpwd == 0){
                    num_showpwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_showpwd.sendMessageDelayed(message,250);
                }else if(num_showpwd == 1){
                    if(rawX >= 65 && rawX <= 490 && rawY >= 1745 && rawY <= 1845) {
                        num_showpwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_showpwd.sendMessageDelayed(message,250);
                    }else{
                        num_showpwd = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 65 && rawX <= 490 && rawY >= 1745 && rawY <= 1845) {
                        showpwd();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_showpwd.sendMessageDelayed(message,0);
                    }else{
                        num_showpwd = 0;
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
    Handler leave_handler_showpwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 65 && rawX <= 490 && rawY >= 1745 && rawY <= 1845){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_showpwd.sendMessageDelayed(message,300);
                }else{
                    num_showpwd = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
}
