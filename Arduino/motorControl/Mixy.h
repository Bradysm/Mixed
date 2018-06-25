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

// drink pour prototype
void drinkPour(Adafruit_DCMotor *motor, long time);


// constants
const long ONE_OUNCE = 15000; // measured pouring one ounce of vodka (15 sec with tube disjunction)
const long TWO_OUNCES = 30000; // (30 sec with tube disjuntion)
