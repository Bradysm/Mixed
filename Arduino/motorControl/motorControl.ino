/*
 * @author- Brady Murphy
 * @version-June 27, 2018
 * 
 * This code is used as the main runner for the beerig
 * all drinks are defined within the code and allow for variable
 * time thus enabling varying strength within the drinks.
 * This will allow for more customizability in the future.
*/

#include "Mixy.h"


// Create the motor shield object with the default I2C address
// we will have to create a specific I2C address in the future
Adafruit_MotorShield AFMS = Adafruit_MotorShield(0x60); 
Adafruit_MotorShield AFMS2 = Adafruit_MotorShield(0x61); // need to add a stacking value
Adafruit_MotorShield AFMS3 = Adafruit_MotorShield(0x63); // need to add a stacking value
Adafruit_MotorShield AFMS4 = Adafruit_MotorShield(0x64);

// Adafruit_MotorShield AFMS3 = Adafruit_MotorShield(); // need to add a stacking value
// Or, create it with a different I2C address (say for stacking)
// Adafruit_MotorShield AFMS = Adafruit_MotorShield(0x61); 

// Select which 'port' M1, M2, M3 or M4. In this case, M1
Adafruit_DCMotor *vodka = AFMS.getMotor(1); // M1 shield 1
Adafruit_DCMotor *cranberry = AFMS.getMotor(2); // M2 shield 1
Adafruit_DCMotor *orangeJuice = AFMS.getMotor(3); // M3 shield 1
Adafruit_DCMotor *tequila = AFMS.getMotor(4); // M4 shield 1

// from shield 2
Adafruit_DCMotor *redBull = AFMS2.getMotor(1);
Adafruit_DCMotor *tonic = AFMS2.getMotor(2);
Adafruit_DCMotor *grenadine = AFMS2.getMotor(3);
Adafruit_DCMotor *gin = AFMS2.getMotor(4);

// from shield 3
Adafruit_DCMotor *rum = AFMS3.getMotor(1);
Adafruit_DCMotor *coke = AFMS3.getMotor(2);
Adafruit_DCMotor *grapefruit = AFMS3.getMotor(3);
Adafruit_DCMotor *margaritaMix = AFMS3.getMotor(4);

// from shield 4
Adafruit_DCMotor *simpleSyrup = AFMS4.getMotor(1);
Adafruit_DCMotor *lemonJuice = AFMS4.getMotor(2);
Adafruit_DCMotor *limeJuice = AFMS4.getMotor(3);
Adafruit_DCMotor *club = AFMS4.getMotor(4);

/*=========================================================================
    APPLICATION SETTINGS
    FACTORYRESET_ENABLE       Perform a factory reset when running this sketch
   
                              Enabling this will put your Bluefruit LE module
                              in a 'known good' state and clear any config
                              data set in previous sketches or projects, so
                              running this at least once is a good idea.
   
                              When deploying your project, however, you will
                              want to disable factory reset by setting this
                              value to 0.  If you are making changes to your
                              Bluefruit LE device via AT commands, and those
                              changes aren't persisting across resets, this
                              is the reason why.  Factory reset will erase
                              the non-volatile memory where config data is
                              stored, setting it back to factory default
                              values.
       
                              Some sketches that require you to bond to a
                              central device (HID mouse, keyboard, etc.)
                              won't work at all with this feature enabled
                              since the factory reset will clear all of the
                              bonding data stored on the chip, meaning the
                              central device won't be able to reconnect.
    MINIMUM_FIRMWARE_VERSION  Minimum firmware version to have some new features
    MODE_LED_BEHAVIOUR        LED activity, valid options are
                              "DISABLE" or "MODE" or "BLEUART" or
                              "HWUART"  or "SPI"  or "MANUAL"
    -----------------------------------------------------------------------*/
    #define FACTORYRESET_ENABLE         1
    #define MINIMUM_FIRMWARE_VERSION    "0.6.6"
    #define MODE_LED_BEHAVIOUR          "MODE"
/*=========================================================================*/


/* ...hardware SPI, using SCK/MOSI/MISO hardware SPI pins and then user selected CS/IRQ/RST */
Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_CS, BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);

