package com.github.wangfeixixi.util;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.github.wangfeixixi.util.view.HorizontalProgressBarWithNumber;
import com.tencent.smtt.sdk.WebView;

import wangfei.util.common.ThreadUtils;
import wangfei.util.fragmentation.BaseFragment;
import wangfei.util.fragmentation.BaseFragmentVH;
import wangfei.utilwebx5.X5WebChromeClient;
import wangfei.utilwebx5.X5WebView;
import wangfei.utilwebx5.X5WebViewClient;

public class WebFVH extends BaseFragmentVH {
    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableField<Boolean> isWebRefresh = new ObservableField<>(false);
    public final ObservableField<Integer> pbNumber = new ObservableField<>(0);
    public final ObservableField<X5WebView> webview = new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>("详情");
    public final ObservableField<Boolean> isRefresh = new ObservableField<>(false);

    public WebFVH(BaseFragment ctx) {
        super(ctx);
    }

    public void onRefresh() {
        isRefresh.set(true);
        isWebRefresh.set(true);
        ThreadUtils.runOnUiThreadDelayed(new Runnable() {
            @Override
            public void run() {
                isRefresh.set(false);
            }
        }, 2000);
    }

    @BindingAdapter({"app:setWebProgressBar"})
    public static void setProgressBar(final HorizontalProgressBarWithNumber pb, final Integer pbNumber) {
        if (pbNumber != null) {
            if (pbNumber <= 0 || pbNumber >= 100) {
                pb.setVisibility(View.GONE);
            } else {
                pb.setVisibility(View.VISIBLE);
                pb.setProgress(pbNumber);
            }
        }
    }

    @BindingAdapter({"app:initLoadUrl"})
    public static void initLoadUrl(final X5WebView webView, final String url) {
        if (url != null) {
            webView.loadUrlByCookie(webView.getContext(), url, null);
        }
    }

    @BindingAdapter({"app:isWebRefresh"})
    public static void isWebRefresh(final X5WebView webView, final Boolean webVH) {
        if (webVH != null) {
            webView.reload();
        }
    }

    @BindingAdapter({"app:initWebViewClient"})
    public static void initWebViewClient(final X5WebView webView, final WebFVH webVH) {
        if (webVH != null) {
            webView.setX5ViewClient(new X5WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    webVH.isRefresh.set(false);
                }
            });
        }
    }

    @BindingAdapter({"app:initWebChromeClient"})
    public static void initWebChromeClient(final X5WebView webView, final WebFVH webVH) {
        if (webVH != null) {
            webView.setX5ChromeClient(new X5WebChromeClient(webVH.mCtx.getActivity()) {
                @Override
                public void onReceivedTitle(WebView webView, String title) {
                    if (title == null)
                        webVH.title.set(title);//获取网站标题
                }

                @Override
                public void onProgressChanged(WebView webView, int newProgress) {
                    webVH.pbNumber.set(newProgress);//获取加载进度
                    if (newProgress >= 100)
                        webVH.isRefresh.set(false);
                }
            });
        }
    }

    //webview滑动冲突
    @BindingAdapter({"app:initswipeRefreshLayout", "app:initx5Webview"})
    public static void refreshAndWebView(final SwipeRefreshLayout swipeRefreshLayout, final WebFVH baseTestVH, final X5WebView webView) {
        if (baseTestVH != null && webView != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    baseTestVH.onRefresh();
                    swipeRefreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            swipeRefreshLayout.setRefreshing(false);
                            baseTestVH.isRefresh.set(false);
                        }
                    }, 2000);
                }
            });
            // 设置子视图是否允许滚动到顶部
            swipeRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
                @Override
                public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
                    return webView.getWebScrollY() > 0;
                }
            });
        }
    }
}
