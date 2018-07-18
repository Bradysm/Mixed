package com.beering.beerig_app;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements com.beering.beerig_app.BluetoothLeUart.Callback{
    // start partying button
    private ImageButton partyBtn;

    // Bluetooth Le UART instance
    public BluetoothLeUart uart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the UART object
        uart = new BluetoothLeUart(getApplicationContext());

        // grab reference to the button and make it nonclickable until arduino connection
        partyBtn = findViewById(R.id.Start_Partying);
        partyBtn.setClickable(false);
        partyBtn.setEnabled(false);

    }

    // Take user to the home screen so they can begin selecting their drink
    public void startHomeActivity(View view) {
        uart.send("r");
        Intent intent = new Intent(this, HomeScreen.class);
        MainActivity.this.startActivity(intent);
    }

    /**
     * Allows 'Start Partying' Button to fade in and out. Purely aesthetic addition.
     */
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

    // OnResume, called right before UI is displayed. Connect to the bluetooth device
    @Override
    protected void onResume(){
        super.onResume();
        uart.registerCallback(this);
        uart.connectFirstAvailable();
    }

    // OnStop, called before the activity loses foreground fo
    @Override
    protected void onDestroy(){
        super.onDestroy();
        uart.unregisterCallback(this);
        uart.disconnect();
    }

    // UART callback event handler
    @Override
    public void onConnected(BluetoothLeUart uart) {
        // called when UART device is connected and ready to send/recieve data
        // enable the start partying button
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("it worked");
                partyBtn = (ImageButton) findViewById(R.id.Start_Partying);
                partyBtn.setEnabled(true);
                partyBtn.setClickable(true);
                runStartPartyingAnimation((ImageView) partyBtn);
            }
        });
    }

    /**
     * method is called when there is an error that occurs which prevents from connecting
     * @param uart UART bluetooth object
     */
    @Override
    public void onConnectFailed(BluetoothLeUart uart) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                partyBtn = findViewById(R.id.Start_Partying);
                partyBtn.setClickable(false);
                partyBtn.setEnabled(false);
            }
        });
    }

    /**
     * called when the bluetooth UART device becomes disconnected
     * @param uart bluetooth device
     */
    @Override
    public void onDisconnected(BluetoothLeUart uart) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                partyBtn = findViewById(R.id.Start_Partying);
                partyBtn.setClickable(false);
                partyBtn.setEnabled(false);
            }
        });
    }

    @Override
    public void onReceive(BluetoothLeUart uart, BluetoothGattCharacteristic rx) {
        //TODO : this can print a toast or do nothing
    }

    /**
     * this is called when a bluetooth device is found
     * @param device device found in the world
     */
    @Override
    public void onDeviceFound(BluetoothDevice device) {
        StringBuilder notification = new StringBuilder();
        notification.append(String.format("%s%n", "Found decvice: " + device.getAddress()));
        notification.append("Waiting for device connection");
    }

    /**
     * this is called once the device is connected and the info is readily avaialble to the app
     */
    @Override
    public void onDeviceInfoAvailable() {
        StringBuilder notification = new StringBuilder();
        notification.append(uart.getDeviceInfo());
    }

    public BluetoothLeUart getUart(){
        return this.uart;
    }
}
