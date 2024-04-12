package com.example.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class selectCourse extends AppCompatActivity {

    private CardView C1,C2,C3,C4,C5,C6,C7,C8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course);

        C1 = findViewById(R.id.c1);
        C2 = findViewById(R.id.c2);
        C3 = findViewById(R.id.c3);
        C4 = findViewById(R.id.c4);
        C5 = findViewById(R.id.c5);
        C6 = findViewById(R.id.c6);
        C7 = findViewById(R.id.c7);
        C8 = findViewById(R.id.c8);

        //click on each cards to navigate to register_course activity(course details page)
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectCourse.this, register_course.class);
                startActivity(intent);
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectCourse.this, register_course.class);
                startActivity(intent);
            }
        }); // likewise can do for other cards

        ImageView accountImage = findViewById(R.id.account_image);

        // Set OnClickListener to the ImageView
        accountImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create PopupMenu
                PopupMenu popupMenu = new PopupMenu(selectCourse.this, v);

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
                            startActivity(new Intent(selectCourse.this, MainActivity.class));
                            return true;
                        } else if (itemId == R.id.menu_login) {
                            // Handle login action
                            // Start LoginActivity or perform login logic
                            startActivity(new Intent(selectCourse.this, Login.class));
                            return true;
                        } else if (itemId == R.id.menu_register) {
                            // Handle register action
                            // Start RegisterActivity or perform registration logic
                            startActivity(new Intent(selectCourse.this, user_info.class));
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