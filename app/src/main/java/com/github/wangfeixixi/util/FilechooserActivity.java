package com.github.wangfeixixi.util;


import wangfei.utilwebx5.BaseX5WebActivity;
import wangfei.utilwebx5.X5WebViewSample;

/**
 * 文件选择的时候，应该打开权限，todo现在是不可用的
 * webSetting.setAllowFileAccessFromFileURLs(false);
 * webSetting.setAllowUniversalAccessFromFileURLs(false);
 * 设置为true
 * <p>
 * 注意这个有应用克隆漏洞隐患，如果不用就不必打开
 */
public class FilechooserActivity extends BaseX5WebActivity {
    @Override
    protected X5WebViewSample getmX5WebView() {
        return (X5WebViewSample) findViewById(R.id.activity_filechooser);
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
