package com.example.mynotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static android.content.Context.NOTIFICATION_SERVICE;

public class SingleTimeWorker extends Worker {
    NotificationManager manager;
    NotificationCompat.Builder builder;
    PendingIntent pi;
    Intent i;

    public SingleTimeWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        manager= (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        i=new Intent(getApplicationContext(),MainActivity.class);
        pi=PendingIntent.getActivity(getApplicationContext(),123,i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        myNotificationChannel();
        showNotification();

        return null;
    }
    public void showNotification() {
        builder=new NotificationCompat.Builder(getApplicationContext(),"MYCHANNEL");
        builder.setContentTitle("My own Notification");
        builder.setContentText("This my notifation from AAD Internship");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_reply_24,"Reply",pi);
        Bitmap bitmap= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kotlin_vs_java);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        manager.notify(123,builder.build());
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
}
