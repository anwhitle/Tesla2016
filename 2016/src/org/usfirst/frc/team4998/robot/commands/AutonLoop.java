package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class AutonLoop extends CommandBase {
	Timer stopwatch;
	Double futureTime;
    public void SimpleAuton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(chassis);
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopwatch = new Timer();
    	stopwatch.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	futureTime = stopwatch.get() +3; //will move until the three seconds is up 
    	while(stopwatch.get() < futureTime){ //moving forward for 3 seconds
    		chassis.drive(0, 0.8); //drive
    	}
    	while (chassis.getRange() <98){ //Sensor will detect things up to 98 inches 
    	chassis.drive(0, 0.5); //drive	
    	}	
    	while(chassis.getAngle() <90) { //Robot will rotate until it reaches 90 degrees
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5); //drive
    	}
    	futureTime = stopwatch.get() +3; //will move until the three seconds is up
    	while(stopwatch.get() <futureTime){ //moving forward for 3 seconds
    		chassis.drive(0, 0.8); //drive
    	}
    	while (chassis.getRange() <98) { //Sensor will detect things up to 98 inches
    		chassis.drive(0, 0.5); //drive	
    	}
    	while(chassis.getAngle() <90){ //Robot will rotate until it reaches 90 degrees
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5); //drive
    	}
    	futureTime = stopwatch.get() +3; //will move until the three seconds is up 
    	while(stopwatch.get() < futureTime){ //moving forward for 3 seconds
    		chassis.drive(0, 0.8); //drive
    	}
    	while (chassis.getRange() <98) { //Sensor will detect things up to 98 inches
    		chassis.drive(0, 0.5); //drive	
    	}
    	while(chassis.getAngle() <90){ //Robot will rotate until it reaches 90 degrees
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5); //drive 
    	}
      	futureTime = stopwatch.get() +2; //will move until the two seconds is up 
    	while(stopwatch.get() < futureTime){ //moving forward for 2 seconds
    		chassis.drive(0, 0.8); //drive
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
