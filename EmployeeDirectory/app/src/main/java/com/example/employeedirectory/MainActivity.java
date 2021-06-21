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
                .build();
    }

    public void saveData(View view) {
        entity=new EmployeeEntity();
        entity.setEmpName(binding.etEmpName.getEditableText().toString());
        entity.setEmpId(binding.etEmpId.getEditableText().toString());
        entity.setEmpAddress(binding.etEmpaddress.getEditableText().toString());
        entity.setEmpSalary(binding.etEmpSalary.getEditableText().toString());
        database.employeeDAO().insert(entity);
        Toast.makeText(this, "insert success \n"+
                binding.etEmpName.getEditableText().toString(), Toast.LENGTH_SHORT).show();

    }

    public void retriveData(View view) {
    }
}