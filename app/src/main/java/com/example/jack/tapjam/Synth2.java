package com.example.jack.tapjam;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Synth2 extends Activity {

    ImageButton b1, b2, b3, b4, b5, b6, b7, b8;
    LinearLayout L1, L2, L3, L4, L5, L6, L7, L8;
    private float x1 = 0;
    private float x2 = 0;
    private float y1 = 0;
    private float y2 = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int condition;
        try {
            condition = getIntent().getIntExtra("transition", 0);
//            condition = getIntent().getExtras().getInt("transition");
        }catch (NullPointerException e){
            condition = 0;
        }
        System.out.println(condition);

        if (condition < 0){
            overridePendingTransition(R.anim.slide_in1, R.anim.slide_out1);
        }
        else {
            overridePendingTransition(R.anim.slide_out2, R.anim.slide_in2);
        }

        setContentView(R.layout.activity_synth2);
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
        L1 = (LinearLayout) findViewById(R.id.L1);
        L2 = (LinearLayout) findViewById(R.id.L2);
        L3 = (LinearLayout) findViewById(R.id.L3);
        L4 = (LinearLayout) findViewById(R.id.L4);
        L5 = (LinearLayout) findViewById(R.id.L5);
        L6 = (LinearLayout) findViewById(R.id.L6);
        L7 = (LinearLayout) findViewById(R.id.L7);
        L8 = (LinearLayout) findViewById(R.id.L8);

    }

    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        View v = (LinearLayout) findViewById(R.id.layout);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                x1 = event.getX();
                y1 = event.getY();
                int width = v.getWidth();
//                int height = v.getHeight();
                float x = event.getX();
//                float y = event.getY();
                String msg;
                if (x < width / 8) {
                    sound1(v);
                } else if (width / 8 < x && x < width / 4) {
                    sound2(v);
                } else if (width / 4 < x && x < 3 * width / 8) {
                    sound3(v);
                } else if (3 * width / 8 < x && x < width / 2) {
                    sound4(v);
                } else if (width / 2 < x && x < 5 * width / 8) {
                    sound5(v);
                } else if (5 * width / 8 < x && x < 3 * width / 4) {
                    sound6(v);
                } else if (3 * width / 4 < x && x < 7 * width / 8) {
                    sound7(v);
                } else if (7 * width / 8 < x) {
                    sound8(v);
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int width = v.getWidth();
//                int height = v.getHeight();
                float x = event.getX();
//                float y = event.getY();
                String msg;
                if (x < width / 8) {
                    sound1(v);
                } else if (width / 8 < x && x < width / 4) {
                    sound2(v);
                } else if (width / 4 < x && x < 3 * width / 8) {
                    sound3(v);
                } else if (3 * width / 8 < x && x < width / 2) {
                    sound4(v);
                } else if (width / 2 < x && x < 5 * width / 8) {
                    sound5(v);
                } else if (5 * width / 8 < x && x < 3 * width / 4) {
                    sound6(v);
                } else if (3 * width / 4 < x && x < 7 * width / 8) {
                    sound7(v);
                } else if (7 * width / 8 < x) {
                    sound8(v);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                x2 = event.getX();
                y2 = event.getY();
                if (Math.abs(y2 - y1) > 300) {
                    Intent mainIntent = new Intent(getApplicationContext(), Synth.class);
//                            mainIntent.putExtra("id", "1");
                    int test = (int)(y2-y1);
                    mainIntent.putExtra("transition", test);
                    //SplashScreen.this.startActivity(mainIntent);
                    startActivity(mainIntent);
                }
                break;
            }
        }
        return true;
    }

    public void sound1(View v) {
        L1.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano1);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L1.setPressed(false);
            }
        });

    }

    public void sound2(View v) {
        L2.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano2);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L2.setPressed(false);

            }
        });

    }

    public void sound3(View v) {
        L3.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano3);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L3.setPressed(false);
            }
        });

    }

    public void sound4(View v) {
        L4.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano4);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L4.setPressed(false);
            }
        });

    }

    public void sound5(View v) {
        L5.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano5);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L5.setPressed(false);
            }
        });

    }

    public void sound6(View v) {
        L6.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano6);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L6.setPressed(false);
            }
        });
    }

    public void sound7(View v) {
        L7.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano7);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L7.setPressed(false);

            }
        });
    }

    public void sound8(View v) {
        L8.setPressed(true);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.piano8);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                L8.setPressed(false);
            }
        });
    }

}
