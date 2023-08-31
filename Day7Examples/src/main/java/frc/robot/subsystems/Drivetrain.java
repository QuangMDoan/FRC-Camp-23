package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.romi.RomiGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{

  public static final double kPulsesPerRevolution = 1440.0;
  public static final double kWheelDiameterCM = 6.75;
  public static final double kWheelCircumference = kWheelDiameterCM * Math.PI;

  private Spark leftMotor = new Spark(0);
  private Spark rightMotor = new Spark(1);

  public Encoder leftEncoder = new Encoder(4, 5);
  public Encoder rightEncoder = new Encoder(6, 7);
  private RomiGyro _gyro = new RomiGyro();

  public Drivetrain() {
    rightMotor.setInverted(true);
    leftEncoder.setDistancePerPulse(kWheelCircumference / kPulsesPerRevolution);
    rightEncoder.setDistancePerPulse(kWheelCircumference / kPulsesPerRevolution);
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void resetGyro() {
    _gyro.reset();
  }

  public double getAngle() {
    return _gyro.getAngle();
  }

  @Override
  public void periodic() {
  }

  public void setMotors(double left, double right){
    leftMotor.set(left);
    rightMotor.set(right);
  }

  public double getLeftWheelSpeed() {
    return leftEncoder.getRate();
  }

  public double getRightWheelSpeed() {
    return rightEncoder.getRate();
  }

  public double getLeftDistance(){
    return leftEncoder.getDistance();
  }

  public double getRightDistance(){
    return rightEncoder.getDistance();
  }
}
