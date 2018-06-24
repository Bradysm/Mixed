#include <Wire.h>
#include <Adafruit_MotorShield.h>

// method prototypes
void shotOfVodka(Adafruit_DCMotor *motor, int time);
void cranberryPour(Adafruit_DCMotor *motor, int time);

// constants
const int SHOT_TIME = 30000;
