package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class checkInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_info);
    }


    public void kmsInfo(View view) {
        Intent infoKms = new Intent(this, infoKmsActivity.class);
        startActivity(infoKms);
    }

    public void ridesInfo(View view) {
        Intent infoRides = new Intent(this, infoRidesActivity.class);
        startActivity(infoRides);
    }
}