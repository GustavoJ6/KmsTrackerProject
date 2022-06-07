package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class eurosToLiters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_euros_to_liters);
    }

    public void calculate3(View view) {
        //Ir buscar o valor de euros e o preço e calcular quantos litros da e mudar o textview que esta definido a "" para o novo, also, dar clear automaticamente
        EditText inBudget = findViewById(R.id.budget);
        String budgetS = inBudget.getText().toString().trim();
        Double budget = Double.parseDouble(budgetS);

        EditText inPrice = findViewById(R.id.gasPrice);
        String priceS = inPrice.getText().toString().trim();
        Double price = Double.parseDouble(priceS);

        Double liters = budget/price;
        liters = LitersToKmsActivity.round(liters,3);
        TextView litersShow = findViewById(R.id.textViewLitersShow);
        litersShow.setText(String.valueOf( liters) + " Liters");

    }


    public void clear3(View v) {
        TextView textBudget = (TextView) findViewById(R.id.budget);
        textBudget.setText("");

    }
    public void clear4(View v){
        TextView textPrice = (TextView) findViewById(R.id.gasPrice);
        textPrice.setText("");
    }

}