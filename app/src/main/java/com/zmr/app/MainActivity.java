package com.zmr.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        
        // Activer JavaScript
        webSettings.setJavaScriptEnabled(true);
        
        // Activer la persistance du localStorage (API moderne)
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        
        // Empêcher l'ouverture dans le navigateur externe
        webView.setWebViewClient(new WebViewClient());
        
        // Charger votre HTML
        webView.loadUrl("file:///android_asset/index.html");
        
        setContentView(webView);
    }
}
