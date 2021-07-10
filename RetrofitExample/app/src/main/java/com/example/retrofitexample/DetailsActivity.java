package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {
    TextView date, coutry, confirmed, active, deaths, recovered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
                date = findViewById(R.id.tv_date);
        coutry = findViewById(R.id.country);
        confirmed = findViewById(R.id.confirmed);
        active = findViewById(R.id.active);
        deaths = findViewById(R.id.death);
        recovered = findViewById(R.id.recoverd);
        Intent intent=getIntent();
        String resActive=intent.getStringExtra("a");
        String resDeaths=intent.getStringExtra("dt");
        String resCnf=intent.getStringExtra("cn");
        String resDate=intent.getStringExtra("d");
        String resCountry=intent.getStringExtra("c");
        String resRecover=intent.getStringExtra("r");
        active.setText("Active:"+resActive);
        deaths.setText("Deaths:"+resDeaths);
        confirmed.setText("Confirmed:"+resCnf);
        date.setText("Date:"+properDateFormat(resDate));
        coutry.setText("Country:"+resCountry);
        recovered.setText("Recovered:"+resRecover);
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
