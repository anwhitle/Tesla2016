package org.usfirst.frc.team4998.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team4998.robot.RobotMap;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
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
}