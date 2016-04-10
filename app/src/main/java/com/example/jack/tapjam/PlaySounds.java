package com.example.jack.tapjam;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.ExecutionException;

import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler1;


/**
 * Created by Jack on 4/10/2016.
 */
public class PlaySounds extends Service {
    public static Context context;

    public IBinder onBind(Intent intent) {
        return null;
    }
    public int onStartCommand(Intent intent, int flag, int startId) {
        handleCommand(intent);
        return START_STICKY;
    }

    private void handleCommand(Intent intent) {
        GetSounds.hub.on( "broadcastMessage", new SubscriptionHandler1<String>() {
            @Override
            public void run(String msg) {
                Log.d("result := ", msg);
            }
        }, String.class);
        int sound = 0;

            if (sound == 1) {
                MediaPlayer mp = MediaPlayer.create(context, R.raw.snare);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 2) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.hihat);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 3) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.kick);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 4) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.clap);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 11) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f1);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 12) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f2);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 13) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f3);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 14) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f4);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 15) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f5);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 16) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f6);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 17) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f7);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 18) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.f1);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 21) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano1);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 22) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano2);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 23) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano3);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 24) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano4);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 25) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano5);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 26) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano6);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 27) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano7);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else if (sound == 28) {

                MediaPlayer mp = MediaPlayer.create(context, R.raw.piano8);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            }
            sound = 0;

    }
}
