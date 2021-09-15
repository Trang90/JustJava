package com.example.android.justjava.family;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.android.justjava.R;
import com.example.android.justjava.Word;
import com.example.android.justjava.WordsAdapter;
import com.example.android.justjava.databinding.ActivityNumberBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {


    private ActivityNumberBinding binding;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final ArrayList<Word> family =new ArrayList<>();
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));
        family.add(new Word(R.drawable.family_father,"father", "vater", R.raw.family_father));

        WordsAdapter adapter = new WordsAdapter(this, family, R.color.category_family);
        binding.numberGridView.setAdapter(adapter);

        binding.numberGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word families = family.get(position);
                mMediaPlayer= MediaPlayer.create(FamilyActivity.this, families.getMediaPlayerId());
                mMediaPlayer.start();

            }
        });

    }


}