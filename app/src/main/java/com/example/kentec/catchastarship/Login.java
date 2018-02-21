package com.example.kentec.catchastarship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    private EditText mName, mPassword;
    private Button btnLogin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void changeActivityLogin(View view){
        Intent intent = new Intent(this, DeliveryChoice.class);
        startActivity(intent);
    }

}
