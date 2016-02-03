package com.ainemo.android.activity;

import com.ainemo.android.R;
import com.ainemo.android.app.MyApplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends Activity {
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
}
