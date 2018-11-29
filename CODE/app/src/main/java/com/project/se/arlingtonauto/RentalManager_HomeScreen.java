package com.project.se.arlingtonauto;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class RentalManager_HomeScreen extends AppCompatActivity {

    final DatabaseConnector connection = new DatabaseConnector(this);
    ArrayList<String> searchResults;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_manager__home_screen);
        username = getIntent().getStringExtra("username");
        Button backButton = findViewById(R.id.RentalManager_Back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RentalManager_HomeScreen.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // Logout Button
        Button Logout = findViewById(R.id.RentalManager_Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RentalManager_HomeScreen.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        // View All Rentals
        Button view_all_rental = findViewById(R.id.view_all_rental);
        view_all_rental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RentalManager_HomeScreen.this, UserCancelReservedRental.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        // View Specific Rental
        Button ViewSpecificRental = findViewById(R.id.ViewSpecificRental);
        ViewSpecificRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RentalManager_HomeScreen.this, UserCancelReservedRental.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        Button UpdateProfile = findViewById(R.id.update_profile1);
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
                Intent i = new Intent(RentalManager_HomeScreen.this, updateProfileScreen.class);
                i.putExtra("searchList", searchResults);
                i.putExtra("UTAID", uta_id);
                startActivity(i);
                RentalManager_HomeScreen.this.finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
