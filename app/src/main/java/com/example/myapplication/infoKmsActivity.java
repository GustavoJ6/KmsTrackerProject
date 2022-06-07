package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class infoKmsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kms);

        FileInputStream fis = null;

        try {
            fis = openFileInput(MainActivity.FILE_TOTALS);
            InputStreamReader isr = new InputStreamReader(fis);
            Scanner sc = new Scanner(isr);
             TextView text = (TextView) findViewById(R.id.showKms);
            StringBuilder sb = new StringBuilder();
            String s;
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                sb.append(s).append("\n");

            }

            text.setText(sb.toString());
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