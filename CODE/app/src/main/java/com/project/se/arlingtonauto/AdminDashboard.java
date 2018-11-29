package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminDashboard extends AppCompatActivity {
    final DatabaseConnector connection = new DatabaseConnector(this);
    ArrayList<String> searchResults;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_screen);
        username = getIntent().getStringExtra("username");
        Button backButton = findViewById(R.id.AdminDashboard_Back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonToast();
                startActivity(new Intent(AdminDashboard.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });



        // Revoke Renter
        Button revoke_renter = findViewById(R.id.revoke_renter);
        revoke_renter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, RevokeRenter.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // update_profile
        Button update_profile = findViewById(R.id.update_profile);
        update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(AdminDashboard.this, RevokeRenter.class));
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
                Intent i = new Intent(AdminDashboard.this, updateProfileScreen.class);
                i.putExtra("searchList", searchResults);
                i.putExtra("UTAID", uta_id);
                startActivity(i);
                AdminDashboard.this.finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //Cancel Revoke renter
        Button cancelRevoke = findViewById(R.id.AdminDashboard_Cancel_Revoke_Renter);
        cancelRevoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, CancelRevokeRenter.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });




        // Logout Button
        Button Logout = findViewById(R.id.AdminDashboard_Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });




        // Edit RM and User Profile
        Button Edit_RM_User_Profile = findViewById(R.id.Edit_RM_User_Profile);
        Edit_RM_User_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, EditUserRMProfileScreen.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        // Change User role
        Button Change_user_role = findViewById(R.id.Change_user_role);
        Change_user_role.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, Change_UserRole1.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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
