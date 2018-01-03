package wangfei.utilwebx5;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;

import wangfei.utilwebx5.MWebChromeClient;
import wangfei.utilwebx5.MWebViewJS;
import wangfei.utilwebx5.MX5WebView;
import wangfei.utilwebx5.MX5WebViewUtils;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.utils.TbsLog;

public abstract class BaseX5WebActivity extends Activity {

    protected ValueCallback<Uri> uploadFile;
    protected ValueCallback<Uri[]> uploadFiles;
    protected MX5WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        initView();
        mWebView = getmX5WebView();
        initData();
    }


    private void initData() {
        setWebChromeClient();
        addJavascriptInterface();
        start();
        setDownload();
    }

    private void setDownload() {
        mWebView.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String arg0, String arg1, String arg2,
                                        String arg3, long arg4) {
                TbsLog.d("BaseX5WebActivity", "url: " + arg0);
            }
        });
    }


    protected abstract void initView();

    protected abstract MX5WebView getmX5WebView();

    protected abstract void start();

    public void setWebChromeClient() {
        MWebChromeClient mWebChromeClient = new MWebChromeClient(this);

        mWebChromeClient.setFileChooseListener(new MWebChromeClient.FileChoooseListener() {
            @Override
            public void listener(ValueCallback<Uri[]> filePathCallback) {
                uploadFiles = filePathCallback;
            }
        });
        mWebView.setWebChromeClient(mWebChromeClient);
    }

    public void addJavascriptInterface() {
        mWebView.addJavascriptInterface(new MWebViewJS(mWebView) {

            @JavascriptInterface
            public void onX5ButtonClicked() {
                MX5WebViewUtils.enableX5FullscreenFunc(webView);
            }

            @JavascriptInterface
            public void onCustomButtonClicked() {
                MX5WebViewUtils.disableX5FullscreenFunc(webView);
            }

            @JavascriptInterface
            public void onLiteWndButtonClicked() {
                MX5WebViewUtils.enableLiteWndFunc(webView);
            }

            @JavascriptInterface
            public void onPageVideoClicked() {
                MX5WebViewUtils.enablePageVideoFunc(webView);
            }
        }, "Android");
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
