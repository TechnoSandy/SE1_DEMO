package com.project.se.arlingtonauto;


import android.content.Context;
import android.content.Intent;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserCancelReservedRental extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
//    String[] rideArray = {"ride 1 - 10/13/2018" ,"ride 2 - 10/14/2018", "ride 3 - 10/15/2018", "ride 4 - 10/16/2018" ,"ride 5 - 10/17/2018" ,"ride 6 - 10/18/2018" };
String[] rideArray = {"ride 1 - 10/13/2018" ,"ride 2 - 10/14/2018", "ride 3 - 10/15/2018", "ride 4 - 10/16/2018" ,"ride 5 - 10/17/2018"};
    final ArrayList<String> list =new ArrayList<String>(Arrays.asList(rideArray));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cancel_reserved_rental);
        listView = findViewById(R.id.PrototypeReservedRental);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                String item = list.get(itemPosition);
                list.remove(itemPosition);
                cancelToast();
                adapter.notifyDataSetChanged();




            }

        });
        Button backButton = findViewById(R.id.PrototypeBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonToast();
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

    private void backButtonToast() {
        Context context = getApplicationContext();
        CharSequence text = "Back Button Clicked";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void cancelToast() {
        Context context = getApplicationContext();
        CharSequence text = "Reservation cancelled";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
