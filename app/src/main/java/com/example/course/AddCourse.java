package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.course.database.DatabaseHandler;
import com.example.course.model.Course;

public class AddCourse extends AppCompatActivity {

    private EditText editTextCourseName, editTextDescription, editTextStartDate, editTextEndDate,
            editTextCourseFee, editTextMaxParticipants, editTextPublishDate;
    private Spinner spinnerBranches;
    private Button btnAddCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        btnAddCourse = findViewById(R.id.btnAddCourse);


        editTextCourseName = findViewById(R.id.editTxtName);
        editTextDescription = findViewById(R.id.description);
        editTextStartDate = findViewById(R.id.editTtName);
        editTextEndDate = findViewById(R.id.editTTtName);
        editTextCourseFee = findViewById(R.id.editTtTtName);
        editTextMaxParticipants = findViewById(R.id.editffTtName);
        editTextPublishDate = findViewById(R.id.editfttTtName);
        spinnerBranches = findViewById(R.id.branches);
        btnAddCourse = findViewById(R.id.btnAddCourse);


        String[] branches = {"Mathara", "Kandy", "Negombo", "Colombo", "Jaffna", "Kegalle", "Piliyandala", "Kottawa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, branches);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranches.setAdapter(adapter);


        btnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = editTextCourseName.getText().toString().trim();
                String description = editTextDescription.getText().toString().trim();
                String startDate = editTextStartDate.getText().toString().trim();
                String endDate = editTextEndDate.getText().toString().trim();
                String courseFeeStr = editTextCourseFee.getText().toString().trim();
                String maxParticipantsStr = editTextMaxParticipants.getText().toString().trim();
                String publishDate = editTextPublishDate.getText().toString().trim();
                String selectedBranch = spinnerBranches.getSelectedItem().toString();

                //TODO: add validation, like start date < end date etc
                if (courseName.isEmpty() || description.isEmpty() || startDate.isEmpty() ||
                        endDate.isEmpty() || courseFeeStr.isEmpty() || maxParticipantsStr.isEmpty() ||
                        publishDate.isEmpty()) {
                    Toast.makeText(AddCourse.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double courseFee = Double.parseDouble(courseFeeStr);
                int maxParticipants = Integer.parseInt(maxParticipantsStr);

                Course course = new Course(courseName, startDate, endDate, courseFee, description, maxParticipants);
                addCourseToDatabase(course);
            }
        });
    }


    private void addCourseToDatabase(Course course) {
        DatabaseHandler dbHandler = new DatabaseHandler(this);
        dbHandler.addCourse(course);
        Toast.makeText(this, "Course added successfully!", Toast.LENGTH_SHORT).show();
    }

}