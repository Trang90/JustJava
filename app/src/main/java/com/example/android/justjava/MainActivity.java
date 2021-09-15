package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
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
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaPlayer = MediaPlayer.create(this, R.raw.hange);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        binding.pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

    }
}


