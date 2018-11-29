package com.project.se.arlingtonauto;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EditUserRMProfileScreen extends AppCompatActivity {

    EditText nameEditText;
    final DatabaseConnector connection = new DatabaseConnector(this);
    ArrayList<String> searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_rmprofile_screen);
        // Logout Button
        Button Search = findViewById(R.id.Search);
        nameEditText = findViewById(R.id.Name);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();

                //query db
                Cursor cursor = connection.getReadableDatabase().query(true, "USER_TABLE", new String[]{"USERNAME", "UTA_ID"}, "USERNAME LIKE ?", new String[]{"%" + name + "%"}, null, null, null,
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
                Intent i = new Intent(EditUserRMProfileScreen.this, urm.class);
                i.putExtra("searchList", searchResults);
                startActivity(i);
                EditUserRMProfileScreen.this.finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);



                // Logout Button
                Button Logout = findViewById(R.id.RequestRentalScreen_Logout);
                Logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(EditUserRMProfileScreen.this, MainActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    }
                });
            }
        });
    }
}