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

public class DeleteConsultant extends AppCompatActivity {

    // creating variables for our edittext,
    // button, textview and progressbar.
    private EditText txtConsultantID;
    private Button btnReadConsultant;
    private ProgressBar loadingPB;
    private TextView responseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_consultant);

        // initializing our views
        txtConsultantID = (EditText) findViewById(R.id.consultantID);
        btnReadConsultant = findViewById(R.id.btnDeleteConsultant);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        btnReadConsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (txtConsultantID.getText().toString().isEmpty()) {
                    Toast.makeText(DeleteConsultant.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("TestGettext", txtConsultantID.getText().toString());
                // calling a method to post the data and passing our text fields.
                String consultantId = txtConsultantID.getText().toString();
                readDataUsingVolley(consultantId);

            }
        });
    }

    private void readDataUsingVolley(String consultantId) {
        // url to post our data
        String url = "http://192.168.0.107:8080/consultant/delete/" + consultantId;
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(DeleteConsultant.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response string.
                        responseTV.setText("Successfully deleted: " + response.substring(0));
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
