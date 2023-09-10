package com.example.shuttlesmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shuttlesmartapp.API.Painter.CreateCustomer;
import com.example.shuttlesmartapp.API.Painter.CreateQuote;
import com.example.shuttlesmartapp.API.Painter.DeleteCustomer;
import com.example.shuttlesmartapp.API.Painter.DeleteQuote;
import com.example.shuttlesmartapp.API.Painter.ReadAllCustomers;
import com.example.shuttlesmartapp.API.Painter.ReadAllQuotes;
import com.example.shuttlesmartapp.API.Painter.ReadCustomer;
import com.example.shuttlesmartapp.API.Painter.ReadQuote;

public class CustomerManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_manager);

        // Declare our buttons and assign them to the layout by ID

        Button btnCreateCustomer = findViewById(R.id.btnCreateCustomer);
        Button btnReadCustomer = findViewById(R.id.btnReadCustomer);
        Button btnUpdateCustomer = findViewById(R.id.btnUpdateCustomer);
        Button btnDeleteCustomer = findViewById(R.id.btnDeleteCustomer);
        Button btnGetAllCustomers = findViewById(R.id.btnDeleteCustomer);

        btnCreateCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to execute after clicking button;
                openCreateCustomer();
            }
        });

        btnReadCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadCustomer();
            }
        });

        btnDeleteCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openDeleteCustomer(); }
        });

        btnGetAllCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadAllCustomers();
            }
        });
    }

    public void openCreateCustomer() {
        Intent intent = new Intent(this, CreateCustomer.class);
        startActivity(intent);
    }

    public void openReadCustomer() {
        Intent intent = new Intent(this, ReadCustomer.class);
        startActivity(intent);
    }

    public void openDeleteCustomer() {
        Intent intent = new Intent(this, DeleteCustomer.class);
        startActivity(intent);
    }
    public void openReadAllCustomers() {
        Intent intent = new Intent(this, ReadAllCustomers.class);
        startActivity(intent);
    }

}