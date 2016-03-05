
package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Ultrasonic;
//import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team4998.robot.RobotMap;
/**
 *
 */
public class Chassis extends Subsystem { 
	VictorSP leftFront, leftBack, rightBack ,rightFront; //Declare victors 
	//AnalogGyro gyro; //Declare gyro
	//Ultrasonic sonicSensor; //Declare ultrasonic 
	double correctLF, correctLB, correctRF, correctRB;
	//public static int ultrasonic;
	//final int gyroChannel = 0; //analog input
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	leftFront   = new VictorSP (RobotMap.chassisLeftFront); // Assign victors to ports in robot map
    	leftBack = new VictorSP (RobotMap.chassisLeftBack); 
        rightFront  = new VictorSP (RobotMap.chassisRightFront);
    	rightBack = new VictorSP (RobotMap.chassisRightBack);
       // gyro = new AnalogGyro(gyroChannel); 
    	//ultrasonic = 1;
    	//sonicSensor = new Ultrasonic (RobotMap.ultrasonic1, RobotMap.ultrasonic2); //Assign ultrasonic sensor to ports in robot map 
    	correctLF = 1.0;
    	correctLB = 1.0;
    	correctRF = 1.0;
    	correctRB = 1.0;
    }
    
    
    public void drive(double y, double z){
    	if(Math.abs(z) > 0.05){ //If z axis is greater than deadzone, then make robot rotate based on z value
        	leftFront.set(-z*.5*correctLF);
        	leftBack.set(-z*.5*correctLB);
        	rightFront.set(z*.5*correctRF);
        	rightBack.set(z*.5*correctRB);
    	} else if(Math.abs(y) > RobotMap.deadZone) { //If y axis is greater than deadzone, then make robot move forward based on y value
    		leftFront.set(y*correctLF);
        	leftBack.set(y*correctLB);
        	rightFront.set(y*correctRF);
        	rightBack.set(y*correctRB);
    	} else { //Else stop the robot 
    		leftFront.set(0);
        	leftBack.set(0);
        	rightFront.set(0);
        	rightBack.set(0);
    	}

    }
    
    public double getRange()   {
    	return 0; //sonicSensor.getRangeInches(); //gets range of ultrasonic sensor
    }
    public double getAngle() {
    	return 0; //gyro.getAngle(); // Gets angle of gryo
    }
}

