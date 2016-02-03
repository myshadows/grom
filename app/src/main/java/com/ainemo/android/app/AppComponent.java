package com.ainemo.android.app;

import com.ainemo.android.activity.MainActivity;
import com.ainemo.android.module.AppModule;
import com.ainemo.android.module.Network;

import dagger.Component;

/**
 * Created by tonywang on 1/8/16.
 */
@Component(modules = {AppModule.class, Network.class})
public interface AppComponent {
    void injectMainActivity(MainActivity activity);
}
