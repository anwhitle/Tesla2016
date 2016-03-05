package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4998.robot.Robot;
/**
 *
 */
public class Auton2 extends Command {
	Timer stopwatch;
    public Auton2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(Robot.chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopwatch = new Timer();
    	stopwatch.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(stopwatch.get() < 2.0){
    		Robot.chassis.drive(0.5, 0); //Drives forward for two seconds
    	}
    	
    	while(stopwatch.get() < 3.0){
    		Robot.chassis.drive(0, 0.6); //Rotates for one second
    	}
    	
    	while(stopwatch.get() < 5.0){
    		Robot.chassis.drive(0.5, 0); //Drives forward for two seocnds
    	}
    	
    	while(stopwatch.get() < 6.0){
    		Robot.chassis.drive(0, 0.6); //Rotates for one second
    	}
    	
    	while(stopwatch.get() < 8.0){
    		Robot.chassis.drive(0.5, 0); //Drives forward for two seconds
    	}
    	
    	while(stopwatch.get() < 9.0){
    		Robot.chassis.drive(0, 0.6); //Rotates for one second
    	}
    	
    	while(stopwatch.get() < 11.0){
    		Robot.chassis.drive(0.5, 0); //Drives for two seconds
    	}
    	
    	while(stopwatch.get() <12.0){
    		Robot.chassis.drive(0, 0.6); //Rotates for one second 
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
