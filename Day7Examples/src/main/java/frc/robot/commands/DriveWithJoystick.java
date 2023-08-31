package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveWithJoystick extends CommandBase {
  public static final double kMaxSpeedMps = 0.274;
  public static final double kMaxAngularSpeedRadPerSec = Math.PI/2;
  public static final double kTrackWidthMeters = 141.0/1000; 
  private final Joystick _joystick = new Joystick(0);
  private final Drivetrain _drivetrain;

  private final DifferentialDriveKinematics _kinematics = new DifferentialDriveKinematics(kTrackWidthMeters);

  public DriveWithJoystick(Drivetrain drivetrain) {
    _drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    var driveSpeed = -_joystick.getY() * kMaxSpeedMps;
    var rotationSpeed = -_joystick.getX() * kMaxAngularSpeedRadPerSec;
    drive(driveSpeed, rotationSpeed);
  }

  private void drive(double forwardSpeed, double rotSpeed) {
    var chassisSpeeds = new ChassisSpeeds(forwardSpeed, 0, rotSpeed);
    var wheelSpeeds = _kinematics.toWheelSpeeds(chassisSpeeds);

    var leftEncoderSpeed = _drivetrain.getLeftEncoderSpeed();
    var rightEncoderSpeed = _drivetrain.getRightEncoderSpeed();

    var desiredLeftWheelSpeed = wheelSpeeds.leftMetersPerSecond;
    var desiredRightWheelSpeed = wheelSpeeds.rightMetersPerSecond;

    SmartDashboard.putNumber("leftEncoderSpeed", leftEncoderSpeed);
    SmartDashboard.putNumber("desiredLeftWheelSpeed", desiredLeftWheelSpeed);

    SmartDashboard.putNumber("rightEncoderSpeed", rightEncoderSpeed);
    SmartDashboard.putNumber("desiredRightWheelSpeed", desiredRightWheelSpeed);

    _drivetrain.setMotors(desiredLeftWheelSpeed, desiredRightWheelSpeed);
  }
}