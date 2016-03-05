package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4998.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlexisJoeyTeleop extends Command {
	public double steadyRate = 0;
	public boolean toggle = false;
	Suck suck;
    public AlexisJoeyTeleop() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.chassis);
         requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	suck = new Suck ();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(Robot.oi.getZ0(), Robot.oi.getY0()); //Drives chassis based on y and z axis of joystick 1 
    	
    	//New Code
    	///*
    	Robot.oi.xbox2y.whenPressed(new Shoot(0.5));
    	Robot.oi.xbox2b.whenPressed(new Shoot(0.75));
    	Robot.oi.xbox2x.whenPressed(new Shoot(0.85));
    	Robot.oi.xbox2a.whenPressed(new Shoot(1.0));
    	if (Robot.oi.getXbox2RightT() > .25){
    		suck = new Suck ();
    		suck.start();
    	}
    	else {
    		if (!suck.done) {
    			suck.cancel();
    		}
    	}
    	
    	//*/
    	
    	/*if (oi.b2s1.get()){
    		toggle = !toggle;
    		steadyRate = oi.getY1();
    	}
    	
    	if (toggle){
    		shooter.lift(steadyRate);
    	}
    	else {
    	*/
    	Robot.shooter.lift(Robot.oi.getXbox2LeftSY());
    	//}
    	
    	smartDashboard(); // Outputs value to smart dashboard
    		
    	//old code
    	 /*
    	if (Robot.oi.b3s1.get()) { // Shooter based on the four buttons, each has different speed, 3,4,5,6
    		Robot.shooter.shoot(-0.5);
    	} else if (Robot.oi.b4s1.get()) {
    		Robot.shooter.shoot(0.75);
    	} else if (Robot.oi.b5s1.get()) {
    		Robot.shooter.shoot(1.0);
    	} else if (Robot.oi.b6s1.get()){
    		Robot.shooter.shoot(.5);
    	} else {
    		Robot.shooter.shoot(0);
    	}
    	
    	if (Robot.oi.b1s1.get()){ //Kicks based on two different button, 1 and 2
    		Robot.shooter.kick(0.8); 
    	}else if (Robot.oi.b2s1.get()){
    		Robot.shooter.kick(-0.4);
    	}else {
    		Robot.shooter.kick(0);
    	}
    	*/
    	
    	
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
