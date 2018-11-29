package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static Object UserRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent i = new Intent(MainActivity.this, Dashboard.class);
        final Intent i1 = new Intent(MainActivity.this, RentalManager_HomeScreen.class);
        final Intent i2 = new Intent(MainActivity.this, AdminDashboard.class);
        final EditText UserName = findViewById(R.id.UsernameText);
        final EditText Password = findViewById(R.id.PasswordText);
        i.putExtra("username", UserName.getText().toString());
        i1 .putExtra("username", UserName.getText().toString());
        i2 .putExtra("username", UserName.getText().toString());


        final DatabaseConnector connection = new DatabaseConnector(this);

//        setContentView(R.layout.activity_anushree);

        // Adding drop down also known as spinner
        Spinner spinner = findViewById(R.id.user_role);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_role, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                UserRole = parent.getItemAtPosition(pos);
                Log.d("SELECTED ROLE", (String) UserRole);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // Login Button
        Button login = findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Code to check if the user exist will come here !!!

                Boolean result = connection.checkUser(UserName.getText().toString(),Password.getText().toString());


                if(result){
                    loginToast();
                if (UserRole.equals("User")) {
                    startActivity(i);
                    MainActivity.this.finish();
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else if (UserRole.equals("Admin")) {
//                    startActivity(new Intent(MainActivity.this, AdminDashboard.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    startActivity(i2);
                    MainActivity.this.finish();
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if (UserRole.equals("Manager")) {
                    startActivity(i1);
                    MainActivity.this.finish();
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else {
                    Log.d("SELECTED ROLE", (String) UserRole);
                }
                }else{
                    //test(result);
                    LoginErrorToast("User Does not exist please register to login");

                }

//                startActivity(new Intent(MainActivity.this, Anushree.class));
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        Button register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Code to check if the user exist will come here !!!
                registerMsg();
                startActivity(new Intent(MainActivity.this, Registration.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }

    private void loginToast() {
        Context context = getApplicationContext();
        CharSequence text = "Logged In successfully";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void test(Boolean result) {
        Context context = getApplicationContext();
        CharSequence text = "result - "+result;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void LoginErrorToast(String MSG) {
        Context context = getApplicationContext();
        CharSequence text = MSG;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void registerMsg() {
        Context context = getApplicationContext();
        CharSequence text = "Please Register !!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
