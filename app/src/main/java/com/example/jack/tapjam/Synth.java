package com.example.jack.tapjam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Synth extends Activity {


    ImageButton b1, b2, b3, b4, b5, b6, b7, b8;

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
    }



    public void sound1(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n1);
        m.start();

    }

    public void sound2(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n2);

        m.start();
    }

    public void sound3(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n3);

        m.start();

    }

    public void sound4(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n4);

        m.start();

    }

    public void sound5(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n5);

        m.start();

    }

    public void sound6(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n6);

        m.start();

    }

    public void sound7(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n7);

        m.start();

    }

    public void sound8(View v) {
        MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.n7);

        m.start();

    }

}
