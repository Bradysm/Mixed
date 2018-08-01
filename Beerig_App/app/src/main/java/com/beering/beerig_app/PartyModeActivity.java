package com.beering.beerig_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.security.SecureRandom;

public class PartyModeActivity extends AppCompatActivity {

    /**
     * instance variables used to create the functionality
     * of party mode
     */
    private ImageView partyDescription;
    private DrinkList list = new DrinkList();
    private SecureRandom randomNumber = new SecureRandom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_mode);

        //Used to make paragraph in partymode viewable
        partyDescription = (ImageView) findViewById(R.id.party_mode_description);
        partyDescription.bringToFront();
        partyDescription.invalidate();

    }

    /**
     * this method will open the dialog box for Party Mode
     *
     * @param view current view
     */
    public void openPartyDialog(View view){
        // create a random number to determine vodka or tequila
        int randomNum = randomNumber.nextInt(2) + 1;
        int randomShots = randomNumber.nextInt(4) + 1;
        Drink randomDrink;

        if(randomNum == 1)
            randomDrink = list.getDrink("Vodka Shot");
        else
            randomDrink = list.getDrink("Tequila Shot");


        PartyDialog dialog = new PartyDialog(this, randomDrink, randomShots);
        dialog.show();
    }

    /**
     * this will end the activity and take the user back to main screen
     * @param view current View
     */
    public void goBack(View view){
        finish();
    }

}
