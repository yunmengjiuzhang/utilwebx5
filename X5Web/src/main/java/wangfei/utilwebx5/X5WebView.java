package wangfei.utilwebx5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;

public class X5WebView extends WebView {
    public X5WebView(Context arg0) {
        super(arg0);
        initData();

    }

    @SuppressLint("SetJavaScriptEnabled")
    public X5WebView(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        initData();
    }

    public void initData() {
        initWebViewSettings();
        this.setWebChromeClient(getmX5WebChromeClient());
        this.setWebViewClient(getmX5WebViewClient());
        this.addJavascriptInterface(getX5JS(), getX5JSName());
        this.setDownloadListener(getmX5DownLoadListener());
    }

    public String getX5JSName() {
        return "Android";
    }

    public X5JS getX5JS() {
        return new X5JS(this);
    }

    public X5DownLoadListener getmX5DownLoadListener() {
        return new X5DownLoadListener();
    }

    public X5WebViewClient getmX5WebViewClient() {
        return new X5WebViewClient();
    }

    public X5WebChromeClient getmX5WebChromeClient() {
        return null;
    }

    public void initWebViewSettings() {
        WebSettings webSetting = this.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(false);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(true);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);

        // this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
        // settings 的设计
    }
}
