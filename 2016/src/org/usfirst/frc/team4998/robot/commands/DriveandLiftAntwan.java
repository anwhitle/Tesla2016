package org.usfirst.frc.team4998.robot.commands;

import org.usfirst.frc.team4998.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveandLiftAntwan extends Command {
	public double driveForward(){
		if (Robot.oi.getXboxRightT() > 0.1){
			return Robot.oi.getXboxRightT()* -1;
		} else if (Robot.oi.getXboxLeftT() > 0.1) {
			return Robot.oi.getXboxLeftT();
		} else {
			return 0.0;
		}
	}

    public DriveandLiftAntwan() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(Robot.oi.getXboxLeftSX(), driveForward()); //Drives chassis based on y and z axis of joystick 1 
    	Robot.shooter.lift(Robot.oi.getXbox2LeftSY());
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
