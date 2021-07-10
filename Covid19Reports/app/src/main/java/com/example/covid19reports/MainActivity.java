package com.example.covid19reports;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.covid19reports.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
ProgressDialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        if (!isNetworkConnected()){
            Toast.makeText(this, "no internet", Toast.LENGTH_SHORT).show();
        }else {

            dialog = new ProgressDialog(this);
            dialog.setTitle("Please Wait..!");
            dialog.setMessage("Loading..!");
            dialog.show();
            EndPointInterface pointInterface = RetrofitInstance.getRetrofit()
                    .create(EndPointInterface.class);
            Call<String> c = pointInterface.getData();
            c.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.i("MainActivity", response.body());
                    dialog.dismiss();
                    try {
                        JSONArray rootAry = new JSONArray(response.body());
                        JSONObject obj = rootAry.getJSONObject(rootAry.length() - 1);
                        String resDate = obj.getString("Date");
                        String resCountry = obj.getString("Country");
                        String resConfirmed = obj.getString("Confirmed");
                        String resDeaths = obj.getString("Deaths");
                        String resRecovered = obj.getString("Recovered");
                        String resActive = obj.getString("Active");
                        binding.tvDate.setText("Date :" + properDate(resDate));
                        binding.tvCountry.setText("Country :" + resCountry);
                        binding.tvDeath.setText("Deaths :" + resDeaths);
                        binding.tvConfirmed.setText("Confirmed :" + resConfirmed);
                        binding.tvRecovred.setText("Recovered :" + resRecovered);
                        binding.tvAcitive.setText("Active :" + resActive);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "faild for Loading..", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    private String properDate(String resDate) {
        String inputPattern="yy-mm-dd";
        String outputPattern="dd-mm-yy";

        SimpleDateFormat inputFormat=new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat=new SimpleDateFormat(outputPattern);
        Date d=null;
        String str=null;
        try {
            d=inputFormat.parse(resDate);
            str=outputFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}