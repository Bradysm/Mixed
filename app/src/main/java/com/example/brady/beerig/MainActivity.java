package com.example.brady.beerig;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                //If User Presses Account Icon on Nav Bar
                case R.id.navigation_account:
                    setContentView(R.layout.fragment_account);

                    break;

                //If User Presses Drinks Icon on Nav Bar
                case R.id.navigation_drinks:
                    setContentView(R.layout.fragment_drink);

                    break;

                //If User Presses Settings Icon on Nav Bar
                case R.id.navigation_settings:
                    setContentView(R.layout.fragment_settings);

                    break;

                default:
                    return false;
            }
            //keepNavBar();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        //keepNavBar();
    }

    private void keepNavBar(){
        //Creates Bottom Navigation Bar When App Opens
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
