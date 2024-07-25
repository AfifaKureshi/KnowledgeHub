package com.example.functionalapplication;

import static com.example.functionalapplication.Screen2.REQUEST_CALL_PERMISSION;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AndroidDev extends AppCompatActivity {
    Button btncalland;
    TextView link1,link2,link3,link4,link5;
    ImageView imageand1,imageand2,backand ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_android_dev);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent andi=getIntent();
        btncalland=findViewById(R.id.btncalland);
        imageand1=findViewById(R.id.imageand1);
        imageand2=findViewById(R.id.imageand2);
        backand=findViewById(R.id.backand);
        link1=findViewById(R.id.link1);
        link2=findViewById(R.id.link2);
        link3=findViewById(R.id.link3);
        link4=findViewById(R.id.link4);
        link5=findViewById(R.id.link5);
        imageand1.setImageDrawable(getResources().getDrawable(R.drawable.android));
        imageand2.setImageDrawable(getResources().getDrawable(R.drawable.featuresand));
        backand.setImageDrawable(getResources().getDrawable(R.drawable.arrow1));
        backand.setOnClickListener(v -> {
            onBackPressed();
        });
        btncalland.setOnClickListener(v -> {
            String phoneNumber = "1234567890"; // Phone number should be a String
            if (ContextCompat.checkSelfPermission(AndroidDev.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(AndroidDev.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                makePhoneCall(phoneNumber);
            }
        });

        link1.setOnClickListener(v->{
            Intent link1i=new Intent(Intent.ACTION_VIEW);
            link1i.setData(Uri.parse("https://www.geeksforgeeks.org/introduction-to-android-development/"));
            startActivity(link1i);
        });
        link2.setOnClickListener(v->{
            Intent link2i=new Intent(Intent.ACTION_VIEW);
            link2i.setData(Uri.parse("https://www.geeksforgeeks.org/history-of-android/"));
            startActivity(link2i);
        });
        link3.setOnClickListener(v->{
            Intent link3i=new Intent(Intent.ACTION_VIEW);
            link3i.setData(Uri.parse("https://www.geeksforgeeks.org/best-way-to-become-android-developer-a-complete-roadmap/"));
            startActivity(link3i);
        });
        link4.setOnClickListener(v->{
            Intent link4i=new Intent(Intent.ACTION_VIEW);
            link4i.setData(Uri.parse("https://www.geeksforgeeks.org/android-app-development-fundamentals-for-beginners/"));
            startActivity(link4i);
        });
        link5.setOnClickListener(v->{
            Intent link5i=new Intent(Intent.ACTION_VIEW);
            link5i.setData(Uri.parse("https://www.geeksforgeeks.org/android-studio-tutorial/"));
            startActivity(link5i);
        });
    }
    public void makePhoneCall(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        try {
            startActivity(callIntent);
        } catch (SecurityException e) {
            Toast.makeText(this, "Permission denied to make phone call", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String phoneNumber = "1234567890"; // Phone number should be a String
                makePhoneCall(phoneNumber);
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }}