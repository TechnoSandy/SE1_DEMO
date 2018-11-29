package com.project.se.arlingtonauto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RevokeRenterConfirmPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revoke_renter_confirm_page);

        // Logout Button
        Button Logout = findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RevokeRenterConfirmPage.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
    public void onRevoke(View v)
    {
        Toast.makeText(RevokeRenterConfirmPage.this,"Renter Revoked Successfully",Toast.LENGTH_LONG).show();
    }
}
