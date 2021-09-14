package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.android.justjava.databinding.ActivityNumberBinding;


import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private ActivityNumberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Word> phrase = new ArrayList<>();
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));
        phrase.add(new Word("Hello", "Hallo"));

        WordsAdapter adapter = new WordsAdapter(this, phrase, R.color.category_phrases);
        binding.numberGridView.setAdapter(adapter);
    }
}