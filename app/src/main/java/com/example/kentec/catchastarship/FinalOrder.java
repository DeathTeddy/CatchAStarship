package com.example.kentec.catchastarship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinalOrder extends AppCompatActivity {

    private TextView mShipOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);
        mShipOrder = (TextView) findViewById(R.id.textViewOrder);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String name = getIntent().getStringExtra("editTextName" );
        String country = getIntent().getStringExtra("editTextCountry");
        String phone = getIntent().getStringExtra("editTextPhone");
        String address = getIntent().getStringExtra("editTextAddress");
        boolean isChecked = getIntent().getBooleanExtra("checkBoxValue", false);
        if(isChecked==false) {
            String shipOrder = "Order Info " + "\n" + "______________" + "\n" + "\n" + "Name: " + name + "\n" + "Is an Earthling" + "\n" + "Your chosen ship: " + mPreferences.getString("com.example.kentec.catchastarship.chosenShip", "") + "\n"
                    + "Phone: " + phone + "\n" + "Address: " + address + "\n" + "country: " + country;

            mShipOrder.setText(shipOrder);
        }
        if(isChecked==true) {
            String shipOrder = "Order Info " + "\n" + "______________" + "\n" + "\n" + "Name: " + name + "\n" + "Is not an Earthling" + "\n" + "Your chosen ship: " + mPreferences.getString("com.example.kentec.catchastarship.chosenShip", "") + "\n"
                    + "Phone: " + phone + "\n" + "Address: " + address + "\n" + "country: " + country;

            mShipOrder.setText(shipOrder);
        }
    }

    FinalOrder.MyReceiver mReceiver = new MyReceiver();

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

    public void changeActivityShips(View view){
        Intent intent = new Intent(this, ShipPicker.class);
        startActivity(intent);

    }
    public void changeActivityLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
