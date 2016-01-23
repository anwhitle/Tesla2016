package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4998.robot.subsystems.*;
import org.usfirst.frc.team4998.robot.OI;
/**
 *
 */
public class CommandBase extends CommandGroup {
    //static Chassis chassis = new Chassis();
    static OI oi = new OI();
    static Shooter shooter = new Shooter();
    public  CommandBase() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
