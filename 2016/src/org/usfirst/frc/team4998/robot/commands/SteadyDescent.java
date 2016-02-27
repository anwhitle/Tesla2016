package org.usfirst.frc.team4998.robot.commands;

import org.usfirst.frc.team4998.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SteadyDescent extends Command {
	public double theSpeed = 0;
	public double futureTime;
	Timer stopwatch;
    public SteadyDescent(double speed) {
    	requires (Robot.shooter);
    	theSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopwatch = new Timer();
    	stopwatch.start();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (theSpeed>0){
    		futureTime = stopwatch.get() +0.1;
    		while (stopwatch.get()<futureTime) {
    			Robot.shooter.lift (theSpeed);
    		}
    		theSpeed = theSpeed-0.1;
    	}
    	Robot.shooter.lift(0);
    	isFinished ();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Robot.shooter.shoot(0);
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
