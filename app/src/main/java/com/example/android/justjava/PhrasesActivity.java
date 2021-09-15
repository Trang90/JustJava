package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.android.justjava.databinding.ActivityNumberBinding;
import com.example.android.justjava.family.FamilyActivity;


import java.lang.ref.PhantomReference;
import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private ActivityNumberBinding binding;
private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final ArrayList<Word> phrase = new ArrayList<>();
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));
        phrase.add(new Word("Hello", "Hallo", R.raw.phrase_are_you_coming));

        WordsAdapter adapter = new WordsAdapter(this, phrase, R.color.category_phrases);
        binding.numberGridView.setAdapter(adapter);

        binding.numberGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word phrases = phrase.get(position);
                mMediaPlayer= MediaPlayer.create(PhrasesActivity.this, phrases.getMediaPlayerId());
                mMediaPlayer.start();

            }
        });
    }
}