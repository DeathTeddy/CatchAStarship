package com.example.kentec.catchastarship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DeliveryChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_choice);
    }
    public void changeActivityShips(View view){
        Intent intent = new Intent(this, ShipPicker.class);
        startActivity(intent);
    }
    public void changeActivityOrder(View view){
        Intent intent = new Intent(this, FinalOrder.class);
        startActivity(intent);
    }
}
