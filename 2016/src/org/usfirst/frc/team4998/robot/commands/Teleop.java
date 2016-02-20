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
    	chassis.drive(oi.getZ0(), oi.getY0()); //Drives chassis based on y and z axis of joystick 1 
    	if (oi.b1s1.get()) { // Shooter based on the four buttons, each has different speed, 1,2,3,4
    		shooter.shoot(-0.4);
    	} else if (oi.b2s1.get()) {
    		shooter.shoot(0.75);
    	} else if (oi.b3s1.get()) {
    		shooter.shoot(.85);
    	} else if (oi.b4s1.get()){
    		shooter.shoot(.5);
    	} else {
    		shooter.shoot(0);
    	}
    	if (oi.b5s1.get()){ //Kicks based on two different button, 5 an 6
    		shooter.kick(0.8); 
    	}else if (oi.b6s1.get()){
    		shooter.kick(-0.8);
    	}else {
    		shooter.kick(0);
    	}
    	if (oi.getPOV1() == 0){ //Lifts when user moved the pov up. (The little button like joystick on the joystick)
    		//Moves the position based on the throttle of the joystick 
    		shooter.lifter(oi.getThrottle1());
    	}
    		
    	//if (oi.getPOV1() == 0){
    		//shooter.lift(1);
    	//} else if (oi.getPOV1() == 180){
    		//shooter.lift(-1);
    		
    //	} else {
    		//shooter.lift(0);
    	//}
    	
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
    }
}
