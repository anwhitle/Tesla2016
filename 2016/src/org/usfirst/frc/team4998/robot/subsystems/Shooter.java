
package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team4998.robot.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem {
    VictorSP right,left,kick; //Declare  victors
    CANTalon lift1;//, lift2;
    Encoder encoder; //Declare encoder
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	right = new VictorSP(RobotMap.rightShooter); // Assign victors to ports based on robot map 
    	left = new VictorSP(RobotMap.leftShooter); 
    	lift1 = new CANTalon (RobotMap.lift1);
    	//lift2 = new CANTalon (RobotMap.lift2);
    	kick = new VictorSP (RobotMap.kick);
    	encoder = new Encoder(RobotMap.lift1, RobotMap.lift2, true, EncodingType.k4X); // Assigns encoder to ports based on robot map, ignore true and encoding 
    	encoder.setMaxPeriod(RobotMap.encoderMaxPeriod); //Sets value for encoders based on robot map
    	encoder.setMinRate(RobotMap.encoderMinRate);
    	encoder.setDistancePerPulse(RobotMap.encoderDistancePerPulse); 
    	encoder.setReverseDirection(RobotMap.encoderReverseDirection);
    	encoder.setSamplesToAverage(RobotMap.encoderSamplesToAverage);
    }
    public void lift(double speed){ //Lifts based on speed
    	if (Math.abs(speed) > RobotMap.deadZone) {
    		lift1.set(speed * 0.7);
    		//lift2.set(speed * 0.6);
    	}
    	else { //stops it 
    		lift1.set(0);
    		//lift2.set(0);
    	}
   
   
    }
    public void shoot(double speed){ //Moves shooter based on speed 
    	
    	if(Math.abs(speed)> RobotMap.deadZone){ 
    		right.set(speed);
        	left.set(-speed);
    	} else {
    		right.set(0);
    		left.set(0);
    	}
    }
    public void kick(double speed){ //Moves kicker based on speed 
    	
    	if(Math.abs(speed)> RobotMap.deadZone){
    		kick.set(speed * RobotMap.kickerSpeedControl); //Multiplying by speed control so it dosn't go too fast 
    	} else {
    		kick.set(0);
    	}
    }
    public void lifter(double throttle){ 
    	double liftp = -1;
    	if (throttle < -0.75 ){ //Getting set intervals based on throttle with -1 being the bottom 
    		liftp = -1;
    	}	
    	else if (throttle < -.25){
    		liftp = -.5;
    	}
    	else if (throttle < .25) {
    		liftp = 0;
    	}
    	else if (throttle < .75){
    		liftp = .5;
    	}
    	else {
    		liftp = 1;
    	}
    	
    	if (encoder.getDistance() > liftp){ //If the current distance is greater than the wanted distance
    		while(encoder.getDistance() > liftp){ //Then move the lift back until current distance is wanted distance 
    			lift(-1);
    		}
    	}
    	else { //Same as above, but inversed 
    		while(encoder.getDistance() < liftp){
    			lift(1);
    		}
    	} 
    	lift(0); // Then stop it 
    }
    
    public double getEncoderDistance() {
    	return lift1.getPosition();
    }
    public double getEncPosition() {
    	return lift1.getEncPosition();
    }
    public double getD() {
    	return lift1.getD();
    }
    public double getP() {
    	return lift1.getP();
    }
    public double getI() {
    	return lift1.getI();
    }
    
    
    
    
}
 