package com.example.shuttlesmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shuttlesmartapp.API.Painter.ReadAllPainters;
import com.example.shuttlesmartapp.API.Painter.ReadAllProjects;

public class ProjectManager extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_manager);

        // Declare buttons and assign them to the layout by ID

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

        btnGetAllProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadAllProjects();
            }
        });
    }
    public void openReadAllProjects() {
        Intent intent = new Intent(this, ReadAllProjects.class);
        startActivity(intent);
    }
}
