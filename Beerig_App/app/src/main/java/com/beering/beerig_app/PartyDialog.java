package com.beering.beerig_app;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

/**
 * @author Brady Murphy
 * @version July 24, 2018
 *
 * This class is created to represent the functionality behind
 * the Party Mode dialog
 */
public class PartyDialog extends Dialog{
    // instance variables for UI
    public Activity activity;
    public Dialog dialog;
    public ImageButton drinkBtn;
    public ImageButton backBtn;
    public TextView name;
    public TextView description;
    public TextView recipe;

    // instance variables used to store drink values
    private String drinkName;
    private String drinkDesc;
    private String uartChar;
    private String drinkRecipe;
    private int shots;

    // constructor
    public PartyDialog(Activity a, Drink drink, int numShots) {
        super(a);
        this.activity = a;
        this.drinkName = String.format("%s%s", drink.getDrinkName(), (numShots != 1 ? "'s" : ""));
        this.drinkDesc = String.format("A random alcohol was selected and you got %s's!" +
                " Your generated number of shots is %d! Line em up! A shot will be poured every 30 seconds so get ready!"
                , drinkName.toLowerCase(),
                numShots);
        this.uartChar = drink.getUartCom();
        this.drinkRecipe = String.format("%s * %d", drink.getRecipe(), numShots);
        this.shots = numShots;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.party_dialog);

        //Display drink name and description
        description = (TextView) findViewById(R.id.drink_description);
        description.setText(drinkDesc);
        name = (TextView) findViewById(R.id.drink_name);
        name.setText(drinkName);

        //Display drink recipe
        recipe = (TextView) findViewById(R.id.drink_recipe);
        recipe.setText(drinkRecipe);

        //If user clicks "pour it" button
        //Use this method to send data to Arduino
        drinkBtn = (ImageButton) findViewById(R.id.pour_drink_party);
        drinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(activity, "Enjoy the " + drinkName, Toast.LENGTH_SHORT)
                        .show();
                byte[] value;
                try {
                    //send data to service
                    value = uartChar.getBytes("UTF-8");
                    MainActivity.mService.writeRXCharacteristic(value);

                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        //If user clicks to cancel
        //Take user back to Drink Activity
        backBtn = (ImageButton) findViewById(R.id.go_back_party);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dismiss();
            }
        });

    }
}
