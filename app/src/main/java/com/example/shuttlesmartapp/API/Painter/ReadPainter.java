package com.example.shuttlesmartapp.API.Painter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shuttlesmartapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ReadPainter extends AppCompatActivity {

    // creating variables for our edittext,
    // button, textview and progressbar.
    private EditText txtPainterID;
    private Button btnReadPainter;
    private ProgressBar loadingPB;
    private TextView responseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_painter);

        // initializing our views
        txtPainterID = (EditText) findViewById(R.id.painterID);
        btnReadPainter = findViewById(R.id.btnReadPainter);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        btnReadPainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (txtPainterID.getText().toString().isEmpty()) {
                    Toast.makeText(ReadPainter.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("TestGettext", txtPainterID.getText().toString());
                // calling a method to post the data and passing our text fields.
                String painterId = txtPainterID.getText().toString();
                readDataUsingVolley(painterId);

            }
        });
    }

    private void readDataUsingVolley(String painterId) {
        // url to post our data
        String url = "http://192.168.8.100:8080/painter/read/" + painterId;
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(ReadPainter.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response string.
                        responseTV.setText("Response is: " + response.substring(0));
                        loadingPB.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseTV.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
