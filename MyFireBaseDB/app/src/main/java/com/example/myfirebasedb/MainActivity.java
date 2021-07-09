package com.example.myfirebasedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myfirebasedb.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
FirebaseDatabase database;
DatabaseReference reference;
StudentModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
      //  mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);

    database=FirebaseDatabase.getInstance();
    reference=database.getReference("student");

    }

    public void saveData(View view) {
        String name=binding.etUserName.getText().toString();
        String email=binding.etEmail.getText().toString();
        String mobile=binding.etUserMobile.getText().toString();
        if (name.isEmpty()||email.isEmpty()||mobile.isEmpty()){
            Toast.makeText(this, "name,email,mobile cannot empty", Toast.LENGTH_SHORT).show();
        }else {
            model = new StudentModel(name, email, mobile);
            reference.push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(MainActivity.this, "added to firebase ", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void retriveData(View view) {
        startActivity(new Intent(this,DisplayActivity.class));
    }
}