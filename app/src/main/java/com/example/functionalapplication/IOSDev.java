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

public class IOSDev extends AppCompatActivity {
    Button btncallios;
    ImageView imageios1,imageios2,imageios3,imageios4,imageios5,imageios6,imageios7,imageios8,imageios9,backios;
    TextView link1,link2,link3,link4,link5,link6,link7,link8,link9,link10,link11,link12,link13,link14,link15,link16,link17,link18,link19,link20;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iosdev);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent iosi=getIntent();
        btncallios = findViewById(R.id.btncallios);
        backios=findViewById(R.id.backios);
        imageios1 = findViewById(R.id.imageios1);
        imageios2 = findViewById(R.id.imageios2);
        imageios3 = findViewById(R.id.imageios3);
        imageios4 = findViewById(R.id.imageios4);
        imageios5 = findViewById(R.id.imageios5);
        imageios6 = findViewById(R.id.imageios6);
        imageios7 = findViewById(R.id.imageios7);
        imageios8 = findViewById(R.id.imageios8);
        imageios9 = findViewById(R.id.imageios9);
        link1=findViewById(R.id.link1);
        link2=findViewById(R.id.link2);
        link3=findViewById(R.id.link3);
        link4=findViewById(R.id.link4);
        link5=findViewById(R.id.link5);
        link6=findViewById(R.id.link6);
        link7=findViewById(R.id.link7);
        link8=findViewById(R.id.link8);
        link9=findViewById(R.id.link9);
        link10=findViewById(R.id.link10);
        link11=findViewById(R.id.link11);
        link12=findViewById(R.id.link12);
        link13=findViewById(R.id.link13);
        link14=findViewById(R.id.link14);
        link15=findViewById(R.id.link15);
        link16=findViewById(R.id.link16);
        link17=findViewById(R.id.link17);
        link18=findViewById(R.id.link18);
        link19=findViewById(R.id.link19);
        link20=findViewById(R.id.link20);
        imageios1.setImageDrawable(getResources().getDrawable(R.drawable.ios1));
        imageios2.setImageDrawable(getResources().getDrawable(R.drawable.ios2));
        imageios3.setImageDrawable(getResources().getDrawable(R.drawable.ios3));
        imageios4.setImageDrawable(getResources().getDrawable(R.drawable.ios4));
        imageios5.setImageDrawable(getResources().getDrawable(R.drawable.ios5));
        imageios6.setImageDrawable(getResources().getDrawable(R.drawable.ios6));
        imageios7.setImageDrawable(getResources().getDrawable(R.drawable.ios7));
        imageios8.setImageDrawable(getResources().getDrawable(R.drawable.ios8));
        imageios9.setImageDrawable(getResources().getDrawable(R.drawable.ios9));
        backios.setImageDrawable(getResources().getDrawable(R.drawable.arrow1));
        backios.setOnClickListener(v -> {
            onBackPressed();
        });
        btncallios.setOnClickListener(v -> {
            String phoneNumber = "1234567890"; // Phone number should be a String
            if (ContextCompat.checkSelfPermission(IOSDev.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(IOSDev.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                makePhoneCall(phoneNumber);
            }
        });
        link1.setOnClickListener(v->{
            Intent link1i=new Intent(Intent.ACTION_VIEW);
            link1i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/getting-started-with-scrumdinger"));
            startActivity(link1i);
        });
        link2.setOnClickListener(v->{
            Intent link2i=new Intent(Intent.ACTION_VIEW);
            link2i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/using-stacks-to-arrange-views"));
            startActivity(link2i);
        });
        link3.setOnClickListener(v->{
            Intent link3i=new Intent(Intent.ACTION_VIEW);
            link3i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/creating-a-card-view"));
            startActivity(link3i);
        });
        link4.setOnClickListener(v->{
            Intent link4i=new Intent(Intent.ACTION_VIEW);
            link4i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/displaying-data-in-a-list"));
            startActivity(link4i);
        });
        link5.setOnClickListener(v->{
            Intent link5i=new Intent(Intent.ACTION_VIEW);
            link5i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/creating-a-navigation-hierarchy"));
            startActivity(link5i);
        });
        link6.setOnClickListener(v->{
            Intent link1i=new Intent(Intent.ACTION_VIEW);
            link1i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/managing-data-flow-between-views"));
            startActivity(link1i);
        });
        link7.setOnClickListener(v->{
            Intent link2i=new Intent(Intent.ACTION_VIEW);
            link2i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/creating-the-edit-view"));
            startActivity(link2i);
        });
        link8.setOnClickListener(v->{
            Intent link3i=new Intent(Intent.ACTION_VIEW);
            link3i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/passing-data-with-bindings"));
            startActivity(link3i);
        });
        link9.setOnClickListener(v->{
            Intent link4i=new Intent(Intent.ACTION_VIEW);
            link4i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/making-classes-observable"));
            startActivity(link4i);
        });
        link10.setOnClickListener(v->{
            Intent link5i=new Intent(Intent.ACTION_VIEW);
            link5i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/responding-to-events"));
            startActivity(link5i);
        });
        link11.setOnClickListener(v->{
            Intent link1i=new Intent(Intent.ACTION_VIEW);
            link1i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/managing-state-and-life-cycle"));
            startActivity(link1i);
        });
        link12.setOnClickListener(v->{
            Intent link2i=new Intent(Intent.ACTION_VIEW);
            link2i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/updating-app-data"));
            startActivity(link2i);
        });
        link13.setOnClickListener(v->{
            Intent link3i=new Intent(Intent.ACTION_VIEW);
            link3i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/adopting-swift-concurrency"));
            startActivity(link3i);
        });
        link14.setOnClickListener(v->{
            Intent link4i=new Intent(Intent.ACTION_VIEW);
            link4i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/persisting-data"));
            startActivity(link4i);
        });
        link15.setOnClickListener(v->{
            Intent link5i=new Intent(Intent.ACTION_VIEW);
            link5i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/adopting-new-api-features"));
            startActivity(link5i);
        });
        link17.setOnClickListener(v->{
            Intent link1i=new Intent(Intent.ACTION_VIEW);
            link1i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/drawing-the-timer-view"));
            startActivity(link1i);
        });
        link18.setOnClickListener(v->{
            Intent link2i=new Intent(Intent.ACTION_VIEW);
            link2i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/examining-data-flow-in-scrumdinger"));
            startActivity(link2i);
        });
        link19.setOnClickListener(v->{
            Intent link3i=new Intent(Intent.ACTION_VIEW);
            link3i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/transcribing-speech-to-text"));
            startActivity(link3i);
        });
        link20.setOnClickListener(v->{
            Intent link4i=new Intent(Intent.ACTION_VIEW);
            link4i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/finding-more-resources"));
            startActivity(link4i);
        });
        link16.setOnClickListener(v->{
            Intent link5i=new Intent(Intent.ACTION_VIEW);
            link5i.setData(Uri.parse("https://developer.apple.com/tutorials/app-dev-training/handling-errors"));
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