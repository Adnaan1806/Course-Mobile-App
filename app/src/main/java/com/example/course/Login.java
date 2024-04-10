package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log = findViewById(R.id.login);
        log.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Profile_setup.class);
            startActivity(intent);
        });
    }
}