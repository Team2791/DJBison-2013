package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2791.MyRobot.Robot;
import org.usfirst.frc2791.MyRobot.RobotMap;

public class ForwardLeft300 extends Command {
  private double setpoint;

  public ForwardLeft300() {
    requires(Robot.driveTrainLeft);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    Robot.driveTrainLeft.enable();
    Robot.driveTrainLeft.setSetpoint(-1000.0);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    Robot.driveTrainLeft.enable();
    Robot.driveTrainLeft.setSetpoint(1.0);
    //Robot.ds.println(DriverStationLCD.Line.kUser2,1,""+RobotMap.driveTrainLeftQuadratureEncoderLeft.getRate()+"                      ");
    //Robot.ds.updateLCD();
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return Robot.driveTrainLeft.onTarget();
  }

  // Called once after isFinished returns true
  protected void end() {
    Robot.driveTrainLeft.disable();
    RobotMap.driveTrainLeftLeftMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
