package com.beering.beerig_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*final ImageView startPartying = findViewById(R.id.Start_Partying);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade);
        startPartying.startAnimation(anim);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startPartying.startAnimation(anim);
                            }
                        });
                    }
                },
                4000
        );*/
    }

    public void startHomeActivity(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        MainActivity.this.startActivity(intent);
    }
}
