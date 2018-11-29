package com.project.se.arlingtonauto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AvailableCarsScreen extends AppCompatActivity {


    String[] CarName = {"Smart", "Economy", "Compact", "Intermediate", "Standard","Full Size","SUV","MiniVan","Ultra Sports"};
    String[] NumberOfOccupants = {"1","3","4","4","5","6","8","9","2"};
    String[] Amount = {"110","150","130","200","250","200","150","100","160"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_cars_screen);
        NameAdapter nameAdapter = new NameAdapter();

        ListView lv = (ListView) findViewById(android.R.id.list);

        lv.setAdapter(nameAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(AvailableCarsScreen.this, CarDetailsScreen.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });


        // Logout Button
        Button Logout = findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AvailableCarsScreen.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

    }





    class NameAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return CarName.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.available_car, null);

            TextView Car_Name = view.findViewById(R.id.car_name);
            TextView No_of_occupants = view.findViewById(R.id.no_of_occupants);
            TextView amount = view.findViewById(R.id.amount);

            Car_Name.setText(CarName[i]);
            No_of_occupants.setText(NumberOfOccupants[i]);
            amount.setText(Amount[i]);
            return view;
        }
    }
}

