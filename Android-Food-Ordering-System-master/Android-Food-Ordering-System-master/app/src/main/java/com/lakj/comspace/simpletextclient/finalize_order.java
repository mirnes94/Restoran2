package com.lakj.comspace.simpletextclient;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class finalize_order extends Activity {

    private static final  String KEY_STAVKE="strorderitem";
   private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private String request_url = "http://10.0.2.2/member/insertStavke.php";
   TextView tv_order_item;
   String strorderitem;

    private ProgressDialog pDialog;

 //  private EditText phoneNumber,email,datumNarudzbe,fullName;
  // private int total;
  // private String strphonenumber,stremail,strdateorder,strtotal,strfullname;
    private String strorder;


    finalize_order a = this;
   // public static Socket client;
   // public static PrintWriter printwriter;
   // public static BufferedReader bb;
   // public static String messsage;
   // public static String m1;
    static int old_all_total;
    static int all_total;

    //String personal_preferances;
    Object oo;
    public static String messsage;
    public static String m1;
    String fin_order_string = "";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string = "";
   // private ProgressDialog pDialog;

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);


        show_Order();
        tot_v();
        oo = this;

        tv_order_item=findViewById(R.id.order_final);
       Button stavke=findViewById(R.id.button5);
        stavke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strorderitem=tv_order_item.getText().toString().trim();
                createOrderItem();
                checkOrder();

            }
        });


    }


    private void displayLoader() {
        pDialog = new ProgressDialog(finalize_order.this);
        pDialog.setMessage("Adding data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    private void createOrderItem() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            request.put(KEY_STAVKE,strorderitem);

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
                                Toast.makeText(getApplicationContext(),"Stavke narudzbe uspjesno dodane", Toast.LENGTH_LONG).show();
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


    //


    public void show_Order() {


        if (PizzaMenu.margarita > 0) {
            fin_order_string = fin_order_string + "Margarita(4KM)- "+ String.valueOf(PizzaMenu.margarita) + "\n";
        }
        if (PizzaMenu.capricciosa > 0) {
            fin_order_string = fin_order_string + "Capricciosa 5KM)-" + String.valueOf(PizzaMenu.capricciosa) + "\n";
        }
        if (PizzaMenu.funghi > 0) {
            fin_order_string = fin_order_string + "Funghi(5KM)-" + String.valueOf(PizzaMenu.funghi) + "\n";
        }

        if (PizzaMenu.bianca > 0) {
            fin_order_string = fin_order_string + "Bianca(6KM)-" + String.valueOf(PizzaMenu.bianca) + "\n";
        }

        if (PizzaMenu.picante > 0) {
            fin_order_string = fin_order_string + "Picante(5KM)-" + String.valueOf(PizzaMenu.picante) + "\n";
        }
        if (PizzaMenu.altonno > 0) {
            fin_order_string = fin_order_string + "Al tonno(6KM)-" + String.valueOf(PizzaMenu.altonno) + "\n";
        }
        if (PizzaMenu.calzone > 0) {
            fin_order_string = fin_order_string + "Calzone(5KM)-" + String.valueOf(PizzaMenu.calzone) + "\n";
        }
        if (PizzaMenu.vegetariana > 0) {
            fin_order_string = fin_order_string + "Vegetariana(4KM)-" + String.valueOf(PizzaMenu.vegetariana) + "\n";
        }
        if (PizzaMenu.quanttroformaggi > 0) {
            fin_order_string = fin_order_string + "Guanttro formaggi(6KM)-" + String.valueOf(PizzaMenu.quanttroformaggi) + "\n";
        }

        if (BurgerMenu.maliBurger > 0) {
            fin_order_string = fin_order_string + "Mali Burger(3KM)-" + String.valueOf(BurgerMenu.maliBurger) + "\n";
        }
        if (BurgerMenu.srednjiBurger > 0) {
            fin_order_string = fin_order_string + "Srednji Burger(5KM)-" + String.valueOf(BurgerMenu.srednjiBurger) + "\n";
        }
        if (BurgerMenu.velikiBurger > 0) {
            fin_order_string = fin_order_string + "Veliki Burger(7KM)-" + String.valueOf(BurgerMenu.velikiBurger) + "\n";
        }
        if (BurgerMenu.maliBurgerPiletina > 0) {
            fin_order_string = fin_order_string + "Mali Burger - Piletina -(2KM)-" + String.valueOf(BurgerMenu.maliBurgerPiletina) + "\n";
        }
        if (BurgerMenu.srednjiBurgerPiletina > 0) {
            fin_order_string = fin_order_string + "Srednji Burger - Piletina -(4KM)-" + String.valueOf(BurgerMenu.srednjiBurgerPiletina) + "\n";
        }
        if (BurgerMenu.velikiBurgerPiletina > 0) {
            fin_order_string = fin_order_string + "Veliki Burger - Piletina -(6KM)-" + String.valueOf(BurgerMenu.velikiBurgerPiletina) + "\n";
        }


        String temp_order_view = fin_order_string + old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }


    public void checkOrder(){
        Intent finish = new Intent(this, CheckOrder.class);
        startActivity(finish);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v() {
        all_total = all_total + old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("total price:" + "KM " + (finalize_order.all_total));
    }




   /* public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                client = new Socket("127.0.0.top1", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb = new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(finalize_order.messsage); // write the message to output stream
                printwriter.flush();
                m1 = bb.readLine();
                //System.out.println("dd:"+m1);
                //m1="hello";
                bb.close();
                client.close(); // closing the connection
            } catch ( UnknownHostException e ) {
                e.printStackTrace();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
            return null;
        }
    }*/
    public void send_ord(View v) {
        order_string = fin_order_string;


        final Object o = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to confirm this order?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total);
                ; // get the text message on the text field
                // messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total);
                //SendMessage sendMessageTask = new SendMessage();
               // sendMessageTask.execute();
                Intent nextact = new Intent((finalize_order) o, CheckOrder.class);
                startActivity(nextact);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }





}