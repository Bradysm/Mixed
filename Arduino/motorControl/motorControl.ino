/* 
This is a test sketch for the Adafruit assembled Motor Shield for Arduino v2
It won't work with v1.x motor shields! Only for the v2's with built in PWM
control

For use with the Adafruit Motor Shield v2 
---->  http://www.adafruit.com/products/1438
*/

#include "Mixy.h"

// Create the motor shield object with the default I2C address
// we will have to create a specific I2C address in the future
Adafruit_MotorShield AFMS = Adafruit_MotorShield(); 
// Or, create it with a different I2C address (say for stacking)
// Adafruit_MotorShield AFMS = Adafruit_MotorShield(0x61); 

// Select which 'port' M1, M2, M3 or M4. In this case, M1
Adafruit_DCMotor *shield1Motor1 = AFMS.getMotor(1);
Adafruit_DCMotor *shield1Motor2 = AFMS.getMotor(2);


// boolean varaiables
bool poured;

void setup() {
  Serial.begin(9600);           // set up Serial library at 9600 bps
  AFMS.begin();  // create with the default frequency 1.6KHz
  //AFMS.begin(1000);  // OR with a different frequency, say 1KHz
  
  // Set the speed to start, from 0 (off) to 255 (max speed)
  shield1Motor1->setSpeed(250);
  shield1Motor1->run(FORWARD);
  shield1Motor2->setSpeed(250);
  shield1Motor2->run(FORWARD);
  
  // turn on motor
  shield1Motor1->run(RELEASE);
  shield1Motor2->run(RELEASE);

  poured = false;
}

/*
Consistantly running listening loop
that will allow us to listen to bluetooth.
*/
void loop() {
  // pour one vodka cran
  if(!poured){
    shotOfVodka(shield1Motor1, (SHOT_TIME/2));
    cranberryPour(shield1Motor2, 30000);
    poured = true;
  }

  // turn off the motors
  shield1Motor1->run(RELEASE);
  shield1Motor2->run(RELEASE);
  
  // wait for one second
  delay(1000);
}

/* this method will pour vodka for the 
 *  duration of the time given as the parameter
 *  @param time-time in miliseconds for vodka to pour
*/
void shotOfVodka(Adafruit_DCMotor *motor, int time){
  motor->run(FORWARD);
  delay(time);
  motor->run(RELEASE);
}

/* this will pour cranberry juice for the alotted
  amount of time passed
*/
void cranberryPour(Adafruit_DCMotor *motor, int time){
  motor->run(FORWARD);
  delay(time);
  motor->run(RELEASE);
}

