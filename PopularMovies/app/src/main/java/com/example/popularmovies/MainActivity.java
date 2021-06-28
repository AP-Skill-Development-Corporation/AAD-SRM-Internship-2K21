package com.example.popularmovies;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.popularmovies.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching Movies..");
        dialog.setMessage("Please Wait..Loading");
        dialog.show();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        EndPointInterface ie = MovieInstance.getMoviesInstance().create(EndPointInterface.class);
        Call<List<ResultsItem>> c = ie.getAllData();
        c.enqueue(new Callback<List<ResultsItem>>() {
            @Override
            public void onResponse(Call<List<ResultsItem>> call, Response<List<ResultsItem>> response) {
                dialog.dismiss();
                Log.i("data", String.valueOf(response.body()));
                MoviesAdapter adapter = new MoviesAdapter(MainActivity.this, response.body());
                binding.recyler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                binding.recyler.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ResultsItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "faild ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}