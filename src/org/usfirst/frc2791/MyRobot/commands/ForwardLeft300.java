// RobotBuilder Version: 0.0.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2791.MyRobot.Robot;
import org.usfirst.frc2791.MyRobot.RobotMap;
/**
 *
 */
public class  ForwardLeft300 extends Command {
    private double setpoint;
    public ForwardLeft300() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrainLeft);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
       
    }
    // Called just before this Command runs the first time
    protected void initialize() { 
    Robot.driveTrainLeft.enable();
    Robot.driveTrainLeft.setSetpoint(-1000.0);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=EXECUTE
        Robot.driveTrainLeft.enable();
        Robot.driveTrainLeft.setSetpoint(1.0);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=EXECUTE
    //Robot.ds.println(DriverStationLCD.Line.kUser2,1,""+RobotMap.driveTrainLeftQuadratureEncoderLeft.getRate()+"                      ");
    //Robot.ds.updateLCD();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return Robot.driveTrainLeft.onTarget();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }
    // Called once after isFinished returns true
    protected void end() { 
        Robot.driveTrainLeft.disable();
        RobotMap.driveTrainLeftLeftMotor.set(0);
        //RobotMap.driveTrainLeftLeftMotor2.set(0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { 
        end();
    }
  
}
