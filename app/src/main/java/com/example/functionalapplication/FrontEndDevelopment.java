package com.example.functionalapplication;

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

public class FrontEndDevelopment extends AppCompatActivity {
    WebView webViewFront;
    ImageView backwebfront;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_front_end_development);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent fronti=getIntent();
        backwebfront=findViewById(R.id.backwebfront);
        backwebfront.setImageDrawable(getResources().getDrawable(R.drawable.arrow1));
        backwebfront.setOnClickListener(v -> {
            onBackPressed();
        });
        webViewFront = findViewById(R.id.webviewFront);
        webViewSetup(webViewFront);

    }
    protected static void webViewSetup(WebView webView){
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSafeBrowsingEnabled(true);
        webView.loadUrl("https://www.geeksforgeeks.org/web-development/#front_dev");
    }

}