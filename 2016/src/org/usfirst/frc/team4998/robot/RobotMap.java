package org.usfirst.frc.team4998.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static int button0 = 0;
	public static int button1 = 1;
	
	public static int joystickOnePort1 = 0;
	public static int joystickTwoPort2 = 1;

	public static int chassisLeftFront = 1;
	public static int chassisLeftBack = 2;
	public static int chassisRightFront = 3;
	public static int chassisRightBack = 4;
	
	public static int rightShooter = 5;
	public static int leftShooter = 6;
	
	public static int lift1 = 7;
	public static int lift2 = 8;	//no longer used
	public static int kick = 9;
	
	public static double deadZone = 0.15; 
	public static double kickerSpeedControl = 0.4;
	
	public static int ultrasonic1 = 1;
	public static int ultrasonic2 = 2;
	
	public static double encoderMaxPeriod = 0.1;
	public static int encoderMinRate = 1;
	public static double encoderDistancePerPulse = 1;
	public static boolean encoderReverseDirection = true; 
	public static int encoderSamplesToAverage = 1;
	
}
