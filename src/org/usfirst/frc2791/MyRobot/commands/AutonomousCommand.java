package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2791.MyRobot.Robot;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc2791.MyRobot.RobotMap;

/**
 *
 */
public class AutonomousCommand extends Command {
  public AutonomousCommand() {
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    RobotMap.timz2.reset();
    RobotMap.timz2.start();
    RobotMap.timz5.reset();
    RobotMap.VexMotor.set(0);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    //Robot.ds.free();
    //Robot.ds.println(DriverStationLCD.Line.kUser1,1,"Toggle1: "+RobotMap.toggle1.get()+"                                             ");
    //Robot.ds.println(DriverStationLCD.Line.kUser2,1,"Toggle2: "+RobotMap.toggle2.get()+"                                             ");
    //Robot.ds.updateLCD();
    Robot.ds.println(DriverStationLCD.Line.kUser4, 1,
      "LimitSwitch: " + RobotMap.limitSwitch.get() + "                                             ");
    Robot.ds.println(DriverStationLCD.Line.kUser5, 1,
      "ArmEncoder: " + RobotMap.armEncoder.get() + "                                           ");
    Robot.ds.updateLCD();
    RobotMap.shooterWheelClose.set(1);
    RobotMap.shooterWheelFar.set(1);

    while (RobotMap.timz2.get() < 4) {
      RobotMap.VexMotor.set(0);
      if (RobotMap.limitSwitch.get()) {
        RobotMap.armMotor.set(-0.1);
      } else {
        RobotMap.armMotor.set(0.0);
        RobotMap.armEncoder.reset();
      }
    }
    while ((RobotMap.timz2.get() > 4) && (RobotMap.timz2.get() < 7)) {
      //-245 worn out wheels, back croner, 3 pointers
      // 176 //-400 was high, do lower -- 375
      //manchester data - 3 point back corner = 166 with medium worn out wheels - perfect\
      //just was -195
      // -275 for 2 pointers, -295 for 3 pointers for corners closets to the middle
      //191 for worst wheel condition -good value practice, 350 (code like 340) with 0.5 voltage for 3's front corner
      //0.3 is normal back voltage, //220 was back new wheel encoder value, last known value=227
      RobotMap.VexMotor.set(0);
      if (RobotMap.armEncoder.get() > (-(int) (232 * 20.0 / 19.0))) {
        RobotMap.armMotor.set(0.3);
      }
    }
      else{
      RobotMap.armMotor.set(0.0);
    }

    while ((RobotMap.timz2.get() > 7) && (RobotMap.timz2.get() < 7.5)) {
      RobotMap.VexMotor.set(0);
      RobotMap.solenoid2.set(true);
    }
    while ((RobotMap.timz2.get() < 8) && (RobotMap.timz2.get() > 7.5)) {
      RobotMap.VexMotor.set(0);
      RobotMap.solenoid2.set(false);
    }
    while ((RobotMap.timz2.get() < 9) && (RobotMap.timz2.get() > 8)) {
      RobotMap.VexMotor.set(1);
    }
    while ((RobotMap.timz2.get() < 9.5) && (RobotMap.timz2.get() > 9)) {
      RobotMap.VexMotor.set(0);
    }
    while ((RobotMap.timz2.get() < 10) && (RobotMap.timz2.get() > 9.5)) {
      RobotMap.VexMotor.set(0);
      RobotMap.solenoid2.set(true);
    }
    while ((RobotMap.timz2.get() < 10.5) && (RobotMap.timz2.get() > 10)) {
      RobotMap.VexMotor.set(0);
      RobotMap.solenoid2.set(false);
    }
    while ((RobotMap.timz2.get() < 11.5) && (RobotMap.timz2.get() > 10.5)) {
      RobotMap.VexMotor.set(1);
    }
    while ((RobotMap.timz2.get() < 12) && (RobotMap.timz2.get() > 11.5)) {
      RobotMap.VexMotor.set(0);
    }
    while ((RobotMap.timz2.get() < 12.5) && (RobotMap.timz2.get() > 12)) {
      RobotMap.VexMotor.set(0);
      RobotMap.solenoid2.set(true);
    }
    while ((RobotMap.timz2.get() < 13) && (RobotMap.timz2.get() > 12.5) {
      RobotMap.VexMotor.set(0);
      RobotMap.solenoid2.set(false);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}