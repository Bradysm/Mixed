#include <Adafruit_ATParser.h>
#include <Adafruit_BLE.h>
#include <Adafruit_BLEBattery.h>
#include <Adafruit_BLEEddystone.h>
#include <Adafruit_BLEGatt.h>
#include <Adafruit_BLEMIDI.h>
#include <Adafruit_BluefruitLE_SPI.h>
#include <Adafruit_BluefruitLE_UART.h>

/**
 * @author- Brady Murphy
 * @version-Aug 20, 2018
 */

#include <Wire.h>
#include <Adafruit_MotorShield.h>
#include <Arduino.h>
#include <SPI.h>
#include "BluefruitConfig.h"
#if SOFTWARE_SERIAL_AVAILABLE
  #include <SoftwareSerial.h>
#endif



// full drink prototypes
void vodkaCranberry(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran);
void screwdriver(Adafruit_DCMotor *vodka, Adafruit_DCMotor *oj);
void vodkaRedBull(Adafruit_DCMotor *vodka, Adafruit_DCMotor *redBull);
void cokeAndRum(Adafruit_DCMotor *rum, Adafruit_DCMotor *coke);
void tequilaSunrise(Adafruit_DCMotor *tequila, Adafruit_DCMotor *oj, Adafruit_DCMotor *grenadine);
void ginAndTonic(Adafruit_DCMotor *gin, Adafruit_DCMotor *tonic);
void vodkaTonic(Adafruit_DCMotor *vodka, Adafruit_DCMotor *tonic);
void seaBreeze(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran, Adafruit_DCMotor *grapefruit);
void tomCollins(Adafruit_DCMotor *gin, Adafruit_DCMotor *lemonJuice, Adafruit_DCMotor *club, Adafruit_DCMotor *simpleSyrup);
void margarita(Adafruit_DCMotor *tequilla, Adafruit_DCMotor *margaritaMix);
void daiquiri(Adafruit_DCMotor *rum, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *simpleSyrup);
void rumSpritz(Adafruit_DCMotor *rum, Adafruit_DCMotor *club);
void lemonMarg(Adafruit_DCMotor *tequila, Adafruit_DCMotor *lemonJuice, Adafruit_DCMotor *simpleSyrup);
void gimlet(Adafruit_DCMotor *gin, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *simpleSyrup);
void ginRickey(Adafruit_DCMotor *gin, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *club);
void saltyDog(Adafruit_DCMotor *gin, Adafruit_DCMotor *grapefruit);
void madras(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran, Adafruit_DCMotor *oj);
void vodkaShot(Adafruit_DCMotor *vodka);
void tequilaShot(Adafruit_DCMotor *tequila);
void ginShot(Adafruit_DCMotor *gin);

// drink pour prototype
void drinkPour(Adafruit_DCMotor *motor, long time);

// random functions helping to support initialization
int lowerCaseToInt(int val);
void error(const __FlashStringHelper*err);
void releaseMotors(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cranberry, Adafruit_DCMotor *orangeJuice, Adafruit_DCMotor *tequila, Adafruit_DCMotor *redBull,
  Adafruit_DCMotor *tonic, Adafruit_DCMotor *grenadine, Adafruit_DCMotor *gin, Adafruit_DCMotor *rum, Adafruit_DCMotor *coke, Adafruit_DCMotor *grapefruit,
  Adafruit_DCMotor *margaritaMix, Adafruit_DCMotor *simpleSyrup, Adafruit_DCMotor *lemonJuice, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *club);

void initializeMotorSpeed(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cranberry, Adafruit_DCMotor *orangeJuice, Adafruit_DCMotor *tequila, Adafruit_DCMotor *redBull,
  Adafruit_DCMotor *tonic, Adafruit_DCMotor *grenadine, Adafruit_DCMotor *gin, Adafruit_DCMotor *rum, Adafruit_DCMotor *coke, Adafruit_DCMotor *grapefruit,
  Adafruit_DCMotor *margaritaMix, Adafruit_DCMotor *simpleSyrup, Adafruit_DCMotor *lemonJuice, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *club);

// constants
const long ONE_OUNCE = 15000; // measured pouring one ounce of vodka (15 sec with tube disjunction)
const long TWO_OUNCES = 30000; // (30 sec with tube disjuntion)
