package com.example.functionalapplication;

import static com.example.functionalapplication.Screen2.REQUEST_CALL_PERMISSION;

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

public class MachineLearning extends AppCompatActivity {
    Button btncallml;
    TextView link1,link2,link3,link4,link5;
    ImageView imageml,backml ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_machine_learning);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent mli=getIntent();
        btncallml=findViewById(R.id.btncallml);
        imageml=findViewById(R.id.imageml);
        backml=findViewById(R.id.backml);
        link1=findViewById(R.id.link1);
        link2=findViewById(R.id.link2);
        link3=findViewById(R.id.link3);
        link4=findViewById(R.id.link4);
        link5=findViewById(R.id.link5);
        imageml.setImageDrawable(getResources().getDrawable(R.drawable.ml));
        backml.setImageDrawable(getResources().getDrawable(R.drawable.arrow1));
        backml.setOnClickListener(v -> {
            onBackPressed();
        });
        btncallml.setOnClickListener(v -> {
            String phoneNumber = "1234567890"; // Phone number should be a String
            if (ContextCompat.checkSelfPermission(MachineLearning.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MachineLearning.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                makePhoneCall(phoneNumber);
            }
        });

        link1.setOnClickListener(v->{
            Intent link1i=new Intent(Intent.ACTION_VIEW);
            link1i.setData(Uri.parse("https://www.geeksforgeeks.org/what-is-machine-learning/"));
            startActivity(link1i);
        });
        link2.setOnClickListener(v->{
            Intent link2i=new Intent(Intent.ACTION_VIEW);
            link2i.setData(Uri.parse("https://www.geeksforgeeks.org/real-life-applications-of-machine-learning/"));
            startActivity(link2i);
        });
        link3.setOnClickListener(v->{
            Intent link3i=new Intent(Intent.ACTION_VIEW);
            link3i.setData(Uri.parse("https://www.geeksforgeeks.org/role-of-machine-learning-in-data-science/"));
            startActivity(link3i);
        });
        link5.setOnClickListener(v->{
            Intent link4i=new Intent(Intent.ACTION_VIEW);
            link4i.setData(Uri.parse("https://www.geeksforgeeks.org/top-machine-learning-dataset-find-open-datasets"));
            startActivity(link4i);
        });
        link4.setOnClickListener(v->{
            Intent link5i=new Intent(Intent.ACTION_VIEW);
            link5i.setData(Uri.parse("https://www.geeksforgeeks.org/steps-to-build-a-machine-learning-model/"));
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
    }
    }
