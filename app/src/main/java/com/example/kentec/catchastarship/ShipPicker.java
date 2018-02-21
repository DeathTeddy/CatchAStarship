package com.example.kentec.catchastarship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShipPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_picker);
    }
    public void changeActivityAddress(View view){
        Intent intent = new Intent(this, AddressCapture.class);
        startActivity(intent);
    }
}
