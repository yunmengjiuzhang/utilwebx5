package com.github.wangfeixixi.util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wangfei.utilwebx5.X5WebView;

public class Main3Activity extends Main2Activity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected X5WebView getmX5WebView() {
        return findViewById(R.id.x5webview);
    }

    @Override
    protected void start() {
        mWebView.loadUrl("http://blog.csdn.net/qq_36017059/article/details/78061063");
    }
}
