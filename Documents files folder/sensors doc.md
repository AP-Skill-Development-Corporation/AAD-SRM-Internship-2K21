# Sensors in ANdroid 

## build.gradle(app)
```XML
/ sensy API
    implementation 'com.github.nisrulz:sensey:1.8.0'
```



## activity_main.xml
```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp"
    tools:context=".MainActivity">

    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/shake"
        android:text="Shake Sensor"
        android:textSize="25sp"/>
    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/light"
        android:text="Light Sensor"
        android:textSize="25sp"/>
    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/touch"
        android:text="Touch Sensor"
        android:textSize="25sp"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="No Sensor Detected"
        android:textSize="30sp"
        android:textColor="#0321C5"
        android:gravity="center"
        android:id="@+id/mysensor"/>


</LinearLayout>
```

## MainAcitivty.java
```JAVA
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.github.nisrulz.sensey.LightDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;
import com.github.nisrulz.sensey.TouchTypeDetector;

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

        /*Shake Sensor*/
        final ShakeDetector.ShakeListener shakeListener = new ShakeDetector.ShakeListener() {
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

        /*Implement On CLick Listiner for SWITCH*/

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Sensey.getInstance().startShakeDetection(shakeListener);
                }else {
                    Sensey.getInstance().stopShakeDetection(shakeListener);
                }
            }
        });


        /*Light Sensor*/

        final LightDetector.LightListener lightListener = new LightDetector.LightListener() {
            @Override
            public void onDark() {
                tv.setText("It is Dark Room");
            }

            @Override
            public void onLight() {
                tv.setText("It is Light Room");
            }
        };

        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Sensey.getInstance().startLightDetection(lightListener);
                }else {
                    Sensey.getInstance().stopLightDetection(lightListener);
                }
            }
        });

        /*Touch Sensor*/

        final TouchTypeDetector.TouchTypListener touchTypListener = new TouchTypeDetector.TouchTypListener() {
            @Override
            public void onDoubleTap() {
                tv.setText("Double Tap");
            }

            @Override
            public void onLongPress() {
                tv.setText("Long Press");
            }

            @Override
            public void onScroll(int i) {
                tv.setText("Scroll");
            }

            @Override
            public void onSingleTap() {
                tv.setText("Single Tap");
            }

            @Override
            public void onSwipe(int i) {
                tv.setText("Swipe");
            }

            @Override
            public void onThreeFingerSingleTap() {
                tv.setText("Three Fingers Single Tap");
            }

            @Override
            public void onTwoFingerSingleTap() {
                tv.setText("Two Fingers Single Tap");
            }
        };

        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Sensey.getInstance().startTouchTypeDetection(MainActivity.this,touchTypListener);
                }else {
                    Sensey.getInstance().stopTouchTypeDetection();
                }
            }
        });
    }

    /*This is Important*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Sensey.getInstance().setupDispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*To Stop your Sensor*/
        Sensey.getInstance().stop();
    }
}

```
## [Sound effects link](https://www.zapsplat.com/sound-effect-categories/)
