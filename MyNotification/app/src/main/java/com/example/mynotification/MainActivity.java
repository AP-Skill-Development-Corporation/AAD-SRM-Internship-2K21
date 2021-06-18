package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NotificationManager manager;
NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        myNotificationChannel();
    }

    private void myNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel cn=new NotificationChannel("MYCHANNEL","srm",
                    NotificationManager.IMPORTANCE_HIGH);
            cn.enableLights(true);
            cn.enableVibration(true);
            cn.setLightColor(Color.BLUE);
            manager.createNotificationChannel(cn);

        }
    }

    public void showNotification(View view) {
        builder=new NotificationCompat.Builder(this,"MYCHANNEL");
        builder.setContentTitle("My own Notification");
        builder.setContentText("This my notifation from AAD Internship");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setPriority(Notification.PRIORITY_HIGH);
        manager.notify(123,builder.build());
    }
}