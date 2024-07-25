package com.example.functionalapplication;

import static com.example.functionalapplication.Screen2.REQUEST_CALL_PERMISSION;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BlockChain extends AppCompatActivity {
    ImageView imageblockch,imagetik1,imagetik2,imagetik3,backblock;
    Button btncallblock,btntrain;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_block_chain);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent blocki=getIntent();
        imageblockch=findViewById(R.id.imageblockch);
        imagetik1=findViewById(R.id.imagetik1);
        imagetik2=findViewById(R.id.imagetik2);
        imagetik3=findViewById(R.id.imagetik3);
        backblock=findViewById(R.id.backblock);
        btncallblock=findViewById(R.id.btncallblock);
        btntrain=findViewById(R.id.btntrain);
        imagetik1.setImageDrawable(getResources().getDrawable(R.drawable.tik));
        imagetik2.setImageDrawable(getResources().getDrawable(R.drawable.tik));
        imagetik3.setImageDrawable(getResources().getDrawable(R.drawable.tik));
        imageblockch.setImageDrawable(getResources().getDrawable(R.drawable.blockch));
        backblock.setImageDrawable(getResources().getDrawable(R.drawable.arrow1));
        backblock.setOnClickListener(v -> {
            onBackPressed();
        });
        btntrain.setOnClickListener(view -> {
            Intent link3i=new Intent(Intent.ACTION_VIEW);
            link3i.setData(Uri.parse("https://www.geeksforgeeks.org/blockchain/"));
            startActivity(link3i);
        });
        btncallblock.setOnClickListener(v -> {
            String phoneNumber = "1234567890"; // Phone number should be a String
            if (ContextCompat.checkSelfPermission(BlockChain.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(BlockChain.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                makePhoneCall(phoneNumber);
            }
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