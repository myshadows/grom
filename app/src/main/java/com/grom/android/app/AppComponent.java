package com.grom.android.app;

import com.grom.android.activity.MainActivity;
import com.grom.android.module.AppModule;
import com.grom.android.module.Network;

import dagger.Component;

/**
 * Created by tonywang on 1/8/16.
 */
@Component(modules = {AppModule.class, Network.class})
public interface AppComponent {
    void injectMainActivity(MainActivity activity);
}
