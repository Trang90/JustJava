package com.example.android.justjava.color;

import android.content.Context;
import android.media.AudioManager;
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

    private AudioManager mAudioManager;



    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mMediaPlayer.release();

        }
    };

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK && mMediaPlayer != null) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);} else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


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
                releaseMediaPlayer();

                //gọi lại audio bị ngừng
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

//we have audio focus now

                    //ko cần dòng này nữa
                //mMediaPlayer = MediaPlayer.create(ColorActivity.this, color.getMediaPlayerId());
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        mMediaPlayer = MediaPlayer.create(ColorActivity.this, color.getMediaPlayerId());

                        // Start the audio file
                        mMediaPlayer.start();

                        // Setup a listener on the media player, so that we can stop and release the
                        // media player once the sound has finished playing.
                        mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                    }

            }

        });


    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

private void releaseMediaPlayer(){
        if (mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer= null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
}
}