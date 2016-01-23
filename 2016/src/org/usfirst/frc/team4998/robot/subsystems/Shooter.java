package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team4998.robot.RobotMap;
/**
 *
 */
public class Shooter extends Subsystem {
    VictorSP right,left;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	right = new VictorSP(RobotMap.rightShooter);
    	left = new VictorSP(RobotMap.leftShooter);
    }
    public void shoot(double speed){
    	
    	if(Math.abs(speed)> 0.2){
    		right.set(speed);
        	left.set(speed);
    	} else {
    		right.set(0);
    		left.set(0);
    	}
    }
}


