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

    //chuyển MediaPlayer.OnCompletionListener thành hàm global
    private  MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ngắt nhạc đang chơi để play lại
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.hange);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mOnCompletionListener); // release nhạc sau khi hết
            }
        });

        binding.pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

    }

    private void releaseMediaPlayer (){
        if (mediaPlayer!=null){
            mediaPlayer.release(); // giải phòng vì ko cần nữa
            mediaPlayer=null; // set về null để ko chơi nhạc nữa
        }
    }
}


