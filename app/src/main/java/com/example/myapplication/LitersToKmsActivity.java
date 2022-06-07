package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LitersToKmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liters_to_kms);
    }

    public void calculate1(View v){
        EditText inLiters = findViewById(R.id.totalLiters1);
        String liters = inLiters.getText().toString().trim();
        Double litersI = Double.parseDouble(liters);
        Double kms = (litersI*100)/MainActivity.CONSUME;
        kms = round(kms, 3);

        TextView text = (TextView) inLiters;
        text.setText(String.valueOf(kms)+ " Kms");

        //Possivelmente adicionar um mostrador e arredondar o resultado (fazer o mesmo no  kms to liters)
    }
    public void clear(View v){
        TextView text = (TextView) findViewById(R.id.totalLiters1);
        text.setText("");

    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}