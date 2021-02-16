package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoodLab extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_lab);
        // Thread startTimer = new Thread() {
        //  public void run() {
        // try {
        //sleep(3000)
        //finish();
        // } catch (InterruptedException e) {
        //e.printStackTrace();
        //}
        //}

        // };
        // startTimer.start();
    }
    public void goToMenu(View view){
        Intent intent0 = new Intent(FoodLab.this, Order_Type.class);
        startActivity(intent0);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }
    public void home(View view)
    {
        Intent nextact1=new Intent(this,FoodLab.class);
        startActivity(nextact1);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }

}
