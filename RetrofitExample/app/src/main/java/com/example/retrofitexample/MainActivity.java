package com.example.retrofitexample;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    /*TextView date, coutry, confirmed, active, deaths, recovered;*/
    ProgressDialog dialog;
RecyclerView rv;
RecyclerDateAdapter dateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Data Fetching..");
        dialog.setMessage("Please Wait ...");
        rv=findViewById(R.id.rec);

//        date = findViewById(R.id.tv_date);
//        coutry = findViewById(R.id.country);
//        confirmed = findViewById(R.id.confirmed);
//        active = findViewById(R.id.active);
//        deaths = findViewById(R.id.death);
//        recovered = findViewById(R.id.recoverd);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null) {
            //Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert..!");
        builder.setMessage("Please check your internet connection..then proceed");
        builder.setIcon(R.drawable.ic_warning_black_24dp);
        builder.show();
        } else {
            dialog.show();

            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            /*dialog = ProgressDialog.show(WelcomePage.this, "", "Loading...", true,false);
            new Welcome_Page().execute();*/

            EndpointInterface ei = RetrofitInstance.getRetrofit().create(EndpointInterface.class);
            Call<List<Repo>> c=ei.getData();
            c.enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                 dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Total Days : "+
                            response.body().size(), Toast.LENGTH_SHORT).show();
                 dateAdapter=new RecyclerDateAdapter(getApplicationContext(),response.body());
                 LinearLayoutManager lm=new LinearLayoutManager(getApplicationContext());
                 lm.setReverseLayout(true);
                 lm.setStackFromEnd(true);
                 rv.setLayoutManager(lm);
                 rv.setAdapter(dateAdapter);
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {

                }
            });

        }

    }

    private String properDateFormat(String resDate) {
        String inputPattern = "yy-mm-dd";
        String outputPattern = "dd-mm-yy";
        SimpleDateFormat inputDate = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputDate = new SimpleDateFormat(outputPattern);
        Date d = null;
        String str = null;
        try {
            d = inputDate.parse(resDate);
            str = outputDate.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

}
