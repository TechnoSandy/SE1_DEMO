package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewReservedRental extends AppCompatActivity {
    String[] fromDate= {"09/13/2018", "09/18/2018", "09/24/2018"};
    String[] toDate={"09/15/2018", "09/22/2018", "09/29/2018"};
    String[] amountPaid={"80$","100$","165$"};
    String[] typeOfCar={"Economy","SUV", "Compact"};
    String[] fromTime={"3 PM", "1 PM", "2 PM"};
    String[] toTime={"9 AM", "12 PM","1 PM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reserved_rental);
        ListView lv = (ListView) findViewById(android.R.id.list);
        CustomAdapter customAdapter = new CustomAdapter();
        lv.setAdapter(customAdapter);

        // Logout Button
        Button Logout = findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewReservedRental.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        Button backButton = findViewById(R.id.button7);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonToast();
                startActivity(new Intent(ViewReservedRental.this, Dashboard.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return fromDate.length;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= getLayoutInflater().inflate(R.layout.customlayout,null);
            TextView cartype_ans= view.findViewById(R.id.textView_cartype_ans);
            TextView amount_ans= view.findViewById(R.id.textView_amount_ans);
            TextView fromdate_ans= view.findViewById(R.id.textView_fromdate_ans);
            TextView todate_ans= view.findViewById(R.id.textView_todate_ans);
            TextView fromtime_ans= view.findViewById(R.id.textView_fromtime_ans);
            TextView tilltime_ans= view.findViewById(R.id.textView_tilltime_ans);

            cartype_ans.setText(typeOfCar[i]);
            amount_ans.setText(amountPaid[i]);
            fromdate_ans.setText(fromDate[i]);
            todate_ans.setText(toDate[i]);
            fromtime_ans.setText(fromTime[i]);
            tilltime_ans.setText(toTime[i]);
            return view;
        }



        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }
    }
    private void backButtonToast() {
        Context context = getApplicationContext();
        CharSequence text = "Back Button Clicked";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
