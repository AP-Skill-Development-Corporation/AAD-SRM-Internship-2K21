package com.example.employeedirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.employeedirectory.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
ActivityUpdateBinding updateBinding;
EmployeeEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       updateBinding= DataBindingUtil.setContentView(this,R.layout.activity_update);
    updateBinding.etEmpNameUpdate.setText(getIntent().getStringExtra("name_key"));
    updateBinding.etEmpaddressUpdate.setText(getIntent().getStringExtra("address_key"));
    updateBinding.etEmpSalaryUpdate.setText(getIntent().getStringExtra("salary_key"));
    updateBinding.etEmpIdUpdate.setText(getIntent().getStringExtra("id_key"));


    }

    public void updateData(View view) {
        entity=new EmployeeEntity();
        entity.setEmpName(updateBinding.etEmpNameUpdate.getText().toString());
        entity.setEmpSalary(updateBinding.etEmpSalaryUpdate.getText().toString());
        entity.setEmpAddress(updateBinding.etEmpaddressUpdate.getText().toString());
        entity.setEmpId(updateBinding.etEmpIdUpdate.getText().toString());
       // MainActivity.database.employeeDAO().update(entity);
        MainActivity.viewModel.update(entity);
        Toast.makeText(this, "updated :"+updateBinding.etEmpNameUpdate.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}