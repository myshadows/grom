package com.grom.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.WorkerThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@WorkerThread
public class AppModule {

    private final Application mApp;

    public AppModule(Application app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public Context context() {
        return mApp;
    }


}
