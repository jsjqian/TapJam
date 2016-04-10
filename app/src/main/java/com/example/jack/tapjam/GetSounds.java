package com.example.jack.tapjam;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;

/**
 * Created by Srujan on 4/9/2016.
 */
public class GetSounds extends Service {


    @Nullable
    @Override
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
        String host = "http://192.168.0.xxx:8080";
        HubConnection connection = new HubConnection( host );
        HubProxy hub = connection.createHubProxy( "ChatHub" );
    }


}
