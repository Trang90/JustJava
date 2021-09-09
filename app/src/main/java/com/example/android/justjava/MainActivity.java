package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.android.justjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    int quantity = 0;
    int price =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = quantity - 1;
                displayQuantity(quantity);
            }
        });

        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = quantity +1;
                displayQuantity(quantity);
            }
        });

        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox whippedCream = binding.cbCream;
                int price = calculatePrice();
                boolean hasWhippedCream = whippedCream.isChecked();
                String message= displayMsg (price, hasWhippedCream);
                displaySummary(message);
            }
        });

    }



    private void displayQuantity (int number){
        binding.tvNumber.setText("" + number);
    }

    private void displaySummary (String text){
        binding.tvDisplaySummary.setText("" + text);
    }

    private String displayMsg (int price, boolean hasCream){
       String msg = "Name: Lyla";
        msg+= "\nAdd cream? " + hasCream;
        msg+= "\nQuantity: " + quantity;
        msg+= "\nTotal: " + price;
        msg+= "\nThanks";
        return msg;
    }

    private int calculatePrice (){
        return price = quantity *5 ;
    }


}