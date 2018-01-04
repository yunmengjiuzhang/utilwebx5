package com.github.wangfeixixi.util;

import wangfei.utilwebx5.BaseX5WebActivity;
import wangfei.utilwebx5.X5WebViewSample;

public class FullScreenActivity extends BaseX5WebActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_other);
    }

    @Override
    protected X5WebViewSample getmX5WebView() {
        return (X5WebViewSample) findViewById(R.id.activity_filechooser);
    }

    @Override
    protected void start() {
        mWebView.loadUrl("file:///android_asset/webpage/fullscreenVideo.html");
    }
}
