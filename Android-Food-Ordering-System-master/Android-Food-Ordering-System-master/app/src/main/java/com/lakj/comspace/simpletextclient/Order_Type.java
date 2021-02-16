package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Order_Type extends Activity {
    static int new_ord_flag=0;
    @Override
    public void onBackPressed() {
        // do nothing.
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__type);

        finalize_order.all_total=PizzaMenu.n_total+BurgerMenu.n_totalBurger;//+PitaMenu.total+SokMenu.total...

        TextView tv = (TextView) findViewById(R.id.total_on_mm);
        if(finalize_order.all_total >0){
        tv.setText(""+"KM " + finalize_order.all_total);}
    }
    public void pizzaAct(View view)
    {
        Intent nextact=new Intent(this,PizzaMenu.class);
        startActivity(nextact);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }
    public void burgerAct(View view)
    {
        Intent nextact1=new Intent(this,BurgerMenu.class);
        startActivity(nextact1);
       overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }
    public void home(View view)
    {
        Intent nextact1=new Intent(this,FoodLab.class);
        startActivity(nextact1);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }


    public void fin_ord(View view)
    {
        final Object o= this;
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

                                Intent nextact = new Intent((Order_Type) o, thankyou.class);
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

