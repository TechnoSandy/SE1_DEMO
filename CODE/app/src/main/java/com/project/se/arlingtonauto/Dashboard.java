package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    final DatabaseConnector connection = new DatabaseConnector(this);
    ArrayList<String> searchResults;
    String username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_screen);
        username = getIntent().getStringExtra("username");

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
//                startActivity(new Intent(Dashboard.this, Registration.class));
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                //query db
                Cursor cursor = connection.getReadableDatabase().query(true, "USER_TABLE", new String[]{"USERNAME", "UTA_ID"}, "USERNAME LIKE ?", new String[]{"%" + username + "%"}, null, null, null,
                        null);

                if (cursor.getCount() > 0) {
                    searchResults = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        String entry = "Name: " + cursor.getString(0) + "\n" + "UTA ID: " + cursor.getString(1);
                        searchResults.add(entry);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No search results found.", Toast.LENGTH_SHORT);
                }
                String uta_id = searchResults.get(0).split("\n")[1].replace("UTA ID: ", "");
                Intent i = new Intent(Dashboard.this, updateProfileScreen.class);
                i.putExtra("searchList", searchResults);
                i.putExtra("UTAID", uta_id);
                startActivity(i);
                Dashboard.this.finish();
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
