package com.example.jack.tapjam;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonElement;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import microsoft.aspnet.signalr.client.Action;
import microsoft.aspnet.signalr.client.ErrorCallback;
import microsoft.aspnet.signalr.client.MessageReceivedHandler;
import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.transport.LongPollingTransport;

/**
 * Created by Srujan on 4/9/2016.
 */
public class GetSounds extends IntentService {

    private HubConnection connection;
    private HubProxy hub;
    private SignalRFuture<Void> _awaitConnection;

    public GetSounds() {
        super("GetSounds");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("inside", "handle");
        Platform.loadPlatformComponent(new AndroidPlatformComponent());
        // Change to the IP address and matching port of your SignalR server.
//        String host = "http://192.168.0.xxx:8080";
        connection = new HubConnection("http://tapjam.azurewebsites.net");
        hub = connection.createHubProxy( "TapJam" );

        hub.subscribe(new Object() {
            @SuppressWarnings("unused")
            public void messageReceived(String name, String message) {
                System.out.println(name + ": " + message);
            }
        });

        // Subscribe to the error event
        connection.error(new ErrorCallback() {

            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });

        // Subscribe to the connected event
        connection.connected(new Runnable() {

            @Override
            public void run() {
                System.out.println("CONNECTED");
            }
        });

        // Subscribe to the closed event
        connection.closed(new Runnable() {

            @Override
            public void run() {
                System.out.println("DISCONNECTED");
            }
        });

        // Start the connection
//        connection.start()
//                .done(new Action<Void>() {
//
//                    @Override
//                    public void run(Void obj) throws Exception {
//                        Log.d("connect", "Done Connecting!");
//                    }
//                });

        // Subscribe to the received event
        connection.received(new MessageReceivedHandler() {

            @Override
            public void onMessageReceived(JsonElement json) {
                System.out.println("RAW received message: " + json.toString());
            }
        });

        startConnection();

        while(true){

        }
    }
    private void startConnection(){
        _awaitConnection = connection.start(new LongPollingTransport(connection.getLogger()));
//you can do here a while loop for reintents or something ( this is a good practices, at least 3 tries.
        try {
            _awaitConnection.get(2000, TimeUnit.MILLISECONDS);

        } catch (InterruptedException e) {
            System.out.println("Disconnect . . .");
        } catch (ExecutionException e) {
            System.out.println("Error . . .");
        }catch(Exception e){}
    }


}
