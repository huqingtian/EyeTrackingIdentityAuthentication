package com.hqt.eyetrackingidentityauthentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class MainActivity extends AppCompatActivity {
    ImageView img_message, img_contacts, img_focus, img_setting;
    TextView txt_message, txt_contacts, txt_focus, txt_setting;
    int color_chosed, color_unchosed;
    long exitTime;
    FragmentManager fm;
    MessageFragment messageFragment;
    ContactsFragment contactsFragment;
    FocusFragment focusFragment;
    SettingFragment settingFragment;
    private float rawX;
    private float rawY;
    boolean flag1 = true, flag4 = true, flag = true;
    int num_message, num_contacts, num_focus, num_setting, num_ind, num_cal,num_pic, num_dir, num_pwd, num_exit, num_ges, num_reset;
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper = new ETDBHelper(this);
    UsersTable user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_main);
        init();
        //创建广播
        InnerRecevier innerReceiver = new InnerRecevier();
        //动态注册广播
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        //启动广播
        registerReceiver(innerReceiver, intentFilter);
        showFragment(1);
        messageChosed();
    }
    private void messageChosed(){
        flag1 = true;
        flag4 = false;
        Message message = Message.obtain();
        message.what = 1;
        handler1.sendMessageDelayed(message,300);
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
        flag1 = false;
        flag4 = false;
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
        flag1 = false;
        flag4 = false;
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
        flag1 = false;
        flag4 = true;
        Message message = Message.obtain();
        message.what = 1;
        handler4.sendMessageDelayed(message,300);
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
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message,300);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 112) {
            if(resultCode == 112){
                Intent intent = new Intent(MainActivity.this, CalculationActivity.class);
                startActivityForResult(intent,112);
            }else{
                startHandler1();
            }
        }else if(requestCode == 113){
            if(resultCode == 112){
                Intent intent = new Intent(MainActivity.this, HumanCheckActivity.class);
                startActivityForResult(intent,113);
            }else{
                startHandler1();
            }
        }else if(requestCode == 111 || requestCode == 114 || requestCode == 115){
            startHandler1();
        }
        if (requestCode == 141) {
            rawX = 0;
            rawY = 0;
            flag4 = true;
            Message message = Message.obtain();
            message.what = 1;
            handler4.sendMessageDelayed(message,300);
        }
    }
    void startHandler1(){
        rawX = 0;
        rawY = 0;
        flag1 = true;
        Message message = Message.obtain();
        message.what = 1;
        handler1.sendMessageDelayed(message,300);
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
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rawX = ev.getRawX();
        rawY = ev.getRawY();
        return super.dispatchTouchEvent(ev);
    }
    @SuppressLint("HandlerLeak")
    Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag1){
                if(msg.what == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 460 && rawY <= 680){
                        flag1 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_ind.sendMessageDelayed(message,300);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 765 && rawY <= 950){
                        flag1 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_cal.sendMessageDelayed(message,300);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 1030 && rawY <= 1230){
                        flag1 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_pic.sendMessageDelayed(message,300);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 1310 && rawY <= 1520){
                        flag1 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_dir.sendMessageDelayed(message,300);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 1600 && rawY <= 1800){
                        flag1 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_ges.sendMessageDelayed(message,300);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler1.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler4 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag4){
                if(msg.what == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 800 && rawY <= 1000){
                        flag4 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_pwd.sendMessageDelayed(message,0);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 1300 && rawY <= 1520){
                        flag4 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset.sendMessageDelayed(message,0);
                    }else if(rawX >= 0 && rawX <= 1430 && rawY >= 1830 && rawY <= 2030){
                        flag4 = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_exit.sendMessageDelayed(message,0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler4.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag){
                if(msg.what == 1){
                    if(rawX >= 0 && rawX <= 330 && rawY >= 2230 && rawY <= 2380){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_message.sendMessageDelayed(message,0);
                    }else if(rawX >= 360 && rawX <= 720 && rawY >= 2230 && rawY <= 2380){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_contacts.sendMessageDelayed(message,0);
                    }else if(rawX >= 750 && rawX <= 1100 && rawY >= 2230 && rawY <= 2380){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_focus.sendMessageDelayed(message,0);
                    }else if(rawX >= 1140 && rawX <= 1430 && rawY >= 2230 && rawY <= 2380){
                        flag = false;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_setting.sendMessageDelayed(message,0);
                    }
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,300);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_message = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_message == 0){
                    num_message++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_message.sendMessageDelayed(message,250);
                }else if(num_message == 1){
                    if(rawX >= 0 && rawX <= 340 && rawY >= 2230 && rawY <= 2380) {
                        num_message++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_message.sendMessageDelayed(message,250);
                    }else{
                        num_message = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 340 && rawY >= 2230 && rawY <= 2380) {
                        showFragment(1);
                        messageChosed();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_message.sendMessageDelayed(message,300);
                    }else{
                        num_message = 0;
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
    Handler leave_handler_message = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 0 && rawX <= 340 && rawY >= 2230 && rawY <= 2380){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_message.sendMessageDelayed(message,300);
                }else{
                    num_message = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_contacts = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_contacts == 0){
                    num_contacts++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_contacts.sendMessageDelayed(message,250);
                }else if(num_contacts == 1){
                    if(rawX >= 360 && rawX <= 730 && rawY >= 2230 && rawY <= 2380) {
                        num_contacts++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_contacts.sendMessageDelayed(message,250);
                    }else{
                        num_contacts = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 360 && rawX <= 730 && rawY >= 2230 && rawY <= 2380) {
                        showFragment(2);
                        contactsChosed();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_contacts.sendMessageDelayed(message,300);
                    }else{
                        num_contacts = 0;
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
    Handler leave_handler_contacts = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 360 && rawX <= 730 && rawY >= 2230 && rawY <= 2380){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_contacts.sendMessageDelayed(message,300);
                }else{
                    num_contacts = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_focus = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_focus == 0){
                    num_focus++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_focus.sendMessageDelayed(message,250);
                }else if(num_focus == 1){
                    if(rawX >= 750 && rawX <= 1100 && rawY >= 2230 && rawY <= 2380) {
                        num_focus++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_focus.sendMessageDelayed(message,250);
                    }else{
                        num_focus = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 750 && rawX <= 1100 && rawY >= 2230 && rawY <= 2380) {
                        showFragment(3);
                        focusChosed();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_focus.sendMessageDelayed(message,300);
                    }else{
                        num_focus = 0;
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
    Handler leave_handler_focus = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 750 && rawX <= 1100 && rawY >= 2230 && rawY <= 2380){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_focus.sendMessageDelayed(message,300);
                }else{
                    num_focus = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_setting = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_setting == 0){
                    num_setting++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_setting.sendMessageDelayed(message,250);
                }else if(num_setting == 1){
                    if(rawX >= 1140 && rawX <= 1430 && rawY >= 2230 && rawY <= 2380) {
                        num_setting++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_setting.sendMessageDelayed(message,250);
                    }else{
                        num_setting = 0;
                        flag = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 1140 && rawX <= 1430 && rawY >= 2230 && rawY <= 2380) {
                        showFragment(4);
                        settingChosed();
                        Message message = Message.obtain();
                        message.what = 1;
                        leave_handler_setting.sendMessageDelayed(message,300);
                    }else{
                        num_setting = 0;
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
    Handler leave_handler_setting = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(rawX >= 1140 && rawX <= 1430 && rawY >= 2230 && rawY <= 2380){
                    Message message = Message.obtain();
                    message.what = 1;
                    leave_handler_setting.sendMessageDelayed(message,300);
                }else{
                    num_setting = 0;
                    flag = true;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessageDelayed(message,0);
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_ind = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_ind == 0){
                    num_ind++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_ind.sendMessageDelayed(message,250);
                }else if(num_ind == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 460 && rawY <= 680) {
                        num_ind++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_ind.sendMessageDelayed(message,250);
                    }else{
                        num_ind = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 460 && rawY <= 680) {
                        Intent intent = new Intent(MainActivity.this, IndependentPwdActivity.class);
                        startActivityForResult(intent,111);
                    }else{
                        num_ind = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_cal = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_cal == 0){
                    num_cal++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_cal.sendMessageDelayed(message,250);
                }else if(num_cal == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 765 && rawY <= 950) {
                        num_cal++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_cal.sendMessageDelayed(message,250);
                    }else{
                        num_cal = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 765 && rawY <= 950) {
                        Intent intent = new Intent(MainActivity.this, CalculationActivity.class);
                        startActivityForResult(intent,112);
                    }else{
                        num_cal = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
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
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1030 && rawY <= 1230) {
                        num_pic++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_pic.sendMessageDelayed(message,250);
                    }else{
                        num_pic = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1030 && rawY <= 1230) {
                        num_pic = 0;
                        Intent intent = new Intent(MainActivity.this, HumanCheckActivity.class);
                        startActivityForResult(intent,113);
                    }else{
                        num_pic = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_dir = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_dir == 0){
                    num_dir++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_dir.sendMessageDelayed(message,250);
                }else if(num_dir == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1310 && rawY <= 1520) {
                        num_dir++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_dir.sendMessageDelayed(message,250);
                    }else{
                        num_dir = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1310 && rawY <= 1520) {
                        num_dir = 0;
                        Intent intent = new Intent(MainActivity.this, DirectionPwdActivity.class);
                        startActivityForResult(intent,114);
                    }else{
                        num_dir = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_ges = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_ges == 0){
                    num_ges++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_ges.sendMessageDelayed(message,250);
                }else if(num_ges == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1600 && rawY <= 1800) {
                        num_ges++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_ges.sendMessageDelayed(message,250);
                    }else{
                        num_ges = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1600 && rawY <= 1800) {
                        num_ges = 0;
                        Intent intent = new Intent(MainActivity.this, GesturePwdActivity.class);
                        startActivityForResult(intent,114);
                    }else{
                        num_ges = 0;
                        flag1 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler1.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_pwd = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_pwd == 0){
                    num_pwd++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_pwd.sendMessageDelayed(message,250);
                }else if(num_pwd == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 800 && rawY <= 1000) {
                        num_pwd++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_pwd.sendMessageDelayed(message,250);
                    }else{
                        num_pwd = 0;
                        flag4 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 800 && rawY <= 1000) {
                        num_pwd = 0;
                        Intent intent = new Intent(MainActivity.this, ChangePwdActivity.class);
                        startActivityForResult(intent,141);
                    }else{
                        num_pwd = 0;
                        flag4 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_reset = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_reset == 0){
                    num_reset++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_reset.sendMessageDelayed(message,250);
                }else if(num_reset == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1300 && rawY <= 1520) {
                        num_reset++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_reset.sendMessageDelayed(message,250);
                    }else{
                        num_reset = 0;
                        flag4 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1300 && rawY <= 1520) {
                        num_reset = 0;
                        Intent intent = new Intent(MainActivity.this, ResetPwdActivity.class);
                        startActivityForResult(intent,141);
                    }else{
                        num_reset = 0;
                        flag4 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
    @SuppressLint("HandlerLeak")
    Handler handler_exit = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                if(num_exit == 0){
                    num_exit++;
                    Message message = Message.obtain();
                    message.what = 1;
                    handler_exit.sendMessageDelayed(message,250);
                }else if(num_exit == 1){
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1830 && rawY <= 2030) {
                        num_exit++;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler_exit.sendMessageDelayed(message,250);
                    }else{
                        num_exit = 0;
                        flag4 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,0);
                    }
                }else {
                    if(rawX >= 0 && rawX <= 1430 && rawY >= 1830 && rawY <= 2030) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        sqliteImplementer.changeUserLoginTag(user.username, "0");
                        startActivity(intent);
                        finish();
                    }else{
                        num_exit = 0;
                        flag4 = true;
                        Message message = Message.obtain();
                        message.what = 1;
                        handler4.sendMessageDelayed(message,0);
                    }
                }
            }
        }
    };
}

