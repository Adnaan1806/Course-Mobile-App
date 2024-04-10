package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] Branches = {"Colombo", "kandy" , "Matara" , "Galle"};

    AutoCompleteTextView BranchSelection;

    ArrayAdapter<String> adapterItems;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, user_info.class);
            startActivity(intent);

            BranchSelection = findViewById(R.id.BranchSelection);

            adapterItems = new ArrayAdapter<String>(this,R.layout.list_items);

            BranchSelection.setAdapter(adapterItems);

            BranchSelection.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getApplicationContext(),"Branch"+Branches,Toast.LENGTH_SHORT).show();

                }

            });
        });

    }
}