package com.github.wangfeixixi.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import wangfei.utilwebx5.X5WebView;
import wangfei.utilwebx5.X5WebViewClient;

public class MainActivity extends AppCompatActivity {
    private X5WebView mx5WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initLienter();

        mx5WebView = new X5WebView(this, null);
        mx5WebView.setWebViewClient(new X5WebViewClient());

        FrameLayout viewById = findViewById(R.id.test_webview);
        viewById.addView(mx5WebView, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.FILL_PARENT,
                FrameLayout.LayoutParams.FILL_PARENT));

        mx5WebView.loadUrl("http://blog.csdn.net/qq_36017059/article/details/78061063");
    }

    private void initLienter() {
        findViewById(R.id.btnliulan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        BrowserActivity.class);
                MainActivity.this.startActivity(intent);
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
