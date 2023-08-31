
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Rotate extends CommandBase {
  Drivetrain _drivetrain;
  double _degrees = 0;
  
  public Rotate(Drivetrain drivetrain, double angleToTurn) {
    _drivetrain = drivetrain;
    _degrees = angleToTurn;
  }


  @Override
  public void initialize() {
    _drivetrain.resetGyro();
  }

  @Override
  public void execute() {
    _drivetrain.setMotors(-0.1, 0.1);
  }

  @Override
  public void end(boolean interrupted) {
    _drivetrain.setMotors(0, 0);
  }

  @Override
  public boolean isFinished() {
    if(Math.abs(_drivetrain.getAngle()) > _degrees) {
      return true;
    }
    return false;
  }
}
