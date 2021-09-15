package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
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

private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mMediaPlayer.release();
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
                releaseMediaPlayer();

//                mMediaPlayer= MediaPlayer.create(PhrasesActivity.this, phrases.getMediaPlayerId());
//                mMediaPlayer.start();
//                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrases.getMediaPlayerId());

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

    private void releaseMediaPlayer (){
        if(mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }

}