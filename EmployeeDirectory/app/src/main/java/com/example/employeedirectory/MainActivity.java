package com.example.employeedirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.employeedirectory.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
static EmployeeDatabase database;
EmployeeEntity entity;
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        database= Room.databaseBuilder(this,EmployeeDatabase.class,"srm")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        entity=new EmployeeEntity();
        entity.setEmpName(binding.etEmpName.getText().toString());
        entity.setEmpId(binding.etEmpId.getText().toString());
        entity.setEmpAddress(binding.etEmpaddress.getText().toString());
        entity.setEmpSalary(binding.etEmpSalary.getText().toString());
        database.employeeDAO().insert(entity);
        Toast.makeText(this, "insert success \n"+
                binding.etEmpName.getText().toString(), Toast.LENGTH_SHORT).show();


    }

    public void retriveData(View view) {
    }
}