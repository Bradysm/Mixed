package com.beering.beerig_app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RumActivity extends AppCompatActivity {

    Bundle savedInstanceState = new Bundle();
    private DrinkList list = new DrinkList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rum);



    }

    public void openRumSpritz(View view){
        Drink rumSpritz = list.getDrink("Rum Spritz");
        ViewDialog dialog = new ViewDialog(this, rumSpritz.getDrinkName(), rumSpritz.getDescription());
        dialog.show();

    }

    public void openCokeAndRum(View view){
        Drink cokeAndRum = list.getDrink("Coke and Rum");
        ViewDialog dialog = new ViewDialog(this, cokeAndRum.getDrinkName(), cokeAndRum.getDescription());
        dialog.show();

    }
}
