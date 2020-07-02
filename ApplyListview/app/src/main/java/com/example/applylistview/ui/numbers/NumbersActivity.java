package com.example.applylistview.ui.numbers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.applylistview.Pojo.Word;
import com.example.applylistview.R;
import com.example.applylistview.ui.main.WordAdapter;

import java.util.List;

/*

        MVVM


 */
public class NumbersActivity extends AppCompatActivity {

    ListView listView;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    NumbersViewModel numViewmodel;

    AudioManager.OnAudioFocusChangeListener mOnAudiofocusChangeistener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        listView = findViewById(R.id.list);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // mvvm
        numViewmodel = ViewModelProviders.of(this).get(NumbersViewModel.class);
        numViewmodel.getNumbers();

        numViewmodel.data.observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(final List<Word> words) {

                WordAdapter adapter = new WordAdapter(NumbersActivity.this, (List<Word>) words, R.color.category_numbers);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Word word = words.get(position);
                        releaseMediaPlayer();

                        int result = audioManager.requestAudioFocus(mOnAudiofocusChangeistener, AudioManager.STREAM_MUSIC,
                                AudioManager.AUDIOFOCUS_GAIN);

                        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                            mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudio_id());
                            mediaPlayer.start();

                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    releaseMediaPlayer();
                                }
                            });
                        }
                    }
                });


            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {

        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            audioManager.abandonAudioFocus(mOnAudiofocusChangeistener);

        }
    }
}