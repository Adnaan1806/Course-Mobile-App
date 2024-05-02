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

import com.example.course.database.DatabaseHandler;
import com.example.course.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class user_info extends AppCompatActivity {

     DatabaseHandler dbHelper;
    String[] genders = {"Male", "Female", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        setContentView(R.layout.activity_user_info);

        dbHelper = new DatabaseHandler(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinnerGender);
        spinner.setAdapter(adapter);
    }

    public void redirectToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void register(View view) {
        if (validateFields()) {

            EditText nameEditText = findViewById(R.id.editTxtName);
            EditText emailEditText = findViewById(R.id.editTxtEmail);
            EditText addressEditText = findViewById(R.id.editTxtAddress);
            EditText cityEditText = findViewById(R.id.editTxtCity);
            EditText phoneEditText = findViewById(R.id.editTxtNumber);
            Spinner genderSpinner = findViewById(R.id.spinnerGender);
            EditText dobEditText = findViewById(R.id.editTxtDOB);

            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String address = addressEditText.getText().toString();
            String city = cityEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String gender = genderSpinner.getSelectedItem().toString();
            String dob = dobEditText.getText().toString();


            Toast.makeText(this, name , Toast.LENGTH_SHORT).show();

            Student student = new Student(name, email, address, city,phone,gender,dob);
            try{
                DatabaseHandler dbHandler = new DatabaseHandler(this);
                long id = dbHandler.addStudent(student);
                dbHandler.close();
                if(id == -1){
                    showErrorMessage("Email already exists");
                    return;
                }
                Intent intent = new Intent(this, Profile_setup.class);
                intent.putExtra("student_id", id);
                startActivity(intent);
            } catch (Exception e) {
                showErrorMessage(e.getMessage());
            }

        }

    }

    private boolean validateFields() {
        EditText nameEditText = findViewById(R.id.editTxtName);
        EditText emailEditText = findViewById(R.id.editTxtEmail);
        EditText addressEditText = findViewById(R.id.editTxtAddress);
        EditText cityEditText = findViewById(R.id.editTxtCity);
        EditText phoneEditText = findViewById(R.id.editTxtNumber);
        Spinner genderSpinner = findViewById(R.id.spinnerGender);
        EditText dobEditText = findViewById(R.id.editTxtDOB);
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String city = cityEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String gender = genderSpinner.getSelectedItem().toString();
        String dob = dobEditText.getText().toString();



        if (name.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() || phone.isEmpty()) {
            showErrorMessage("All fields are required");
            return false;
        }
        else if (phone.length() != 10) {

            showErrorMessage(String.valueOf(phone.length()));
            return false;
        }
        SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
        sdfrmt.setLenient(false);
        /* Create Date object
         * parse the string into date
         */
        try
        {
            Date javaDate = sdfrmt.parse(dob);
        }
        /* Date format is invalid */
        catch (ParseException e)
        {
            showErrorMessage("Invalid Date of Birth");
            return false;
        }
        return true;

    }

    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}