package com.example.androidsensors;

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
    Switch s1, s2, s3;
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
        /*touch sensor*/
        final TouchTypeDetector.TouchTypListener touchTypListenernew = new TouchTypeDetector.TouchTypListener() {
            @Override
            public void onDoubleTap() {
                tv.append("DoubleTaped\n");
            }

            @Override
            public void onLongPress() {
                tv.append("LongPress\n");

            }

            @Override
            public void onScroll(int i) {
                tv.append("onScroll\n");
            }

            @Override
            public void onSingleTap() {
                tv.append("singleTap\n");
            }

            @Override
            public void onSwipe(int i) {
                tv.append("swiping\n");
            }

            @Override
            public void onThreeFingerSingleTap() {
                tv.append("onThreeFingerSingleTap\n");
            }

            @Override
            public void onTwoFingerSingleTap() {
                tv.append("onTwoFingerSingleTap\n");
            }
        };
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Sensey.getInstance().startTouchTypeDetection(MainActivity.this, touchTypListenernew);
                } else {
                    Sensey.getInstance().stopTouchTypeDetection();
                }
            }
        });
        /*Light Sensor*/
        final LightDetector.LightListener lightListener = new LightDetector.LightListener() {
            @Override
            public void onDark() {
                tv.setText("Dark");
            }

            @Override
            public void onLight() {
                tv.setText("Light");
            }
        };
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Sensey.getInstance().startLightDetection(lightListener);
                } else {
                    Sensey.getInstance().stopLightDetection(lightListener);
                }
            }
        });
        /*Shake Sensor*/
        final ShakeDetector.ShakeListener listener = new ShakeDetector.ShakeListener() {
            @Override
            public void onShakeDetected() {
                tv.setText("Shake Detected");
            }

            @Override
            public void onShakeStopped() {
                tv.setText("Shake stopped");

            }
        };
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Sensey.getInstance().startShakeDetection(listener);
                } else {
                    Sensey.getInstance().stopShakeDetection(listener);
                }
            }
        });


    }

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