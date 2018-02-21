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
import android.widget.RadioButton;
import android.widget.Toast;

public class ShipPicker extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    //stores which ship is chosen
    private String chosenShip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_picker);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
    }

    ShipPicker.MyReceiver mReceiver = new MyReceiver();

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
    public void onRadioButtonClicked(View view){

        //checks if a button is selected
        boolean checked = ((RadioButton)view).isChecked();

        //checks which ship (button) is selected and notifies the user what is currently selected
        switch(view.getId()) {
            case R.id.radioButtonShip1:
                if (checked){
                    Toast toast1 = Toast.makeText(this, "Ship 1 is currently selected!", Toast.LENGTH_LONG);
                    toast1.show();
                    String chosenShip = "Ship 1";
                    mEditor.putString("com.example.kentec.catchastarship.chosenShip", chosenShip);
                    mEditor.commit();
                    break;
                }
            case R.id.radioButtonShip2:
                if (checked){
                    Toast toast2 = Toast.makeText(this, "Ship 2 is currently selected!", Toast.LENGTH_LONG);
                    toast2.show();
                    String chosenShip = "Ship 2";
                    mEditor.putString("com.example.kentec.catchastarship.chosenShip", chosenShip);
                    mEditor.commit();
                    break;
                }
            case R.id.radioButtonShip3:
                if (checked){
                    Toast toast3 = Toast.makeText(this, "Ship 3 is currently selected!", Toast.LENGTH_LONG);
                    toast3.show();
                    String chosenShip = "Ship 3";
                    mEditor.putString("com.example.kentec.catchastarship.chosenShip", chosenShip);
                    mEditor.commit();
                    break;
                }
        }
    }
    public void changeActivityAddress(View view){
        Intent intent = new Intent(this, AddressCapture.class);
        startActivity(intent);
    }
}
