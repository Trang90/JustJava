package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.android.justjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    int scoreA = 0;
    int scoreB = 0;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.tv1pA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA = scoreA +1;
                displayA(scoreA);
            }
        });

        binding.tv2pA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA = scoreA +2;
                displayA(scoreA);
            }
        });

        binding.tv3pA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA = scoreA +3;
                displayA(scoreA);
            }
        });

        binding.tvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayB(0);
                displayA(0);
            }
        });

        binding.tv1pB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB = scoreB + 1;
                displayB(scoreB);

            }
        });

        binding.tv2pB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB = scoreB + 2;
                displayB(scoreB);

            }
        });

        binding.tv3pB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB = scoreB + 3;
                displayB(scoreB);

            }
        });

    }



    private void displayA (int number){
        binding.tvScoreA.setText("" + number);
    }

    private void displayB (int number){
        binding.tvScoreB.setText("" + number);
    }


}