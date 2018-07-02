package com.beering.beerig_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Make Start Partying Fade in and out
        ImageView startPartying = findViewById(R.id.Start_Partying);
        runStartPartyingAnimation(startPartying);

    }

    // Take user to the home screen so they can begin selecting their drink
    public void startHomeActivity(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        MainActivity.this.startActivity(intent);
    }

    // Allows 'Start Partying' Button to fade in and out. Purely aesthetic addition.
    private void runStartPartyingAnimation(ImageView startPartying){
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeIn.setRepeatCount(AlphaAnimation.INFINITE);
        fadeOut.setRepeatCount(AlphaAnimation.INFINITE);
        startPartying.startAnimation(fadeIn);
        startPartying.startAnimation(fadeOut);
        fadeIn.setDuration(1600);
        fadeOut.setDuration(1600);
        fadeOut.setStartOffset(fadeIn.getStartOffset());
        fadeIn.setStartOffset(fadeOut.getStartOffset());
    }
}
