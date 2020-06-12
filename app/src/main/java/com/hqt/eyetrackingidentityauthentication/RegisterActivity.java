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
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    EditText edt_password;
    EditText edt_username;
    String pwd = "";
    TextView txt_tip;
    Drawable drawable;
    ColorStateList hintColor;
    private float rawX ;
    private float rawY ;
    boolean flag = true;
    int num_username, num_password, num_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        edt_password = findViewById(R.id.edt_password);
        edt_username = findViewById(R.id.edt_username);
        edt_password.setInputType(InputType.TYPE_NULL);
        edt_username.setInputType(InputType.TYPE_NULL);
        txt_tip = findViewById(R.id.txt_tip);
        drawable = edt_password.getBackground();
        hintColor = edt_password.getHintTextColors();
        edt_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!"".equals(edt_password.getText().toString())){
                    edt_password.setBackground(drawable);
                    edt_password.setHintTextColor(hintColor);
                    txt_tip.setText("");
                }
            }
        });
        edt_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!"".equals(edt_username.getText().toString())){
                    edt_username.setBackground(drawable);
                    edt_username.setHintTextColor(hintColor);
                }
            }
        });
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,0);
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
    void register(){
        if("".equals(edt_username.getText().toString())){
            edt_username.setBackgroundResource(R.drawable.edt_shape);
            edt_username.setHintTextColor(Color.parseColor("#FF0000"));
        }
        if("".equals(edt_password.getText().toString())){
            edt_password.setBackgroundResource(R.drawable.edt_shape);
            edt_password.setHintTextColor(Color.parseColor("#FF0000"));
        }else{
            if(isLetterDigit(pwd) && pwd.length() >= 8 && pwd.length() <= 16){
                String username = edt_username.getText().toString();
                UsersTable user = sqliteImplementer.getUser(username);
                if(user.password == null) {
                    pwd = getMD5String(pwd);
                    UsersTable table = new UsersTable(username, pwd);
                    table.ettag = "1";
                    sqliteImplementer.saveData(table);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    setResult(111, intent);
                    finish();
                }else{
                    Toast.makeText(RegisterActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
                }
            }else{
                txt_tip.setText("密码必须为包含数字以及字符的8-16位组合");
                edt_password.setBackgroundResource(R.drawable.edt_shape);
                edt_password.setHintTextColor(Color.parseColor("#FF0000"));
            }
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 111) {
            String username = data.getStringExtra("key");
            edt_username.setText(username);
        }
        if (requestCode == 112 && resultCode == 111) {
            String password = data.getStringExtra("key");
            String temp = "";
            for(int i = 0; i < password.length(); i++){
                temp += "●";
            }
            edt_password.setText(temp);
            pwd = password;
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
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 940 && rawY <= 1040){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_username.sendMessageDelayed(message,0);
                    }else if(rawX >= 140 && rawX <= 1300 && rawY >= 1200 && rawY <= 1300){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_password.sendMessageDelayed(message,0);
                    }else if(rawX >= 80 && rawX <= 1370 && rawY >= 1480 && rawY <= 1680){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_register.sendMessageDelayed(message,0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_username = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_username == 0){
                    num_username++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_username.sendMessageDelayed(message,250);
                }else if(num_username == 1){
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 940 && rawY <= 1040) {
                        num_username++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_username.sendMessageDelayed(message,250);
                    }else{
                        num_username = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 940 && rawY <= 1040) {
                        num_username = 0;
                        Intent intent = new Intent(RegisterActivity.this, InputActivity.class);
                        intent.putExtra("isPwd", "0");
                        startActivityForResult(intent,111);
                    }else{
                        num_username = 0;
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
    Handler handler_password = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_password == 0){
                    num_password++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_password.sendMessageDelayed(message,250);
                }else if(num_password == 1){
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 1200 && rawY <= 1300) {
                        num_password++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_password.sendMessageDelayed(message,250);
                    }else{
                        num_password = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 140 && rawX <= 1300 && rawY >= 1200 && rawY <= 1300) {
                        num_password = 0;
                        Intent intent = new Intent(RegisterActivity.this, InputActivity.class);
                        intent.putExtra("isPwd", "1");
                        startActivityForResult(intent, 112);
                    }else{
                        num_password = 0;
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
    Handler handler_register = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_register == 0){
                    num_register++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_register.sendMessageDelayed(message,250);
                }else if(num_register == 1){
                    if(rawX >= 80 && rawX <= 1370 && rawY >= 1480 && rawY <= 1680) {
                        num_register++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_register.sendMessageDelayed(message,250);
                    }else{
                        num_register = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 80 && rawX <= 1370 && rawY >= 1480 && rawY <= 1680) {
                        num_register = 0;
                        register();
                    }else{
                        num_register = 0;
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
