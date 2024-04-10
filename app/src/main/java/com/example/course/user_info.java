package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class user_info extends AppCompatActivity {

    private Button registerButton;
    private Button loginButton;
    private Spinner spinner;

    EditText name, email, phone, address, city, dob, nic, gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        name = findViewById(R.id.editTxtName);
        email = findViewById(R.id.editTxtEmail);
        phone = findViewById(R.id.editTxtNumber);
        address = findViewById(R.id.editTxtAddress);
        city = findViewById(R.id.editTxtCity);
        dob = findViewById(R.id.editTxtDOB);
        nic = findViewById(R.id.editTxtNIC);
        spinner = findViewById(R.id.spinnerGender);


        //entering values to spinner
       spinner = findViewById(R.id.spinnerGender);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
               String item = adapterView.getItemAtPosition(position).toString();
               //Toast.makeText(user_info.this,"Selected Item: "+ item, Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

       ArrayList<String> options = new ArrayList<>();
         options.add("Male");
         options.add("Female");
         ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);


          //directing to next page by clicking the register button
        registerButton = findViewById(R.id.registerUserButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_info.this, register_course.class);
                startActivity(intent);

            }
        });

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_info.this, Login.class);
                startActivity(intent);

            }
        });

    }

}