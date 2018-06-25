/*
 * This code is used as the main runner for the beerig
 * all drinks are defined within the code and allow for variable
 * time thus enabling varying strength within the drinks.
 * This will allow for more customizability in the future.
*/

#include "Mixy.h"

// Create the motor shield object with the default I2C address
// we will have to create a specific I2C address in the future
Adafruit_MotorShield AFMS = Adafruit_MotorShield(); 
// Or, create it with a different I2C address (say for stacking)
// Adafruit_MotorShield AFMS = Adafruit_MotorShield(0x61); 

// Select which 'port' M1, M2, M3 or M4. In this case, M1
Adafruit_DCMotor *vodka = AFMS.getMotor(1); // M1 shield 1
Adafruit_DCMotor *cranberry = AFMS.getMotor(2); // M2 shield 1
Adafruit_DCMotor *orangeJuice = AFMS.getMotor(3); // M3 shield 
Adafruit_DCMotor *tequila = AFMS.getMotor(4); // M4 shield 

// drink variable that is used to define drinks
int drinkChoice;

void setup() {
  Serial.begin(9600);           // set up Serial library at 9600 bps
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
  
  // turn on motor
  vodka->run(RELEASE);
  cranberry->run(RELEASE);
  orangeJuice->run(RELEASE);
  tequila->run(RELEASE);

  drinkChoice = 0; // this will be the no-op value
}

/*
Consistantly running listening loop
that will allow us to listen to bluetooth.
*/
void loop() {
  // pour one vodka cran
  if(drinkChoice != 0){
    // run through a switchcase list
    switch(drinkChoice){
      case 1:
        vodkaCranberry(vodka, cranberry);
        break;
      case 2:
        screwdriver(vodka, orangeJuice);
        break;
      case 3:
        // vodkaRedBull(vodka, redBull);
        break;
      case 4:
        // tequilaSunrise(tequila, orangeJuice, grenadine);
        break;
      case 5:
        // ginAndTonic(gin, tonic);
        break;
      case 6:
        // vodkaTonic(vodka, tonic);
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
  
  // wait for one second
  delay(1000);
}

/*
 * This method will make one vodka cranberry 
 * drink. This contains one ounce of vodka
 * and 4.5 ounces of cranberry juice
 * 
 * @param-vodka: pointer to vodka motor
 * @param-cran: pointer to cranberry juice motor
*/
void vodkaCranberry(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran){
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
  drinkPour(vodka, TWO_OUNCES);
  drinkPour(redBull, (long)(ONE_OUNCE * 4));
}

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
  drinkPour(rum, (long)(ONE_OUNCE * 4));
  drinkPour(coke, (long)(ONE_OUNCE * 1.667));
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
  drinkPour(tequila, (long)(ONE_OUNCE * 1.5));
  drinkPour(oj, (long)(ONE_OUNCE * 3));
  drinkPour(grenadine, (long)(ONE_OUNCE * 0.5));
}

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
  drinkPour(gin, (long)(ONE_OUNCE * 3));
  drinkPour(tonic, (long)(ONE_OUNCE * 4));
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
  drinkPour(vodka, TWO_OUNCES);
  drinkPour(tonic, (long)(ONE_OUNCE * 4));
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

