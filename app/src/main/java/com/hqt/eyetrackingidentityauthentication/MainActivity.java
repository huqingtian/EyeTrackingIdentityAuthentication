package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img_message;
    ImageView img_contacts;
    ImageView img_focus;
    ImageView img_setting;
    TextView txt_message;
    TextView txt_contacts;
    TextView txt_focus;
    TextView txt_setting;
    int color_chosed;
    int color_unchosed;
    long exitTime;
    FragmentManager fm;
    MessageFragment messageFragment;
    ContactsFragment contactsFragment;
    FocusFragment focusFragment;
    SettingFragment settingFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_main);
        init();
        showFragment(1);
        //创建广播
        InnerRecevier innerReceiver = new InnerRecevier();
        //动态注册广播
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        //启动广播
        registerReceiver(innerReceiver, intentFilter);
    }
    View.OnClickListener onClickListener_Tab = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_message:
                    showFragment(1);
                    messageChosed();
                    break;
                case R.id.ll_contacts:
                    showFragment(2);
                    contactsChosed();
                    break;
                case R.id.ll_focus:
                    showFragment(3);
                    focusChosed();
                    break;
                case R.id.ll_setting:
                    showFragment(4);
                    settingChosed();
                    break;
                default:
                    break;
            }
        }
    };
    private void messageChosed(){
        img_message.setImageResource(R.drawable.img_messagechosed);
        txt_message.setTextColor(color_chosed);
        img_contacts.setImageResource(R.drawable.img_contacts);
        txt_contacts.setTextColor(color_unchosed);
        img_focus.setImageResource(R.drawable.img_focus);
        txt_focus.setTextColor(color_unchosed);
        img_setting.setImageResource(R.drawable.img_setting);
        txt_setting.setTextColor(color_unchosed);
    }
    private void contactsChosed(){
        img_message.setImageResource(R.drawable.img_message);
        txt_message.setTextColor(color_unchosed);
        img_contacts.setImageResource(R.drawable.img_contactschosed);
        txt_contacts.setTextColor(color_chosed);
        img_focus.setImageResource(R.drawable.img_focus);
        txt_focus.setTextColor(color_unchosed);
        img_setting.setImageResource(R.drawable.img_setting);
        txt_setting.setTextColor(color_unchosed);
    }
    private void focusChosed(){
        img_message.setImageResource(R.drawable.img_message);
        txt_message.setTextColor(color_unchosed);
        img_contacts.setImageResource(R.drawable.img_contacts);
        txt_contacts.setTextColor(color_unchosed);
        img_focus.setImageResource(R.drawable.img_focuschosed);
        txt_focus.setTextColor(color_chosed);
        img_setting.setImageResource(R.drawable.img_setting);
        txt_setting.setTextColor(color_unchosed);
    }
    private void settingChosed(){
        img_message.setImageResource(R.drawable.img_message);
        txt_message.setTextColor(color_unchosed);
        img_contacts.setImageResource(R.drawable.img_contacts);
        txt_contacts.setTextColor(color_unchosed);
        img_focus.setImageResource(R.drawable.img_focus);
        txt_focus.setTextColor(color_unchosed);
        img_setting.setImageResource(R.drawable.img_settingchosed);
        txt_setting.setTextColor(color_chosed);
    }
    public void showFragment(int index) {
        FragmentTransaction ft = fm.beginTransaction();
        // 想要显示一个fragment,先隐藏所有fragment，防止重叠
        hideFragments(ft);
        switch (index) {
            case 1:
                // 如果fragment1已经存在则将其显示出来
                if (messageFragment != null)
                    ft.show(messageFragment);
                    // 否则是第一次切换则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add
                else {
                    messageFragment = new MessageFragment();
                    ft.add(R.id.fragment, messageFragment);
                }
                break;
            case 2:
                if (contactsFragment != null)
                    ft.show(contactsFragment);
                else {
                    contactsFragment = new ContactsFragment();
                    ft.add(R.id.fragment, contactsFragment);
                }
                break;
            case 3:
                if (focusFragment != null)
                    ft.show(focusFragment);
                else {
                    focusFragment = new FocusFragment();
                    ft.add(R.id.fragment, focusFragment);
                }
                break;
            case 4:
                if (settingFragment != null)
                    ft.show(settingFragment);
                else {
                    settingFragment = new SettingFragment();
                    ft.add(R.id.fragment, settingFragment);
                }
                break;
        }
        ft.commit();
    }
    // 当fragment已被实例化，就隐藏起来
    public void hideFragments(FragmentTransaction ft) {
        if (messageFragment != null)
            ft.hide(messageFragment);
        if (contactsFragment != null)
            ft.hide(contactsFragment);
        if (focusFragment != null)
            ft.hide(focusFragment);
        if (settingFragment != null)
            ft.hide(settingFragment);
    }
    void init(){
        LinearLayout ll_message = findViewById(R.id.ll_message);
        LinearLayout ll_contacts = findViewById(R.id.ll_contacts);
        LinearLayout ll_focus = findViewById(R.id.ll_focus);
        LinearLayout ll_setting = findViewById(R.id.ll_setting);
        ll_message.setOnClickListener(onClickListener_Tab);
        ll_contacts.setOnClickListener(onClickListener_Tab);
        ll_focus.setOnClickListener(onClickListener_Tab);
        ll_setting.setOnClickListener(onClickListener_Tab);
        img_message = findViewById(R.id.img_message);
        img_contacts = findViewById(R.id.img_contacts);
        img_focus = findViewById(R.id.img_focus);
        img_setting = findViewById(R.id.img_setting);
        txt_message = findViewById(R.id.txt_message);
        txt_contacts = findViewById(R.id.txt_contacts);
        txt_focus = findViewById(R.id.txt_focus);
        txt_setting = findViewById(R.id.txt_setting);
        color_chosed = txt_message.getCurrentTextColor();
        color_unchosed = txt_contacts.getCurrentTextColor();
        fm = getSupportFragmentManager();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if((System.currentTimeMillis() - exitTime) > 2000){
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                Intent in = new Intent(MainActivity.this, EyeTrackActivity.class);
                startActivity(in);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
            return true;
        }
        if (KeyEvent.KEYCODE_HOME == keyCode) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    class InnerRecevier extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (reason != null) {
                    if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                        Intent in = new Intent(MainActivity.this, EyeTrackActivity.class);
                        startActivity(in);
                    }
                }
            }
        }
    }
}

