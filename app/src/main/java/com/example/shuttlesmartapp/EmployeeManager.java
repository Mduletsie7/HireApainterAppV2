package com.example.shuttlesmartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmployeeManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_manager);

        Button btnManagePainters = findViewById(R.id.btnManagePainters);
        Button btnManageConsultants = findViewById(R.id.btnManageConsultants);

        btnManagePainters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPainterManager();
            }
        });

        btnManageConsultants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConsultantManager();
            }
        });

    }

        public void openPainterManager() {
            Intent intent = new Intent(this, PainterManager.class);
            startActivity(intent);
        }

        public void openConsultantManager() {
            Intent intent = new Intent(this, ConsultantManager.class);
            startActivity(intent);
        }
}