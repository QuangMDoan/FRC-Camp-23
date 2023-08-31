// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class WASDDrive extends CommandBase {
  DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(0.141);
  Joystick _joystick = new Joystick(0);
  Drivetrain _drivetrain;

  public WASDDrive(Drivetrain drivetrain) {
    addRequirements(_drivetrain);
  }

  @Override
  public void execute() {
    double xInput = _joystick.getX();
    double yInput = _joystick.getY();

    ChassisSpeeds desiredChassisSpeeds = new ChassisSpeeds(-yInput*0.7, 0, -xInput*Math.PI);
    DifferentialDriveWheelSpeeds speeds = kinematics.toWheelSpeeds(desiredChassisSpeeds);
    _drivetrain.setMotors(speeds.leftMetersPerSecond, speeds.rightMetersPerSecond);
  }
}
