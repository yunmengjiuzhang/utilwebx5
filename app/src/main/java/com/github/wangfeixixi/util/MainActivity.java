package com.github.wangfeixixi.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.github.wangfeixixi.util.sample.WebF;

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
                        FullScreenActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.btnwenjian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        FilechooserActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }
}
