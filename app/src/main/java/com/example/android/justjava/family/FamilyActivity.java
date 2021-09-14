package com.example.android.justjava.family;

import android.os.Bundle;

import com.example.android.justjava.Word;
import com.example.android.justjava.WordsAdapter;
import com.example.android.justjava.databinding.ActivityNumberBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;


import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {


    private ActivityNumberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Word> family =new ArrayList<>();
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));
        family.add(new Word("father", "vater"));

        WordsAdapter adapter = new WordsAdapter(this, family);
        binding.numberGridView.setAdapter(adapter);

    }


}