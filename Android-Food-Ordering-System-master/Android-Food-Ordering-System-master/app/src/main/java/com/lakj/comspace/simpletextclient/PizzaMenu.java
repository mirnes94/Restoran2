package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class PizzaMenu extends Activity{

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);
        total_cal();
        orders_list_init();
    }

    static int margarita;
    static int capricciosa;
    static int funghi;
    static int bianca;
    static int picante;
    static int altonno;
    static int calzone;
    static int vegetariana;
    static int quanttroformaggi;

    static int n_total;


    public void margarita_inc(View view){
        margarita=inc(margarita);
        TextView tv = (TextView) findViewById(R.id.tv_margarita);
        tv.setText("" +  margarita);
        total_cal();
    }
    public void margarita_dec(View view) {
        if ( margarita >= 0) {
            margarita= dec( margarita);
            TextView tv = (TextView) findViewById(R.id.tv_margarita);
            if( margarita>0) tv.setText("" +  margarita);
            else tv.setText("__");
            total_cal();

        }
    }

    public void capricciosa_inc(View view){
        capricciosa=inc(capricciosa);
        TextView tv = (TextView) findViewById(R.id.tv_capricciosa);
        tv.setText("" +  capricciosa);
        total_cal();
    }
    public void capricciosa_dec(View view) {
        if ( capricciosa>= 0) {
            capricciosa= dec(capricciosa);
            TextView tv = (TextView) findViewById(R.id.tv_capricciosa);
            if( capricciosa>0) tv.setText("" +  capricciosa);
            else tv.setText("__");
            total_cal();

        }
    }

    public void funghi_inc(View view){
        funghi=inc(funghi);
        TextView tv = (TextView) findViewById(R.id.tv_funghi);
        tv.setText("" +  funghi);
        total_cal();
    }
    public void funghi_dec(View view) {
        if ( funghi>= 0) {
            funghi= dec(funghi);
            TextView tv = (TextView) findViewById(R.id.tv_funghi);
            if( funghi>0) tv.setText("" +  funghi);
            else tv.setText("__");
            total_cal();

        }
    }

    public void bianca_inc(View view){
        bianca=inc(bianca);
        TextView tv = (TextView) findViewById(R.id.tv_bianca);
        tv.setText("" +  bianca);
        total_cal();
    }
    public void bianca_dec(View view) {
        if ( bianca>= 0) {
            bianca= dec(bianca);
            TextView tv = (TextView) findViewById(R.id.tv_bianca);
            if( bianca>0) tv.setText("" +  bianca);
            else tv.setText("__");
            total_cal();

        }
    }

    public void picante_inc(View view){
        picante=inc(picante);
        TextView tv = (TextView) findViewById(R.id.tv_picante);
        tv.setText("" + picante);
        total_cal();
    }
    public void picante_dec(View view) {
        if ( picante>= 0) {
            picante= dec(picante);
            TextView tv = (TextView) findViewById(R.id.tv_picante);
            if(  picante>0) tv.setText("" +  picante);
            else tv.setText("__");
            total_cal();

        }
    }

    public void altonno_inc(View view){
       altonno=inc(altonno);
        TextView tv = (TextView) findViewById(R.id.tv_altonno);
        tv.setText("" + altonno);
        total_cal();
    }
    public void altonno_dec(View view) {
        if ( altonno>= 0) {
            altonno= dec(altonno);
            TextView tv = (TextView) findViewById(R.id.tv_altonno);
            if(  altonno>0) tv.setText("" +  altonno);
            else tv.setText("__");
            total_cal();

        }
    }


    public void calzone_inc(View view){
        calzone=inc(calzone);
        TextView tv = (TextView) findViewById(R.id.tv_calzone);
        tv.setText("" + calzone);
        total_cal();
    }
    public void calzone_dec(View view) {
        if (calzone>= 0) {
            calzone= dec(calzone);
            TextView tv = (TextView) findViewById(R.id.tv_calzone);
            if( calzone>0) tv.setText("" +  calzone);
            else tv.setText("__");
            total_cal();

        }
    }

    public void vegetariana_inc(View view){
        vegetariana=inc(vegetariana);
        TextView tv = (TextView) findViewById(R.id.tv_vegetariana);
        tv.setText("" + vegetariana);
        total_cal();
    }
    public void vegetariana_dec(View view) {
        if (vegetariana>= 0) {
           vegetariana= dec(vegetariana);
            TextView tv = (TextView) findViewById(R.id.tv_vegetariana);
            if( vegetariana>0) tv.setText("" +  vegetariana);
            else tv.setText("__");
            total_cal();

        }
    }

    public void quanttroformaggi_inc(View view){
        quanttroformaggi=inc(quanttroformaggi);
        TextView tv = (TextView) findViewById(R.id.tv_quanttroformaggi);
        tv.setText("" + quanttroformaggi);
        total_cal();
    }
    public void quanttroformaggi_dec(View view) {
        if (quanttroformaggi>= 0) {
            quanttroformaggi= dec(quanttroformaggi);
            TextView tv = (TextView) findViewById(R.id.tv_quanttroformaggi);
            if( quanttroformaggi>0) tv.setText("" +  quanttroformaggi);
            else tv.setText("__");
            total_cal();

        }
    }
    public void total_cal() {
        n_total = margarita * (4) + capricciosa * (5) + funghi * (5) + bianca * (6) + picante * (5) + altonno * (6) + calzone * (5) + vegetariana * (4) + quanttroformaggi * (6);
        finalize_order.all_total = PizzaMenu.n_total+BurgerMenu.n_totalBurger;//+PitaMenu.total + SokMenu.total.. itd
        if (finalize_order.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
            tv.setText("" + "KM " + (finalize_order.all_total));
        }

        else{
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
            tv.setText("");

        }
    }





    public void main_menu(View view){
        Intent goto_main_menu= new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public int dec(int x) {
        if (x > 0) {
            x--;
            return x;
        }
        else return 0;
    }


    public int inc(int x)
    {
        x++;
        return (x);
    }

    public void orders_list_init(){

        if(margarita>0) {
            TextView tv = (TextView) findViewById(R.id.tv_margarita);
            tv.setText("" + margarita);
        }

        if(capricciosa>0) {
            TextView tv = (TextView) findViewById(R.id.tv_capricciosa);
            tv.setText("" + capricciosa);
        }
        if(funghi>0) {
            TextView tv = (TextView) findViewById(R.id.tv_funghi);
            tv.setText("" +funghi);
        }
        if(bianca>0) {
            TextView tv = (TextView) findViewById(R.id.tv_bianca);
            tv.setText("" + bianca);
        }


        if(picante>0) {
            TextView tv = (TextView) findViewById(R.id.tv_picante);
            tv.setText("" + picante);
        }
        if(altonno>0) {
            TextView tv = (TextView) findViewById(R.id.tv_altonno);
            tv.setText("" + altonno);
        }

        if(calzone>0) {
            TextView tv = (TextView) findViewById(R.id.tv_calzone);
            tv.setText("" + calzone);
        }
        if(vegetariana>0) {
            TextView tv = (TextView) findViewById(R.id.tv_vegetariana);
            tv.setText("" + vegetariana);
        }


        if(quanttroformaggi>0) {
            TextView tv = (TextView) findViewById(R.id.tv_quanttroformaggi);
            tv.setText("" + quanttroformaggi);
        }

    }

    public void fin_ord(View view)
    {
        final Object o=this;
        if(finalize_order.all_total>0) {
            Intent fin = new Intent(this, finalize_order.class);
            startActivity(fin);
            overridePendingTransition(R.anim.fadin, R.anim.fadout);
        }
        else{
            if(finalize_order.next_ord_flag==1)
            {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you don't want to place another order?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent nextact = new Intent((PizzaMenu) o, thankyou.class);
                                startActivity(nextact);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }

            else{
                Toast.makeText(getApplicationContext(),
                        "Please select your order", Toast.LENGTH_SHORT).show();
            }
        }
    }
}