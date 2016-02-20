package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class SimpleAuton extends CommandBase {
	Timer stopwatch;
    public SimpleAuton() {
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
    	while(stopwatch.get() < 2.0){
    		chassis.drive(0, 0.6); // Moves forward for two seconds
    	}
    	while(stopwatch.get() < 4.0){
    		chassis.drive(0, -0.6); // Moved backwards for two seconds 
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
