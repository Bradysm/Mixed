package com.beering.beerig_app;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

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
    /**
     * instance variables used to create the
     * drink dialog. Contains the various views
     * and Drink options to complete a drink order
     */
    public Activity activity;
    public ImageButton drinkBtn;
    public ImageButton backBtn;
    public TextView randomFact;
    public TextView name;
    public TextView description;
    public TextView recipe;
    public RandomFactList factList;
    private Drink drink;
    private LottieAnimationView loading_anim;
    private LoadingAnimationList animationList;

    /**
     * constructor to create Drink Dialog
     * @param a activity that it's placed on
     * @param drink drink to be poured
     */
    public ViewDialog(Activity a, Drink drink) {
        super(a);
        this.activity = a;
        this.drink = drink;
        this.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.drink_dialog);

        // get the random fact and create fact list obj
        factList = new RandomFactList();
        randomFact = (TextView) findViewById(R.id.random_fact);

        // Loading Animation
        animationList = new LoadingAnimationList();
        loading_anim = findViewById(R.id.loading_anim);
        loading_anim.setAnimation(animationList.getLoadingAnimation());
        loading_anim.setVisibility(View.INVISIBLE);

        //Display drink name and description
        description = (TextView) findViewById(R.id.drink_description);
        description.setText(drink.getDescription());
        name = (TextView) findViewById(R.id.drink_name);
        name.setText(drink.getDrinkName());

        //Display drink recipe
        recipe = (TextView) findViewById(R.id.drink_recipe);
        recipe.setText(drink.getRecipe());

        //If user clicks "pour it" button
        //Use this method to send data to service
        drinkBtn = (ImageButton) findViewById(R.id.pour_drink);
        drinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(activity, "Enjoy the " + drink.getDrinkName(), Toast.LENGTH_SHORT)
                        .show();
                byte[] value;
                try {
                    //send data to service
                    value = drink.getUartCom().getBytes("UTF-8");
                    MainActivity.mService.writeRXCharacteristic(value);

                    // disable the buttons on the dialog and enable progress bar
                    drinkBtn.setVisibility(View.INVISIBLE);
                    backBtn.setVisibility(View.INVISIBLE);
                    recipe.setText("");

                    // make the bar visible
                    randomFact.setVisibility(View.VISIBLE);
                    randomFact.setText(factList.getFact());
                    final long drinkTime = drink.getPourTime();

                    // creates a countdown timer to update the user
                    new CountDownTimer(drinkTime, 1000){
                        // called everytime a second goes by
                        public void onTick(long milliSecondsUntilDone){
                            // update the description text to display time
                            description.setText(String.format("%s %d seconds",
                                    "Pour time remaining: " , milliSecondsUntilDone / 1000));

                            //start loading animation
                            loading_anim.playAnimation();
                            loading_anim.setVisibility(View.VISIBLE);

                        }
                        // this is called when the timer is over
                        public void onFinish(){
                            Toast.makeText(activity, "Ready to pour another drink", Toast.LENGTH_LONG)
                                    .show();
                            drinkBtn.setVisibility(View.VISIBLE);
                            backBtn.setVisibility(View.VISIBLE);
                            description.setText(drink.getDescription());
                            recipe.setText(drink.getRecipe());

                            dismiss();
                        }
                    }.start();

                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        // creates functionality for backBtn to take user back to Activity
        backBtn = (ImageButton) findViewById(R.id.go_back);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dismiss();
            }
        });

    }

}

