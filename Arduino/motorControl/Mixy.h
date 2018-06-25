#include <Wire.h>
#include <Adafruit_MotorShield.h>

// full drink prototypes
void vodkaCranberry();
void screwdriver();
void vodkaRedBull();
void cokeAndRum();
void tequilaSunrise();

// liquor prototypes
void vodkaPour(Adafruit_DCMotor *motor, int time);
void rumPour(Adafruit_DCMotor *motor, int time);
void tequilaPour(Adafruit_DCMotor *motor, int time);
void ginPour(Adafruit_DCMotor *motor, int time);

// mixer prototypes
void grapefruitPour(Adafruit_DCMotor *motor, int time);
void ojPour(Adafruit_DCMotor *motor, int time); 
void cranberryPour(Adafruit_DCMotor *motor, int time);
void cokePour(Adafruit_DCMotor *motor, int time);
void tonicPour(Adafruit_DCMotor *motor, int time);
void grenadinePour(Adafruit_DCMotor *motor, int time);
void redBullPour(Adafruit_DCMotor *motor, int time);


// constants
const int ONE_OUNCE = 15000; // measured pouring one ounce of vodka (15 sec with tube disjunction)
const int TWO_OUNCES = 30000; // (30 sec with tube disjuntion)
