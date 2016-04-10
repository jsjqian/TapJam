package com.example.jack.tapjam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.concurrent.ExecutionException;

import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler;

public class MainActivity extends Activity {
    public Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton start = (ImageButton)findViewById(R.id.start_button);
        Log.d("before initialize", "1");
        Intent external_sounds = new Intent(Intent.ACTION_SYNC, null, this, GetSounds.class);
        startService(external_sounds);
        PlaySounds.context = getApplicationContext();
        Intent play_sounds = new Intent(Intent.ACTION_SYNC, null, this, PlaySounds.class);
        startService(play_sounds);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateSessionActivity.class);
                startActivity(intent);
            }
        });
    }
    public void PlayAudio(int audio)
    {
        final int a = audio;
        handler.post(new Runnable(){
            @Override
            public void run() {
                //send the int to where it needs to go
                //and play audio
            }});
    }
    public void UpdateStatus( String status )
    {
        final String fStatus = status;
        handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println(fStatus);
            }
        });
    }


}
