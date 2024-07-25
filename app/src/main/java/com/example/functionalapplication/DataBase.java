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

public class DataBase extends AppCompatActivity {
    WebView webViewDb;
    ImageView backwebDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent fronti=getIntent();
        backwebDb=findViewById(R.id.backDb);
        backwebDb.setImageDrawable(getResources().getDrawable(R.drawable.arrow1));
        backwebDb.setOnClickListener(v -> {
            onBackPressed();
        });
        webViewDb = findViewById(R.id.webviewDb);
        webViewSetup(webViewDb);

    }
    protected static void webViewSetup(WebView webView){
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSafeBrowsingEnabled(true);
        webView.loadUrl("https://www.w3schools.com/sql/");
    }
    }
