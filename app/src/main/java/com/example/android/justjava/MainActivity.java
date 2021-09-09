package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.android.justjava.databinding.ActivityMainBinding;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    int quantity = 0;
    int price = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity >0 ){
                    quantity = quantity - 1;
                    displayQuantity(quantity);
                } else {
                    quantity = 0;
                    Toast.makeText(MainActivity.this, "You cannot order less than 1 cup", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity >= 0 && quantity <100) {
                quantity = quantity+1;
                displayQuantity(quantity);
            } else
                {quantity = 100;
                Toast.makeText(MainActivity.this, "You cannot order more than 100 cups", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox hasCream = binding.cbCream;
                boolean addCream = hasCream.isChecked();
                CheckBox hasChocolate = binding.cbChocolate;
                boolean addChocolate = hasChocolate.isChecked();


                String name = binding.edittextName.getText().toString();
                calculatePrice(addCream, addChocolate);
                String msg = displayMSG(name, addCream, addChocolate);
                displaySummary(msg);


                Intent intent = new Intent (Intent.ACTION_SENDTO);
                intent.setData (Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "laraolivia13@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Order from: " + name);
                intent.putExtra(Intent.EXTRA_TEXT, msg);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }




            }
        });

    }

    private void displayQuantity (int number){
        binding.tvNumber.setText(""+number);
    }

    private int calculatePrice (boolean addCream, boolean addChocolate){
        int basePrice =5;
        int creamPrice = 1;
        int chocolatePrice=2;

        if (addCream) {
            basePrice = basePrice + creamPrice;
        }
        if (addChocolate) {
            basePrice = basePrice + chocolatePrice;
        }
        return price = quantity * basePrice;
    }

    private void displaySummary (String text){
        binding.tvDisplaySummary.setText(""+ text);
    }

    private String displayMSG (String name, boolean addCream, boolean addChocolate){
        String msg = getString(R.string.name, name);
        msg+= "\n"+ getString(R.string.add_cream, addCream);
        msg+= "\n"+ getString(R.string.add_chocolate,addChocolate);
        msg+= "\n" + getString(R.string.quantity,quantity);
        msg+="\n" + getString(R.string.total, NumberFormat.getCurrencyInstance().format(price));
        msg+= "\n"+getString(R.string.thanks);
        return msg;
    }
}