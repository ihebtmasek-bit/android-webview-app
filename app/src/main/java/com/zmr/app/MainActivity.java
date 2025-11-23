package com.zmr.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try {
            WebView webView = new WebView(this);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("file:///android_asset/index.html");
            setContentView(webView);
        } catch (Exception e) {
            // Fallback simple
            WebView webView = new WebView(this);
            webView.loadData("<h1>Notes App</h1><p>Application chargée</p>", "text/html", "UTF-8");
            setContentView(webView);
        }
    }
}
