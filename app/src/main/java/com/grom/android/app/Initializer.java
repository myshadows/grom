package com.grom.android.app;

import android.support.annotation.WorkerThread;

import com.grom.android.module.AppModule;
import com.grom.android.module.Network;

import rx.Observable;
import rx.Subscriber;

public class Initializer implements Observable.OnSubscribe<AppComponent> {
    private final MyApplication mApplication;

    public Initializer(MyApplication application) {
        mApplication = application;
    }

    @Override
    @WorkerThread
    public void call(Subscriber<? super AppComponent> subscriber) {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(mApplication))
                .network(new Network(mApplication))
                .build();
        if (!subscriber.isUnsubscribed()) {
            subscriber.onNext(appComponent);
            subscriber.onCompleted();
        }
    }
}
