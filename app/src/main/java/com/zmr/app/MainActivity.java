package com.zmr.app;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();

        // Activer JavaScript
        webSettings.setJavaScriptEnabled(true);

        // Activer la persistance du localStorage
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAppCacheEnabled(true);

        // Spécifier un dossier pour le cache
        webSettings.setAppCachePath(getApplicationContext().getCacheDir().getPath());

        // Empêcher l'ouverture dans le navigateur externe
        webView.setWebViewClient(new WebViewClient());

        // Charger votre HTML
        webView.loadUrl("file:///android_asset/index.html");
    }
}
