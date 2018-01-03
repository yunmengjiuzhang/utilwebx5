package wangfei.utilwebx5;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class MWebChromeClient extends WebChromeClient {

    protected Activity mCtx;

    public MWebChromeClient(Activity a) {
        mCtx = a;
    }


    @Override
    public boolean onJsConfirm(WebView arg0, String arg1, String arg2,
                               JsResult arg3) {
        return super.onJsConfirm(arg0, arg1, arg2, arg3);
    }

    View myVideoView;
    View myNormalView;
    IX5WebChromeClient.CustomViewCallback callback;

    // /////////////////////////////////////////////////////////
    //

    /**
     * 全屏播放配置
     */
//    @Override
//    public void onShowCustomView(View view,
//                                 IX5WebChromeClient.CustomViewCallback customViewCallback) {
//        FrameLayout normalView = (FrameLayout) view.findViewById(R.id.activity_filechooser);//todo
//        ViewGroup viewGroup = (ViewGroup) normalView.getParent();
//        viewGroup.removeView(normalView);
//        viewGroup.addView(view);
//        myVideoView = view;
//        myNormalView = normalView;
//        callback = customViewCallback;
//    }

    @Override
    public void onHideCustomView() {
        if (callback != null) {
            callback.onCustomViewHidden();
            callback = null;
        }
        if (myVideoView != null) {
            ViewGroup viewGroup = (ViewGroup) myVideoView.getParent();
            viewGroup.removeView(myVideoView);
            viewGroup.addView(myNormalView);
        }
    }

    @Override
    public boolean onJsAlert(WebView arg0, String arg1, String arg2,
                             JsResult arg3) {
        /**
         * 这里写入你自定义的window alert
         */
        return super.onJsAlert(null, arg1, arg2, arg3);
    }

//    // For Android 3.0+
//    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
//        Log.i("test", "openFileChooser 1");
////        webView.getContext().uploadFile = uploadFile;
//        MX5WebViewUtils.openFileChooseProcess(mCtx);
//    }
//
//    // For Android < 3.0
//    public void openFileChooser(ValueCallback<Uri> uploadMsgs) {
//        Log.i("test", "openFileChooser 2");
////        FilechooserActivity.this.uploadFile = uploadFile;
//        MX5WebViewUtils.openFileChooseProcess(mCtx);
//    }
//
//    // For Android  > 4.1.1
//    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
//        Log.i("test", "openFileChooser 3");
////        FilechooserActivity.this.uploadFile = uploadFile;
//        MX5WebViewUtils.openFileChooseProcess(mCtx);
//    }

    // For Android  >= 5.0
    public boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView,
                                     ValueCallback<Uri[]> filePathCallback,
                                     WebChromeClient.FileChooserParams fileChooserParams) {
        Log.i("MWebChromeClient", "openFileChooser 4:");

        if (fileChoooseListener != null)
            fileChoooseListener.listener(filePathCallback);
        MX5WebViewUtils.openFileChooseProcess(mCtx);
        return true;
    }

    public FileChoooseListener fileChoooseListener;

    public void setFileChooseListener(FileChoooseListener f) {
        fileChoooseListener = f;
    }

    public interface FileChoooseListener {
        void listener(ValueCallback<Uri[]> filePathCallback);
    }
}
