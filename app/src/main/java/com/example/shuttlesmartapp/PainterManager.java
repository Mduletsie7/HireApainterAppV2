package com.example.shuttlesmartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shuttlesmartapp.API.Painter.CreatePainter;
import com.example.shuttlesmartapp.API.Painter.DeletePainter;
import com.example.shuttlesmartapp.API.Painter.ReadAllPainters;
import com.example.shuttlesmartapp.API.Painter.ReadPainter;

public class PainterManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter_manager);

        // Declare our buttons and assign them to the layout by ID

        Button btnCreatePainter = findViewById(R.id.btnCreatePainter);
        Button btnReadPainter = findViewById(R.id.btnReadPainter);
        Button btnUpdatePainter = findViewById(R.id.btnUpdatePainter);
        Button btnDeletePainter = findViewById(R.id.btnDeletePainter);
        Button btnGetAllPainters = findViewById(R.id.btnGetAllPainters);

        btnCreatePainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to execute after clicking button;
                openCreatePainter();
            }
        });

        btnReadPainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadPainter();
            }
        });

        btnDeletePainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openDeletePainter(); }
        });

        btnGetAllPainters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadAllPainters();
            }
        });
    }

    public void openCreatePainter() {
        Intent intent = new Intent(this, CreatePainter.class);
        startActivity(intent);
    }

    public void openReadPainter() {
        Intent intent = new Intent(this, ReadPainter.class);
        startActivity(intent);
    }

    public void openDeletePainter() {
        Intent intent = new Intent(this, DeletePainter.class);
        startActivity(intent);
    }
    public void openReadAllPainters() {
        Intent intent = new Intent(this, ReadAllPainters.class);
        startActivity(intent);
    }


}