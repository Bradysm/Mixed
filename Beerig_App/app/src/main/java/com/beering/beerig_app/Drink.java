package com.beering.beerig_app;

public final class Drink {
    /**
     * instance variables used to define a Drink
     */
    private final String drinkName; // name of drink
    private final String description; // describes the drink
    private final char uartCom; // this will be sent to the arduino

    /**
     * constructor to create a drink object
     * @param name of drink
     * @param desc description of the drink and contents
     * @param uart character value which will define the drink
     */
    public Drink(String name, String desc, char uart){
        this.drinkName = name;
        this.description = desc;
        this.uartCom = uart;
    }

    /**
     * gets the drink name
     *
     * @return String object contianing drink name
     */
    public String getDrinkName() {
        return drinkName;
    }

    /**
     * gets the description of the drink
     *
     * @return a String obj contianing the drink description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets the character to be sent over UART
     *
     * @return char value to be sent over UART
     */
    public char getUartCom() {
        return uartCom;
    }
}
