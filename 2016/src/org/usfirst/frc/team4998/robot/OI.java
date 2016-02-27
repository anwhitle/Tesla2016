package org.usfirst.frc.team4998.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team4998.robot.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick stick0 = new Joystick(RobotMap.joystickOnePort1);
	public static Joystick stick1 = new Joystick(RobotMap.joystickTwoPort2);
	
	public JoystickButton Button0 = new JoystickButton(stick0,0);
	public JoystickButton Button1 = new JoystickButton(stick0,1);
	public JoystickButton Button2 = new JoystickButton(stick0,2);
	public JoystickButton Button3 = new JoystickButton(stick0,3);
	public JoystickButton Button4 = new JoystickButton(stick0,4);
	public JoystickButton Button5 = new JoystickButton(stick0,5);
	public JoystickButton Button6 = new JoystickButton(stick0,6);
	public JoystickButton Button7 = new JoystickButton(stick0,7);
	public JoystickButton b1s1 = new JoystickButton(stick1,1);
	public JoystickButton b2s1 = new JoystickButton(stick1,2);
	public JoystickButton b3s1 = new JoystickButton(stick1,3);
	public JoystickButton b4s1 = new JoystickButton(stick1,4);
	public JoystickButton b5s1 = new JoystickButton(stick1,5);
	public JoystickButton b6s1 = new JoystickButton(stick1,6);
	public JoystickButton b7s1 = new JoystickButton(stick1,7);
	//pub
	
	
	public JoystickButton xbox1a = new JoystickButton (stick0,0);
	public JoystickButton xbox1b = new JoystickButton (stick0,1);
	public JoystickButton xbox1x = new JoystickButton (stick0,2);
	public JoystickButton xbox1y = new JoystickButton (stick0,3);
	public JoystickButton xbox1leftbumper = new JoystickButton (stick0,4);
	public JoystickButton xbox1rightbumper = new JoystickButton (stick0,5);
	
	public JoystickButton xbox2a = new JoystickButton (stick1,0);
	public JoystickButton xbox2b = new JoystickButton (stick1,1);
	public JoystickButton xbox2x = new JoystickButton (stick1,2);
	public JoystickButton xbox2y = new JoystickButton (stick1,3);
	public JoystickButton xbox2leftbumper = new JoystickButton (stick1,4);
	public JoystickButton xbox2rightbumper = new JoystickButton (stick1,5);
	
	public double getY0 (){
		return stick0.getY();
	}
	public double getX0 (){
		return stick0.getX();
	}
	public double getZ0 (){
		return stick0.getTwist();
	}
	public double getThrottle0(){
		return stick0.getThrottle();
	}
	public double getPOV0() {
		return stick0.getPOV(0);
	}
	public double getY1 (){
		return stick1.getY();
	}
	public double getX1 (){
		return stick1.getX();
	}
	public double getZ1 (){
		return stick1.getTwist();
	}
	public double getThrottle1(){
		return stick1.getThrottle();
	}
	public double getPOV1() {
		return stick1.getPOV(0);
	}
	public double getSlider1() {
		return stick1.getDirectionDegrees();
	}
	
	public boolean getXbox1A(){
		return stick0.getRawButton(0);
	}
	public boolean getXbox1B(){
		return stick0.getRawButton(1);
	}
	public boolean getXbox1Y(){
		return stick0.getRawButton(3);
	}
	public boolean getXbox1X(){
		return stick0.getRawButton(2);
	}
	
	public double getXboxRightSX(){
		return stick0.getRawAxis(4);
	}
	public double getXboxRightSY(){
		return stick0.getRawAxis(5);
	}
	
	public double getXboxLeftSX(){
		return stick0.getRawAxis(0);
	}
	public double getXboxLeftSY(){
		return stick0.getRawAxis(1);
	}
	public double getXboxLeftT(){
		return stick0.getRawAxis(2);
	}
	public double getXboxRightT(){
		return stick0.getRawAxis(3);
	}
	public boolean getXbox1BumpL(){
		return stick0.getRawButton(4);
	}
	public boolean getXbox1BumpR(){
		return stick0.getRawButton(5);
	}
	public boolean getXbox2A(){
		return stick1.getRawButton(0);
	}
	public boolean getXbox2B(){
		return stick1.getRawButton(1);
	}
	public boolean getXbox2Y(){
		return stick1.getRawButton(3);
	}
	public boolean getXbox2X(){
		return stick1.getRawButton(2);
	}
	
	public double getXbox2RightSX(){
		return stick1.getRawAxis(4);
	}
	public double getXbox2RightSY(){
		return stick1.getRawAxis(5);
	}
	
	public double getXbox2LeftSX(){
		return stick1.getRawAxis(0);
	}
	public double getXbox2LeftSY(){
		return stick1.getRawAxis(1);
	}
	public double getXbox2LeftT(){
		return stick1.getRawAxis(2);
	}
	public double getXbox2RightT(){
		return stick1.getRawAxis(3);
	}
	public boolean getXbox2BumpL(){
		return stick1.getRawButton(4);
	}
	public boolean getXbox2BumpR(){
		return stick1.getRawButton(5);
	}
	
}