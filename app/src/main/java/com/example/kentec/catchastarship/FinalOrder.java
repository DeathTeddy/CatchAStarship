package com.example.kentec.catchastarship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FinalOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);
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
