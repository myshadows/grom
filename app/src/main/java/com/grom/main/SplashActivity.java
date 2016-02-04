package com.grom.main;

import android.os.Bundle;
import android.os.Handler;

import com.grom.R;
import com.grom.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goMainActivity();
                finish();
            }
        }, 2000);
    }
}
