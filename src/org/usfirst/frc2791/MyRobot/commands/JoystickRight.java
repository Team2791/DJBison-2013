package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2791.MyRobot.OI;
import org.usfirst.frc2791.MyRobot.Robot;
import org.usfirst.frc2791.MyRobot.RobotMap;
import edu.wpi.first.wpilibj.DriverStationLCD;

public class JoystickRight extends Command {
  public JoystickRight() {
    requires(Robot.driveTrainRight);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    RobotMap.driveTrainRightRightMotor1.set(-0.3 * OI.joystick2.getY()); // -1.0
    RobotMap.driveTrainRightRightMotor2.set(-0.3 * OI.joystick2.getY()); // -1.0
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {
    RobotMap.driveTrainRightRightMotor1.set(0);
    RobotMap.driveTrainRightRightMotor2.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
