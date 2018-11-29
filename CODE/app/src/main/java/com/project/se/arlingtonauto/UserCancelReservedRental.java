package com.project.se.arlingtonauto;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class UserCancelReservedRental extends AppCompatActivity {
    ListView listView;
//    String[] rideArray = {"ride 1 - 10/13/2018" ,"ride 2 - 10/14/2018", "ride 3 - 10/15/2018", "ride 4 - 10/16/2018" ,"ride 5 - 10/17/2018" ,"ride 6 - 10/18/2018" };
String[] rideArray = {"ride 1 - 10/13/2018" ,"ride 2 - 10/14/2018", "ride 3 - 10/15/2018", "ride 4 - 10/16/2018" ,"ride 5 - 10/17/2018"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cancel_reserved_rental);
        listView = findViewById(R.id.PrototypeReservedRental);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, rideArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
                startActivity(new Intent(UserCancelReservedRental.this, View_SpecificRental.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }

        });
        Button backButton = findViewById(R.id.PrototypeBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                backButtonToast();
                startActivity(new Intent(UserCancelReservedRental.this, Dashboard.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // Logout Button
        Button Logout = findViewById(R.id.PrototypeLogout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserCancelReservedRental.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

    }
}
