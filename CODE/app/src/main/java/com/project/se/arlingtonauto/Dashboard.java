package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_screen);
        Button CancelReservedRental = findViewById(R.id.cancel_reservation);
        CancelReservedRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, UserCancelReservedRental.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button backButton = findViewById(R.id.UserHomeScreen_Back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               backButtonToast();
               startActivity(new Intent(Dashboard.this, MainActivity.class));
               overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });



        // Logout Button
        Button Logout = findViewById(R.id.UserHomeScreen_Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        Button UpdateProfile = findViewById(R.id.update_profile);
        UpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, Registration.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Request Rental
        Button RequestRental = findViewById(R.id.request_rental);
        RequestRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, RequestRentalScreen.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        // view reserved Rental
        Button viewReservedRetal = findViewById(R.id.view_reserved_rental);
        viewReservedRetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, ViewReservedRental.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Cancel Reservation
        Button cancelReservation = findViewById(R.id.cancel_reservation);
        cancelReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, UserCancelReservedRental.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    private void backButtonToast() {
        Context context = getApplicationContext();
        CharSequence text = "Back Button Clicked";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
