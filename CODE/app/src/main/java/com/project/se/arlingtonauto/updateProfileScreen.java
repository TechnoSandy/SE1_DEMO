package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class updateProfileScreen extends AppCompatActivity {
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile_screen);


        final EditText UserName = findViewById(R.id.regUserName);
        final EditText Password = findViewById(R.id.regPassword);
        final EditText UtaID = findViewById(R.id.regUTAID);
        final EditText Email = findViewById(R.id.regEmail);
        final EditText Phone = findViewById(R.id.regPhone);
        final EditText Address = findViewById(R.id.regAddress);
        final RadioGroup autoClubRadio = findViewById(R.id.autoClubRadio);
        final Spinner role = findViewById(R.id.reg_user_role);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_role, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        role.setAdapter(adapter);

        final DatabaseConnector connection = new DatabaseConnector(this);

        String uta_id = getIntent().getStringExtra("UTAID");

        Cursor cursor = connection.getReadableDatabase().rawQuery("select * from USER_TABLE where UTA_ID = ?", new String[]{uta_id});

        cursor.moveToNext();

        UserName.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.USERNAME)));

        Password.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.PASSWORD)));

        if (cursor.getString(cursor.getColumnIndex(DatabaseConnector.CLUB)).equals("no")) {
            ((RadioButton) autoClubRadio.getChildAt(1)).setChecked(true);
        } else {
            ((RadioButton) autoClubRadio.getChildAt(0)).setChecked(true);
        }

        int pos = adapter.getPosition(cursor.getString(cursor.getColumnIndex(DatabaseConnector.ROLE)));

        role.setSelection(pos);

        Address.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.ADDRESS)));

        Phone.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.PHONE)));

        Email.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.EMAIL)));

        UtaID.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.UTAID)));

        UserName.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.USERNAME)));

        UserName.setText(cursor.getString(cursor.getColumnIndex(DatabaseConnector.USERNAME)));

        Button backUpdateProfilePage = findViewById(R.id.update_profile_Screen_Back);
        backUpdateProfilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updateProfileScreen.this, urm.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        update = findViewById(R.id.update_profile);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection.updateData(UserName.getText().toString(), Password.getText().toString(),
                        role.getSelectedItem().toString(), UtaID.getText().toString(), Email.getText().toString(),
                        Phone.getText().toString(), Address.getText().toString(),
                        ((RadioButton) findViewById(autoClubRadio.getCheckedRadioButtonId())).getText().toString());
                updateDatabase();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(updateProfileScreen.this, urm.class);
        i.putExtra("searchList", getIntent().getStringArrayListExtra("searchList"));
        startActivity(i);
        updateProfileScreen.this.finish();
    }

    private void updateDatabase() {
        Context context = getApplicationContext();
        CharSequence text = "Profile details updated successfully!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        startActivity(new Intent(updateProfileScreen.this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}