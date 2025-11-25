package com.yourapp.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "ZNotesApp";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        WebView webView = new WebView(this);
        
        // Configurer WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        
        // Définir le WebViewClient
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e(TAG, "WebView error: " + description + " (" + errorCode + ") for URL: " + failingUrl);
                
                // Afficher une page d'erreur personnalisée
                String errorHtml = "<html><body style='text-align:center; padding:50px;'><h2>😕 Unable to load notes</h2><p>Please check your connection and try again.</p><button onclick='location.reload()' style='padding:10px 20px; margin:10px;'>Retry</button></body></html>";
                view.loadData(errorHtml, "text/html", "UTF-8");
            }
            
            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(TAG, "Page loaded successfully: " + url);
            }
        });
        
        // Définir le WebChromeClient pour les logs
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                Log.d("WebViewConsole", message + " -- From line " + lineNumber + " of " + sourceID);
            }
        });
        
        // Charger l'application web
        try {
            Log.d(TAG, "Loading index.html from assets...");
            webView.loadUrl("file:///android_asset/index.html");
        } catch (Exception e) {
            Log.e(TAG, "Error loading HTML: " + e.getMessage());
            String fallbackHtml = "<html><body style='text-align:center; padding:50px;'><h2>📝 Z Notes App</h2><p>Welcome to Z Notes! The app is loading...</p><p>If you see this message for too long, please restart the app.</p></body></html>";
            webView.loadData(fallbackHtml, "text/html", "UTF-8");
        }
        
        setContentView(webView);
    }
}
