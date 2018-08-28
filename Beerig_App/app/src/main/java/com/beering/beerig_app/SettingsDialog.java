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

/**
 * this class is used as a basic formatting for the dialog
 * to be used for settings. This will allow the user to prime
 * the motors and see a thank you from the Mixed Team
 *
 * @author Brady Murphy
 * @version August 28 2018
 */
public class SettingsDialog extends Dialog {
    /**
     * instance variables used to create the
     * drink dialog. Contains the various views
     * and Drink options to complete a drink order
     */
    public Activity activity;
    public ImageButton primeBtn;
    public ImageButton backBtn;
    public TextView thankYou;
    private Drink drink;

    /**
     * constructor to create Drink Dialog
     * @param a activity that it's placed on
     * @param drink drink to be poured
     */
    public SettingsDialog(Activity a, Drink drink) {
        super(a);
        this.activity = a;
        this.drink = drink;
        this.setCanceledOnTouchOutside(false);
        thankYou = (TextView) findViewById(R.id.thank_you);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settings_dialog);


        //If user clicks "prime" button
        //Use this method to send data to service
        primeBtn = (ImageButton) findViewById(R.id.prime_button);
        primeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                byte[] value;
                try {
                    //send data to service
                    value = drink.getUartCom().getBytes("UTF-8");
                    MainActivity.mService.writeRXCharacteristic(value);

                    // make the buttons invisible and update thank you
                    primeBtn.setVisibility(View.INVISIBLE);
                    backBtn.setVisibility(View.INVISIBLE);
                    final long drinkTime = drink.getPourTime();
                    thankYou.setText(R.string.priming);


                    // creates a countdown timer to update the user
                    new CountDownTimer(drinkTime, 1000){
                        // called everytime a second goes by
                        public void onTick(long milliSecondsUntilDone){
                        }
                        // this is called when the timer is over
                        public void onFinish(){
                            Toast.makeText(activity, "Motors Primed", Toast.LENGTH_LONG)
                                    .show();
                            primeBtn.setVisibility(View.VISIBLE);
                            backBtn.setVisibility(View.VISIBLE);
                            thankYou.setText(R.string.thank_you);
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


