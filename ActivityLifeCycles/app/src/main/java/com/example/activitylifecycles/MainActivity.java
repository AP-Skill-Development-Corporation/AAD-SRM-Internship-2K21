package com.example.activitylifecycles;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.activitylifecycles.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    /*1.onCreate()
     * 2.onStart()
     * 3.onResume()
     * 4.onPause()
     * 5.onStop()
     * 6.onRestart()
     * 7.onDestroy()*/
    /*In java overriding and overLoading*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.tv.append("onCreate()\n");
        Log.i("hello", "onCreate()");
        Toast.makeText(this, "App is Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.tv.append("onStart()\n");
        Log.i("hello", "onStart()");
        Toast.makeText(this, "App is Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.tv.append("onResume()\n");
        Log.i("hello", "onResume()");
        Toast.makeText(this, "App is Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.tv.append("onPause()\n");
        Log.i("hello", "onPause()");
        Toast.makeText(this, "App is Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        binding.tv.append("onStop()\n");
        Log.i("hello", "onStop()");
        Toast.makeText(this, "App is Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        binding.tv.append("onReStart()\n");
        Log.i("hello", "onReStart()");
        Toast.makeText(this, "App is ReStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.tv.append("onDestroy()\n");
        Log.i("hello", "onDestroy()");
        Toast.makeText(this, "App is Destroyed", Toast.LENGTH_SHORT).show();
    }
}