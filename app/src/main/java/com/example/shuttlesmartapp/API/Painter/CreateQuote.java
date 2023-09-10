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

public class CreateQuote extends AppCompatActivity {
    // creating variables for our edittext,
    // button, textview and progressbar.
    private EditText txtQuoteID, txtIssueDate, txtExpiryDate, txtTotalCost, txtStatus;
    private Button btnCreateQuote;
    private ProgressBar loadingPB;
    private TextView responseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quote);

        // initializing our views
        txtQuoteID = (EditText) findViewById(R.id.quoteID);
        txtIssueDate = (EditText) findViewById(R.id.issueDate);
        txtExpiryDate = (EditText) findViewById(R.id.expiryDate);
        txtTotalCost = (EditText) findViewById(R.id.totalCost);
        txtStatus = (EditText) findViewById(R.id.status);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        btnCreateQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (txtQuoteID.getText().toString().isEmpty()
                        || txtIssueDate.getText().toString().isEmpty()
                        || txtExpiryDate.getText().toString().isEmpty()
                        || txtTotalCost.getText().toString().isEmpty()
                        || txtStatus.getText().toString().isEmpty()) {
                    Toast.makeText(CreateQuote.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("TestGettext", txtQuoteID.getText().toString());
                // calling a method to post the data and passing our text fields.
                postDataUsingVolley(
                        txtQuoteID.getText().toString(),
                        txtIssueDate.getText().toString(),
                        txtExpiryDate.getText().toString(),
                        txtTotalCost.getText().toString(),
                        txtStatus.getText().toString());
            }
        });
    }

    private void postDataUsingVolley(String quoteId, String issueDate, String expiryDate, String totalCost, String status) {
        // url to post our data
        String url = "http://192.168.8.100:8080/quote/create";
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(CreateQuote.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty
                loadingPB.setVisibility(View.GONE);
                txtQuoteID.getText().toString();
                txtIssueDate.getText().toString();
                txtTotalCost.getText().toString();
                txtStatus.getText().toString();
//                txtPainterID.setText("");
//                txtFirstName.setText("");
//                txtLastName.setText("");
//                txtPhoneNumber.setText("");
//                txtEmail.setText("");
//                txtStreetAddress.setText("");
//                txtCity.setText("");
//                txtProvince.setText("");
//                txtPostalCode.setText("");

                // on below line we are displaying a success toast message.
                Toast.makeText(CreateQuote.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                    String quoteId = respObj.getString("quoteId");
                    String issueDate = respObj.getString("issueDate");
                    String expiryDate = respObj.getString("expiryDate");
                    String totalCost = respObj.getString("totalCost");
                    String status = respObj.getString("status");

                    // on below line we are setting this string s to our text view.
                    responseTV.setText("quoteId : " + quoteId +
                            "\n" + "issueDate : " + issueDate +
                            "\n" + "expiryDate : " + expiryDate +
                            "\n" + "totalCost : " + totalCost +
                            "\n" + "status : " + status );
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(CreateQuote.this, "Failed to get response from API = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("quoteId", String.valueOf(txtQuoteID));
                params.put("issueDate", String.valueOf(txtIssueDate));
                params.put("expiryDate", String.valueOf(txtExpiryDate));
                params.put("totalCost", String.valueOf(txtTotalCost));
                params.put("status", String.valueOf(txtStatus));

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }
}
