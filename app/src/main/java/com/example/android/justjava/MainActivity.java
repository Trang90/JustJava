package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.android.justjava.color.ColorActivity;
import com.example.android.justjava.databinding.ActivityMainBinding;
import com.example.android.justjava.family.FamilyActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NumberActivity.class);
                startActivity(intent);
            }
        });

        binding.colors.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), ColorActivity.class);
                startActivity(intent);
            }
        });

        binding.family.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FamilyActivity.class);
                startActivity(intent);
            }
        });

        binding.phrases.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhrasesActivity.class);
                startActivity(intent);
            }
        });
            }

//    public void openNumberLists (View view) {
//
//        Intent intent = new Intent(this, NumberActivity.class);
//        startActivity(intent);
//
//    }

}


