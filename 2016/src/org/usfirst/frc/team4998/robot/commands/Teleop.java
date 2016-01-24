package org.usfirst.frc.team4998.robot.commands;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Teleop extends CommandBase {

    public Teleop() {
        // Use requires() here to declare subsystem dependencies
         requires(chassis);
         requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.drive(oi.getZ0(), oi.getY0());
    	//if (!((Math.abs(oi.getY0())> RobotMap.deadZone) || (Math.abs(oi.getZ0()) > RobotMap.deadZone))){
    		shooter.shoot(oi.getX1());
    	//} 
    	shooter.lift(oi.getPOV1());
    	smartDashboard();
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
    public void smartDashboard (){
    	SmartDashboard.putDouble("0xaxis", oi.getX0());
    	SmartDashboard.putDouble("0yaxis", oi.getY0());
    	SmartDashboard.putDouble("0zaxis", oi.getZ0());
    	SmartDashboard.putDouble("0POVaxis", oi.getPOV0());
    	SmartDashboard.putDouble("0Throttleaxis", oi.getThrottle0());
    	SmartDashboard.putDouble("1xaxis", oi.getX1());
    	SmartDashboard.putDouble("1yaxis", oi.getY1());
    	SmartDashboard.putDouble("1zaxis", oi.getZ1());
    	SmartDashboard.putDouble("1POVaxis", oi.getPOV1());
    	SmartDashboard.putDouble("1Throttleaxis", oi.getThrottle1());
    }
}
