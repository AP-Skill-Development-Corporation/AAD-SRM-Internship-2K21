package com.example.mygraphs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mygraphs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }




    public void pichart(View view) {
        String s1 = binding.value1.getText().toString();
        String s2 = binding.value2.getText().toString();
        String s3 = binding.value3.getText().toString();
        String s4 = binding.value4.getText().toString();
        String s5 = binding.value5.getText().toString();


        Intent intent = new Intent(this,PieChartActiivty.class);
        intent.putExtra("key1",s1);
        intent.putExtra("key2",s2);
        intent.putExtra("key3",s3);
        intent.putExtra("key4",s4);
        intent.putExtra("key5",s5);
        startActivity(intent);
    }

    public void bargraph(View view) {
        String s1 = binding.value1.getText().toString();
        String s2 = binding.value2.getText().toString();
        String s3 = binding.value3.getText().toString();
        String s4 = binding.value4.getText().toString();
        String s5 = binding.value5.getText().toString();
        Intent i = new Intent(this,BarGraphActivity.class);
        i.putExtra("key1",s1);
        i.putExtra("key2",s2);
        i.putExtra("key3",s3);
        i.putExtra("key4",s4);
        i.putExtra("key5",s5);
        startActivity(i);
    }
}