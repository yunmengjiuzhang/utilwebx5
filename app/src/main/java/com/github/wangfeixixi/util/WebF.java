package com.github.wangfeixixi.util;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.wangfeixixi.util.databinding.FWebBinding;

import wangfei.util.fragmentation.BaseFragment;
import wangfei.utilwebx5.X5WebView;


public class WebF extends BaseFragment {

    private WebFVH webFVH;
    private X5WebView mWebView;

    @Override
    protected View getOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FWebBinding inflate = DataBindingUtil.inflate(inflater, R.layout.f_web, container, false);

        webFVH = new WebFVH(this);
        inflate.setWebFVH(webFVH);

        mWebView = inflate.fffffwebview;

        Bundle args = getArguments();
        if (args != null) {
            webFVH.url.set(args.getString("url"));
        }


        webFVH.webview.set(mWebView);
        return inflate.getRoot();
    }


    @Override
    public boolean onBackPressedSupport() {
        if (mWebView != null && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        } else {
            return super.onBackPressedSupport();
        }
    }

    public static BaseFragment newInstance(String url) {
        WebF webF = new WebF();

        Bundle args = new Bundle();
        args.putString("url", url);
        webF.setArguments(args);
        return webF;
    }
}
