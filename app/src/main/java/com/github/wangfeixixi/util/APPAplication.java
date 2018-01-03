package com.github.wangfeixixi.util;

import android.app.Application;

import wangfei.utilwebx5.CrashHandler;
import wangfei.utilwebx5.MX5WebViewUtils;

public class APPAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this, "aaaaaaaaaaaaaaaaaaaaaa");
        MX5WebViewUtils.init(this);
    }

}
