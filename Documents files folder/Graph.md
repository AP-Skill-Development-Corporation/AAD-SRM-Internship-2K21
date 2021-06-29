# Graph-Reports
## build.gradle file module:app
```XML
add DataBinding 

/*Display Graphs*/
    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'

```

## build.gradle file module:project
```XML
 repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
```

### activity_main
```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp"
    tools:context=".MainActivity">


    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/value1"
        android:hint="Enter Value"
        android:inputType="number"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/value2"
        android:hint="Enter Value"
        android:inputType="number"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/value3"
        android:hint="Enter Value"
        android:inputType="number"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/value4"
        android:hint="Enter Value"
        android:inputType="number"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/value5"
        android:hint="Enter Value"
        android:inputType="number"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Bar Graph"
        android:onClick="bargraph"
        android:layout_marginTop="10dp"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Pie Chart"
        android:layout_marginTop="10dp"
        android:onClick="pichart"/>

</LinearLayout>
```

### activity_bar_graph
```XML
<com.github.mikephil.charting.charts.BarChart
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/bargarph"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

### activity_pie_chart_actiivty
```XML
<com.github.mikephil.charting.charts.PieChart
        android:id="@+id/pichart"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
## MainAcivity.java
```JAVA
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.value1);
        et2 = findViewById(R.id.value2);
        et3 = findViewById(R.id.value3);
        et4 = findViewById(R.id.value4);
        et5 = findViewById(R.id.value5);
    }

    public void bargraph(View view) {

        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        String s3 = et3.getText().toString();
        String s4 = et4.getText().toString();
        String s5 = et5.getText().toString();

        Intent i = new Intent(this,BarGraphActivity.class);
        i.putExtra("key1",s1);
        i.putExtra("key2",s2);
        i.putExtra("key3",s3);
        i.putExtra("key4",s4);
        i.putExtra("key5",s5);
        startActivity(i);

    }

    public void pichart(View view) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        String s3 = et3.getText().toString();
        String s4 = et4.getText().toString();
        String s5 = et5.getText().toString();

        Intent intent = new Intent(this,PieChartActiivty.class);
        intent.putExtra("key1",s1);
        intent.putExtra("key2",s2);
        intent.putExtra("key3",s3);
        intent.putExtra("key4",s4);
        intent.putExtra("key5",s5);
        startActivity(intent);
    }
}

```
## PieChartActiivty.java
```JAVA
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActiivty extends AppCompatActivity {

    PieChart pieChart;
    ArrayList<PieEntry> pieEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_actiivty);
        pieChart =findViewById(R.id.pichart);

        pieEntries = new ArrayList<>();

        String v1 = getIntent().getStringExtra("key1");
        String v2 = getIntent().getStringExtra("key2");
        String v3 = getIntent().getStringExtra("key3");
        String v4 = getIntent().getStringExtra("key4");
        String v5 = getIntent().getStringExtra("key5");

        pieEntries.add(new PieEntry(Float.parseFloat(v1),"2015"));
        pieEntries.add(new PieEntry(Float.parseFloat(v2),"2016"));
        pieEntries.add(new PieEntry(Float.parseFloat(v3),"2017"));
        pieEntries.add(new PieEntry(Float.parseFloat(v4),"2018"));
        pieEntries.add(new PieEntry(Float.parseFloat(v5),"2019"));

        PieDataSet dataSet =new PieDataSet(pieEntries,"Students");
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setValueTextSize(16f);
        dataSet.setValueTextColor(Color.WHITE);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.setCenterText("Students");
        pieChart.getDescription().setEnabled(false);
        pieChart.animate();

    }
}
```


## BarGraphActivity.java
```JAVA
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarGraphActivity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);
        barChart = findViewById(R.id.bargarph);

        barEntries = new ArrayList<>();

        String v1 = getIntent().getStringExtra("key1");
        String v2 = getIntent().getStringExtra("key2");
        String v3 = getIntent().getStringExtra("key3");
        String v4 = getIntent().getStringExtra("key4");
        String v5 = getIntent().getStringExtra("key5");


        barEntries.add(new BarEntry(2000, Float.parseFloat(v1)));
        barEntries.add(new BarEntry(2001, Float.parseFloat(v2)));
        barEntries.add(new BarEntry(2002, Float.parseFloat(v3)));
        barEntries.add(new BarEntry(2003, Float.parseFloat(v4)));
        barEntries.add(new BarEntry(2004, Float.parseFloat(v5)));

        BarDataSet dataSet = new BarDataSet(barEntries,"Customers");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(16f);

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.animateY(2000);
    }
}

```
