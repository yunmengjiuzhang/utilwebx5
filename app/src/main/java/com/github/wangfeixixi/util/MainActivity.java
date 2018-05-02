package com.github.wangfeixixi.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import wangfei.util.common.UIUtils;
import wangfei.util.fragmentation.BaseActivity;
import wangfei.utilwebx5.X5Utils;
import wangfei.utilwebx5.X5WebViewSample;

public class MainActivity extends BaseActivity {
    private X5WebViewSample mx5WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        X5Utils.init(UIUtils.getContext());//初始化

        initLienter();

        WebF webF = findFragment(WebF.class);
        if (webF == null)
            loadRootFragment(R.id.test_webview, WebF.newInstance("https://github.com/wangfeixixi"));

    }

    private void initLienter() {
        findViewById(R.id.btnliulan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(WebF.newInstance("http://www.iqiyi.com/fun/20130701/0ba18f613aa59b46.html"));
            }
        });
        findViewById(R.id.btnshipin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        VideoActivity.class);
                MainActivity.this.startActivity(intent);
//                start(WebF.newInstance("file:///android_asset/webpage/fullscreenVideo.html"));
            }
        });

        /**
         * 文件选择的时候，应该打开权限，todo现在是不可用的
         * webSetting.setAllowFileAccessFromFileURLs(false);
         * webSetting.setAllowUniversalAccessFromFileURLs(false);
         * 设置为true
         * <p>
         * 注意这个有应用克隆漏洞隐患，如果不用就不必打开
         */
        findViewById(R.id.btnwenjian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(WebF.newInstance("file:///android_asset/webpage/fileChooser.html"));
            }
        });

    }
}
