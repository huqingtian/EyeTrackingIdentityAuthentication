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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

import org.w3c.dom.Text;

public class ChangeLoginPwdActivity extends AppCompatActivity {
    ImageView img_loginpwdreturn;
    ImageView img_showpwd;
    EditText edt_oldpwd;
    EditText edt_newpwd;
    TextView txt_tip;
    Button btn_changeloginpwd;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    boolean showTag = true;
    Drawable drawable;
    ColorStateList hintColor;
    UsersTable user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_login_pwd);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        img_loginpwdreturn = findViewById(R.id.img_loginpwdreturn);
        txt_tip = findViewById(R.id.txt_change_tip);
        img_showpwd = findViewById(R.id.img_showpwd);
        edt_oldpwd = findViewById(R.id.edt_oldpwd);
        edt_newpwd = findViewById(R.id.edt_newpwd);
        drawable = edt_newpwd.getBackground();
        hintColor = edt_newpwd.getHintTextColors();
        btn_changeloginpwd = findViewById(R.id.btn_changeloginpwd);
        img_loginpwdreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_showpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        btn_changeloginpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(edt_oldpwd.getText().toString())){
                    edt_oldpwd.setBackgroundResource(R.drawable.edt_shape);
                    edt_oldpwd.setHintTextColor(Color.parseColor("#FF0000"));
                }
                if("".equals(edt_newpwd.getText().toString())){
                    edt_newpwd.setBackgroundResource(R.drawable.edt_shape);
                    edt_newpwd.setHintTextColor(Color.parseColor("#FF0000"));
                }else{
                    if(isLetterDigit(edt_newpwd.getText().toString()) && edt_newpwd.getText().toString().length() >= 8 && edt_newpwd.getText().toString().length() <= 16){
                        if(user.password.equals(edt_oldpwd.getText().toString())){
                            String password = edt_newpwd.getText().toString();
                            sqliteImplementer.changeLoginPwd(user.username, password);
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
        });
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
