package com.github.wangfeixixi.util;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebViewClient;

import wangfei.utilwebx5.X5DownLoadListener;
import wangfei.utilwebx5.X5JS;
import wangfei.utilwebx5.X5WebChromeClient;
import wangfei.utilwebx5.X5WebView;
import wangfei.utilwebx5.X5WebViewClient;

public abstract class Main2Activity extends AppCompatActivity {
    protected ValueCallback<Uri> uploadFile;
    protected ValueCallback<Uri[]> uploadFiles;
    protected X5WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        initView();
        mWebView = getmX5WebView();
        initData();
    }


    private void initData() {
        mWebView.setWebChromeClient(getmX5WebChromeClient());
        mWebView.setWebViewClient(getmX5WebViewClient());
        mWebView.addJavascriptInterface(getX5JS(), getX5JSName());
        mWebView.setDownloadListener(getmX5DownLoadListener());
        start();
    }

    private String getX5JSName() {
        return "Android";
    }

    private X5JS getX5JS() {
        return new X5JS(mWebView);
    }

    public X5DownLoadListener getmX5DownLoadListener() {
        return new X5DownLoadListener();
    }

    protected abstract void initView();

    protected abstract X5WebView getmX5WebView();

    protected abstract void start();

    public WebViewClient getmX5WebViewClient() {
        return new X5WebViewClient();
    }

    public WebChromeClient getmX5WebChromeClient() {
        X5WebChromeClient mWebChromeClient = new X5WebChromeClient(this);

        mWebChromeClient.setFileChooseListener(new X5WebChromeClient.FileChoooseListener() {
            @Override
            public void listener(ValueCallback<Uri[]> filePathCallback) {
                uploadFiles = filePathCallback;
            }
        });
        return mWebChromeClient;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        try {
            super.onConfigurationChanged(newConfig);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView != null && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            } else
                return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0:
                    if (null != uploadFile) {
                        Uri result = data == null || resultCode != RESULT_OK ? null
                                : data.getData();
                        uploadFile.onReceiveValue(result);
                        uploadFile = null;
                    }
                    if (null != uploadFiles) {
                        Uri result = data == null || resultCode != RESULT_OK ? null
                                : data.getData();
                        uploadFiles.onReceiveValue(new Uri[]{result});
                        uploadFiles = null;
                    }
                    break;
                default:
                    break;
            }
        } else if (resultCode == RESULT_CANCELED) {
            if (null != uploadFile) {
                uploadFile.onReceiveValue(null);
                uploadFile = null;
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent == null || mWebView == null || intent.getData() == null)
            return;
        mWebView.loadUrl(intent.getData().toString());
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null)
            mWebView.destroy();
        super.onDestroy();
    }
}
