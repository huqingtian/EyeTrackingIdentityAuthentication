package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import org.w3c.dom.Text;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    EditText edt_password;
    EditText edt_username;
    TextView txt_tip;
    Button btn_register;
    Drawable drawable;
    ColorStateList hintColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        edt_password = findViewById(R.id.edt_password);
        edt_username = findViewById(R.id.edt_username);
        btn_register = findViewById(R.id.btn_register);
        txt_tip = findViewById(R.id.txt_tip);
        drawable = edt_password.getBackground();
        hintColor = edt_password.getHintTextColors();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(edt_username.getText().toString())){
                    edt_username.setBackgroundResource(R.drawable.edt_shape);
                    edt_username.setHintTextColor(Color.parseColor("#FF0000"));
                }
                if("".equals(edt_password.getText().toString())){
                    edt_password.setBackgroundResource(R.drawable.edt_shape);
                    edt_password.setHintTextColor(Color.parseColor("#FF0000"));
                }else{
                    if(isLetterDigit(edt_password.getText().toString()) && edt_password.getText().toString().length() >= 8 && edt_password.getText().toString().length() <= 16){
                        String username = edt_username.getText().toString();
                        String password = edt_password.getText().toString();
                        UsersTable user = sqliteImplementer.getUser(username);
                        if(user.password == null) {
                            UsersTable table = new UsersTable(username, password);
                            table.ettag = "1";
                            sqliteImplementer.saveData(table);
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
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
            }
        });
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
}
