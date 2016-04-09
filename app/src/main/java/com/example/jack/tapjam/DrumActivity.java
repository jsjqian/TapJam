package com.example.jack.tapjam;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DrumActivity extends Activity {


    private ImageButton snare;
    private ImageButton hihat;
    private ImageButton kick;
    private ImageButton clap;

    MediaPlayer snare_sound;
    MediaPlayer hihat_sound;
    MediaPlayer kick_sound;
    MediaPlayer clap_sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drum);



        snare = (ImageButton) findViewById(R.id.snare);
        hihat = (ImageButton) findViewById(R.id.hihat);
        kick = (ImageButton) findViewById(R.id.kick);
        clap = (ImageButton) findViewById(R.id.clap);


        clap_sound = MediaPlayer.create(getApplicationContext(), R.raw.clap);
        kick_sound = MediaPlayer.create(getApplicationContext(), R.raw.kick);
        hihat_sound = MediaPlayer.create(getApplicationContext(), R.raw.hihat);
        snare_sound = MediaPlayer.create(getApplicationContext(), R.raw.snare);

        snare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    snare_sound.setDataSource("../raw/snare.wav");
                    snare_sound.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                snare_sound.start();


            }
        });

        hihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    hihat_sound.setDataSource("../raw/hihat.wav");
                    hihat_sound.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                hihat_sound.start();

            }
        });

        kick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    kick_sound.setDataSource("../raw/kick.wav");
                    kick_sound.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                kick_sound.start();

            }
        });

        clap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    clap_sound.setDataSource("../raw/clap.wav");
                    clap_sound.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clap_sound.start();

            }
        });
    }

}
