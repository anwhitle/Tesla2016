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
    	futureTime = stopwatch.get() +2;
    	while(stopwatch.get() < futureTime){ //moving forward for 2 seconds
    		chassis.drive(0, 0.8);
    	}
    	while(chassis.get() <90) {
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5);
    	}
    	futureTime = stopwatch.get() +2;
    	while(stopwatch.get() <futureTime){ //moving forward for 2 seconds
    		chassis.drive(0, 0.8);
    	}
    	while(chassis.get() <90){
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5);
    	}
    	futureTime = stopwatch.get() +2;
    	while(stopwatch.get() < futureTime){ //moving forward for 2 seconds
    		chassis.drive(0, 0.8);
    	}
    	while(chassis.get() <9.0){
    		//turning until the robot is 90 degrees
    		chassis.drive(0, -0.5);
    	}
      	futureTime = stopwatch.get() +2;
    	while(stopwatch.get() < futureTime){ //moving forward for 2 seconds
    		chassis.drive(0, 0.8);
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
