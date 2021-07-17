package com.example.attendancedashboard;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                android.os.Process.killProcess(android.os.Process.myPid());
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
