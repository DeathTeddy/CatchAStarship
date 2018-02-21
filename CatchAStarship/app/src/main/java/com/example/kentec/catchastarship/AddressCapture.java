package com.example.kentec.catchastarship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
            if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)) {  //battery is low!
                Toast.makeText(context, "Battery low, loss of order may occur.", Toast.LENGTH_LONG).show();
                Log.v("myReceiver", "battery low");
            }
        }
    }
    public void changeActivityOrder(View view){

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextCountry = findViewById(R.id.editTextCountry);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText editTextAddress = findViewById(R.id.editTextAddress);
        boolean isChecked = ((CheckBox) findViewById(R.id.notEarthling)).isChecked();



        Intent intent = new Intent(this, FinalOrder.class);

        intent.putExtra("editTextName", editTextName.getText().toString());
        intent.putExtra("editTextCountry", editTextCountry.getText().toString());
        intent.putExtra("editTextPhone", editTextPhone.getText().toString());
        intent.putExtra("editTextAddress", editTextAddress.getText().toString());
        intent.putExtra("checkBoxValue", isChecked);

        startActivity(intent);
    }
}
