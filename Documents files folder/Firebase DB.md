# Android Firebase DataBase for Data store and Retrive to server
1. Step:Adding dependancys in build.gradle file Module:app

```XML
 implementation 'com.google.firebase:firebase-analytics:19.0.0'
    implementation 'com.google.firebase:firebase-database:20.0.0'
    implementation 'com.google.firebase:firebase-storage:20.0.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    testImplementation 'junit:junit:4.+'
    implementation platform('com.google.firebase:firebase-bom:28.2.0')

```
2. Step:XML file design
```XML

<?xml version="1.0" encoding="utf-8"?>
<layout>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="15dp"
    android:gravity="center"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Registration Form"
        android:gravity="center"
        android:textSize="30sp"
        android:textStyle="bold"

         />
    <ImageView
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:layout_gravity="center"
        android:src="@drawable/ic_launcher_background"
        android:layout_marginTop="15dp"
        android:id="@+id/iv"
        />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/name"
        android:hint="Enter Name"
        android:layout_marginTop="15dp"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/mail"
        android:hint="Enter Mail"
        android:layout_marginTop="15dp"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/number"
        android:hint="Enter Number"
        android:inputType="phone"
        android:layout_marginTop="15dp"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="save"
        android:layout_marginTop="15dp"
        android:onClick="save"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Fetch"
        android:layout_marginTop="15dp"
        android:onClick="fetch"/>


</LinearLayout>
</layout>

```
3. Step: Display the Data design file
```XML
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="9dp"
    tools:context=".DisplayActivity">
    <androidx.recyclerview.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/rv"/>
</androidx.constraintlayout.widget.ConstraintLayout>

```
4. row for recyclerview
```XML
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    app:cardCornerRadius="5dp"
    app:cardBackgroundColor="@color/teal_200"
    android:layout_marginBottom="6dp"

    >
<LinearLayout
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="6dp">

    <ImageView
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_weight="1"
        android:id="@+id/iv"
        android:src="@drawable/ic_launcher_background"
        android:background="@null"/>
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:layout_weight="3">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/name"
            android:textSize="21sp"
            android:text="name"
            android:layout_weight="1"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/mail"
            android:textSize="21sp"
            android:text="mail"
            android:layout_weight="1"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/number"
            android:textSize="21sp"
            android:text="number"
            android:layout_weight="1"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:gravity="center"
        android:orientation="vertical">
        <ImageButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/edit"
            android:background="@null"
            android:layout_weight="1"
            android:src="@drawable/ic_edit"/>
        <ImageButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/del"
            android:layout_weight="1"
            android:background="@null"
            android:src="@drawable/ic_del"/>
    </LinearLayout>

</LinearLayout>
</androidx.cardview.widget.CardView>
``
5. Adapter
```JAVA

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HoldView> {
    Context ct;
    ArrayList<MyModel> list;

    public MyAdapter(Context ct, ArrayList<MyModel> list) {
        this.ct = ct;
        this.list = list;
    }

    @Override
    public HoldView onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new HoldView(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.HoldView holder, int position) {
        Glide.with(ct).load(list.get(position).getImg())
                .placeholder(R.drawable.ic_launcher_background).into(holder.iv);
        holder.name.setText(list.get(position).getName());
        holder.mail.setText(list.get(position).getMail());
        holder.number.setText(list.get(position).getNumber());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("UserData");
                reference.child(list.get(position).getNumber()).removeValue();
                Toast.makeText(ct, "Data Deleted",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HoldView extends RecyclerView.ViewHolder {
        ImageButton edit,del;
        TextView name,mail,number;
        ImageView iv;
        public HoldView(@NonNull View itemView) {
            super(itemView);
            edit = itemView.findViewById(R.id.edit);
            del = itemView.findViewById(R.id.del);
            name = itemView.findViewById(R.id.name);
            mail = itemView.findViewById(R.id.mail);
            number = itemView.findViewById(R.id.number);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
```
6. Model
```JAVA
public class MyModel {
    String img,name,mail,number;

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getNumber() {
        return number;
    }

    public MyModel() {
    }

    public MyModel(String img, String name, String mail, String number) {
        this.img = img;
        this.name = name;
        this.mail = mail;
        this.number = number;
    }
}
```

7. Display Acitivty
```JAVA
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    RecyclerView rv;
    DatabaseReference reference;
    ArrayList<MyModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        rv = findViewById(R.id.rv);
        list = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("UserData");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    MyModel myModel = dataSnapshot.getValue(MyModel.class);
                    list.add(myModel);
                }
                MyAdapter adapter = new MyAdapter(DisplayActivity.this,list);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(DisplayActivity.this));

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(DisplayActivity.this, ""+error,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```
8. MainActivity.java
```JAVA
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.firedb.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    StorageReference storageReference;
    ActivityMainBinding binding;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference("UserData");
        storageReference = FirebaseStorage.getInstance().getReference()
                .child("Images/"+ UUID.randomUUID().toString());

        ActivityResultLauncher<String> mgetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                uri = result;
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                    binding.iv.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        binding.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mgetContent.launch("image/*");
            }
        });
    }

    public void save(View view) {
        storageReference.putFile(uri).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String url = uri.toString();
                        String name = binding.name.getText().toString();
                        String mail = binding.mail.getText().toString();
                        String num = binding.number.getText().toString();
                        MyModel myModel = new MyModel(url,name,mail,num);

                      /*  String id = databaseReference.push().getKey();*/
                        databaseReference.child(num).setValue(myModel);
                        Toast.makeText(MainActivity.this, "Data Inserted",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void fetch(View view) {
        startActivity(new Intent(this,DisplayActivity.class));
    }
}
```
