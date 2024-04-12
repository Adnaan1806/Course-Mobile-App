package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class register_course extends AppCompatActivity {

    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_course);

        registerButton = findViewById(R.id.registerCourse);
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(register_course.this, confirmationPage.class);
            startActivity(intent);

        });

        ImageView accountImage = findViewById(R.id.account_image);

        // Set OnClickListener to the ImageView
        accountImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create PopupMenu
                PopupMenu popupMenu = new PopupMenu(register_course.this, v);

                // Inflate menu resource
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

                // Set item click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item click
                        int itemId = item.getItemId();
                        if (itemId == R.id.menu_logout) {
                            // Handle logout action
                            // Start LogoutActivity or perform logout logic
                            startActivity(new Intent(register_course.this, MainActivity.class));
                            return true;
                        } else if (itemId == R.id.menu_login) {
                            // Handle login action
                            // Start LoginActivity or perform login logic
                            startActivity(new Intent(register_course.this, Login.class));
                            return true;
                        } else if (itemId == R.id.menu_register) {
                            // Handle register action
                            // Start RegisterActivity or perform registration logic
                            startActivity(new Intent(register_course.this, user_info.class));
                            return true;
                        }
                        return false;
                    }
                });

                // Show the PopupMenu
                popupMenu.show();
            }
        });

    }
}