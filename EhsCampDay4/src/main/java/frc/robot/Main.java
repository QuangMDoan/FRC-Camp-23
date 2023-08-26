// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Write a TimedRobot program to run autonomously (no user inputs) with half speed
 * in the first 2 seconds then run with 20% of the speed in the next 2 seconds.
 */
public final class Main {
  private Main() {}

 
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
