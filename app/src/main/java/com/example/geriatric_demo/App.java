package com.example.geriatric_demo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.parse.Parse;

public class App extends Application {
    public static final String CHANNEL_1_ID ="channel1";
    public static final String CHANNEL_2_ID ="channel2";

    @Override
    public void onCreate() {
        super.onCreate();


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );

        createNotificationChannels();

    }

    private void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID, "channel1", NotificationManager.IMPORTANCE_HIGH);
         channel1.setDescription("alert ");
         NotificationManager manager = getSystemService(NotificationManager.class);
         manager.createNotificationChannel(channel1);

        }
    }
}
