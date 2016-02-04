package com.grom.web;

import android.content.Context;
import android.content.Intent;

import org.json.JSONObject;

/**
 * Created by dengluxiao on 2/4/16.
 */
public interface JsHost {
    
    int configDomainPermission(String paramString);

    void finish();

    void ga();

    Context getContext();

    int getDefaultBackIcon();

    int getDefaultCloseIcon();

    int getDefaultCustomBackIcon();

    int getDefaultSearchIcon();

    int getDefaultShareIcon();

    int getDomainPermission();

//    JsHandler getJsHandler(String paramString);

//    ITitleBar getTitleBarHost();

    boolean isOnScroll();

    void loadJs(String paramString);

    void loadUrl(String paramString);

    void post(Runnable paramRunnable);

    void publish(String paramString);

    void publish(JSONObject paramJSONObject);

//    void putJsHandler(JsHandler paramJsHandler);

//    void replaceTitleBar(BaseTitleBar paramBaseTitleBar);

    String requestId();

    void resetJsHandler();

    void setBackgroundColor(int paramInt);

    void setOnScroll(boolean paramBoolean);

    void startActivity(Intent paramIntent);

    void startActivityForResult(Intent paramIntent, int paramInt);

//    void subscribe(String paramString, JsHandler paramJsHandler);

    void unsubscribe(String paramString);
}
