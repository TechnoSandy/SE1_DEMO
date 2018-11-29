package com.project.se.arlingtonauto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RequestRentalScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_rental_screen);
        Button RequestRental_confirmButton = findViewById(R.id.RequestRental_confirmButton);
        RequestRental_confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestRentalScreen.this, AvailableCarsScreen.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        // Logout Button
        Button Logout = findViewById(R.id.RequestRentalScreen_Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestRentalScreen.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}
