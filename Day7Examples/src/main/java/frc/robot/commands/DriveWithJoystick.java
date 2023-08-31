package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveWithJoystick extends CommandBase {
  public static final double kMaxSpeedMps = 0.274;
  public static final double kMaxAngularSpeedRadPerSec = Math.PI/2;
  public static final double kTrackWidthMeters = .141; 
  private final Joystick _joystick = new Joystick(0);
  private final Drivetrain _drivetrain;

  private final DifferentialDriveKinematics _kinematics = new DifferentialDriveKinematics(kTrackWidthMeters);
  private final PIDController _leftPidController = new PIDController(0.1, 0, 0);
  private final PIDController _rightPidController = new PIDController(0.1, 0, 0);

  public DriveWithJoystick(Drivetrain drivetrain) {
    _drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    var xSpeed = -_joystick.getY();
    var rotSpeed = -_joystick.getX();
    drive(xSpeed, rotSpeed);
  }

  private void drive(double forwardSpeed, double rotSpeed) {
    ChassisSpeeds chassisSpeeds = new ChassisSpeeds(forwardSpeed, 0, rotSpeed);
    DifferentialDriveWheelSpeeds wheelSpeeds = _kinematics.toWheelSpeeds(chassisSpeeds);

    double leftPower = _leftPidController.calculate(_drivetrain.getLeftWheelSpeed(), wheelSpeeds.leftMetersPerSecond);
    double rightPower = _rightPidController.calculate(_drivetrain.getRightWheelSpeed(), wheelSpeeds.rightMetersPerSecond);

    _drivetrain.setMotors(leftPower, rightPower);
  }
}