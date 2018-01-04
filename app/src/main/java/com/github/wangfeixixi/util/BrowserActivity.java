package com.github.wangfeixixi.util;

import android.widget.FrameLayout;

import wangfei.utilwebx5.BaseX5WebActivity;
import wangfei.utilwebx5.X5WebViewSample;

public class BrowserActivity extends BaseX5WebActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_browser);
    }

    @Override
    protected X5WebViewSample getmX5WebView() {
        mWebView = new X5WebViewSample(this);
        FrameLayout mViewParent = (FrameLayout) findViewById(R.id.framelayout);
        mViewParent.removeAllViews();
        mViewParent.addView(mWebView, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.FILL_PARENT,
                FrameLayout.LayoutParams.FILL_PARENT));
        return mWebView;
    }

    @Override
    protected void start() {

        mWebView.loadUrl("http://app.html5.qq.com/navi/index");
    }
}
