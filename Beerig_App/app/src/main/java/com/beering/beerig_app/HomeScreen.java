package com.beering.beerig_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void startTequilaActivity(View view){
        Intent tequilaIntent = new Intent(this, TequilaActivity.class);
        HomeScreen.this.startActivity(tequilaIntent);
    }

    public void startRumActivity(View view){
        Intent rumActivity = new Intent(this, RumActivity.class);
        HomeScreen.this.startActivity(rumActivity);
    }

    public void startGinActivity(View view){
        Intent ginActivity = new Intent(this, GinActivity.class);
        HomeScreen.this.startActivity(ginActivity);
    }

    public void startVodkaActivity(View view){
        Intent vodkaActivity = new Intent(this, VodkaActivity.class);
        HomeScreen.this.startActivity(vodkaActivity);
    }
}
