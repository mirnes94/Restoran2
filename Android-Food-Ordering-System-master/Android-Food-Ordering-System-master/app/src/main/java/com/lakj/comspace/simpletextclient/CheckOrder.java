package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckOrder extends Activity {
    ///
    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_EMPTY = "";
    private static final String KEY_FULLNAME = "strfullname";
    private static final String KEY_PHONENUMBER = "strphonenumber";
    private static final String KEY_DATEORDER = "strdateorder";
    private static final String KEY_EMAIL = "stremail";
    private static final String KEY_TOTAL = "strtotal";
    private static final  String KEY_STAVKE="strorderitem";



    ///
    private String request_url = "http://10.0.2.2/member/kreirajnarudzbu.php";
    ///

    CheckOrder a = this;

    TextView tv_order_item;
    private EditText phoneNumber,email,datumNarudzbe,fullName;
    private int total;
    private String strphonenumber,stremail,strdateorder,strtotal,strfullname,strorder,strorderitem;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_order);

        fullName=findViewById(R.id.etFullname);
        phoneNumber=findViewById(R.id.phone_no);
        datumNarudzbe=findViewById(R.id.etdatumNarudzbe);
        email=findViewById(R.id.email);
        total=finalize_order.all_total;



        Button narudzba = findViewById(R.id.buttonCheckOrder);
        narudzba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strfullname=fullName.getText().toString().trim();
                strphonenumber=phoneNumber.getText().toString().trim();
                strdateorder=datumNarudzbe.getText().toString().trim();
                stremail=email.getText().toString().trim();
                strtotal= String.valueOf(total).trim();
                if(validateInputs()){
                    createOrder();
                    finishOrder();
                }



            }

        });




    }


    private boolean validateInputs() {
        if (KEY_EMPTY.equals(strfullname)) {
            fullName.setError("Full name is not empty!!");
            fullName.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(strphonenumber)) {
            phoneNumber.setError("Phone number is not empty!!");
            phoneNumber.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(strdateorder)) {
            datumNarudzbe.setError("Date order is not empty!!");
            datumNarudzbe.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(stremail)) {
            email.setError("Email is not empty!!");
            email.requestFocus();
            return false;
        }


        return true;
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(CheckOrder.this);
        pDialog.setMessage("Adding data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }
    private void createOrder() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            request.put(KEY_FULLNAME,strfullname);
            request.put(KEY_PHONENUMBER, strphonenumber);
            request.put(KEY_DATEORDER, strdateorder);
            request.put(KEY_EMAIL, stremail);
            request.put(KEY_TOTAL, strtotal);

        } catch ( JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, request_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();

                        try {
                            //Check if dish added successfully
                            if (response.getInt(KEY_STATUS) == 0) {
                                //Set the user session
                                Toast.makeText(getApplicationContext(),"Narudzba uspjesno kreirana", Toast.LENGTH_LONG).show();
                                //  session.loginUser(menu_item);
                                //loadDashboard();

                            }else if(response.getInt(KEY_STATUS) == 1){
                                Toast.makeText(getApplicationContext(),
                                        response.getString(KEY_MESSAGE), Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        // Access the RequestQueue through your singleton class.


        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);

    }


    public void finishOrder(){
        Intent finish = new Intent(this, thankyou.class);
        startActivity(finish);
    }
}
