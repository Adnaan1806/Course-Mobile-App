package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button log,registerButtonMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log = findViewById(R.id.login);
        log.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Profile_setup.class);
            startActivity(intent);
        });

        registerButtonMove = findViewById(R.id.registerButtonMove);
        registerButtonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, user_info.class);
                startActivity(intent);

            }
        });
    }
}