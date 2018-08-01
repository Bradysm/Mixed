package com.beering.beerig_app;

import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.util.Hashtable;

/**
 * RandomFactList that allows for RandomFacts to be stored
 * and retrieved
 *
 * @author Andrew
 * @author Brady Murphy
 * @version Aug 1, 2018
 */
public class RandomFactList {
    /**
     * HashTable is used to create the list to allow for mapping from an
     * integer to a RandomFact. Provides 0(1) look-up and
     */
    private Hashtable<Integer, RandomFact> factList;
    private final SecureRandom randomNumberGen = new SecureRandom();

    /**
     * RandomFactList constructor
     */
    public RandomFactList(){
        // Random List
        factList = new Hashtable<Integer, RandomFact>();

        // random facts placed on list
        RandomFact bangingHead = new RandomFact("Did you know banging your head against the wall for one hour burns 150 calories");
        RandomFact yourMom = new RandomFact("Did you know the oldest \"Your Mom\" joke was discovered on a 3,500 year old Babylonian Tablet.");
        RandomFact chocolateCows = new RandomFact("7% of Americans believe chocolate milk comes from brown cows.");
        RandomFact forwardAndBackwards = new RandomFact("The following can be read forwards and backwards: \nDo geese see God?");

        //Add Awesome facts to HashTable list
        factList.put(1, bangingHead);
        factList.put(2, yourMom);
        factList.put(3, chocolateCows);
        factList.put(4, forwardAndBackwards);

    }


    /**
     * gets a random fact from the fact list and returns
     * the Fact to the caller in String format
     *
     * @return String object containing the fact
     *
     */
    public String getFact(){
        Integer num = randomNumberGen.nextInt(getNumberOfFacts()) + 1;
        return factList.get(num).getFact();
    }

    /**
     * this method return the number of facts in the fact list
     *
     * @return int value representing the number of facts
     */
    private int getNumberOfFacts(){
        return factList.size();
    }

}
