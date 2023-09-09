package com.example.shuttlesmartapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectManager extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_manager);

        // Declare our buttons and assign them to the layout by ID

        Button btnCreateProject = findViewById(R.id.btnCreateProject);
        Button btnReadProject = findViewById(R.id.btnReadProject);
        Button btnUpdateProject = findViewById(R.id.btnUpdateProject);
        Button btnDeleteProject = findViewById(R.id.btnDeleteProject);
        Button btnGetAllProjects = findViewById(R.id.btnGetAllProjects);

        btnCreateProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to execute after clicking button;
            }
        });
    }
}
