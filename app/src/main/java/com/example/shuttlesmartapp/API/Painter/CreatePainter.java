package com.example.shuttlesmartapp.API.Painter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
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

public class CreatePainter extends AppCompatActivity {
    // creating variables for our edittext,
    // button, textview and progressbar.
    private EditText txtPainterID, txtFirstName, txtLastName, txtPhoneNumber, txtEmail, txtStreetAddress, txtCity, txtProvince, txtPostalCode;
    private Button btnCreatePainter;
    private ProgressBar loadingPB;
    private TextView responseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_painter);

        // initializing our views
        txtPainterID = (EditText) findViewById(R.id.painterID);
        txtFirstName = (EditText) findViewById(R.id.firstName);
        txtLastName = (EditText) findViewById(R.id.lastName);
        txtPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtStreetAddress = (EditText) findViewById(R.id.streetAddress);
        txtCity = (EditText) findViewById(R.id.city);
        txtProvince = (EditText) findViewById(R.id.province);
        txtPostalCode = (EditText) findViewById(R.id.postalCode);
        btnCreatePainter= findViewById(R.id.btnCreatePainter);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        btnCreatePainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (txtPainterID.getText().toString().isEmpty()
                        || txtFirstName.getText().toString().isEmpty()
                        || txtLastName.getText().toString().isEmpty()
                        || txtPhoneNumber.getText().toString().isEmpty()
                        || txtEmail.getText().toString().isEmpty()
                        || txtStreetAddress.getText().toString().isEmpty()
                        || txtCity.getText().toString().isEmpty()
                        || txtProvince.getText().toString().isEmpty()
                        || txtPostalCode.getText().toString().isEmpty()) {
                    Toast.makeText(CreatePainter.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("TestGettext", txtPainterID.getText().toString());
                // calling a method to post the data and passing our text fields.
                postDataUsingVolley(
                        txtPainterID.getText().toString(),
                        txtFirstName.getText().toString(),
                        txtLastName.getText().toString(),
                        txtPhoneNumber.getText().toString(),
                        txtEmail.getText().toString(),
                        txtStreetAddress.getText().toString(),
                        txtCity.getText().toString(),
                        txtProvince.getText().toString(),
                        txtPostalCode.getText().toString());

            }
        });
    }

    private void postDataUsingVolley(String painterId, String firstName, String lastName, String phoneNumber, String email, String streetAddress, String city, String province, String postalCode) {
        // url to post our data
        String url = "http://192.168.0.107:8080/painter/create";
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(CreatePainter.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty
                loadingPB.setVisibility(View.GONE);
                txtPainterID.getText().toString();
                txtFirstName.getText().toString();
                txtLastName.getText().toString();
                txtPhoneNumber.getText().toString();
                txtEmail.getText().toString();
                txtStreetAddress.getText().toString();
                txtCity.getText().toString();
                txtProvince.getText().toString();
                txtPostalCode.getText().toString();
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
                Toast.makeText(CreatePainter.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                    String painterId = respObj.getString("painterId");
                    String firstName = respObj.getString("firstName");
                    String lastName = respObj.getString("lastName");
                    String phoneNumber = respObj.getString("phoneNumber");
                    String email = respObj.getString("email");
                    String streetAddress = respObj.getString("streetAddress");
                    String city = respObj.getString("city");
                    String province = respObj.getString("province");
                    String postalCode = respObj.getString("postalCode");

                    // on below line we are setting this string s to our text view.
                    responseTV.setText("painterId : " + painterId +
                            "\n" + "firstName : " + firstName +
                            "\n" + "lastName : " + lastName +
                            "\n" + "phoneNumber : " + phoneNumber +
                            "\n" + "email : " + email +
                            "\n" + "streetAddress : " + streetAddress +
                            "\n" + "city : " + city +
                            "\n" + "province : " + province +
                            "\n" + "postalCode : " + postalCode);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(CreatePainter.this, "Failed to get response from API = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("painterId", String.valueOf(txtPainterID));
                params.put("firstName", String.valueOf(txtFirstName));
                params.put("lastName", String.valueOf(txtLastName));
                params.put("phoneNumber", String.valueOf(txtPhoneNumber));
                params.put("email", String.valueOf(txtEmail));
                params.put("streetAddress", String.valueOf(txtStreetAddress));
                params.put("city", String.valueOf(txtCity));
                params.put("province", String.valueOf(txtProvince));
                params.put("postalCode", String.valueOf(txtPostalCode));

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
