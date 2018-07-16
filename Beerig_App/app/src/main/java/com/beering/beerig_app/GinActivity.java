package com.beering.beerig_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * this class is used to create the functionality of the Gin view
 *
 * @author Brady Murphy
 * @version July 16 2018
 */
public class GinActivity extends AppCompatActivity {
    /**
     * instance variables used for this activity
     */
    Bundle savedInstanceState = new Bundle();
    private DrinkList list = new DrinkList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gin);

    }

    /**
     * this method will open a dialog box to order a gin and tonic drink
     *
     * @param view current view
     */
    public void openGinAndTonic(View view){
        Drink ginTonic = list.getDrink("Gin and Tonic");
        ViewDialog dialog = new ViewDialog(this, ginTonic);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a Tom Collins drink
     *
     * @param view current view
     */
    public void openTomCollins(View view){
        Drink tomCollins = list.getDrink("Tom Collins");
        ViewDialog dialog = new ViewDialog(this, tomCollins);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a Salty Dog drink
     *
     * @param view current view
     */
    public void openSaltyDog(View view){
        Drink saltyDog = list.getDrink("Salty Dog");
        ViewDialog dialog = new ViewDialog(this, saltyDog);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a gin rickey drink
     *
     * @param view current view
     */
    public void openGinRickey(View view){
        Drink ginRickey = list.getDrink("Gin Rickey");
        ViewDialog dialog = new ViewDialog(this, ginRickey);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a gin shot
     *
     * @param view current view
     */
    public void openGinShot(View view){
        Drink ginShot = list.getDrink("Gin Shot");
        ViewDialog dialog = new ViewDialog(this, ginShot);
        dialog.show();

    }

    /**
     * this method will open a dialog box to order a Gimlet drink
     *
     * @param view current view
     */
    public void openGimlet(View view){
        Drink gimlet = list.getDrink("Gimlet");
        ViewDialog dialog = new ViewDialog(this, gimlet);
        dialog.show();

    }

}
