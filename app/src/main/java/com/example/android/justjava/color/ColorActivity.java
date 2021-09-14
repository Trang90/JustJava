package com.example.android.justjava.color;

import android.os.Bundle;

import com.example.android.justjava.R;
import com.example.android.justjava.Word;
import com.example.android.justjava.WordsAdapter;
import com.example.android.justjava.databinding.ActivityNumberBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import androidx.navigation.ui.AppBarConfiguration;


import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityNumberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word(R.drawable.color_red,"red", "rot"));
        colors.add(new Word(R.drawable.color_red,"red", "rot"));
        colors.add(new Word(R.drawable.color_red,"red", "rot"));
        colors.add(new Word(R.drawable.color_red,"red", "rot"));
        colors.add(new Word(R.drawable.color_red,"red", "rot"));
        colors.add(new Word(R.drawable.color_red,"red", "rot"));
        colors.add(new Word(R.drawable.color_red,"red", "rot"));

        WordsAdapter adapter = new WordsAdapter(this, colors, R.color.category_colors);
        binding.numberGridView.setAdapter(adapter);


    }


}