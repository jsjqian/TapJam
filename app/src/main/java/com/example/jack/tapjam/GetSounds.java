package com.example.jack.tapjam;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.concurrent.ExecutionException;

import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;

/**
 * Created by Srujan on 4/9/2016.
 */
public class GetSounds extends Service {

    @Nullable
    static HubConnection connection;
    static HubProxy hub;
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flag, int startId) {
        handleCommand(intent);
        return START_STICKY;
    }

    private void handleCommand(Intent intent) {
        Platform.loadPlatformComponent(new AndroidPlatformComponent());
// Change to the IP address and matching port of your SignalR server.
        String host = "http://tapjam2016.azurewebsites.net/";
        connection = new HubConnection( host );
        hub = connection.createHubProxy( "ChatHub" );
        SignalRFuture<Void> awaitConnection = connection.start();
        try {
            awaitConnection.get();
        } catch (InterruptedException e) {
            // Handle ...
        } catch (ExecutionException e) {
            // Handle ...
        }

    }


}
