package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BurgerMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_menu);

        total_cal();
        orders_list_init();
    }

    static int maliBurger;
    static int srednjiBurger;
    static int velikiBurger;
    static int maliBurgerPiletina;
    static int srednjiBurgerPiletina;
    static int velikiBurgerPiletina;

    static int n_totalBurger;


    public void burgermali_inc(View view){
        maliBurger=inc(maliBurger);
        TextView tv = (TextView) findViewById(R.id.tv_BurgerMali);
        tv.setText("" +  maliBurger);
        total_cal();
    }
    public void burgermali_dec(View view) {
        if ( maliBurger >= 0) {
            maliBurger= dec( maliBurger);
            TextView tv = (TextView) findViewById(R.id.tv_BurgerMali);
            if( maliBurger>0) tv.setText("" +  maliBurger);
            else tv.setText("__");
            total_cal();

        }
    }


    public void burgersrednji_inc(View view){
        srednjiBurger=inc(srednjiBurger);
        TextView tv = (TextView) findViewById(R.id.tv_BurgerSrednji);
        tv.setText("" +  srednjiBurger);
        total_cal();
    }
    public void burgersrednji_dec(View view) {
        if ( srednjiBurger >= 0) {
            srednjiBurger= dec(srednjiBurger);
            TextView tv = (TextView) findViewById(R.id.tv_BurgerSrednji);
            if( srednjiBurger>0) tv.setText("" +  srednjiBurger);
            else tv.setText("__");
            total_cal();

        }
    }

    public void burgerveliki_inc(View view){
        velikiBurger=inc(velikiBurger);
        TextView tv = (TextView) findViewById(R.id.tv_BurgerVeliki);
        tv.setText("" +  velikiBurger);
        total_cal();
    }
    public void burgerveliki_dec(View view) {
        if ( velikiBurger >= 0) {
            velikiBurger= dec(velikiBurger);
            TextView tv = (TextView) findViewById(R.id.tv_BurgerVeliki);
            if( velikiBurger>0) tv.setText("" +  velikiBurger);
            else tv.setText("__");
            total_cal();

        }
    }


    public void burgermalipiletina_inc(View view){
        maliBurgerPiletina=inc(maliBurgerPiletina);
        TextView tv = (TextView) findViewById(R.id.tv_BurgerMaliPiletina);
        tv.setText("" +  maliBurgerPiletina);
        total_cal();
    }
    public void burgermalipiletina_dec(View view) {
        if ( maliBurgerPiletina >= 0) {
            maliBurgerPiletina= dec( maliBurgerPiletina);
            TextView tv = (TextView) findViewById(R.id.tv_BurgerMaliPiletina);
            if( maliBurgerPiletina>0) tv.setText("" +  maliBurgerPiletina);
            else tv.setText("__");
            total_cal();

        }
    }


    public void burgersrednjipiletina_inc(View view){
        srednjiBurgerPiletina=inc(srednjiBurgerPiletina);
        TextView tv = (TextView) findViewById(R.id.tv_BurgerSrednjiPiletina);
        tv.setText("" +  srednjiBurgerPiletina);
        total_cal();
    }
    public void burgersrednjipiletina_dec(View view) {
        if ( srednjiBurgerPiletina >= 0) {
            srednjiBurgerPiletina= dec(srednjiBurgerPiletina);
            TextView tv = (TextView) findViewById(R.id.tv_BurgerSrednjiPiletina);
            if( srednjiBurgerPiletina>0) tv.setText("" +  srednjiBurgerPiletina);
            else tv.setText("__");
            total_cal();

        }
    }


    public void burgervelikipiletina_inc(View view){
        velikiBurgerPiletina=inc(velikiBurgerPiletina);
        TextView tv = (TextView) findViewById(R.id.tv_BurgerVelikiPiletina);
        tv.setText("" +  velikiBurgerPiletina);
        total_cal();
    }
    public void burgervelikipiletina_dec(View view) {
        if ( velikiBurgerPiletina >= 0) {
            velikiBurgerPiletina= dec(velikiBurgerPiletina);
            TextView tv = (TextView) findViewById(R.id.tv_BurgerVelikiPiletina);
            if( velikiBurgerPiletina>0) tv.setText("" +  velikiBurgerPiletina);
            else tv.setText("__");
            total_cal();

        }
    }
    public void total_cal() {
        n_totalBurger = maliBurger * (3) + srednjiBurger * (5) + velikiBurger * (7) + maliBurgerPiletina * (2) + srednjiBurgerPiletina * (4) + velikiBurgerPiletina * (6);

        finalize_order.all_total = PizzaMenu.n_total + BurgerMenu.n_totalBurger;//+PitaMenu.total + SokMenu.total.. itd

        if (finalize_order.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.n_burg_tot_id);
            tv.setText("" + "KM " + (finalize_order.all_total));
        }

        else{
            TextView tv = (TextView) findViewById(R.id.n_burg_tot_id);
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

        if(maliBurger>0) {
            TextView tv = (TextView) findViewById(R.id.tv_BurgerMali);
            tv.setText("" + maliBurger);
        }

        if(srednjiBurger>0) {
            TextView tv = (TextView) findViewById(R.id.tv_BurgerSrednji);
            tv.setText("" + srednjiBurger);
        }
        if(velikiBurger>0) {
            TextView tv = (TextView) findViewById(R.id.tv_BurgerVeliki);
            tv.setText("" +velikiBurger);
        }

        if(maliBurgerPiletina>0) {
            TextView tv = (TextView) findViewById(R.id.tv_BurgerMaliPiletina);
            tv.setText("" + maliBurgerPiletina);
        }

        if(srednjiBurgerPiletina>0) {
            TextView tv = (TextView) findViewById(R.id.tv_BurgerSrednjiPiletina);
            tv.setText("" + srednjiBurgerPiletina);
        }
        if(velikiBurgerPiletina>0) {
            TextView tv = (TextView) findViewById(R.id.tv_BurgerVelikiPiletina);
            tv.setText("" +velikiBurgerPiletina);
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

                                Intent nextact = new Intent((BurgerMenu) o, thankyou.class);
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

