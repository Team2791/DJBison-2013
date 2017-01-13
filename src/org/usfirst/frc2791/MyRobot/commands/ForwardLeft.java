package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2791.MyRobot.Robot;
import org.usfirst.frc2791.MyRobot.RobotMap;

/**
 *
 */
public class ForwardLeft extends Command {
  public ForwardLeft() {
    requires(Robot.driveTrainLeft);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    Robot.driveTrainLeft.enable();
    Robot.driveTrainLeft.setSetpoint(300.0);
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return Robot.driveTrainLeft.onTarget();
  }

  // Called once after isFinished returns true
  protected void end() {
    RobotMap.driveTrainLeftLeftMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
