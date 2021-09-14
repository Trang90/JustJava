package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.WorkSource;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.justjava.databinding.ActivityMainBinding;
import com.example.android.justjava.databinding.ActivityNumberBinding;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
    private ActivityNumberBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("one", "eins"));
        words.add(new Word("two", "zwei"));
        words.add(new Word("three", "drei"));
        words.add(new Word("four", "vier"));
        words.add(new Word("five", "fuenf"));
        words.add(new Word("six", "sechs"));
        words.add(new Word("seven", "sieben"));
        words.add(new Word("eight", "acht"));
        words.add(new Word("nine", "neun"));
        words.add(new Word("ten", "zehn"));
        Log.v("numberActivity", "number at this position is" + words.get(0));

//        int index =0 ;
//        while (index<words.size()){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            binding.numberGridView.addView(wordView);
//            index += 1;
//        }

//        for (int index = 0; index < words.size(); index++){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            binding.numberGridView.addView(wordView);
//        }

        WordsAdapter adapter = new WordsAdapter(this,words);
        binding.numberGridView.setAdapter(adapter);

    }
}