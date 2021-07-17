package com.example.attendancedashboard;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.widget.Toolbar;


public class ModuleDashboardActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void lecture(View view) {
        startActivity(new Intent(this, LectureDashboardActivity.class));
    }

    public void student(View view) {
        startActivity(new Intent(this, StudentDashboardActivity.class));
    }

    public void attendance(View view) {
        startActivity(new Intent(this, AttendanceDashboardActivity.class));
    }

}
