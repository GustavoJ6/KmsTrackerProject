package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

    }

    public void noteRide(View view) {
        Intent rideInfo = new Intent(this, NoteRideActivity.class);
        Intent toolsMenu = getIntent();
        rideInfo.putExtra("driver", toolsMenu.getStringExtra("driver"));
        startActivity(rideInfo);
    }

    public void addKms(View view){
        Intent kmsAdd = new Intent(this, KmsAdd.class);
        Intent toolsMenu = getIntent();
        kmsAdd.putExtra("driver", toolsMenu.getStringExtra("driver"));
        startActivity(kmsAdd);
    }

    public void checkInfo(View view){
        Intent check = new Intent(this, checkInfoActivity.class);
        startActivity(check);


    }

    public void calculator(View view) {
        Intent calculate = new Intent(this, CalculatorActivity.class);
        startActivity(calculate);

    }
}