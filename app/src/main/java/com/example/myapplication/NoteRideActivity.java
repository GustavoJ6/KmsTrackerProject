package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class NoteRideActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_ride);

    }

    public void write(View v) {
        EditText t = findViewById(R.id.totalKmIn);
        String kms = t.getText().toString();
        kms = kms.trim();
        PrintWriter out = null;
        Intent before = getIntent();
        String driver = before.getStringExtra("driver");

//ANTERIORES



        FileInputStream fis2 = null;
        try {
            fis2 = openFileInput(MainActivity.FILE_IN);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr2 = new InputStreamReader(fis2);
        Scanner sc2 = new Scanner(isr2);
        int prevKms;
        do {
        String prevKmsHelper =sc2.nextLine();
        String [] prevKmsA = prevKmsHelper.split(",");
        prevKms= (int) Double.parseDouble( prevKmsA[0]);
        }while(sc2.hasNextLine());
        // Remover os ficheiros e criar de novo com os respetivos valores. Dica: usar o Mode_private


// REGISTO NORMAL
        try {

            FileOutputStream fos = openFileOutput(MainActivity.FILE_IN, MODE_APPEND);
            out = new PrintWriter(fos);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        out.format("%s,%s%n", kms,driver);
        out.flush();
        out.close();

        try {
            Thread.sleep(1500);
            findViewById(R.id.KmsAsk).setVisibility(View.GONE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

/*
// INICIALIZAR OS TOTAIS

        try {
            FileOutputStream fos = openFileOutput(MainActivity.FILE_TOTALS, MODE_PRIVATE);
            out = new PrintWriter(fos);
            out.print("0,0");
            out.close();
            //NOTIFY
            Toast.makeText(this, "Again", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int kmsI = Integer.parseInt(kms);


*/

        //ESCREVER NOVOS TOTAIS
        FileInputStream fis = null;
        try {
             fis = openFileInput(MainActivity.FILE_TOTALS);
            InputStreamReader isr = new InputStreamReader(fis);
            Scanner sc = new Scanner(isr);
            String line = sc.nextLine();
            String [] eachKms = line.split(",");

            int kmsFinal = Integer.parseInt(kms);
            int rideKms = kmsFinal - prevKms;
            int kmsAtual;

            if (driver.equals("Guga")){
               kmsAtual= Integer.parseInt(eachKms[0]);
               kmsAtual-= rideKms;
               eachKms[0] = String.valueOf(kmsAtual);
                Toast.makeText(this, "Kms restantes:" + eachKms[0], Toast.LENGTH_LONG).show();
            }else{
                kmsAtual= Integer.parseInt(eachKms[1]);
                kmsAtual-= rideKms;
                eachKms[1] = String.valueOf(kmsAtual);
                Toast.makeText(this, "Kms restantes:" +eachKms[1], Toast.LENGTH_LONG).show();
            }

            FileOutputStream fos = openFileOutput(MainActivity.FILE_TOTALS, MODE_PRIVATE);
            out = new PrintWriter(fos);
            out.printf("%s,%s", eachKms[0],eachKms[1]);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        super.onBackPressed();
    }

    public void clearLast(View view){
        EditText t = findViewById(R.id.totalKmIn);
        String kms = t.getText().toString();
        kms = kms.trim();
        PrintWriter out = null;
        Intent before = getIntent();
        String driver = before.getStringExtra("driver");
        try {

            FileOutputStream fos = openFileOutput(MainActivity.FILE_IN, MODE_APPEND);
            out = new PrintWriter(fos);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        out.format("%s,%s%n", kms,driver);
        out.flush();
        out.close();
        Toast.makeText(this, "Fixed", Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(1500);
            findViewById(R.id.KmsAsk).setVisibility(View.GONE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onBackPressed();
    }

}