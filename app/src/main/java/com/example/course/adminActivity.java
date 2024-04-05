package com.example.course;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class adminActivity extends AppCompatActivity {
    EditText adminUsername,adminPassword;
    Button btn_admin;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminUsername = (EditText) findViewById(R.id.adminUsername);
        adminPassword = (EditText) findViewById(R.id.adminPassword);
        btn_admin = (Button) findViewById(R.id.btn_admin);
    }


}
