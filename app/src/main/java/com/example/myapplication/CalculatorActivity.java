package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void litersKms(View view) {
        Intent litersToKms = new Intent(this, LitersToKmsActivity.class);
        startActivity(litersToKms);

    }


    public void kmsToLiters(View v) {
        Intent kmsToLiters = new Intent(this, KmsToLiters.class);
        startActivity(kmsToLiters);
    }

    public void eurosToLiters(View view) {
        Intent eurosToLiters = new Intent(this, eurosToLiters.class);
        startActivity(eurosToLiters);
    }

    public void litersToEuros(View view) {
    }
}