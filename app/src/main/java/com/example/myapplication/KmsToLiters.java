package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class KmsToLiters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kms_to_liters);
    }

    public void calculate2(View v){
        EditText inKms = findViewById(R.id.totalKms1);
        String kms = inKms.getText().toString().trim();
        Double kmsD = Double.parseDouble(kms);
        Double liters = (kmsD*MainActivity.CONSUME)/100;
            liters = LitersToKmsActivity.round(liters, 3);
        TextView text = (TextView) inKms;
        text.setText(String.valueOf(liters)+ " Liters");

    }
    public void clear2(View v){
        TextView text = (TextView) findViewById(R.id.totalKms1);
        text.setText("");
    }
}