package com.hqt.eyetrackingidentityauthentication;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class SettingFragment extends Fragment {
    SqliteImplementer sqliteImplementer;
    ETDBHelper etdbHelper;
    UsersTable user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        etdbHelper = new ETDBHelper(getActivity().getApplicationContext());
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
    }
}
