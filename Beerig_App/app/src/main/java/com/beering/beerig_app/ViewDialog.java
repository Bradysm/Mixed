package com.beering.beerig_app;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * this class is used as a basic formatting for the dialog pop up
 * to be used for drink ordering
 *
 * @author Brady Murphy
 * @version July 15 2018
 */
public class ViewDialog extends Dialog {
    // instance variables for the dialog
    public Activity activity;
    public Dialog dialog;
    public ImageButton drinkBtn;
    public ImageButton backBtn;
    public TextView name;
    public TextView description;
    private String drinkName;
    private String drinkDesc;

    // constructor
    public ViewDialog(Activity a, String name, String description) {
        super(a);
        this.activity = a;
        this.drinkName = name;
        this.drinkDesc = description;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.drink_dialog);
        drinkBtn = (ImageButton) findViewById(R.id.pour_drink);
        backBtn = (ImageButton) findViewById(R.id.go_back);

        description = (TextView) findViewById(R.id.drink_description);
        description.setText(drinkDesc);
        name = (TextView) findViewById(R.id.drink_name);
        name.setText(drinkName);

    }

}

