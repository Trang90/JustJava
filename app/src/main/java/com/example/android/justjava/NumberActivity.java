package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
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
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener () {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();

        }
    };

    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
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
                releaseMediaPlayer();
//                mMediaPlayer = MediaPlayer.create(NumberActivity.this, word.getMediaPlayerId());
//                mMediaPlayer.start();
//
//                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.
                    mMediaPlayer = MediaPlayer.create(NumberActivity.this, word.getMediaPlayerId());

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
        if (mMediaPlayer !=null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }

}