package com.hqt.eyetrackingidentityauthentication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class ChangePwdActivity extends AppCompatActivity {
    ImageView img_changereturn;
    ImageView img_openET;
    FrameLayout fl_changeloginpwd;
    FrameLayout fl_changeetpwd;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    String tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        img_changereturn = findViewById(R.id.img_changereturn);
        img_openET = findViewById(R.id.img_openET);
        fl_changeloginpwd = findViewById(R.id.fl_changeloginpwd);
        fl_changeetpwd = findViewById(R.id.fl_changeetpwd);
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        tag = user.ettag;
        if (!"1".equals(tag)) {
            img_openET.setImageResource(R.drawable.img_btnclose);
        }else{
            img_openET.setImageResource(R.drawable.img_btnopen);
        }
        img_changereturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_openET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("1".equals(tag)){
                    Intent intent = new Intent(ChangePwdActivity.this, ComfirmEtActivity.class);
                    startActivityForResult(intent,0x111);
                }else{
                    img_openET.setImageResource(R.drawable.img_btnopen);
                    sqliteImplementer.changeEtTag(user.username, "1");
                    tag = "1";
                }
            }
        });
        fl_changeloginpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePwdActivity.this, ChangeLoginPwdActivity.class);
                startActivity(intent);
            }
        });
        fl_changeetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePwdActivity.this, ChangeEtPwdActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0x111 && resultCode == 0x111){
            img_openET.setImageResource(R.drawable.img_btnclose);
            sqliteImplementer.changeEtTag(user.username, "0");
            tag = "0";
        }
    }
}
