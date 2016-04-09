package com.example.jack.tapjam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Synth extends Activity {

    ImageButton b1, b2, b3, b4, b5, b6, b7, b8;
    LinearLayout L;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_synth);
        b1 = (ImageButton) findViewById(R.id.imageButton1);
        b1.setClickable(false);
        b2 = (ImageButton) findViewById(R.id.imageButton2);
        b2.setClickable(false);
        b3 = (ImageButton) findViewById(R.id.imageButton3);
        b3.setClickable(false);
        b4 = (ImageButton) findViewById(R.id.imageButton4);
        b4.setClickable(false);
        b5 = (ImageButton) findViewById(R.id.imageButton5);
        b5.setClickable(false);
        b6 = (ImageButton) findViewById(R.id.imageButton6);
        b6.setClickable(false);
        b7 = (ImageButton) findViewById(R.id.imageButton7);
        b7.setClickable(false);
        b8 = (ImageButton) findViewById(R.id.imageButton8);
        b8.setClickable(false);
        L = (LinearLayout) findViewById(R.id.layout);

        L.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

//                if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
//                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f1);
//                    mp.start();
//                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                        public void onCompletion(MediaPlayer mp) {
//                            mp.release();
//                        }
//                    });
                int width = v.getWidth();
//                int height = v.getHeight();
                float x = event.getX();
//                float y = event.getY();
                String msg;
                if (x < width / 8) {
                    sound1(v);
                }
                else if(width/8 < x && x < width/4) {
                    sound2(v);
                }
                else if(width/4 < x && x < 3*width/8) {
                    sound3(v);
                }
                else if(3*width/8 < x && x < width/2) {
                    sound4(v);
                }
                else if(width/2 < x && x < 5*width/8) {
                    sound5(v);
                }
                else if(5*width/8 < x && x < 3*width/4) {
                    sound6(v);
                }
                else if(3*width/4 < x && x < 7*width/8) {
                    sound7(v);
                }
                else if(7*width/8 < x) {
                    sound8(v);
                }
                return false;
            }
        });
    }

    public void sound1(View v) {

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f1);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

    }

    public void sound2(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f2);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

    }

    public void sound3(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f3);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

    }

    public void sound4(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f4);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

    }

    public void sound5(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f5);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

    }

    public void sound6(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f6);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void sound7(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f7);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void sound8(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.f7);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

}
