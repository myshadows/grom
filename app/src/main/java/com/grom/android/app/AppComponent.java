package com.grom.android.app;

import com.grom.android.activity.MainActivity;
import com.grom.android.module.AppModule;
import com.grom.android.module.Network;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AppModule.class, Network.class}
)
public interface AppComponent {
    void injectMainActivity(MainActivity activity);
}
