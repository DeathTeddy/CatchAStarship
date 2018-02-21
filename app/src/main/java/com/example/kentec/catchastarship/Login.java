package com.example.kentec.catchastarship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


/*
    At least two Activities.
    Save at least one data point with a SharedPreference.
    Send at least one data point between Activities using an Intent.
    Read in input from the user using at least one of each:
        Checkbox
        TextView
        Radio Button (use a ButtonGroup)
    Have at least on image in the application.
    Include a BroadcastReceiver to deal with a system event.
        Notify the user of the event (a Toast is fine but it is up to you).
    One Activity needs a ConstraintLayout
    One Activity needs a LinearLayout (horizontal).
*/


public class Login extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mName = (EditText) findViewById(R.id.editTextName);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
    }

    Login.MyReceiver mReceiver = new MyReceiver();

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

    public void changeActivityLogin(View view){
        //saves the name
        String name = mName.getText().toString();
        mEditor.putString("com.example.kentec.catchastarship.name", name);
        mEditor.commit();

        Intent intent = new Intent(this, DeliveryChoice.class);
        startActivity(intent);
    }

}
