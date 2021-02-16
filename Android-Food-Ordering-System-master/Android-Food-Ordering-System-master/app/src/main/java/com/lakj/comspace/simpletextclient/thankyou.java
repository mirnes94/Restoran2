package com.lakj.comspace.simpletextclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class thankyou extends Activity {




    @Override
    public void onBackPressed() {
    // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

    }


    public void main_menu(View view)
    {
        finalize_order.next_ord_flag=1;
        finalize_order.old_ord_string=finalize_order.order_string+finalize_order.old_ord_string;
        finalize_order.old_all_total=finalize_order.all_total;

        PizzaMenu.margarita=0;
        PizzaMenu.capricciosa=0;
        PizzaMenu.funghi=0;
        PizzaMenu.bianca=0;
        PizzaMenu.picante=0;
        PizzaMenu.altonno=0;
        PizzaMenu.calzone=0;
        PizzaMenu.vegetariana=0;
        PizzaMenu.quanttroformaggi=0;
        PizzaMenu.n_total=0;

        BurgerMenu.maliBurger=0;
        BurgerMenu.srednjiBurger=0;
        BurgerMenu.velikiBurger=0;
        BurgerMenu.maliBurgerPiletina=0;
        BurgerMenu.srednjiBurgerPiletina=0;
        BurgerMenu.velikiBurgerPiletina=0;
        BurgerMenu.n_totalBurger=0;

        finalize_order.all_total=0;
        finalize_order.old_all_total= 0;
        finalize_order.order_string="";
        finalize_order.old_ord_string="";


        Intent menu= new Intent(this,Order_Type.class);
        startActivity(menu);

    }

    public void home(View view)
    {
        Intent nextact1=new Intent(this,FoodLab.class);
        startActivity(nextact1);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }

}

