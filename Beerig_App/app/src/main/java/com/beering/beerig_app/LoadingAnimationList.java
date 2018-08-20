package com.beering.beerig_app;

import java.security.SecureRandom;
import java.util.Hashtable;

/**
 * @author Andrew
 * @version Aug 20, 2018
 *
 * Represents all of the potential LoadingAnimations that can be randomly
 * chosen in View or Party Dialog to be displayed while the user's drink is poured.
 */
public class LoadingAnimationList {
    /**
     * HashTable is used to create the list to allow for mapping from an
     * integer to a RandomFact. Provides 0(1) look-up and
     */
    private Hashtable<Integer, LoadingAnimation> animList;
    private final SecureRandom randomNumberGen = new SecureRandom();


    /**
     * Constructor to create Hash Table of Loading Animations
     */
    public LoadingAnimationList(){
        //Animation Hash Table list
        animList = new Hashtable<Integer, LoadingAnimation>();

        // Loading Animations from res/raw/
        LoadingAnimation dinoDance = new LoadingAnimation(R.raw.dino_dance);
        LoadingAnimation gift = new LoadingAnimation(R.raw.gift_popup);
        LoadingAnimation loader = new LoadingAnimation(R.raw.loader);
        LoadingAnimation giftBox = new LoadingAnimation(R.raw.isometric_gift_box);
        LoadingAnimation mugHead = new LoadingAnimation(R.raw.mughead);
        LoadingAnimation sunCloud = new LoadingAnimation(R.raw.sun_in_a_cloud);
        LoadingAnimation grab = new LoadingAnimation(R.raw.grab);
        LoadingAnimation loadingAnim = new LoadingAnimation(R.raw.loading_animation);
        LoadingAnimation hourglass = new LoadingAnimation(R.raw.hourglass);
        LoadingAnimation chicken = new LoadingAnimation(R.raw.funky_chicken);
        LoadingAnimation hamster = new LoadingAnimation(R.raw.loading_hamster);
        LoadingAnimation rectangle = new LoadingAnimation(R.raw.loading_retro_rectangle);
        LoadingAnimation loading1 = new LoadingAnimation(R.raw.loading_1);
        LoadingAnimation dottedLoading = new LoadingAnimation(R.raw.dotted_loader);
        LoadingAnimation cubo = new LoadingAnimation(R.raw.cubo_livre);

        // Adding Animations to animList
        animList.put(1, dinoDance);
        animList.put(2, gift);
        animList.put(3, loader);
        animList.put(4, giftBox);
        animList.put(5, mugHead);
        animList.put(6, sunCloud);
        animList.put(7, grab);
        animList.put(8, loadingAnim);
        animList.put(9, hourglass);
        animList.put(10, chicken);
        animList.put(11, hamster);
        animList.put(12, rectangle);
        animList.put(13, loading1);
        animList.put(14, dottedLoading);
        animList.put(15, cubo);

    }

    /**
     * This method chooses a random Animation from the Hash Table
     *
     * @return Animation to be displayed
     */
    public int getLoadingAnimation(){
        Integer num = randomNumberGen.nextInt(getNumberOfAnimations()) + 1;
        return animList.get(num).getLoadingAnim();
    }

    /**
     * this method return the number of Animations in the animList
     *
     * @return int value representing the number of Animations
     */
    private int getNumberOfAnimations(){
        return animList.size();
    }

}
