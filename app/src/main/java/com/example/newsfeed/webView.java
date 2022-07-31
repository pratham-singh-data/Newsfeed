package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView extends AppCompatActivity {
    WebView newsWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        newsWebView = findViewById(R.id.newsWebView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        newsWebView.setWebViewClient(new WebViewClient());

        if(WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)){
            WebSettingsCompat.setForceDark(newsWebView.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
        }

        newsWebView.loadUrl(url);
    }
}