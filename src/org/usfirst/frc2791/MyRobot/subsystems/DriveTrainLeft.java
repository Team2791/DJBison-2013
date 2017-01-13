package org.usfirst.frc2791.MyRobot.subsystems;
import org.usfirst.frc2791.MyRobot.RobotMap;
import org.usfirst.frc2791.MyRobot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrainLeft extends PIDSubsystem {
  Encoder quadratureEncoderLeft = RobotMap.driveTrainLeftQuadratureEncoderLeft;
  Victor leftMotor1 = RobotMap.driveTrainLeftLeftMotor;

  public DriveTrainLeft() {
    super("DriveTrainLeft", 50.0, 0.0, 0.0);
    setAbsoluteTolerance(20.0);
    getPIDController().setContinuous(false);
    getPIDController().setInputRange(0.0, 2000.0);
    getPIDController().setOutputRange(-1.0, 1.0);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new JoystickLeft());
  }

  protected double returnPIDInput() {
    return quadratureEncoderLeft.pidGet();
  }

  protected void usePIDOutput(double output) {
    leftMotor1.pidWrite(output);
  }
}
