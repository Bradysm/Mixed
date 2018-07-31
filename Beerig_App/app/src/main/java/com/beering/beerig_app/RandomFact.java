package com.beering.beerig_app;

public class RandomFact {

    private String fact;

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
