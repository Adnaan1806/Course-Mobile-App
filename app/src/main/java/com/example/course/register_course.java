package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.course.database.DatabaseHandler;
import com.example.course.model.Branch;

import java.util.List;

public class register_course extends AppCompatActivity {

    Button registerButton;
    TextView courseNameView,startDateView, endDateView, feeView, descriptionView, maxParticipantsView, courseBranchesView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_course);

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

        Intent intent = getIntent();
        int courseID = intent.getIntExtra("course_ID", -1);
        String courseName = intent.getStringExtra("course_name");
        String startDate = intent.getStringExtra("start_date");
        String endDate = intent.getStringExtra("end_date");
        double fee = intent.getDoubleExtra("fee", -1);
        String description = intent.getStringExtra("description");
        int maxParticipants = intent.getIntExtra("max_p", -1);

        courseNameView = findViewById(R.id.courseName);
        startDateView = findViewById(R.id.startingDate);
        endDateView = findViewById(R.id.endingDate);
        feeView = findViewById(R.id.fee);
        descriptionView = findViewById(R.id.description);
        maxParticipantsView = findViewById(R.id.maxpp);
        courseBranchesView = findViewById(R.id.branches);

        courseNameView.setText(courseName);
        startDateView.setText(startDate);
        endDateView.setText(endDate);
        feeView.setText(String.valueOf(fee));
        descriptionView.setText(description);
        maxParticipantsView.setText(String.valueOf(maxParticipants));
        searchForBranches(courseID);

    }

    private void searchForBranches(int courseID) {
        DatabaseHandler db = new DatabaseHandler(this);

        List<Branch> branches = db.getBranchesForACourse(courseID);
        if (branches.size() > 0) {
            for (Branch branch : branches) {
                courseBranchesView.append(branch.getBranch_name() + "\n");
            }
        }
        else {
            courseBranchesView.setText("No branches found!");
        }

    }

    }
