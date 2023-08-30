package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class DrivePath extends SequentialCommandGroup {

  public DrivePath(Drivetrain drivetrain) {
    
    addCommands(new DriveDistance(drivetrain, 12),
                new TurnDegrees(drivetrain, 180),
                new DriveDistance(drivetrain, 12));
  }
}
