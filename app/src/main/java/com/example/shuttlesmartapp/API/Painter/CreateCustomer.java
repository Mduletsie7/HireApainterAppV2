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

public class CreateCustomer extends AppCompatActivity {
    // creating variables for our edittext,
    // button, textview and progressbar.
    private EditText txtCustomerID, txtFirstName, txtLastName, txtPhoneNumber, txtEmailAddress;
    private Button btnCreateCustomer;
    private ProgressBar loadingPB;
    private TextView responseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quote);

        // initializing our views
        txtCustomerID = (EditText) findViewById(R.id.customerID);
        txtFirstName = (EditText) findViewById(R.id.firstName);
        txtLastName = (EditText) findViewById(R.id.lastName);
        txtPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        txtEmailAddress = (EditText) findViewById(R.id.emailAddress);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        btnCreateCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (txtCustomerID.getText().toString().isEmpty()
                        || txtFirstName.getText().toString().isEmpty()
                        || txtLastName.getText().toString().isEmpty()
                        || txtPhoneNumber.getText().toString().isEmpty()
                        || txtEmailAddress.getText().toString().isEmpty()) {
                    Toast.makeText(CreateCustomer.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("TestGettext", txtCustomerID.getText().toString());
                // calling a method to post the data and passing our text fields.
                postDataUsingVolley(
                        txtCustomerID.getText().toString(),
                        txtFirstName.getText().toString(),
                        txtLastName.getText().toString(),
                        txtPhoneNumber.getText().toString(),
                        txtEmailAddress.getText().toString());
            }
        });
    }

    private void postDataUsingVolley(String customerId, String firstName, String lastName, String phoneNumber, String emailAddress) {
        // url to post our data
        String url = "http://192.168.8.100:8080/customer/create";
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(CreateCustomer.this);

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
                txtCustomerID.getText().toString();
                txtFirstName.getText().toString();
                txtLastName.getText().toString();
                txtPhoneNumber.getText().toString();
                txtEmailAddress.getText().toString();
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
                Toast.makeText(CreateCustomer.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                    String customerId = respObj.getString("customerId");
                    String firstName = respObj.getString("firstName");
                    String lastName = respObj.getString("lastName");
                    String phoneNumber = respObj.getString("phoneNumber");
                    String emailAddress = respObj.getString("emailAddress");

                    // on below line we are setting this string s to our text view.
                    responseTV.setText("quoteId : " + customerId +
                            "\n" + "issueDate : " + firstName +
                            "\n" + "expiryDate : " + lastName +
                            "\n" + "totalCost : " + phoneNumber +
                            "\n" + "status : " + emailAddress );
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(CreateCustomer.this, "Failed to get response from API = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("customerId", String.valueOf(customerId));
                params.put("firstName", String.valueOf(firstName));
                params.put("lastName", String.valueOf(lastName));
                params.put("phoneNumber", String.valueOf(phoneNumber));
                params.put("emailAddress", String.valueOf(emailAddress));

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
