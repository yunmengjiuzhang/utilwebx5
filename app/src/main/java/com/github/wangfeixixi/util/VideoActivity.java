package com.github.wangfeixixi.util;

import android.view.View;

import com.tencent.smtt.sdk.TbsVideo;

import wangfei.utilwebx5.BaseX5WebActivity;
import wangfei.utilwebx5.X5Utils;
import wangfei.utilwebx5.X5WebViewSample;

public class VideoActivity extends BaseX5WebActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_video);
//        findViewById(R.id.testButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                X5Utils.enableX5FullscreenFunc(mWebView);
//            }
//        });
//        findViewById(R.id.testButton1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                X5Utils.disableX5FullscreenFunc(mWebView);
//            }
//        });
//        findViewById(R.id.testButton2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                X5Utils.enableLiteWndFunc(mWebView);
//            }
//        });
//        findViewById(R.id.testButton3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                X5Utils.enablePageVideoFunc(mWebView);
//            }
//        });
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
