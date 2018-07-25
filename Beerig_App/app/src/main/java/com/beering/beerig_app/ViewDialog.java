package com.beering.beerig_app;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;

/**
 * this class is used as a basic formatting for the dialog pop up
 * to be used for drink ordering
 *
 * @author Brady Murphy
 * @version July 15 2018
 */
public class ViewDialog extends Dialog {

    // instance variables for the dialog
    public Activity activity;
    public Dialog dialog;
    public ImageButton drinkBtn;
    public ImageButton backBtn;
    public TextView name;
    public TextView description;
    public TextView recipe;

    private String drinkName;
    private String drinkDesc;
    private String uartChar;
    private String drinkRecipe;

    // constructor
    public ViewDialog(Activity a, Drink drink) {
        super(a);
        this.activity = a;
        this.drinkName = drink.getDrinkName();
        this.drinkDesc = drink.getDescription();
        this.uartChar = drink.getUartCom();
        this.drinkRecipe = drink.getRecipe();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.drink_dialog);

        //Display drink name and description
        description = (TextView) findViewById(R.id.drink_description);
        description.setText(drinkDesc);
        name = (TextView) findViewById(R.id.drink_name);
        name.setText(drinkName);

        //Display drink recipe
        recipe = (TextView) findViewById(R.id.drink_recipe);
        recipe.setText(drinkRecipe);

        //If user clicks "pour it" button
        //Use this method to send data to service
        drinkBtn = (ImageButton) findViewById(R.id.pour_drink);
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

                    new CountDownTimer(30000, 1000){
                        public void onTick(long milliSecondsUntilDone){
                            Toast.makeText(activity, "Seconds Remaining " + milliSecondsUntilDone / 1000, Toast.LENGTH_LONG)
                                    .show();
                        }
                        public void onFinish(){
                            Toast.makeText(activity, "Ready to pour another drink", Toast.LENGTH_LONG)
                                    .show();
                        }
                    };

                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                dismiss();
            }
        });

        //If user clicks to cancel
        //Take user back to Drink Activity
        backBtn = (ImageButton) findViewById(R.id.go_back);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dismiss();
            }
        });

    }

}