// drink variable that is used to define drinks
int drinkChoice;


void setup() {
  /************* SET UP MOTOR SHIELDS ************/
  AFMS.begin();
  AFMS2.begin();
  AFMS3.begin();
  AFMS4.begin();
  
  /************* SET UP BLUETOOTH*****************/
  Serial.begin(115200);
  Serial.println(F("<-------------- BOOTING PROCESS --------------->"));
  Serial.println(F("------------------------------------------------"));

  /* Initialise the module */
  Serial.print(F("Initialising the Bluefruit LE module: "));

  if ( !ble.begin(VERBOSE_MODE) )
  {
    error(F("Couldn't find Bluefruit, make sure it's in CoMmanD mode & check wiring?"));
  }
  Serial.println( F("OK!") );

  if ( FACTORYRESET_ENABLE )
  {
    /* Perform a factory reset to make sure everything is in a known state */
    Serial.println(F("Performing a factory reset: "));
    if ( ! ble.factoryReset() ){
      error(F("Couldn't factory reset"));
    }
  }

  /* Disable command echo from Bluefruit */
  ble.echo(false);

  Serial.println("Requesting Bluefruit info:");
  /* Print Bluefruit information */
  ble.info();

  Serial.println(F("Please use Adafruit Bluefruit LE app to connect in UART mode"));
  Serial.println(F("Then Enter characters to send to Bluefruit"));
  Serial.println();

  ble.verbose(false);  // debug info is a little annoying after this point!

  /* Wait for connection */
  while (! ble.isConnected()) {
      delay(500);
  }

  Serial.println(F("******************************"));

  // LED Activity command is only supported from 0.6.6
  if ( ble.isVersionAtLeast(MINIMUM_FIRMWARE_VERSION) )
  {
    // Change Mode LED Activity
    Serial.println(F("Change LED activity to " MODE_LED_BEHAVIOUR));
    ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
  }

  // Set module to DATA mode
  Serial.println( F("Switching to DATA mode!") );
  ble.setMode(BLUEFRUIT_MODE_DATA);

  Serial.println(F("******************************"));
   /************* SET UP BLUETOOTH*****************/

  /************* SET UP MOTORS*****************/
  Serial.println(F("******************************"));
  Serial.println();
  Serial.println(F("<----------- Initializing Beerig ----------->"));
  Serial.println(F("******************************"));
  AFMS.begin();  // create with the default frequency 1.6KHz
  //AFMS.begin(1000);  // OR with a different frequency, say 1KHz
  
  // Set the speed to start, from 0 (off) to 255 (max speed)
  vodka->setSpeed(250);
  vodka->run(FORWARD);
  cranberry->setSpeed(250);
  cranberry->run(FORWARD);
  orangeJuice->setSpeed(250);
  orangeJuice->run(FORWARD);
  tequila->setSpeed(250);
  tequila->run(FORWARD);

  redBull->setSpeed(250);
  redBull->run(FORWARD);
  tonic->setSpeed(250);
  tonic->run(FORWARD);
  grenadine->setSpeed(250);
  grenadine->run(FORWARD);
  gin->setSpeed(250);
  gin->run(FORWARD);

  rum->setSpeed(250);
  rum->run(FORWARD);
  coke->setSpeed(250);
  coke->run(FORWARD);
  grapefruit->setSpeed(250);
  grapefruit->run(FORWARD);
  margaritaMix->setSpeed(250);
  margaritaMix->run(FORWARD);

  simpleSyrup->setSpeed(250);
  simpleSyrup->run(FORWARD);
  lemonJuice->setSpeed(250);
  lemonJuice->run(FORWARD);
  limeJuice->setSpeed(250);
  limeJuice->run(FORWARD);
  club->setSpeed(250);
  club->run(FORWARD);
  
  // release motors
  vodka->run(RELEASE);
  cranberry->run(RELEASE);
  orangeJuice->run(RELEASE);
  tequila->run(RELEASE);
  redBull->run(RELEASE);
  tonic->run(RELEASE);
  grenadine->run(RELEASE);
  gin->run(RELEASE);
  rum->run(RELEASE);
  coke->run(RELEASE);
  grapefruit->run(RELEASE);
  margaritaMix->run(RELEASE);
  simpleSyrup->run(RELEASE);
  lemonJuice->run(RELEASE);
  limeJuice->run(RELEASE);
  club->run(RELEASE);
  /************* SET UP MOTORS*****************/
  // no-op drink value
  drinkChoice = 0; 
}

