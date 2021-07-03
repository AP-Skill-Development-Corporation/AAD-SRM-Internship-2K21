# Payment Gateway-sample Doc
## Step -1:Get API Key From https://razorpay.com
## Step 2:add depndancy (build.gradle-app level)
```XML
implementation 'com.razorpay:checkout:1.6.6'
```
## Step 3:activity_main.xml
```XML
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pay"
        android:onClick="payment"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

```

## MainActivity.Java
```Java
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    /*For Generating APIKEY goto Web Site: https://razorpay.com/*/
    String APIKEY = "Paste your API KEY Here";

    Checkout checkout;
/*this is the muneiah's modifications from android studio*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Checkout.preload(getApplicationContext());

    }

    public void payment(View view) {
        /*intilization CHeckout*/
        checkout = new Checkout();
        /*set APIKEy to checkout*/
        checkout.setKeyID(APIKEY);

        final Activity activity = this;


        try {
            JSONObject object = new JSONObject();
            object.put("Name","Sai Sankar");
            object.put("amount","10000");
            object.put("theme.color","#44BB04");
            object.put("image","https://p7.hiclipart.com/preview/212/540/940/logo-banner-health-care-home-care-service-logo-design.jpg");
            object.put("currency","INR");
            checkout.open(activity,object);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Sucess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Fail \n "+ s , Toast.LENGTH_SHORT).show();
    }
}

```
