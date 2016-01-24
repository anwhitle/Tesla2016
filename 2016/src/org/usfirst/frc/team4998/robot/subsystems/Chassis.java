
package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team4998.robot.RobotMap;
/**
 *
 */
public class Chassis extends Subsystem {
	VictorSP left,right;
	AnalogGyro gyro;
	final int gyroChannel = 0; //analog input
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	left   = new VictorSP (RobotMap.chassisLeft);
        right  = new VictorSP (RobotMap.chassisRight);
        gyro = new AnalogGyro(gyroChannel);

        
    
    }
    
    public void drive(double z, double y){
    	if(Math.abs(z) > RobotMap.deadZone){
        	left.set(z);
        	right.set(-z);
    	} else if(Math.abs(y) > RobotMap.deadZone) {
        	left.set(y);
        	right.set(y);
    	} else {
        	left.set(0);
        	right.set(0);
    	}

    }
    
}

