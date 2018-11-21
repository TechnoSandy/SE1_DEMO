package com.project.se.arlingtonauto;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        // registerBackButtonToast();
        Spinner regSpinner = findViewById(R.id.reg_user_role);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_role, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regSpinner.setAdapter(adapter);
        final DatabaseConnector connection = new DatabaseConnector(this);

        Button backRegistrationPage = findViewById(R.id.back_registraion);
        backRegistrationPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        save = findViewById(R.id.RegUser);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText UserName = findViewById(R.id.regUserName);
                EditText Password = findViewById(R.id.regPassword);
                EditText UtaID = findViewById(R.id.regUTAID);
                EditText Email = findViewById(R.id.regEmail);
                EditText Phone = findViewById(R.id.regPhone);
                EditText Address = findViewById(R.id.regAddress);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                RadioButton radioButtonYes = findViewById(R.id.radio_yes);
                if (TextUtils.isEmpty(UserName.getText())) {
                    UserName.setError("User Name is required!");
                } else if (TextUtils.isEmpty(Password.getText())) {
                    Password.setError("Password is required!");
                } else if (TextUtils.isEmpty(UtaID.getText())) {
                    UtaID.setError("UtaID is required!");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches()) {
                    Email.setError("Email is required!");
                } else if (TextUtils.isEmpty(Phone.getText())) {
                    Phone.setError("Phone is required!");
                } else if (TextUtils.isEmpty(Address.getText())) {
                    Address.setError("Address is required!");
                } else if (radioGroup.getCheckedRadioButtonId() == -1) {
                    radioButtonYes.setError("No Check Box clicked !");
                } else {
                    UserName.setError(null);
                    Password.setError(null);
                    UtaID.setError(null);
                    Email.setError(null);
                    Phone.setError(null);
                    Address.setError(null);
                    radioButtonYes.setError(null);
                    connection.insertData(UserName.getText().toString(), Password.getText().toString(), "role", Integer.parseInt(UtaID.getText().toString()), Email.getText().toString(), Long.parseLong(Phone.getText().toString()), Address.getText().toString(), "no");
//                    Cursor res = connection.getAllData();
//                    if (res.getCount() == 0) {
//                        // show message
//                        showMessage("Error", "Nothing found");
//                        return;
//                    }
//
//                    StringBuffer buffer = new StringBuffer();
//                    while (res.moveToNext()) {
//                        buffer.append("UserName :" + res.getString(0) + "\n");
//                        buffer.append("Password :" + res.getString(1) + "\n");
//                        buffer.append("role :" + res.getString(2) + "\n");
//                        buffer.append("uta id :" + res.getString(3) + "\n\n");
//                        buffer.append("Email :" + res.getString(4) + "\n\n");
//                        buffer.append("Phone :" + res.getString(5) + "\n");
//                        buffer.append("Address :" + res.getString(6) + "\n");
//                        buffer.append("club :" + res.getString(7) + "\n\n");
//                    }
//
//                    // Show all data
//                    showMessage("Data", buffer.toString());
                    saveToDatabase();
                }


            }

        });


    }

    private void saveToDatabase() {
        Context context = getApplicationContext();
        CharSequence text = "You are registered successfully!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        startActivity(new Intent(Registration.this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // Yes
                    break;
            case R.id.radio_no:
                if (checked)
                    // No
                    break;
        }

    }

//    public void showMessage(String title, String Message) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }
}
