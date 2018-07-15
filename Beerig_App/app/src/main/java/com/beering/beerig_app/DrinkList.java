package com.beering.beerig_app;

import java.security.InvalidParameterException;
import java.util.Hashtable;

public final class DrinkList {
    /**
     * hashtable used to store the drink list and provide O(1) lookup
     */
    private Hashtable<String, Drink> list;

    /**
     * constructor to create a DrinkList
     */
    public DrinkList(){
        // create the Hashtable
        list = new Hashtable<String, Drink>();

        // create the Drink objects
        Drink vodkaCran = new Drink("Vodka Cranberry",
                "Is made with vodka and cranberry juice. Light and refreshing. Add a lime for more flavor.", 'a');
        Drink screwdriver = new Drink("Screwdriver",
                "Simple drink made with vodka and Orange Juice. Nothing like having an orange drink before gameday. Go Hokies!", 'b');
        Drink vodkaBull = new Drink("Vodka RedBull",
                "This drink will get you GOIN. Need a pick me up? Here you go. Contains vodka and RedBull", 'c');
        Drink tequilaSunrise = new Drink("Tequla Sunrise",
                "Want to feel like you're in cabo before your exam? This drink compromised of OJ, Tequila, and grenadine has you covered",'d');
        Drink ginAndTonic = new Drink("Gin and Tonic",
                "Very light drink that is refreshing after a long day. Add ice to glass and a lime for some citrus flavor", 'e');
        Drink vodkaTonic = new Drink("Vodka Tonic",
                "Very light drink that is refreshing after a long day. Add ice to glass and lime for some citrus flavor", 'f');
        Drink cokeAndRum = new Drink("Coke and Rum",
                "Rum and Coke, or a Cuba Libre, is a highball cocktail consisting of cola, rum, and traditionally lime juice on ice.", 'g');
        Drink seaBreeze = new Drink("Sea Breeze" ,
                "Cabo? Ahhhh Sea Breeze you mean. A Sea Breeze is a cocktail containing vodka with cranberry juice and grapefruit juice.", 'h');
        Drink margarita = new Drink("Margarita",
                "Want to be Cinqo de messed up? No worries. We got your back with this marg made from Tequila and Jose Cuervo marg mix. Did someone say Tacos?",
                'i');
        Drink tomCollins = new Drink("Tom Collins",
                "The Tom Collins is a Collins cocktail made from gin, lemon juice, sugar, and carbonated water. " +
                        "First memorialized in writing in 1876 by Jerry Thomas.",'j');
        Drink daiquiri = new Drink("Daiquiri", "Simple daiquiri made from rum, lime juice, and simple syrup",
                'k');
        Drink rumSpritz = new Drink("Rum Spritz",
                "A simple, clean and easy drink to make consisting of rum and club soda. " +
                        "Add a lime for some citrus flavor", 'l');
        Drink lemonMarg = new Drink("Lemon Margarita",
                "Nice refreshing summer drink consisting of lemon juice, tequila, and simple syrup. " +
                        "Before ordering, rub rim of glass with lemon then dip in salt", 'm');
        Drink gimlet = new Drink("Gimlet",
                "The gimlet is a cocktail typically made of 2 part gin, 1 part lime juice, and soda.", 'n');
        Drink ginRickey = new Drink("Gin Rickey",
                "The rickey is a highball drink made from gin , lime juice, and carbonated water.", 'o');
        Drink saltyDog = new Drink("Salty Dog",
                "A salty dog is a cocktail of gin, or vodka, and grapefruit juice, served with a salted rim. " +
                        "The salt is the only difference between a salty dog and a greyhound", 'p');
        Drink madras = new Drink("Madras",
                "The Madras is a refreshing, fruity drink that lets you feel some summer anywhere. " +
                        "It consists of vodka, Oj, and cranberry juice." ,'q');
        Drink vodkaShot = new Drink("Vodka Shot", "Well.... Hope you make it home", 'r');
        Drink tequilaShot = new Drink("Tequila Shot", "Make sure to get taco bell after a couple of these.", 'r');
        Drink rumShot = new Drink("Rum Shot", "Why are you doing this? Heck with it, take two!", 's');

        // add any new drinks to the hash table as created
        list.put(vodkaCran.getDrinkName(), vodkaCran);
        list.put(screwdriver.getDrinkName(), screwdriver);
        list.put(vodkaBull.getDrinkName(), vodkaBull);
        list.put(tequilaSunrise.getDrinkName(), tequilaSunrise);
        list.put(ginAndTonic.getDrinkName(), ginAndTonic);
        list.put(vodkaTonic.getDrinkName(), vodkaTonic);
        list.put(cokeAndRum.getDrinkName(), cokeAndRum);
        list.put(seaBreeze.getDrinkName(), seaBreeze);
        list.put(margarita.getDrinkName(), margarita);
        list.put(tomCollins.getDrinkName(), tomCollins);
        list.put(daiquiri.getDrinkName(), daiquiri);
        list.put(rumSpritz.getDrinkName(), rumSpritz);
        list.put(lemonMarg.getDrinkName(), lemonMarg);
        list.put(gimlet.getDrinkName(), gimlet);
        list.put(ginRickey.getDrinkName(), ginRickey);
        list.put(saltyDog.getDrinkName(), saltyDog);
        list.put(madras.getDrinkName(), madras);
        list.put(vodkaShot.getDrinkName(), vodkaShot);
        list.put(tequilaShot.getDrinkName(), tequilaShot);
        list.put(rumShot.getDrinkName(), rumShot);

    }

    /**
     * retreives a drink object from the drink list from
     * the name of the drink. Returns the Drink object which
     * matches the drink name
     *
     * @param drinkName String containing the drinks name
     * @throws InvalidParameterException if drink name was not found
     * @return Drink obj
     */
    public Drink getDrink(String drinkName){
        Drink result = null;
        result = list.get(drinkName);
        if(result != null)
            return result;

        throw new InvalidParameterException("Drink name was not recognized");
    }
}
