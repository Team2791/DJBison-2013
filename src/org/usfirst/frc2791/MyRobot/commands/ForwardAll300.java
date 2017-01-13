package org.usfirst.frc2791.MyRobot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ForwardAll300 extends CommandGroup {
  public ForwardAll300() {
    addParallel(new ForwardLeft300());
    addSequential(new ForwardRight300());
  }
}