/*
Consistantly running listening loop
that will allow us to listen to bluetooth.
*/
void loop() {
  // read in the bluetooth data if available
  if(ble.available()){
    drinkChoice = ble.read();
    Serial.print("Drink Choice: ");
    drinkChoice = lowerCaseToInt(drinkChoice);
    Serial.println(drinkChoice);
    ble.flush();
  }

  // check to see if a drink was ordered
  if(drinkChoice != 0){
    // run through a list of drinks
    switch(drinkChoice){
      case 1:
        vodkaCranberry(vodka, cranberry);
        break;
      case 2:
        screwdriver(vodka, orangeJuice);
        break;
      case 3:
        vodkaRedBull(vodka, redBull);
        break;
      case 4:
        tequilaSunrise(tequila, orangeJuice, grenadine);
        break;
      case 5:
        ginAndTonic(gin, tonic);
        break;
      case 6:
        vodkaTonic(vodka, tonic);
        break;
      case 7:
        cokeAndRum(coke, rum);
        break;
      case 8:
        seaBreeze(vodka, cranberry, grapefruit);
        break;
      case 9:
        margarita(tequila, margaritaMix);
        break;
      case 10:
        tomCollins(gin, lemonJuice, club, simpleSyrup);
        break;
      case 11:
        daquiri(rum, limeJuice, simpleSyrup);
        break;
      case 12:
        rumSpritz(rum, club);
        break;
      case 13:
        lemonMarg(tequila, lemonJuice, simpleSyrup);
        break;
      case 14:
        gimlet(gin, limeJuice, simpleSyrup);
        break;
      case 15:
        ginRickey(gin, limeJuice, club);
        break;
      case 16:
        saltyDog(gin, grapefruit);
        break;
      case 17:
        madras(vodka, cranberry, orangeJuice);
        break;
      case 18:
        vodkaShot(vodka);
        break;
      case 19:
        tequilaShot(tequila);
        break;
      case 20:
        rumShot(rum);
        break;
      default: // catch any invalid number
        break;
    }
    drinkChoice = 0; // reset the drink choice
  }

  // turn off the motors
  vodka->run(RELEASE);
  cranberry->run(RELEASE);
  orangeJuice->run(RELEASE);
  tequila->run(RELEASE);
  redBull->run(RELEASE);
  tonic->run(RELEASE);
  grenadine->run(RELEASE);
  gin->run(RELEASE);
  rum->run(RELEASE);
  coke->run(RELEASE);
  grapefruit->run(RELEASE);
  margaritaMix->run(RELEASE);
  simpleSyrup->run(RELEASE);
  lemonJuice->run(RELEASE);
  limeJuice->run(RELEASE);
  
  // wait for one second
  delay(1000);
}

// <-----------------VODKA---------------------->

/*
 * This method will make one vodka cranberry 
 * drink. This contains one ounce of vodka
 * and 4.5 ounces of cranberry juice
 * 
 * @param-vodka: pointer to vodka motor
 * @param-cran: pointer to cranberry juice motor
*/
void vodkaCranberry(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran){
  Serial.println("Vodka Cranberry");
  Serial.println();
  drinkPour(vodka, ONE_OUNCE);
  drinkPour(cran, (long)(ONE_OUNCE * 4.5));
}

/**
 * this method will make one screwdriver
 * this contains 1.75 ounce of vodka 
 * and 3.5 ounces of OJ
 * should be served with ice
 * 
 * @param-vodka: pointer to vodka motor
 * @param-oj: pointer to orange juice motor
 */
void screwdriver(Adafruit_DCMotor *vodka, Adafruit_DCMotor *oj){
  Serial.println("Screwdriver");
  Serial.println();
  drinkPour(vodka, (long)(ONE_OUNCE * 1.75));
  drinkPour(oj, (long)(ONE_OUNCE * 3.5));
}

