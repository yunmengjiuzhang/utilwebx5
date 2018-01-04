package wangfei.utilwebx5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

public class X5WebViewSample extends X5WebView {
    public X5WebViewSample(Context arg0) {
        super(arg0);
        initData();

    }

    @SuppressLint("SetJavaScriptEnabled")
    public X5WebViewSample(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        initData();
    }

    public void initData() {
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
}
