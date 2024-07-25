package com.example.functionalapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Screen2 extends AppCompatActivity {
    public static final int REQUEST_CALL_PERMISSION = 1;
    Button btncall;
    CardView cardWeb,cardAndroid,cardMachine,cardIOS,cardBlock,cardDataBase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_screen2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent i = getIntent();
        btncall = findViewById(R.id.btncall);
        cardWeb = findViewById(R.id.cardWeb);
        cardAndroid = findViewById(R.id.cardAnd);
        cardMachine = findViewById(R.id.cardML);
        cardIOS = findViewById(R.id.cardIOS);
        cardBlock = findViewById(R.id.cardBlock);
        cardDataBase = findViewById(R.id.cardDB);
        cardWeb.setOnClickListener(v -> {
            Intent WebIntent = new Intent(getBaseContext(), WebDev.class);
            startActivity(WebIntent);
        });
        cardAndroid.setOnClickListener(v -> {
            Intent AndIntent = new Intent(getBaseContext(),AndroidDev.class);
            startActivity(AndIntent);
        });
        cardMachine.setOnClickListener(v -> {
            Intent MlIntent = new Intent(getBaseContext(),MachineLearning.class);
            startActivity(MlIntent);
        });
        cardBlock.setOnClickListener(v -> {
            Intent BlockIntent = new Intent(getBaseContext(),BlockChain.class);
            startActivity(BlockIntent);
        });
        cardDataBase.setOnClickListener(v -> {
            Intent BlockIntent = new Intent(getBaseContext(),DataBase.class);
            startActivity(BlockIntent);
        });

        btncall.setOnClickListener(v -> {
            String phoneNumber = "1234567890"; // Phone number should be a String
            if (ContextCompat.checkSelfPermission(Screen2.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Screen2.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
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