/**
 * This method will make one vodka red bukll
 * this contains 2 ounces of vodka
 * and 4 ounces of redbull 
 * should be served with ice
 * 
 * @param-vodka: pointer to vodka motor
 * @param-redbull: pointer to redbull motor
 */
void vodkaRedBull(Adafruit_DCMotor *vodka, Adafruit_DCMotor *redBull){
  Serial.println("Vodka RedBull");
  Serial.println();
  drinkPour(vodka, TWO_OUNCES);
  drinkPour(redBull, (long)(ONE_OUNCE * 4));
}

/**
 * This method will make one vodka-tonic
 * This drink contains 2 ounces of vodka
 * 4 ounces of tonic
 * This drink should be served with ice
 * and lime juice/wedge
 * 
 * @param-vodka: pointer to vodka motor
 * @param-tonic: pointer to tonic motor
 * 
  */
void vodkaTonic(Adafruit_DCMotor *vodka, Adafruit_DCMotor *tonic){
  Serial.println("Vodka Tonic");
  Serial.println();
  drinkPour(vodka, TWO_OUNCES);
  drinkPour(tonic, (long)(ONE_OUNCE * 4));
}


/**
 * This method will make one sea breeze drink
 * This drink contains 4 ounces of cranberry
 * 1 1/3 ounces of vodka and one ounce of grapefruit
 * This drink should be served with ice
 * and lime juice/wedge
 * 
 * @param-vodka: pointer to vodka motor
 * @param-cran: pointer to cranberry motor
 * @param-grapefruit: pointer to grapefruit motor
 * 
  */
void seaBreeze(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran, Adafruit_DCMotor *grapefruit){
  Serial.println("Sea Breeze");
  Serial.println();
  drinkPour(vodka, (long)(ONE_OUNCE * 1.333));
  drinkPour(cran, (long)(ONE_OUNCE * 4));
  drinkPour(grapefruit, ONE_OUNCE);
}

/**
 * This method will make one madras drink
 * This drink contains 3 ounces of cranberry
 * 1 1/2 ounces of vodka and one ounce of orange juice
 * This drink should be served with ice
 * and lime juice/wedge
 * 
 * @param-vodka: pointer to vodka motor
 * @param-cran: pointer to cranberry motor
 * @param-oj: pointer to orange juice motor
 * 
  */
void madras(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran, Adafruit_DCMotor *oj){
  Serial.println("Madras");
  Serial.println();
  drinkPour(vodka, (long)(ONE_OUNCE * 1.50));
  drinkPour(cran, (long)(ONE_OUNCE * 3));
  drinkPour(oj, ONE_OUNCE); 
}

/**
 * this method will pour one shot of vodka
 * 
 * @param-vodka: pointer to vodka motor
 */
void vodkaShot(Adafruit_DCMotor *vodka){
  Serial.println("Vodka Shot");
  Serial.println();
  drinkPour(vodka, TWO_OUNCES);
}

// <-------------------RUM---------------------->

/**
 * This method will make one coke and rum drink
 * This drink contains four ounces of coke
 * and 1 2/3 ounces of rum
 * This drink should be served with lime
 * 
 * @param-vodka: pointer to vodka motor
 * @param-redbull: pointer to redbull motor
 */
void cokeAndRum(Adafruit_DCMotor *rum, Adafruit_DCMotor *coke){
  Serial.println("Coke and Rum");
  Serial.println();
  drinkPour(rum, (long)(ONE_OUNCE * 4));
  drinkPour(coke, (long)(ONE_OUNCE * 1.667));
}

/**
 * This method will make one daquiri
 * This drink contains 2 ounces of rum
 * 1 ounce of lime juice and 1/2 ounce of simple syrup
 * This drink should be served with ice
 * 
 * @param-rum: pointer to rum motor
 * @param-limeJuice: pointer to lime juice motor
 * @param-simpleSyrup: pointer to tonic motor
 * 
  */
