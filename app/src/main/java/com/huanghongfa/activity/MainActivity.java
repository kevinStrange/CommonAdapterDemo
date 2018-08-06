package com.huanghongfa.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.huanghongfa.adapter.UserAdapter;
import com.huanghongfa.manage.UserDataManage;
import com.huanghongfa.util.ImageLoaderUtil;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;//list列表
    private UserAdapter mUserAdapter;//用户适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageLoaderUtil.initialize(this);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.lvListView);
        mUserAdapter = new UserAdapter(this, UserDataManage.getInstance().getUserData());
        mListView.setAdapter(mUserAdapter);
    }


}
