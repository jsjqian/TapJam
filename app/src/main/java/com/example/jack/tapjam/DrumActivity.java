package com.example.jack.tapjam;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DrumActivity extends Activity {
    
    private ImageButton snare;
    private ImageButton hihat;
    private ImageButton kick;
    private ImageButton clap;
    private boolean isRunning = false;

    private Button metronome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drum);

        snare = (ImageButton) findViewById(R.id.snare);
        hihat = (ImageButton) findViewById(R.id.hihat);
        kick = (ImageButton) findViewById(R.id.kick);
        clap = (ImageButton) findViewById(R.id.clap);
        metronome = (Button) findViewById(R.id.metronome);


        snare.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.snare);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

                }
                return true;
            }
        });

        hihat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.hihat);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

                }
                return true;
            }
        });

        kick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.kick);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

                }
                return true;
            }
        });

        clap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.clap);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

                }
                return true;
            }
        });

        metronome.setOnClickListener(new View.OnClickListener() {
            MediaPlayer metro;
            @Override
            public void onClick(View v) {

                if (!isRunning) {
                    metro = MediaPlayer.create(getApplicationContext(), R.raw.metronome);
                    Log.d("ISRUNNING", "Is running is: " + isRunning);
                    metro.start();
                    metro.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    isRunning = true;

                }else{
                    Log.d("ISRUNNING", "Is running is: " + isRunning);
                    metro.release();
                    isRunning = false;
                }
            }
        });
    }

}
