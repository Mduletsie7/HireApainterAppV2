package com.example.shuttlesmartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shuttlesmartapp.API.Painter.CreatePainter;
import com.example.shuttlesmartapp.API.Painter.DeleteConsultant;
import com.example.shuttlesmartapp.API.Painter.DeletePainter;
import com.example.shuttlesmartapp.API.Painter.ReadAllConsultants;
import com.example.shuttlesmartapp.API.Painter.ReadAllPainters;
import com.example.shuttlesmartapp.API.Painter.ReadConsultant;
import com.example.shuttlesmartapp.API.Painter.ReadPainter;

public class ConsultantManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_manager);

        // Declare our buttons and assign them to the layout by ID

        Button btnCreateConsultant = findViewById(R.id.btnCreateConsultant);
        Button btnReadConsultant = findViewById(R.id.btnReadConsultant);
        Button btnUpdateConsultant = findViewById(R.id.btnUpdateConsultant);
        Button btnDeleteConsultant = findViewById(R.id.btnDeleteConsultant);
        Button btnGetAllConsultants = findViewById(R.id.btnGetAllConsultants);

        btnGetAllConsultants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to execute after clicking button;
               // openCreateConsultant();
            }
        });

        btnReadConsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadConsultant();
            }
        });

        btnDeleteConsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openDeleteConsultant(); }
        });

        btnGetAllConsultants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadAllConsultants();
            }
        });
    }

//    public void openCreatePainter() {
//        Intent intent = new Intent(this, CreateConsultant.class);
//        startActivity(intent);
//    }

    public void openReadConsultant() {
        Intent intent = new Intent(this, ReadConsultant.class);
        startActivity(intent);
    }

    public void openDeleteConsultant() {
        Intent intent = new Intent(this, DeleteConsultant.class);
        startActivity(intent);
    }
    public void openReadAllConsultants() {
        Intent intent = new Intent(this, ReadAllConsultants.class);
        startActivity(intent);
    }


}