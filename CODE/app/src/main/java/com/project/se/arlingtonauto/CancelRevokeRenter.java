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

public class CancelRevokeRenter extends AppCompatActivity {
    ListView listView;

    String[] dataArray = {"Sandeep Satone" ,"Parth Mehta", "Anushree", "Aishwarya" ,"Vaibhav Lahoti" ,"Ambarish salodkar" ,"Delete This User"};
//String[] dataArray = {"Sandy","satish"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_revoke_renter);
//        showMessage();
        listView = findViewById(R.id.PrototypeUserListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, dataArray);
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

            }

        });
        Button backButton = findViewById(R.id.PrototypeBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonToast();
                startActivity(new Intent(CancelRevokeRenter.this, AdminDashboard.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        // Logout Button
        Button Logout = findViewById(R.id.PrototypeLogout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CancelRevokeRenter.this, MainActivity.class));
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
    private void showMessage() {
        Context context = getApplicationContext();
        CharSequence text = "User can now book car again !";
//        int duration = Toast.LENGTH_SHORT;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
