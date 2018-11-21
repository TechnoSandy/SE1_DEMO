package com.project.se.arlingtonauto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Change_UserRole2 extends AppCompatActivity {

    String name[]={"Ambarish","Sandeep","Aishwarya","Anushree","Parth","Vaibhav"};
    String role[]={"User","Rental_Manager","Rental_Manager","User","User","User"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_role2);

        CustomAdapter adapter = new CustomAdapter();
        ListView lv= (ListView) findViewById(android.R.id.list);
        lv.setAdapter(adapter);

        // Change User role
        Button Search = findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Change_UserRole2.this, Change_UserRole3.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
    class CustomAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return name.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(R.layout.userlayout,null);

            TextView rentername_ans= convertView.findViewById(R.id.textView_name_ans);
            TextView uta_id_ans= convertView.findViewById(R.id.textView_role_ans);



            rentername_ans.setText(name[position]);
            uta_id_ans.setText(role[position]);
            return convertView;



        }
    }

}


