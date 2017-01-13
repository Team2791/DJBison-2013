package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2791.MyRobot.Robot;
import org.usfirst.frc2791.MyRobot.RobotMap;

public class ForwardRight300 extends Command {
  public ForwardRight300() {
    requires(Robot.driveTrainRight);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    Robot.driveTrainRight.enable();
    Robot.driveTrainRight.setSetpoint(-1000.0);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    Robot.driveTrainRight.enable();
    Robot.driveTrainRight.setSetpoint(300.0);
    //Robot.ds.println(DriverStationLCD.Line.kUser2,1,""+RobotMap.driveTrainRightQuadratureEncoderRight.getRate()+"                      ");
    //Robot.ds.updateLCD();
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return Robot.driveTrainRight.onTarget();
  }

  // Called once after isFinished returns true
  protected void end() {
    Robot.driveTrainRight.disable();
    RobotMap.driveTrainRightRightMotor1.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
