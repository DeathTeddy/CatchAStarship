package com.example.kentec.catchastarship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AddressCapture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_capture);
    }

    AddressCapture.MyReceiver mReceiver = new MyReceiver();

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter myIF = new IntentFilter("android.intent.action.BATTERY_LOW");
        this.registerReceiver(mReceiver, myIF);
    }

    @Override
    public void onPause() {
        this.unregisterReceiver(mReceiver);
        super.onPause();
    }

    public class MyReceiver extends BroadcastReceiver {
        public MyReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.v("myReceiver", "received an intent");
            String info = "\n something wrong.";
            int mStatus = 0;
            if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)) {  //battery is low!
                Toast.makeText(context, "Battery low, loss of order may occur.", Toast.LENGTH_LONG).show();
                mStatus = 1;
                Log.v("myReceiver", "battery low");
            }
        }
    }
    public void changeActivityOrder(View view){
        Intent intent = new Intent(this, FinalOrder.class);
        startActivity(intent);
    }
}
