package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.WorkSource;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justjava.databinding.ActivityMainBinding;
import com.example.android.justjava.databinding.ActivityNumberBinding;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
    private ActivityNumberBinding binding;
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //thêm fianl thì có thể liên kết arraylist này vs lệnh setOnItemClickListener ở dưới
       final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.number_one,"one", "eins", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"two", "zwei", R.raw.number_two));
        words.add(new Word(R.drawable.number_one,"three", "drei", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"four", "vier", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"five", "fuenf", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"six", "sechs", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"seven", "sieben", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"eight", "acht", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"nine", "neun", R.raw.number_one));
        words.add(new Word(R.drawable.number_one,"ten", "zehn", R.raw.number_one));
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

        WordsAdapter adapter = new WordsAdapter(this,words, R.color.category_numbers);
        binding.numberGridView.setAdapter(adapter);

        binding.numberGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NumberActivity.this, "On Item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                Log.v("Number Activity","Current: " + word);
                mMediaPlayer = MediaPlayer.create(NumberActivity.this, word.getMediaPlayerId());
                mMediaPlayer.start();
            }
        });

    }
}