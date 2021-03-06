package org.usfirst.frc.team4998.robot.commands;

//import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4998.robot.commands.Shoot;
import org.usfirst.frc.team4998.robot.commands.Suck;
import org.usfirst.frc.team4998.robot.Robot;

/**
 *
 */
public class SanaTeleop extends Command {
	public double steadyRate = 0;
	public boolean toggle = false;
	Command shoot;
	
    public SanaTeleop() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.chassis);
         requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(Robot.oi.getXboxLeftSX(), Robot.oi.getXboxRightSY());
    	
    	Robot.oi.xbox2leftbumper.whenPressed(new Shoot(0.5));
    	Robot.oi.xbox2rightbumper.whenPressed(new Shoot(0.75));
    	if(Robot.oi.getXbox2LeftT() > 0.5) {
    		shoot = new Shoot(0.85);
    		shoot.start();
    	}
    	if(Robot.oi.getXbox2RightT() > 0.5) {
    		shoot = new Shoot(1.0);
    		shoot.start();
    	}

    	Robot.oi.xbox2a.whileHeld(new Suck());
    
    	if (Robot.oi.xbox2x.get()){
    		toggle = !toggle;
    		steadyRate = Robot.oi.getXbox2LeftSY();
    	}
    	if (toggle){
    		Robot.shooter.lift(steadyRate);
    	}
    	else {
    		Robot.shooter.lift(Robot.oi.getXbox2LeftSY());
    	}
    	
    	smartDashboard(); // Outputs value to smart dashboard
   	
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
    	SmartDashboard.putDouble("0xaxis", Robot.oi.getX0());
    	SmartDashboard.putDouble("0yaxis", Robot.oi.getY0());
    	SmartDashboard.putDouble("0zaxis", Robot.oi.getZ0());
    	SmartDashboard.putDouble("0POVaxis", Robot.oi.getPOV0());
    	SmartDashboard.putDouble("0Throttleaxis", Robot.oi.getThrottle0());
    	SmartDashboard.putDouble("1xaxis", Robot.oi.getX1());
    	SmartDashboard.putDouble("1yaxis", Robot.oi.getY1());
    	SmartDashboard.putDouble("1zaxis", Robot.oi.getZ1());
    	SmartDashboard.putDouble("1POVaxis", Robot.oi.getPOV1());
    	SmartDashboard.putDouble("1Throttleaxis", Robot.oi.getThrottle1());
    	SmartDashboard.putDouble("1Slider", Robot.oi.getSlider1());
    	SmartDashboard.putDouble("Distance", Robot.shooter.getEncoderDistance());
    	SmartDashboard.putDouble("Position", Robot.shooter.getEncPosition());
    }
}
