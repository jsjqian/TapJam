package com.example.jack.tapjam;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        handler = new Handler();

        Platform.loadPlatformComponent(new AndroidPlatformComponent());
        // Change to the IP address and matching port of your SignalR server.
        String host = "http://tapjam2016.azurewebsites.net/";
        HubConnection connection = new HubConnection( host );
        HubProxy hub = connection.createHubProxy( "ChatHub" );
        hub.on("PlayAudio", new SubscriptionHandler() {
            @Override
            public void run() {

            }
        });
        //actually synchronously setting up the connection
        SignalRFuture<Void> awaitConnection = connection.start();
        try {
            awaitConnection.get();
            System.out.println("reached pass awaitconnection");
        } catch (InterruptedException e) {
            // Handle ...
            Log.d("InterruptedException", e.toString());
        } catch (ExecutionException e) {
            // Handle ...
            Log.d("ExecutionException", e.toString());
        }

        try {
            hub.invoke( "SendMessage", "Client", "Hello world!" ).get();

        } catch (InterruptedException e) {
            // Handle ...
        } catch (ExecutionException e) {
            // Handle ...
        }

        //setting up listener/handler
        hub.subscribe(this);
        Button start = (Button)findViewById(R.id.start_button);
        Log.d("before initialize", "1");
        Intent external_sounds = new Intent(Intent.ACTION_SYNC, null, this, GetSounds.class);
        startService(external_sounds);

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
        handler.post(new Runnable(){
            @Override
            public void run() {
                System.out.println(fStatus);
            }});
    }


}
