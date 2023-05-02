package com.example.word;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grantPermissions();
    }

    public void grantPermissions() {
        String[] permissions = {
//                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET,
        };
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(
                    this, permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{permission},
                        1234);
            }
        }
    }
}