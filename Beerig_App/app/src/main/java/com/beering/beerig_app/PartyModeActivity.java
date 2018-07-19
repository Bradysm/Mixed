package com.beering.beerig_app;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PartyModeActivity extends AppCompatActivity {

    private ImageView partyDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_mode);

        //Used to make paragraph in partymode viewable
        partyDescription = (ImageView) findViewById(R.id.party_mode_description);
        partyDescription.bringToFront();
        partyDescription.invalidate();

    }


}
