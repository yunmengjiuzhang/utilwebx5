package com.github.wangfeixixi.util;

import android.app.Application;

import wangfei.utilwebx5.X5Utils;

public class APPAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this, "aaaaaaaaaaaaaaaaaaaaaa");
        X5Utils.init(this);
    }

}
