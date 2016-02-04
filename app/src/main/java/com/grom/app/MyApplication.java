package com.grom.app;

import android.app.Application;
import android.content.Context;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MyApplication extends Application {

    private Observable<AppComponent> mInitializer;

    public static Observable<AppComponent> initializer(Context ctx) {
        return ((MyApplication) ctx.getApplicationContext()).mInitializer;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInitializer = Observable.create(new Initializer(this)).subscribeOn(Schedulers.computation());
    }
}
