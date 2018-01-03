package com.github.wangfeixixi.util;


import wangfei.utilwebx5.BaseX5WebActivity;
import wangfei.utilwebx5.X5WebView;

public class FilechooserActivity extends BaseX5WebActivity {
    @Override
    protected X5WebView getmX5WebView() {
        return (X5WebView) findViewById(R.id.activity_filechooser);
    }

    @Override
    protected void start() {
        mWebView.loadUrl("file:///android_asset/webpage/fileChooser.html");
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_other);
    }

}
