package com.project.se.arlingtonauto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Change_UserRole3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__user_role3);
        // Logout Button
        Button Logout = findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Change_UserRole3.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

     public void Role_Changed(View view)
    {
        Toast.makeText(this, "Role Changed Successfully!", Toast.LENGTH_SHORT).show();
    }
}



