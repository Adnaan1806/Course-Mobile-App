package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AdminLogin extends AppCompatActivity {

    Button logintoDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        logintoDash = findViewById(R.id.adminLoginButton);
        logintoDash.setOnClickListener(v -> {
            Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);
            startActivity(intent);

        });

    }
}