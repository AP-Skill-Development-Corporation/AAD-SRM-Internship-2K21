package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;

public class MainActivity extends AppCompatActivity {
    Switch s1,s2,s3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.shake);
        s2 = findViewById(R.id.light);
        s3 = findViewById(R.id.touch);
        tv = findViewById(R.id.mysensor);

        /*intialize sensor*/
        Sensey.getInstance().init(MainActivity.this);
    /*Shake sensor*/
        final ShakeDetector.ShakeListener shakeListener=new ShakeDetector.ShakeListener() {
            @Override
            public void onShakeDetected() {
                // implement your own functionality
                tv.setText("Shake Sensor Detected");
            }

            @Override
            public void onShakeStopped() {
                tv.setText("Shake Sensor Stopped");
            }
        };
    }
}