package com.beering.beerig_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


/**
 * this class creates the functionality of the Tequila actiivty
 *
 * @author Brady Murphy
 * @version July 16 2018
 */
public class TequilaActivity extends AppCompatActivity {
    /**
     * instance variables used for this activity
     */
    Bundle savedInstanceState = new Bundle();
    private DrinkList list = new DrinkList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tequila);



    }

    /**
     * this method will open a dialog box to order a Margarita
     *
     * @param view current view
     */
    public void openMargarita(View view){
        Drink margarita = list.getDrink("Margarita");
        ViewDialog dialog = new ViewDialog(this, margarita);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a Lemon Margarita
     *
     * @param view current view
     */
    public void openLemonMarg(View view){
        Drink lemonMarg = list.getDrink("Lemon Margarita");
        ViewDialog dialog = new ViewDialog(this, lemonMarg);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a Tequila Sunrise
     *
     * @param view current view
     */
    public void openTequilaSunrise(View view){
        Drink tequilaSunrise = list.getDrink("Tequila Sunrise");
        ViewDialog dialog = new ViewDialog(this, tequilaSunrise);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a shot of tequila
     *
     * @param view current view
     */
    public void openTequilaShot(View view){
        Drink shot = list.getDrink("Tequila Shot");
        ViewDialog dialog = new ViewDialog(this, shot);
        dialog.show();

    }

    /**
     * this will move back to the previous activity
     */
    public void goBack(View view){
        finish();
    }
}
