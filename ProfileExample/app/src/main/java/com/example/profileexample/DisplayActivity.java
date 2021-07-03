package com.example.profileexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.profileexample.databinding.ActivityDisplayBinding;
import com.example.profileexample.databinding.ActivityDisplayBindingImpl;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayActivity extends AppCompatActivity {
    DatabaseReference reference;
    ActivityDisplayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_display);
        reference = FirebaseDatabase.getInstance().getReference("Profile");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    MyModel myModel = dataSnapshot.getValue(MyModel.class);
                    Glide.with(DisplayActivity.this)
                            .load(myModel.getImg())
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(binding.siv);
                    binding.sname.setText(myModel.getName());
                    binding.smail.setText(myModel.getMail());
                    binding.sroll.setText(myModel.getRoll());
                    binding.snumber.setText(myModel.getPhone());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DisplayActivity.this,
                        ""+error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void edit(View view) {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("key",binding.sroll.getText().toString());
        startActivity(i);
    }
}