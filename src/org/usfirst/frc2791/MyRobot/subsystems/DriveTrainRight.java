package org.usfirst.frc2791.MyRobot.subsystems;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc2791.MyRobot.RobotMap;
import org.usfirst.frc2791.MyRobot.commands.*;

public class DriveTrainRight extends PIDSubsystem {
  Victor rightMotor1 = RobotMap.driveTrainRightRightMotor1;
  Encoder quadratureEncoderRight = RobotMap.driveTrainRightQuadratureEncoderRight;

  public DriveTrainRight() {
    super("DriveTrainRight", 0.5, 200.0, 0.005);
    setAbsoluteTolerance(30.0);
    getPIDController().setContinuous(false);
    getPIDController().setInputRange(0.0, 2000.0);
    getPIDController().setOutputRange(-1.0, 1.0);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new JoystickRight());
  }

  protected double returnPIDInput() {
    return quadratureEncoderRight.pidGet();
  }

  protected void usePIDOutput(double output) {
    rightMotor1.pidWrite(output);
  }
}
