package com.grom.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.grom.R;
import com.grom.app.MyApplication;
import com.grom.base.BaseActivity;
import com.grom.web.WebActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Inject
    Observable<String> mStatusObsv;

    @Bind(R.id.text)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.initializer(getApplicationContext())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(app -> {
                    app.injectMainActivity(this);

                    mStatusObsv.subscribe(s -> {
                        mTextView.append(s);
                        mTextView.append("\n");
                    });
                });

        ButterKnife.bind(this);
    }

    @OnClick(R.id.text)
    public void goWebActivity(){
        Intent intent = new Intent(MainActivity.this, WebActivity.class);
        startActivity(intent);
    }
}
