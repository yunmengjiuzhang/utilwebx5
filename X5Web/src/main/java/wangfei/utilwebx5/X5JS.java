package wangfei.utilwebx5;

import android.webkit.JavascriptInterface;

public class X5JS {

    protected X5WebView webView;

    public X5JS(X5WebView context) {
        webView = context;
    }

    @JavascriptInterface
    public void onX5ButtonClicked() {
        X5Utils.enableX5FullscreenFunc(webView);
    }

    @JavascriptInterface
    public void onCustomButtonClicked() {
        X5Utils.disableX5FullscreenFunc(webView);
    }

    @JavascriptInterface
    public void onLiteWndButtonClicked() {
        X5Utils.enableLiteWndFunc(webView);
    }

    @JavascriptInterface
    public void onPageVideoClicked() {
        X5Utils.enablePageVideoFunc(webView);
    }
}
