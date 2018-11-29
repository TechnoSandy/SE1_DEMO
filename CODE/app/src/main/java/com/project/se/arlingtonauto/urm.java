package com.project.se.arlingtonauto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class urm extends AppCompatActivity {

    ArrayList<String> searchResults;
    ListView searchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urm);
        searchListView = findViewById(R.id.searchListView);
        searchResults = getIntent().getStringArrayListExtra("searchList");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, searchResults);

        searchListView.setAdapter(adapter);

        Button backEditUserRentalManagerPage = findViewById(R.id.button112);
        backEditUserRentalManagerPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(urm.this, EditUserRMProfileScreen.class));
                urm.this.finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String uta_id = searchResults.get(position).split("\n")[1].replace("UTA ID: ", "");
                Intent i = new Intent(urm.this, updateProfileScreen.class);
                i.putExtra("UTAID", uta_id);
                i.putExtra("searchList", searchResults);
                startActivity(i);
                urm.this.finish();
            }
        });

    }
}
