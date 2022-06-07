package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class infoRidesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rides);

        FileInputStream fis = null;

        try {
            fis = openFileInput(MainActivity.FILE_IN);
            InputStreamReader isr = new InputStreamReader(fis);
            Scanner sc = new Scanner(isr);
            TextView text = (TextView) findViewById(R.id.showRides);
            StringBuilder sb = new StringBuilder();
            String s;
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                    sb.append(s).append("\n");

            }


            text.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!= null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}