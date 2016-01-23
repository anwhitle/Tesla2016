
package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team4998.robot.RobotMap;
/**
 *
 */
public class Chassis extends Subsystem {
	VictorSP frontLeft,frontRight,rearLeft,rearRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//frontLeft   = new VictorSP (RobotMap.frontLeft);
        //frontRight  = new VictorSP (RobotMap.frontRight);
        //rearLeft    = new VictorSP (RobotMap.rearLeft);
        //rearRight   = new VictorSP (RobotMap.rearRight);
    
    }
    
    public void drive(double z, double y){
    	if(Math.abs(z) > 0.2){
        	frontLeft.set(z);
        	frontRight.set(-z);
        	rearLeft.set(z);
        	rearRight.set(-z);
    	} else if(Math.abs(y) > 0.2) {
        	frontLeft.set(y);
        	frontRight.set(y);
        	rearLeft.set(y);
        	rearRight.set(y);
    	} else {
        	frontLeft.set(0);
        	frontRight.set(0);
        	rearLeft.set(0);
        	rearRight.set(0);
    	}

    }
    
}