void daquiri(Adafruit_DCMotor *rum, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *simpleSyrup){
  Serial.println("Daquiri");
  Serial.println();
  drinkPour(rum, TWO_OUNCES);
  drinkPour(limeJuice, ONE_OUNCE);
  drinkPour(simpleSyrup, (long)(ONE_OUNCE * 0.5));
}


/**
 * This method will make one rum spritz
 * This drink contains 1 1/2 ounces of rum
 * and 3 ounces of club soda
 * This drink should be served with ice and a lime
 * 
 * @param-rum: pointer to rum motor
 * @param-club: pointer to club soda motor
 * 
  */
void rumSpritz(Adafruit_DCMotor *rum, Adafruit_DCMotor *club){
  Serial.println("Rum Spritz");
  Serial.println();
  drinkPour(rum, (long)(ONE_OUNCE * 1.5));
  drinkPour(club, (long)(ONE_OUNCE * 3));
}


/**
 * this method will pour one shot of rum
 * 
 * @param-rum: pointer to rum motor
 */
void rumShot(Adafruit_DCMotor *rum){
  Serial.println("Rum Shot");
  Serial.println();
  drinkPour(rum, TWO_OUNCES);
}

// <-------------------TEQUILA---------------------->

/**
 * This method will make one lemon margarita
 * This drink contains 2 ounces of tequila
 * and 1 1/2 ounces of lemon juice and 3/4 ounce simple syrup
 * This drink should be served with ice and a lemon
 * 
 * @param-tequila: pointer to tequila motor
 * @param-lemonJuice: pointer to lemon juice motor
 * @param-simpleSyrup: pointer to simple syrup motor
 * 
  */
void lemonMarg(Adafruit_DCMotor *tequila, Adafruit_DCMotor *lemonJuice, Adafruit_DCMotor *simpleSyrup){
  Serial.println("Lemon Margarita");
  Serial.println();
  drinkPour(tequila, TWO_OUNCES);
  drinkPour(lemonJuice, (long)(ONE_OUNCE * 1.5));
  drinkPour(simpleSyrup, (long)(ONE_OUNCE * .75));
}

/**
 * This method will make one tequila sunrise
 * This drink contains 3 ounces of OJ
 * 1 1/2 ounce of tequila and a half ounce
 * of grenadine
 * 
 * @param-tequila: pointer to tequila motor
 * @param-oj: pointer to OJ motor
 * @param-grenadine: pointer to grenadine motor
 * 
  */
void tequilaSunrise(Adafruit_DCMotor *tequila, Adafruit_DCMotor *oj, Adafruit_DCMotor *grenadine){
  Serial.println("Tequila Sunrise");
  Serial.println();
  drinkPour(tequila, (long)(ONE_OUNCE * 1.5));
  drinkPour(oj, (long)(ONE_OUNCE * 3));
  drinkPour(grenadine, (long)(ONE_OUNCE * 0.5));
}

/**
 * This method will make one margarita mix
 * This drink contains 1 ounce of tequilla
 * 3 ounces of jose quervo margarita mix
 * This drink should be served with ice
 * and lime. Add salt to the rim
 * 
 * @param-tequila: pointer to tequilla motor
 * @param-margaritaMix: pointer to margaritaMix motor
 * 
  */
void margarita(Adafruit_DCMotor *tequila, Adafruit_DCMotor *margaritaMix){
  Serial.println("Margarita");
  Serial.println();
  drinkPour(tequila, ONE_OUNCE);
  drinkPour(margaritaMix, (long)(ONE_OUNCE *3));
}

/**
 * this method will pour one shot of tequila
 * 
 * @param-tequila: pointer to vodka motor
 */
void tequilaShot(Adafruit_DCMotor *tequila){
  Serial.println("Tequila Shot");
  Serial.println();
  drinkPour(tequila, TWO_OUNCES);
}


// <------------------GIN--------------------->

/**
 * This method will make one gin and tonic
 * This drink contains 3 ounces of gin
 * 4 ounces of tonic
 * This drink should be served with ice
 * and lime juice
 * 
 * @param-gin: pointer to gin motor
 * @param-tonic: pointer to tonic motor
 * 
  */
