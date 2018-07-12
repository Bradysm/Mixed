package com.beering.beerig_app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ConfirmDrinkFragment extends Fragment {

    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Temporary Dialog Title
        builder.setMessage(R.string.Start_Partying)
                .setTitle(R.string.app_name);


        //Dialog's Confirm Button
        builder.setPositiveButton(R.string.pour, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //User Clicks Pour Drink Button
            }
        });
        //Dialog's Cancel Button
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //User Clicks Cancel Button
            }
        });

        
        return builder.create();
    }

}
