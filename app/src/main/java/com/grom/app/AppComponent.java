package com.grom.app;

import com.grom.main.MainActivity;
import com.grom.module.AppModule;
import com.grom.module.Network;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AppModule.class, Network.class}
)
public interface AppComponent {
    void injectMainActivity(MainActivity activity);
}
