package com.example.shuttlesmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shuttlesmartapp.API.Painter.CreatePainter;
import com.example.shuttlesmartapp.API.Painter.CreateQuote;
import com.example.shuttlesmartapp.API.Painter.DeletePainter;
import com.example.shuttlesmartapp.API.Painter.DeleteQuote;
import com.example.shuttlesmartapp.API.Painter.ReadAllPainters;
import com.example.shuttlesmartapp.API.Painter.ReadPainter;
import com.example.shuttlesmartapp.API.Painter.ReadQuote;
/*
public class QuoteManager extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_manager);

        // Declare our buttons and assign them to the layout by ID

        Button btnCreateQuote = findViewById(R.id.btnCreateQuote);
        Button btnReadQuote = findViewById(R.id.btnReadQuote);
        Button btnUpdateQuote = findViewById(R.id.btnUpdateQuote);
        Button btnDeleteQuote = findViewById(R.id.btnDeleteQuote);
        Button btnGetAllQuotes = findViewById(R.id.btnGetAllQuotes);

        btnCreateQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to execute after clicking button;
                openCreateQuote();
            }
        });

        btnReadQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadQuote();
            }
        });

        btnDeleteQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openDeleteQuote(); }
        });


        btnGetAllQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReadAllQuotes();
            }
        });
    }



    public void openCreateQuote() {
        Intent intent = new Intent(this, CreateQuote.class);
        startActivity(intent);
    }

    public void openReadQuote() {
        Intent intent = new Intent(this, ReadQuote.class);
        startActivity(intent);
    }

    public void openDeleteQuote() {
        Intent intent = new Intent(this, DeleteQuote.class);
        startActivity(intent);
    }

    public void openReadAllQuotes() {
        Intent intent = new Intent(this, ReadAllQuotes.class);
        startActivity(intent);
    }







}


 */