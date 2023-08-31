package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {
  private Command _command;
  private Drivetrain _drivetrain = new Drivetrain();

  @Override
  public void robotInit() {
    _command = new DriveWithJoystick(_drivetrain);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void teleopInit() {
    _command.schedule();
  }

  @Override
  public void teleopPeriodic() {}
}