void ginAndTonic(Adafruit_DCMotor *gin, Adafruit_DCMotor *tonic){
  Serial.println("Gin and Tonic");
  Serial.println();
  drinkPour(gin, (long)(ONE_OUNCE * 3));
  drinkPour(tonic, (long)(ONE_OUNCE * 4));
}

/**
 * This method will make one Tom Collins
 * This drink contains 1 1/2 ounce of gin
 * 2 ounces of club and 1/2 ounce of simple syrup
 * This drink should be served with ice and a lemon
 * 
 * @param-gin: pointer to gin motor
 * @param-lemonJuice: pointer to lemon juice motor
 * @param-club: pointer to tonic motor
 * @param-simpleSyrup: pointer to tonic motor
 * 
  */
void tomCollins(Adafruit_DCMotor *gin, Adafruit_DCMotor *lemonJuice, Adafruit_DCMotor *club, Adafruit_DCMotor *simpleSyrup){
  Serial.println("Tom Collins");
  Serial.println();
  drinkPour(gin, (long)(ONE_OUNCE * 1.5));
  drinkPour(lemonJuice, ONE_OUNCE);
  drinkPour(club, TWO_OUNCES);
  drinkPour(simpleSyrup, (long)(ONE_OUNCE * 0.5));
}

/**
 * This method will make one salty dog
 * This drink contains 2 ounces of gin
 * 4 ounces of grapefruit juice
 * This drink should be served with salt on the rim
 * and ice. Add a lime if desired
 * 
 * @param-gin: pointer to gin motor
 * @param-grapefruit: pointer to grapefruit juice motor
 * 
  */
void saltyDog(Adafruit_DCMotor *gin, Adafruit_DCMotor *grapefruit){
  Serial.println("Salty Dog");
  Serial.println();
  drinkPour(gin, TWO_OUNCES);
  drinkPour(grapefruit, (long)(ONE_OUNCE * 4));
}

/**
 * This method will make one gimlet cocktail
 * This drink contains 2 1/2 ounces of gin
 * and 1/2 ounces of lime juice and 1/2 ounce simple syrup
 * This drink should be served with ice and a lime,
 * or in a chilled glass
 * 
 * @param-gin: pointer to gin motor
 * @param-limeJuice: pointer to lime juice motor
 * @param-simpleSyrup: pointer to simple syrup motor
 * 
  */
void gimlet(Adafruit_DCMotor *gin, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *simpleSyrup){
  Serial.println("Gimlet");
  Serial.println();
  drinkPour(gin, (long)(ONE_OUNCE * 2.50));
  drinkPour(limeJuice, (long)(ONE_OUNCE * 0.50));
  drinkPour(simpleSyrup, (long)(ONE_OUNCE * 0.50));
}


/**
 * This method will make one gin rickey
 * This drink contains 2 ounces of gin
 * and one ounce of lime juice and 4 ounces of club
 * This drink should be served with ice and a lime
 * 
 * @param-gin: pointer to gin motor
 * @param-limeJuice: pointer to lime juice motor
 * @param-club: pointer to club motor
 * 
  */
void ginRickey(Adafruit_DCMotor *gin, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *club){
  Serial.println("Gin Rickey");
  Serial.println();
  drinkPour(gin, TWO_OUNCES);
  drinkPour(limeJuice, ONE_OUNCE);
  drinkPour(club, (long)(ONE_OUNCE * 4));
}

/*
 * This method will be the main method used to
 * pour any liquid. The user will define the motor
 * for which to suck the liquid from and the duration
 * for which it should do so
 * 
 * @param-motor: pointer pointing to specific Adafruit motor
 * @param-time: time in milliseconds 
*/
void drinkPour(Adafruit_DCMotor *motor, long time){
  motor->run(FORWARD);
  delay(time);
  motor->run(RELEASE);
}

/**
 * this will convert an ASCII value to int
 * for example, 'a' will result in 1
 * 
 * @param val- value in ASCII of a lowercase letter
 */
int lowerCaseToInt(int val){
  return (val-96);
}

// A small helper
void error(const __FlashStringHelper*err) {
  Serial.println(err);
  while (1);
}

