package com.dhw.rikao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;

//网页加载页面
public class WebActivity extends AppCompatActivity {
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        //设置在本页面显示加载的页面
        webView.setWebViewClient(new WebViewClient());

        //获取传递的url数据，加载页面
        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);

        //设置显示JavaScript，显示对话框
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
    }
}
