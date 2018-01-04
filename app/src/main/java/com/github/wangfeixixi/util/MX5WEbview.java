package com.github.wangfeixixi.util;

import android.content.Context;
import android.util.AttributeSet;

import wangfei.utilwebx5.X5DownLoadListener;
import wangfei.utilwebx5.X5JS;
import wangfei.utilwebx5.X5WebChromeClient;
import wangfei.utilwebx5.X5WebView;
import wangfei.utilwebx5.X5WebViewClient;


public class MX5WEbview extends X5WebView {
    public MX5WEbview(Context arg0) {
        super(arg0);
    }

    public MX5WEbview(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
    }

    @Override
    public String getX5JSName() {
        return super.getX5JSName();
    }

    @Override
    public X5WebViewClient getmX5WebViewClient() {
        return super.getmX5WebViewClient();
    }

    @Override
    public X5DownLoadListener getmX5DownLoadListener() {
        return super.getmX5DownLoadListener();
    }

    @Override
    public X5JS getX5JS() {
        return super.getX5JS();
    }

    @Override
    public X5WebChromeClient getmX5WebChromeClient() {
        return super.getmX5WebChromeClient();
    }
}
