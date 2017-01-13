package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2791.MyRobot.OI;
import org.usfirst.frc2791.MyRobot.Robot;
import org.usfirst.frc2791.MyRobot.RobotMap;
import edu.wpi.first.wpilibj.Timer;

public class JoystickLeft extends Command {
  public JoystickLeft() {
    requires(Robot.driveTrainLeft);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    //RobotMap.spike.set(Relay.Value.kOn);
    //RobotMap.spike.set(Relay.Value.kForward);
    //RobotMap.compressor.enabled();
    RobotMap.solenoid2.set(false);
    //RobotMap.compressor.start();
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    //RobotMap.wd.feed();
    //RobotMap.spike.set(Relay.Value.kOn);
    //RobotMap.spike.set(Relay.Value.kForward);
    //RobotMap.compressor.enabled();
    //RobotMap.compressor.start();
    //RobotMap.armEncoder.reset();
    // RobotMap.armEncoder.start();
    RobotMap.driveTrainLeftLeftMotor2.set(0.3 * OI.joystick1.getY());
    RobotMap.driveTrainLeftLeftMotor.set(0.3 * OI.joystick1.getY());
    //Robot.ds.println(DriverStationLCD.Line.kUser1,1,"encoderLeft: "+RobotMap.driveTrainLeftQuadratureEncoderLeft.get()+"                             ");
    //Robot.ds.println(DriverStationLCD.Line.kUser1,1,"Toggle1: "+RobotMap.toggle1.get()+"                                             ");
    Robot.ds.println(DriverStationLCD.Line.kUser2, 1, "SensorD1: " + RobotMap.sensor1detector.getValue());
    Robot.ds.updateLCD();

    if (RobotMap.limitSwitch.get() == false) {
      RobotMap.armEncoder.reset();
      // RobotMap.armEncoder.start(); // maybe this will work, idk
    } // WRITTEN BY CHRIS PINECONE, BEST CODER EVER

    Robot.ds.println(DriverStationLCD.Line.kUser4, 1,
      "LimitSwitch: " + RobotMap.limitSwitch.get() + "                                             ");
    //Robot.ds.println(DriverStationLCD.Line.kUser3,1,"ZValue: "+OI.joystick3.getZ());
    Robot.ds.println(DriverStationLCD.Line.kUser5, 1,
      "ArmEncoder: " + RobotMap.armEncoder.get() + "                                           ");

    Robot.ds.updateLCD();
    double shooterConstant = 1.0; //1.0

    // Robot.ds.println(DriverStationLCD.Line.kUser4,1,"Joystick3 GetY: "+OI.joystick3.getY());
    if (RobotMap.limitSwitch.get()) {
      RobotMap.armMotor.set(0.2 * (OI.joystick3.getY()));
      if (OI.joystick3.getRawButton(4) == false) {
        RobotMap.armMotor.set(0.2 * (OI.joystick3.getY()));//0.4
      } else {
        RobotMap.armMotor.set(0.4 * (OI.joystick3.getY()));//0.8
      }
    } else {
      RobotMap.armMotor.set((0.4 * (Math.abs(OI.joystick3.getY()))));//0.4
    }
    Robot.ds.println(DriverStationLCD.Line.kUser1, 1,
      "VexSpeed: " + RobotMap.VexMotor.get() + "                               ");
    Robot.ds.println(DriverStationLCD.Line.kUser3, 1,
      "ArmLimitSwitch: " + RobotMap.limitSwitch2.get() + "                               ");
    Robot.ds.println(DriverStationLCD.Line.kUser6, 1,
      " SensorD2 " + RobotMap.sensor2detector.getValue() + "                                ");
    Robot.ds.updateLCD();
    int IRvalue = 955; // we started at 950, 940 for outside
    RobotMap.compressor.start();
    //normally true

    if ((RobotMap.limitSwitch2.get() == false) && (RobotMap.sensor2detector.getValue() >= IRvalue)) {//both loaded
      //Robot.ds.println(DriverStationLCD.Line.kUser6,1," LOADED and HALDLOADED, GO GET 'EM!");
      //Robot.ds.updateLCD();
      RobotMap.shooterWheelClose.set(shooterConstant);
      RobotMap.shooterWheelFar.set(shooterConstant);

      RobotMap.VexMotor.set(0);
      if (OI.joystick3.getTrigger()) {
        RobotMap.solenoid2.set(true);
      }
      if (OI.joystick3.getTrigger() == false) {
        RobotMap.solenoid2.set(false);
      }
    } else {
      RobotMap.shooterWheelClose.set(0);
      RobotMap.shooterWheelFar.set(0);

      if ((RobotMap.limitSwitch2.get() == false) && (RobotMap.sensor2detector
        .getValue() < IRvalue) && (RobotMap.armEncoder.get() >= -500)) {//bottom is empty and top is loaded
        //Robot.ds.println(DriverStationLCD.Line.kUser6,1," HALFLOADED...WAIT                       ");
        //Robot.ds.updateLCD();

        RobotMap.VexMotor.set(0.75);
        RobotMap.solenoid2.set(false);

        RobotMap.shooterWheelClose.set(shooterConstant);
        RobotMap.shooterWheelFar.set(shooterConstant);
      }
      if ((RobotMap.limitSwitch2.get() == true) && (RobotMap.sensor2detector
        .getValue() >= IRvalue) && (RobotMap.armEncoder.get() >= -500)) {//bottom is loaded and top is empty
        //Robot.ds.println(DriverStationLCD.Line.kUser6,1," LOADED, SHOOT!                      ");
        //Robot.ds.updateLCD();

        RobotMap.VexMotor.set(0.75);
        RobotMap.shooterWheelClose.set(shooterConstant);
        RobotMap.shooterWheelFar.set(shooterConstant);
        if (OI.joystick3.getTrigger()) {
          RobotMap.solenoid2.set(true);
          RobotMap.VexMotor.set(0);
        }
        if (OI.joystick3.getTrigger() == false) {
          RobotMap.solenoid2.set(false);
          RobotMap.VexMotor.set(0.75);
        }
      }
      if ((RobotMap.limitSwitch2.get() == true) && (RobotMap.sensor2detector
        .getValue() < IRvalue) && (RobotMap.armEncoder.get() >= -500)) {//both empty
        //Robot.ds.println(DriverStationLCD.Line.kUser6,1," NOT LOADED, CHILL OUT BRAH              ");
        //Robot.ds.updateLCD();
        RobotMap.solenoid2.set(false);

        RobotMap.VexMotor.set(0.75);
        RobotMap.shooterWheelClose.set(0);
        RobotMap.shooterWheelFar.set(0);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {
    RobotMap.driveTrainLeftLeftMotor.set(0);
    RobotMap.driveTrainLeftLeftMotor2.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
