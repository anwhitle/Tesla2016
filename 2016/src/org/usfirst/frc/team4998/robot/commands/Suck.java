package org.usfirst.frc.team4998.robot.commands;

import org.usfirst.frc.team4998.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Suck extends Command {
	Timer stopwatch;
	double futureTime;
	boolean done;
	//static Shooter shooter = new Shooter();
    public Suck() {
    	requires (Robot.shooter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopwatch = new Timer();
    	stopwatch.start();
    	futureTime = stopwatch.get();
    	done = false;

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (stopwatch.get() < futureTime + 1){
    		Robot.shooter.shoot(-0.4);
    	} else {
    		done = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.shoot(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	done = true;
    	end();
    }
}
