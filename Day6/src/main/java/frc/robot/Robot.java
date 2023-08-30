package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DrivePath;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {
  Drivetrain drivetrain = new Drivetrain();
  
  // Command autonomousCommand = new DriveDistance(drivetrain, 12);
  // Command autonomousCommand = new GyroTurn(drivetrain, 180);
  // Command autonomousCommand = new TurnDegrees(drivetrain, 180);
  
  Command autonomousCommand = new DrivePath(drivetrain);
  
  @Override
  public void robotInit() {
  }

  @Override
  public void disabledInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}
}
