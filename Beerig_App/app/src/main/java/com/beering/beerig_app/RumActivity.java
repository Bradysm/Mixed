package com.beering.beerig_app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Brady Murphy
 * @author Andrew Haus
 */
public class RumActivity extends AppCompatActivity {
    /**
     * instance variables used for this activity
     */
    Bundle savedInstanceState = new Bundle();
    private DrinkList list = new DrinkList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rum);



    }

    /**
     * this method will open a dialog box to order a rum spritz drink
     *
     * @param view current view
     */
    public void openRumSpritz(View view){
        Drink rumSpritz = list.getDrink("Rum Spritz");
        ViewDialog dialog = new ViewDialog(this, rumSpritz);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a rum and coke
     *
     * @param view current view
     */
    public void openCokeAndRum(View view){
        Drink cokeAndRum = list.getDrink("Coke and Rum");
        ViewDialog dialog = new ViewDialog(this, cokeAndRum);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a daiquiri
     *
     * @param view current view
     */
    public void openDaiquiri(View view){
        Drink daiquiri = list.getDrink("Daiquiri");
        ViewDialog dialog = new ViewDialog(this, daiquiri);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a shot of rum
     *
     * @param view current view
     */
    public void openRumShot(View view){
        Drink shot = list.getDrink("Rum Shot");
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
