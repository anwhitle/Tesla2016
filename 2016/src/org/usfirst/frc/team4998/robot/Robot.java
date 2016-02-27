
package org.usfirst.frc.team4998.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4998.robot.commands.Auton2;
import org.usfirst.frc.team4998.robot.commands.SimpleAuton;
import org.usfirst.frc.team4998.robot.commands.Teleop;
import org.usfirst.frc.team4998.robot.subsystems.Chassis;
import org.usfirst.frc.team4998.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
    public static Chassis chassis = new Chassis(); //This is purely used to initialize subsystems and OI 
    public static OI oi = new OI();
    public static Shooter shooter = new Shooter();

    Command teleopCommand;
    Command autonomousCommand;
    Command autonomousCommand2;
    SendableChooser autoChooser;
    CameraServer server;
    boolean buttonValue;
    String dashData, dashData1, dashData2, dashData3, dashData4;
    

    /**
     * 
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	server = CameraServer.getInstance();//start up camera server
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
		oi = new OI();
        // instantiate the command used for the autonomous period
        teleopCommand = new Teleop();
        autonomousCommand = new SimpleAuton(); //go forwards and go back
        autonomousCommand2 = new Auton2(); // goes through two obstacles twice making two loops 
        //Chooses obstacles based on information entered in on smart dashboard 
        
       // SmartDashboard.putData(Scheduler.getInstance());
       // SmartDashboard.putData("autonomous", autonomousCommand);
        //SmartDashboard.putData("autonomous2", autonomousCommand2);
        //Allows to choose between auton modes
        //autoChooser = new SendableChooser();
       // autoChooser.addDefault("SimpleAuton",new SimpleAuton());
        //autoChooser.addObject("Auton2",new Auton2());
       // SmartDashboard.putData("Autonomous mode Chooser", autoChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
       // if (autonomousCommand != null) autonomousCommand.start();
    	//autonomousCommand = (Command) autoChooser.getSelected();
    	
    	
    	
    	//Uses button to change between autons
    	 buttonValue = SmartDashboard.getBoolean("DB/Button 0"); //Chooses which auton to run
    	 if (buttonValue) {
    		 SmartDashboard.putString("Auton", "SimpleAuton");
    		 autonomousCommand.start();
    	 } else {
    		 autonomousCommand2.start();
    		 SmartDashboard.putString("Auton", "Auton2");
    	 }
    	
    }

    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        teleopCommand.start();
        dashData = SmartDashboard.getString("DB/String 0");
        dashData1 = SmartDashboard.getString("DB/String 1");
        dashData2 = SmartDashboard.getString("DB/String 2");
        dashData3 = SmartDashboard.getString("DB/String 3");
        dashData4 = SmartDashboard.getString("DB/String 4");
        SmartDashboard.putString("txtbox 0", dashData);
        SmartDashboard.putString("txtbox 1", dashData1);
        SmartDashboard.putString("txtbox 2", dashData2);
        SmartDashboard.putString("txtbox 3", dashData3);
        SmartDashboard.putString("txtbox 4", dashData4);
        
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
