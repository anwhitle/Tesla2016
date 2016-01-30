package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonLoop extends CommandBase {
	Timer stopwatch;
	Double futureTime;
	int travelTime, textbox1, textbox2, textbox3, textbox4, textbox5;
	
    public void SimpleAuton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(chassis);
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopwatch = new Timer();
    	stopwatch.start();
    	textbox1 = Integer.parseInt(SmartDashboard.getString("DB/String 0"));
    	textbox2 = Integer.parseInt(SmartDashboard.getString("DB/String 1"));
    	textbox3 = Integer.parseInt(SmartDashboard.getString("DB/String 2"));
    	textbox4 = Integer.parseInt(SmartDashboard.getString("DB/String 3"));
    	textbox5 = Integer.parseInt(SmartDashboard.getString("DB/String 4"));
    	if (textbox1 == 1){
    		travelTime = 1;
    	} else if (textbox2 == 1) {
    		travelTime = 2;
    	} else if (textbox3 ==1) {
    		travelTime = 3;
    	} else if (textbox4 ==1) {
    		travelTime = 4;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	futureTime = stopwatch.get() +travelTime; //will move until the three seconds is up 
    	while(stopwatch.get() < futureTime){ //moving forward according to travel time
    		chassis.drive(0, 0.8); //drive
    	}
    	while (chassis.getRange() <98){ //Sensor will detect things up to 98 inches 
    	chassis.drive(0, 0.5); //drive	
    	}	
    	while(chassis.getAngle() <90) { //Robot will rotate until it reaches 90 degrees
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5); //drive
    	}
    	futureTime = stopwatch.get() +travelTime; //will move until the three seconds is up
    	while(stopwatch.get() <futureTime){ //moving forward according to travel time
    		chassis.drive(0, 0.8); //drive
    	}
    	while (chassis.getRange() <98) { //Sensor will detect things up to 98 inches
    		chassis.drive(0, 0.5); //drive	
    	}
    	while(chassis.getAngle() <90){ //Robot will rotate until it reaches 90 degrees
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5); //drive
    	}
    	futureTime = stopwatch.get() +travelTime; //will move until the three seconds is up 
    	while(stopwatch.get() < futureTime){ //moving forward according to travel time
    		chassis.drive(0, 0.8); //drive
    	}
    	while (chassis.getRange() <98) { //Sensor will detect things up to 98 inches
    		chassis.drive(0, 0.5); //drive	
    	}
    	while(chassis.getAngle() <90){ //Robot will rotate until it reaches 90 degrees
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5); //drive 
    	}
      	futureTime = stopwatch.get() +travelTime; //will move until the two seconds is up 
    	while(stopwatch.get() < futureTime){ //moving forward according to travel time
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
