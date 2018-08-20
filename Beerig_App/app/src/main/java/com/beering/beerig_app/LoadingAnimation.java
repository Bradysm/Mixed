package com.beering.beerig_app;

import com.airbnb.lottie.LottieAnimationView;

import org.json.JSONObject;

/**
 * @author Andrew
 * @version Aug 20, 2018
 *
 * This class represents the Loading Animations for the View and Party Dialog
 * This class will be used with RandomFact class while a drink is being poured
 */
public final class LoadingAnimation {

    private LottieAnimationView loadingAnim;
    private int anim;

    /**
     * Constructor for LoadingAnimation Object
     * @param loadingAnim
     */
    public LoadingAnimation(int loadingAnim){
        this.anim = loadingAnim;
    }

    /**
     * Gets the LoadingAnimation from an Object
     * @return LoadingAnimation for Dialog
     */
    public int getLoadingAnim() {
        return anim;
    }
}
