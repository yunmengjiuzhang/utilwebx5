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
        setX5Settings();
    }

    @SuppressLint("SetJavaScriptEnabled")
    public X5WebView(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        setX5Settings();
    }

    public void initData() {
    }

    public void setX5ChromeClient(X5WebChromeClient a) {
        this.setWebChromeClient(a);
    }

    public void setX5ViewClient(X5WebViewClient a) {
        this.setWebViewClient(a);
    }

    public void setX5DownLoadListenrer(X5DownLoadListener a) {
        this.setDownloadListener(a);
    }

    public void setX5JSI(X5JS var1, String jsobjectname) {
        this.addJavascriptInterface(var1, jsobjectname);
    }

    public void setX5Settings() {
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



        // 设置可以访问文件
        //禁止横屏滚动 网页自适配
        webSetting.setLoadWithOverviewMode(true);
//        // 设置可手动缩放 隐藏缩放工具
        webSetting.setDisplayZoomControls(false);
        webSetting.setDefaultTextEncodingName("UTF-8");//设置默认为utf-8
        webSetting.setSaveFormData(true);
        // enable navigator.geolocation
        webSetting.setDatabaseEnabled(true);
        // enable Web Storage: localStorage, sessionStorage
    }
}
