package com.beering.beerig_app;

import java.security.InvalidParameterException;
import java.util.Hashtable;

public class RandomFactList {

    private Hashtable<String, RandomFact> factList;

    public RandomFactList(){

        //Create HashTable for random facts
        factList = new Hashtable<String, RandomFact>();

        /*
         * Create new RandomFact Objects
         *
         * Will be temporarily displayed while Drink pours for user
         */

        RandomFact bangingHead = new RandomFact("Did you know banging your head against the wall for one hour burns 150 calories");

        RandomFact yourMom = new RandomFact("Did you know the oldest \"Your Mom\" joke was discovered on a 3,500 year old Babylonian Tablet.");

        RandomFact chocolateCows = new RandomFact("7% of Americans believe chocolate milk comes from brown cows.");

        RandomFact forwardAndBackwards = new RandomFact("The following can be read forwards and backwards: \nDo geese see God?");


        //Add Awesome facts to HashTable list
        factList.put(bangingHead.getFact(), bangingHead);
        factList.put(yourMom.getFact(), yourMom);
        factList.put(chocolateCows.getFact(), chocolateCows);
        factList.put(forwardAndBackwards.getFact(), forwardAndBackwards);

    }


    public RandomFact getFact(String factName){
        RandomFact result = null;
        result = factList.get(factName);

        if(result != null){
            return result;
        }

        throw new InvalidParameterException("Couldn't find a Random Fact...");
    }

}
