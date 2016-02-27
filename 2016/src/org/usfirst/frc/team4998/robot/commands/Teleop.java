package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Teleop extends CommandBase {
	public double steadyRate = 0;
	public boolean toggle = false;
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
    	
    	/*
    	oi.b5s1.whenPressed(new Shoot(0.5));
    	oi.b3s1.whenPressed(new Shoot(0.75));
    	oi.b4s1.whenPressed(new Shoot(0.85));
    	oi.b6s1.whenPressed(new Shoot(1.0));
    	oi.b1s1.whileHeld(new Suck());
    	*/
    	
    	/*if (oi.b2s1.get()){
    		toggle = !toggle;
    		steadyRate = oi.getY1();
    	}
    	
    	if (toggle){
    		shooter.lift(steadyRate);
    	}
    	else {
    	*/
    		shooter.lift(oi.getY1());
    	//}
    	
    	smartDashboard(); // Outputs value to smart dashboard
    		
    	 
    	
    	if (oi.b3s1.get()) { // Shooter based on the four buttons, each has different speed, 3,4,5,6
    		shooter.shoot(-0.5);
    	} else if (oi.b4s1.get()) {
    		shooter.shoot(0.75);
    	} else if (oi.b5s1.get()) {
    		shooter.shoot(1.0);
    	} else if (oi.b6s1.get()){
    		shooter.shoot(.5);
    	} else {
    		shooter.shoot(0);
    	}
    	
    	if (oi.b1s1.get()){ //Kicks based on two different button, 1 and 2
    		shooter.kick(0.8); 
    	}else if (oi.b2s1.get()){
    		shooter.kick(-0.4);
    	}else {
    		shooter.kick(0);
    	}
    	
    	//if (oi.getPOV1() == 0){ //Lifts when user moved the pov up. (The little button like joystick on the joystick)
    		//Moves the position based on the throttle of the joystick 
    		//shooter.lifter(oi.getThrottle1());
    	//}
    
    	
    	//if (oi.getPOV1() == 0){
    		//shooter.lift(1);
    	//} else if (oi.getPOV1() == 180){
    		//shooter.lift(-1);
    		
    //	} else {
    		//shooter.lift(0);
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
