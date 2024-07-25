package com.example.functionalapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BackEndDevelopment extends AppCompatActivity {
    WebView webViewBack;
    ImageView backwebback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_back_end_development);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent backi=getIntent();
        backwebback=findViewById(R.id.backwebback);
        backwebback.setImageDrawable(getResources().getDrawable(R.drawable.arrow1));
        backwebback.setOnClickListener(v -> {
            onBackPressed();
        });
        webViewBack = findViewById(R.id.webviewBack);
        webViewSetup(webViewBack);

    }
    protected static void webViewSetup(WebView webView){
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSafeBrowsingEnabled(true);
        webView.loadUrl("https://www.geeksforgeeks.org/web-development/#back_dev");
    }
}