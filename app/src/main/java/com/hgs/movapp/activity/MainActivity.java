package com.hgs.movapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hgs.movapp.R;
import com.hgs.movapp.base.BaseActivity;
import com.hgs.movapp.fragment.MainFragment;

public class MainActivity  extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addFragment(R.id.container_main, new MainFragment());
        }
    }


}
