package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4998.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class SimpleAuton2 extends Command {
	Timer stopwatch;
    public SimpleAuton2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopwatch = new Timer();
    	stopwatch.start();
    	stopwatch.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(stopwatch.get() < 5.0){
    		Robot.chassis.drive(0, -1); // Moves forward for two seconds
    	} else if (stopwatch.get() < 10 ){
    		Robot.chassis.drive(0, 1);
    	}
    	  else if(stopwatch.get() > 10.0){
    		Robot.chassis.drive(0, 0.0); // Moved
    	}
    	//while(stopwatch.get() < 6.0){
    		//Robot.chassis.drive(0, 0.8); // Moved backwards for two seconds 
    	//}
    	//while(stopwatch.get() < 9.0){
    		//Robot.chassis.drive(0, -0.8); // Moved backwards for two seconds 
    	//}
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
