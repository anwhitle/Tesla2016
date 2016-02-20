
package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team4998.robot.RobotMap;
/**
 *
 */
public class Chassis extends Subsystem { 
	VictorSP leftFront, leftBack, rightBack ,rightFront; //Declare victors 
	AnalogGyro gyro; //Declare gyro
	Ultrasonic sonicSensor; //Declare ultrasonic 
	public static int ultrasonic;
	final int gyroChannel = 0; //analog input
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	leftFront   = new VictorSP (RobotMap.chassisLeftFront); // Assign victors to ports in robot map
    	leftBack = new VictorSP (RobotMap.chassisLeftBack); 
        rightFront  = new VictorSP (RobotMap.chassisRightFront);
    	rightBack = new VictorSP (RobotMap.chassisRightBack);
        gyro = new AnalogGyro(gyroChannel); 
    	ultrasonic = 1;
    	sonicSensor = new Ultrasonic (RobotMap.ultrasonic1, RobotMap.ultrasonic2); //Assign ultrasonic sensor to ports in robot map 
    }
    
    public void drive(double y, double z){
    	if(Math.abs(z) > RobotMap.deadZone){ //If z axis is greater than deadzone, then make robot rotate based on z value
        	leftFront.set(-z);
        	leftBack.set(-z);
        	rightFront.set(z);
        	rightBack.set(z);
    	} else if(Math.abs(y) > RobotMap.deadZone) { //If y axis is greater than deadzone, then make robot move forward based on y value
    		leftFront.set(y);
        	leftBack.set(y);
        	rightFront.set(y);
        	rightBack.set(y);
    	} else { //Else stop the robot 
    		leftFront.set(0);
        	leftBack.set(0);
        	rightFront.set(0);
        	rightBack.set(0);
    	}

    }
    
    public double getRange()   {
    	return sonicSensor.getRangeInches(); //gets range of ultrasonic sensor
    }
    public double getAngle() {
    	return gyro.getAngle(); // Gets angle of gryo
    }
}

