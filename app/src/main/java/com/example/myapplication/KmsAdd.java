package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class KmsAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kms_add);
    }

    public void subtract(View v){
        Intent before = getIntent();
        String driver = before.getStringExtra("driver");

        EditText t = findViewById(R.id.kmsToSubtract);
        String kmsS = t.getText().toString().trim();
        int kms = Integer.parseInt(kmsS);

        FileInputStream fis = null;
        try {
            fis = openFileInput(MainActivity.FILE_TOTALS);
            InputStreamReader isr = new InputStreamReader(fis);
            Scanner sc = new Scanner(isr);
            String line = sc.nextLine();
            String [] eachKms = line.split(",");

            int kmsAtual;

            if (driver.equals("Guga")){
                kmsAtual = Integer.parseInt(eachKms[0]);
                kmsAtual-= kms;
                eachKms[0] = String.valueOf(kmsAtual);
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[0]+ " | Deducted: " + kms, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[0]+ " | Deducted: " + kms, Toast.LENGTH_LONG).show();
            }else{
                kmsAtual = Integer.parseInt(eachKms[1]);
                kmsAtual-= kms;
                eachKms[1] = String.valueOf(kmsAtual);
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[1]+ " | Deducted: " + kms, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[1]+ " | Deducted: " + kms, Toast.LENGTH_LONG).show();
            }

            FileOutputStream fos = openFileOutput(MainActivity.FILE_TOTALS, MODE_PRIVATE);
            PrintWriter out = new PrintWriter(fos);

            out.printf("%s,%s", eachKms[0],eachKms[1]);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.onBackPressed();

    }

    public void add(View v){
        Intent before = getIntent();
        String driver = before.getStringExtra("driver");

        EditText t = findViewById(R.id.litersToAdd);
        String litersS = t.getText().toString();
        litersS = litersS.trim();
        Double liters = Double.parseDouble(litersS);

        int kms = (int) ((liters * 100)/MainActivity.CONSUME);

        FileInputStream fis = null;
        try {
            fis = openFileInput(MainActivity.FILE_TOTALS);
            InputStreamReader isr = new InputStreamReader(fis);
            Scanner sc = new Scanner(isr);
            String line = sc.nextLine();
            String [] eachKms = line.split(",");

            int kmsAtual;

            if (driver.equals("Guga")){
                kmsAtual = Integer.parseInt(eachKms[0]);
                kmsAtual+= kms;
                eachKms[0] = String.valueOf(kmsAtual);
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[0]+ " | Added: " + kms, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[0]+ " | Added: " + kms, Toast.LENGTH_LONG).show();

            }else{
                kmsAtual = Integer.parseInt(eachKms[1]);
                kmsAtual+= kms;
                eachKms[1] = String.valueOf(kmsAtual);
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[1]+ " | Added: " + kms, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "TOTAL KMS: "+ eachKms[1]+ " | Added: " + kms, Toast.LENGTH_LONG).show();
            }

            FileOutputStream fos = openFileOutput(MainActivity.FILE_TOTALS, MODE_PRIVATE);
            PrintWriter out = new PrintWriter(fos);

            out.printf("%s,%s", eachKms[0],eachKms[1]);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        super.onBackPressed();
    }
}