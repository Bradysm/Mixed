package com.beering.beerig_app;

import java.security.InvalidParameterException;
import java.util.Hashtable;

/**
 * this class is used to repersent the drink list within the Beerig
 * It contains all of the possible drinks with their descriptions
 *
 * @author Brady Murphy
 * @version July 14 2018
 */
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
        // Drink Objects... Descriptions, UART code, and recipe, respectively

        /*
         *  <------ Vodka Drinks ------>
         */

        //Vodka Cranberry
        Drink vodkaCran = new Drink("Vodka Cranberry",
                "Is made with vodka and cranberry juice. Light and refreshing. Add a lime for more flavor.", "a",
                "1 shot of Vodka", "4 and 1/2 ounces of Cranberry", "Serve with a lime");
        //ScrewDriver
        Drink screwdriver = new Drink("Screwdriver",
                "Simple drink made with vodka and Orange Juice. Nothing like having an orange drink before gameday. Go Hokies!", "b",
                "1 and 3/4 ounces vodka", "3 and 1/2 ounce of OJ", "Serve with ice");
        //Vodka Bull
        Drink vodkaBull = new Drink("Vodka RedBull",
                "This drink will get you GOIN. Need a pick me up? Here you go. Contains vodka and RedBull", "c",
                "2 shots of Vodka", "4 Ounces of RedBull", "Serve with a lime");
        //Vodka Tonic
        Drink vodkaTonic = new Drink("Vodka Tonic",
                "Very light drink that is refreshing after a long day. Add ice to glass and lime for some citrus flavor", "f", "1 shot of Vodka",
                "2 ounces of Tonic");
        //Sea Breeze
        Drink seaBreeze = new Drink("Seabreeze" ,
                "Cabo? Ahhhh Sea Breeze you mean. A Sea Breeze is a cocktail containing vodka with cranberry juice and grapefruit juice.", "h",
                "1 shot of vodka", "2 and 2/3 ounce of Cranberry", "1/3 ounce of Grapefruit");
        //Madras
        Drink madras = new Drink("Madras",
                "The Madras is a refreshing, fruity drink that lets you feel some summer anywhere. " +
                        "It consists of vodka, Oj, and cranberry juice." ,"q", "1 shot of vodka",
                        "1 and 1/2 ounce of Cranberry Juice", "1 and 1/2 ounce of Orange Juice");
        //Vodka Shot
        Drink vodkaShot = new Drink("Vodka Shot", "Well.... Hope you make it home", "r",
                "1 shot of Vodka!");

        /*
         *  <------ Tequila Drinks  ------>
         */

        //Tequila Sunrise
        Drink tequilaSunrise = new Drink("Tequila Sunrise",
                "Want to feel like you're in cabo before your exam? This drink compromised of OJ, Tequila, and grenadine has you covered","d",
                "3 shots of Tequila", "1 and 1/2 ounce of tequila", "1/2 of grenadine");
        //Margarita
        Drink margarita = new Drink("Margarita",
                "Want to be Cinco de messed up? No worries. We got your back with this marg made from Tequila and Jose Cuervo marg mix. Did someone say Tacos?",
                "i", "1 shot of tequila", "2 ounces of Margarita mix");
        //Lemon Margarita
        Drink lemonMarg = new Drink("Lemon Margarita",
                "Nice refreshing summer drink consisting of lemon juice, tequila, and simple syrup. " +
                        "Before ordering, rub rim of glass with lemon then dip in salt", "m",
                "1 shot of tequila", "1/2 ounce of Lemon juice", "3/4 ounce of Simple syrup");
        //Tequila Shot
        Drink tequilaShot = new Drink("Tequila Shot", "Make sure to get taco bell after a couple of these.", "s",
                    "1 shot of Tequila!");

        /*
         *  <------ Gin Drinks  ------>
         */

        //Gin and Tonic
        Drink ginAndTonic = new Drink("Gin and Tonic",
                "Very light drink that is refreshing after a long day. Add ice to glass and a lime for some citrus flavor", "e",
                "1 and 1/2 shots of Gin", "1 ounce of Tonic");
        //Tom Collins
        Drink tomCollins = new Drink("Tom Collins",
                "The Tom Collins is a Collins cocktail made from gin, lemon juice, sugar, and carbonated water. " +
                        "First memorialized in writing in 1876 by Jerry Thomas.","j", "1 shot of Gin", "1/2 ounce of Lemon juice",
                "1/2 ounce of Club", "1/2 ounce of Simple syrup");
        //Gimlet
        Drink gimlet = new Drink("Gimlet",
                "The gimlet is a cocktail typically made of 2 part gin, 1 part lime juice, and soda.", "n",
                "1 shot of Gin", "1/2 ounce of Lemon juice", "1/2 ounce of Simple syrup");
        //Gin Rickey
        Drink ginRickey = new Drink("Gin Rickey",
                "The rickey is a highball drink made from gin , lime juice, and carbonated water.", "o", "1 shot of Gin",
                "1 ounce of Lime juice", "2 ounces of Club");
        //Salty Dog
        Drink saltyDog = new Drink("Salty Dog",
                "A salty dog is a cocktail of gin, or vodka, and grapefruit juice, served with a salted rim. " +
                        "The salt is the only difference between a salty dog and a greyhound", "p",
                "1 shot of Gin", "2 ounces of Grapefruit");
        //Gin Shot
        Drink ginShot = new Drink("Gin Shot", "Uhh....Odd choice but okay", "u",
                "1 shot of Gin!");

        /*
         *  <------ Rum Drinks  ------>
         */

        //Coke and Rum
        Drink cokeAndRum = new Drink("Coke and Rum",
                "Rum and Coke, or a Cuba Libre, is a highball cocktail consisting of cola, rum, and traditionally lime juice on ice.", "g",
                "1 shot of Rum", "2 and 1/3 ounces of Coca Cola");
        //Daiquiri
        Drink daiquiri = new Drink("Daiquiri", "Simple daiquiri made from rum, lime juice, and simple syrup",
                "k", "1 shot of rum", "1/2 ounce of Lime juice", "1/2 ounce of Simple syrup");
        //Rum Spritz
        Drink rumSpritz = new Drink("Rum Spritz",
                "A simple, clean and easy drink to make consisting of rum and club soda. " +
                        "Add a lime for some citrus flavor", "l", "1 shot of rum",
                "1 and 1/2 ounces of Club");
        //Rum Shot
        Drink rumShot = new Drink("Rum Shot", "Why are you doing this? Heck with it, take two!", "t",
                "1 shot of Rum!");



        // add any new drinks to the hash table as created
        // same order as above

        //Vodka
        list.put(vodkaCran.getDrinkName(), vodkaCran);
        list.put(screwdriver.getDrinkName(), screwdriver);
        list.put(vodkaBull.getDrinkName(), vodkaBull);
        list.put(vodkaTonic.getDrinkName(), vodkaTonic);
        list.put(seaBreeze.getDrinkName(), seaBreeze);
        list.put(madras.getDrinkName(), madras);
        list.put(vodkaShot.getDrinkName(), vodkaShot);

        //Tequila
        list.put(tequilaSunrise.getDrinkName(), tequilaSunrise);
        list.put(margarita.getDrinkName(), margarita);
        list.put(lemonMarg.getDrinkName(), lemonMarg);
        list.put(tequilaShot.getDrinkName(), tequilaShot);

        //Gin
        list.put(ginAndTonic.getDrinkName(), ginAndTonic);
        list.put(tomCollins.getDrinkName(), tomCollins);
        list.put(gimlet.getDrinkName(), gimlet);
        list.put(ginRickey.getDrinkName(), ginRickey);
        list.put(saltyDog.getDrinkName(), saltyDog);
        list.put(ginShot.getDrinkName(), ginShot);

        //Rum
        list.put(cokeAndRum.getDrinkName(), cokeAndRum);
        list.put(daiquiri.getDrinkName(), daiquiri);
        list.put(rumSpritz.getDrinkName(), rumSpritz);
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
