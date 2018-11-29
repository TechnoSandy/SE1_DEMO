package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class UserCancelReservedRental1 extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] rideArray = {"ride 1 - 10/13/2018" ,"ride 2 - 10/14/2018", "ride 3 - 10/15/2018", "ride 4 - 10/16/2018" ,"ride 5 - 10/17/2018"};
    final ArrayList<String> list =new ArrayList<String>(Arrays.asList(rideArray));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cancel_reserved_rental1);
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                startActivity(new Intent(UserCancelReservedRental1.this, View_SpecificRental.class));
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);

            }

        });
        Button backButton = findViewById(R.id.PrototypeBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonToast();
                startActivity(new Intent(UserCancelReservedRental1.this, Dashboard.class));
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
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
