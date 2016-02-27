package org.usfirst.frc.team4998.robot.commands;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4998.robot.commands.Shoot;
import org.usfirst.frc.team4998.robot.commands.Suck;

/**
 *
 */
public class SanaTeleop extends CommandBase {
	public double steadyRate = 0;
	public boolean toggle = false;
	Command shoot;
	
    public SanaTeleop() {
        // Use requires() here to declare subsystem dependencies
         requires(chassis);
         requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.drive(oi.getXboxLeftSX(), oi.getXboxRightSY());
    	
    	oi.xbox2leftbumper.whenPressed(new Shoot(0.5));
    	oi.xbox2rightbumper.whenPressed(new Shoot(0.75));
    	if(oi.getXbox2LeftT() > 0.5) {
    		shoot = new Shoot(0.85);
    		shoot.start();
    	}
    	if(oi.getXbox2RightT() > 0.5) {
    		shoot = new Shoot(1.0);
    		shoot.start();
    	}

    	oi.xbox2a.whileHeld(new Suck());
    
    	if (oi.xbox2x.get()){
    		toggle = !toggle;
    		steadyRate = oi.getXbox2LeftSY();
    	}
    	if (toggle){
    		shooter.lift(steadyRate);
    	}
    	else {
    		shooter.lift(oi.getXbox2LeftSY());
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
    	SmartDashboard.putDouble("1Slider", oi.getSlider1());
    	SmartDashboard.putDouble("Distance", shooter.getEncoderDistance());
    	SmartDashboard.putDouble("Position", shooter.getEncPosition());
    }
}
