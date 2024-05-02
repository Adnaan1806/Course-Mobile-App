package com.example.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course.database.DatabaseHandler;
import com.example.course.model.Course;

import java.util.ArrayList;
import java.util.List;

public class selectCourse extends AppCompatActivity {

    private CardView C1,C2,C3,C4,C5,C6,C7,C8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        //get all courses and put into view
        List<Course> courses = databaseHandler.fetchCourses();
        EditText searchBar = findViewById(R.id.searchCourse);

        renderCourses(courses);
        searchBar.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String query = searchBar.getText().toString();
                List<Course> searchResults = runSearch(query);
                if (searchResults.size() == 0) {
                    Toast.makeText(selectCourse.this, "No Matching Courses Found", Toast.LENGTH_SHORT).show();
                }
                renderCourses(searchResults);

            }
        });

    }

    private List<Course> runSearch(String query) {
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        return databaseHandler.queryCoursesByName(query);
    }


    private void renderCourses(List<Course> courses) {
        //clear any rendered courses
        GridLayout linearLayout = findViewById(R.id.gridLayout);
        linearLayout.removeAllViews();

        for (Course course : courses) {
            // Create a new CardView
            CardView cardView = new CardView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(12, 12, 12, 12); // Add margins to the CardView
            cardView.setLayoutParams(params);

            // Set card corner radius and elevation
            cardView.setRadius(12);
            cardView.setCardElevation(6);

            // Create a LinearLayout for the CardView content
            LinearLayout innerLayout = new LinearLayout(this);
            innerLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            ));
            innerLayout.setOrientation(LinearLayout.VERTICAL);
            innerLayout.setPadding(16, 16, 16, 16); // Add padding to the content

            // Create TextView for course name
            TextView textViewCourseName = new TextView(this);
            textViewCourseName.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textViewCourseName.setText(course.getCourse_name());
            textViewCourseName.setTextSize(20);
            textViewCourseName.setTextColor(ContextCompat.getColor(this, R.color.black));

            // Add TextView to inner layout
            innerLayout.addView(textViewCourseName);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(selectCourse.this, register_course.class);
                    intent.putExtra("course_ID", course.getCourse_ID());
                    intent.putExtra("course_name", course.getCourse_name());
                    intent.putExtra("start_date", course.getStart_date());
                    intent.putExtra("end_date", course.getEnd_date());
                    intent.putExtra("fee", course.getFee());
                    intent.putExtra("description", course.getDescription());
                    intent.putExtra("max_p", course.getMax_p());
                    startActivity(intent);
                }
            });
            // Add inner layout to CardView
            cardView.addView(innerLayout);

            // Add CardView to the LinearLayout

            linearLayout.addView(cardView);
        }

    }
}