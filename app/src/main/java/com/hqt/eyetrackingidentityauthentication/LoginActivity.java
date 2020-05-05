package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText edt_password;
    EditText edt_username;
    TextView txt_register;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView img_login = findViewById(R.id.img_login);
        edt_password = findViewById(R.id.edt_password);
        edt_username = findViewById(R.id.edt_username);
        txt_register = findViewById(R.id.txt_register);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        if(user != null){
            if(user.logined.equals("1")){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                Intent intent2 = new Intent(LoginActivity.this, EyeTrackActivity.class);
                startActivity(intent2);
                finish();
            }
        }
        img_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                UsersTable table = sqliteImplementer.getUser(username);
                if(!"".equals(table.password)) {
                    if (password.equals(table.password)) {
                        sqliteImplementer.changeUserLoginTag(username, "1");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        Intent intent2 = new Intent(LoginActivity.this, EyeTrackActivity.class);
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                edt_password.setText("");
            }
        });
    }
}
