package com.project.se.arlingtonauto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RevokeRenterConfirmPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revoke_renter_confirm_page);
    }
    public void onRevoke(View v)
    {
        Toast.makeText(RevokeRenterConfirmPage.this,"Renter Revoked Successfully",Toast.LENGTH_LONG).show();
    }
}
