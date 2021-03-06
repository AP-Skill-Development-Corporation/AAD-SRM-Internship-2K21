package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
/*NotificationManager manager;
NotificationCompat.Builder builder;
PendingIntent pi;
Intent i;*/
OneTimeWorkRequest oneTimeWorkRequest;
PeriodicWorkRequest periodicWorkRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       oneTimeWorkRequest=new OneTimeWorkRequest.Builder(SingleTimeWorker.class).build();
periodicWorkRequest=new PeriodicWorkRequest
        .Builder(MyPeriodicWorkRequest.class,
        15, TimeUnit.MINUTES).build();

        /*manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        i=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,123,i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        myNotificationChannel();*/
    }

    /*private void myNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel cn=new NotificationChannel("MYCHANNEL","srm",
                    NotificationManager.IMPORTANCE_HIGH);
            cn.enableLights(true);
            cn.enableVibration(true);
            cn.setLightColor(Color.BLUE);
            manager.createNotificationChannel(cn);

        }
    }*/

    public void showNotification(View view) {
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
    WorkManager.getInstance(this).enqueue(periodicWorkRequest);
     /*   builder=new NotificationCompat.Builder(this,"MYCHANNEL");
        builder.setContentTitle("My own Notification");
        builder.setContentText("This my notifation from AAD Internship");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setPriority(Notification.PRIORITY_HIGH);
       builder.setContentIntent(pi);
       builder.addAction(R.drawable.ic_baseline_reply_24,"Reply",pi);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.kotlin_vs_java);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        manager.notify(123,builder.build());*/
    }

    public void stopMymusic(View view) {
        Intent myintent=new Intent(this,MyMusicService.class);
        stopService(myintent);
    }

    public void startMyMusic(View view) {
        Intent myintent=new Intent(this,MyMusicService.class);
        startService(myintent);
    }
}