package com.beering.beerig_app;

/**
 * this class represents a random fact. Each random fact contains
 * a String that can be retrieved to display and use.
 *
 * @author Andrew
 * @version July 30, 2018
 */
public class RandomFact {
    /**
     * String to storing fact
     */
    private String fact;

    /**
     * RandomFact contsructor
     * @param fact String that is stored as fact
     */
    public RandomFact(String fact){

        this.fact = fact;

    }

    /**
     * random fact to be displayed in ViewDialog
     *
     * @return String fact containing random fact
     */
    public String getFact(){return fact;}



}
