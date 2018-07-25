package com.beering.beerig_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * HomeScreen of Mixer App. This is where user may navigate
 * to certain drink types or click on the partymode option.
 *
 * @author Andrew
 * @version July 23 2018
 *
 */
public class HomeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    // Methods to Open each Drink Activity
    // Activates when the user presses on the Tequila, Rum, Gin, or Vodka button

    //Launch Tequila Activity
    public void startTequilaActivity(View view){
        Intent tequilaIntent = new Intent(this, TequilaActivity.class);
        HomeScreen.this.startActivity(tequilaIntent);
    }

    //Launch Rum Activity
    public void startRumActivity(View view){
        Intent rumActivity = new Intent(this, RumActivity.class);
        HomeScreen.this.startActivity(rumActivity);
    }

    //Launch Gin Activity
    public void startGinActivity(View view){
        Intent ginActivity = new Intent(this, GinActivity.class);
        HomeScreen.this.startActivity(ginActivity);
    }

    //Launch Vodka Activity
    public void startVodkaActivity(View view){
        Intent vodkaActivity = new Intent(this, VodkaActivity.class);
        HomeScreen.this.startActivity(vodkaActivity);
    }

    //Launch PartyMode Activity
    public void startPartyModeActivity(View view){
        Intent partyModeActivity = new Intent(this, PartyModeActivity.class);
        HomeScreen.this.startActivity(partyModeActivity);
    }
}
