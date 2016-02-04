package com.grom.base;

import android.app.Activity;
import android.content.Intent;

import com.grom.main.MainActivity;

/**
 * Created by dengluxiao on 2/4/16.
 */
public class BaseActivity extends Activity{

    public void goMainActivity(){
        Intent intent = new Intent(BaseActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
