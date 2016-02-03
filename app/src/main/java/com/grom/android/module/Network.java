package com.grom.android.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.Subscriber;

@Module
public class Network extends BroadcastReceiver implements Observable.OnSubscribe<NetworkInfo>{

    private final Observable<NetworkInfo> mObservable;
    private Subscriber<? super NetworkInfo> mSubscriber;

    public Network(Context context) {
        context.registerReceiver(this, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        mObservable = Observable.create(this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (!mSubscriber.isUnsubscribed()) {
            mSubscriber.onNext(info);
        }
    }

    @Override
    public void call(Subscriber<? super NetworkInfo> subscriber) {
        mSubscriber = subscriber;
    }

    @Provides
    @Singleton
    public Observable<String> getStatus() {
        return mObservable.map(info -> info == null ? "no network" : "has Network");
    }
}
