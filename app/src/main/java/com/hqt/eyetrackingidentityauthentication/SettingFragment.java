package com.hqt.eyetrackingidentityauthentication;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hqt.eyetrackingidentityauthentication.sqlite.ETDBHelper;
import com.hqt.eyetrackingidentityauthentication.sqlite.SqliteImplementer;
import com.hqt.eyetrackingidentityauthentication.sqlite.UsersTable;

public class SettingFragment extends Fragment {
    FrameLayout fl_exit;
    FrameLayout fl_changepwd;
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
        fl_exit = getView().findViewById(R.id.fl_exit);
        fl_changepwd = getView().findViewById(R.id.fl_changepwd);
        etdbHelper = new ETDBHelper(getActivity().getApplicationContext());
        sqliteImplementer = new SqliteImplementer(etdbHelper);
        user = sqliteImplementer.getLoginedUser();
        fl_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                sqliteImplementer.changeUserLoginTag(user.username, "0");
                startActivity(intent);
                getActivity().finish();
            }
        });
        fl_changepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), ChangePwdActivity.class);
                startActivity(intent);
            }
        });
    }
}
