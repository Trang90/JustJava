package com.example.android.justjava.color;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

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
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word(R.drawable.color_red,"red", "rot", R.raw.color_red));
        colors.add(new Word(R.drawable.color_red,"red", "rot", R.raw.color_red));
        colors.add(new Word(R.drawable.color_red,"red", "rot", R.raw.color_red));
        colors.add(new Word(R.drawable.color_red,"red", "rot", R.raw.color_red));
        colors.add(new Word(R.drawable.color_red,"red", "rot", R.raw.color_red));
        colors.add(new Word(R.drawable.color_red,"red", "rot", R.raw.color_red));
        colors.add(new Word(R.drawable.color_red,"red", "rot", R.raw.color_red));

        WordsAdapter adapter = new WordsAdapter(this, colors, R.color.category_colors);
        binding.numberGridView.setAdapter(adapter);

        binding.numberGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word color= colors.get(position);
                mMediaPlayer = MediaPlayer.create(ColorActivity.this, color.getMediaPlayerId());
                mMediaPlayer.start();
            }
        });


    }


}