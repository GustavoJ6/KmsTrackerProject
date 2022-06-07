 package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

 public class MainActivity extends AppCompatActivity {
     public static final String FILE_IN = "registo.txt";
     public static final String FILE_TOTALS = "totalsKms.txt";
     public static final double CONSUME = 5.7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

     public void launchTools(View v){
         String driver;
         if (R.id.Guga ==  v.getId()){
             driver = "Guga";
         }else{
             driver = "Gui";
         }
         Intent toolsMenu = new Intent(this, ToolsActivity.class);
         toolsMenu.putExtra("driver", driver);
         startActivity(toolsMenu);
     }

}