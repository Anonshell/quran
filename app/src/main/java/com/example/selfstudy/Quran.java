package com.example.selfstudy;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class Quran extends AppCompatActivity {
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        WebView webView = (WebView) findViewById(R.id.webviewId);
        this.webView = webView;
        WebSettings websettings = webView.getSettings();
        websettings.setJavaScriptEnabled(true);
        this.webView.setWebViewClient(new WebViewClient());
        this.webView.loadUrl("https://quran.com/");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}