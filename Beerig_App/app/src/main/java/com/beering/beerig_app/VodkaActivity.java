package com.beering.beerig_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * this class controls the functionality of the vodka activity
 *
 * @author Brady Murphy
 * @version July 16 2018
 */
public class VodkaActivity extends AppCompatActivity {
    /**
     * instance variables used for this activity
     */
    Bundle savedInstanceState = new Bundle();
    private DrinkList list = new DrinkList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vodka);



    }

    /**
     * this method will open a dialog box to order a vodka cranberry drink
     *
     * @param view current view
     */
    public void openVodkaCran(View view){
        Drink vodkaCran = list.getDrink("Vodka Cranberry");
        ViewDialog dialog = new ViewDialog(this, vodkaCran);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a screwdriver drink
     *
     * @param view current view
     */
    public void openScrewdriver(View view){
        Drink screwdriver = list.getDrink("Screwdriver");
        ViewDialog dialog = new ViewDialog(this, screwdriver);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a vodka RedBull drink
     *
     * @param view current view
     */
    public void openVodkaBull(View view){
        Drink vodkaBull = list.getDrink("Vodka RedBull");
        ViewDialog dialog = new ViewDialog(this, vodkaBull);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a vodka tonic drink
     *
     * @param view current view
     */
    public void openVodkaTonic(View view){
        Drink vodkaTonic = list.getDrink("Vodka Tonic");
        ViewDialog dialog = new ViewDialog(this, vodkaTonic);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a seabreeze drink
     *
     * @param view current view
     */
    public void openSeabreeze(View view){
        Drink seabreeze = list.getDrink("Seabreeze");
        ViewDialog dialog = new ViewDialog(this, seabreeze);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a madras drink
     *
     * @param view current view
     */
    public void openMadras(View view){
        Drink madras = list.getDrink("Madras");
        ViewDialog dialog = new ViewDialog(this, madras);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a vodka shot
     *
     * @param view current view
     */
    public void openVodkaShot(View view){
        Drink vodkaShot = list.getDrink("Vodka Shot");
        ViewDialog dialog = new ViewDialog(this, vodkaShot);
        dialog.show();

    }

    /**
     * this will move back to the previous activity
     */
    public void goBack(){
        finish();
    }
}
