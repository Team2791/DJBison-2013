package org.usfirst.frc2791.MyRobot;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2791.MyRobot.commands.*;
import org.usfirst.frc2791.MyRobot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
  Command autonomousCommand;
  public static OI oi;
  public static DriveTrainLeft driveTrainLeft;
  public static DriveTrainRight driveTrainRight;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  public static DriverStationLCD ds = DriverStationLCD.getInstance();

  public void robotInit() {
    RobotMap.init();
    driveTrainLeft = new DriveTrainLeft();
    driveTrainRight = new DriveTrainRight();
    oi = new OI();

    // instantiate the command used for the autonomous period
    autonomousCommand = new AutonomousCommand();
  }

  public void autonomousInit() {
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous
   */
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control
   */
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function called periodically during test mode
   */
  public void testPeriodic() {
    LiveWindow.run();
  }
}
