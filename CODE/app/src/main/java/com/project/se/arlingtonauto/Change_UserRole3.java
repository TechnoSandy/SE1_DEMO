package com.project.se.arlingtonauto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Change_UserRole3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__user_role3);
    }

     public void Role_Changed(View view)
    {
        Toast.makeText(this, "Role Changed Successfully!", Toast.LENGTH_SHORT).show();
    }
}



