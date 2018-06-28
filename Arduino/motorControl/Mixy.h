/**
 * @author- Brady Murphy
 * @version-June 27, 2018
 */

#include <Wire.h>
#include <Adafruit_MotorShield.h>

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
void daquiri(Adafruit_DCMotor *rum, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *simpleSyrup);
void rumSpritz(Adafruit_DCMotor *rum, Adafruit_DCMotor *club);
void lemonMarg(Adafruit_DCMotor *tequila, Adafruit_DCMotor *lemonJuice, Adafruit_DCMotor *simpleSyrup);
void gimlet(Adafruit_DCMotor *gin, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *simpleSyrup);
void ginRickey(Adafruit_DCMotor *gin, Adafruit_DCMotor *limeJuice, Adafruit_DCMotor *club);
void saltyDog(Adafruit_DCMotor *gin, Adafruit_DCMotor *grapefruit);
void madras(Adafruit_DCMotor *vodka, Adafruit_DCMotor *cran, Adafruit_DCMotor *oj);
void vodkaShot(Adafruit_DCMotor *vodka);
void tequilaShot(Adafruit_DCMotor *tequila);

// drink pour prototype
void drinkPour(Adafruit_DCMotor *motor, long time);


// constants
const long ONE_OUNCE = 15000; // measured pouring one ounce of vodka (15 sec with tube disjunction)
const long TWO_OUNCES = 30000; // (30 sec with tube disjuntion)
