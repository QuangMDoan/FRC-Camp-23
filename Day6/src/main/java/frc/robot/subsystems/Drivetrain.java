package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.romi.RomiGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    public static final double kPulsesPerRevolution = 1440.0;

    public static final double kTrackWidthCm = 14.1;

    public static final double kWheelDiameterCm = 7;
    public static final double kInchToCm = 2.54;

    public static final double kWheelCircumferenceCM = Math.PI * kWheelDiameterCm;
    public static final double kCentimetersPerDegree = Math.PI * kTrackWidthCm / 360;

    private final Spark _leftMotor = new Spark(0);
    private final Spark _rightMotor = new Spark(1);
    
    private final Encoder _leftEncoder = new Encoder(4, 5);
    private final Encoder _rightEncoder = new Encoder(6, 7);
    private final RomiGyro _gyro = new RomiGyro();
    
    public Drivetrain() {
        _rightMotor.setInverted(true);

        _leftEncoder.setDistancePerPulse(kWheelCircumferenceCM / kPulsesPerRevolution);
        _rightEncoder.setDistancePerPulse(kWheelCircumferenceCM / kPulsesPerRevolution);

        calibrateGyro();
        resetEncoders();
    }

    @Override
    public void periodic() {
    }

    public void calibrateGyro() {
        _gyro.calibrate();
    }

    public void resetEncoders() {
        _leftEncoder.reset();
        _rightEncoder.reset();
    }

    public void setMotors(double left, double right){
        _leftMotor.set(left);
        _rightMotor.set(right);
    }

    public double getGyroAngle() {
        return _gyro.getAngle();
    }

    public void resetGyro() {
        _gyro.reset();
    }

    public double getLeftDistance(){
        return _leftEncoder.getDistance();
    }

    public double getRightDistance(){
        return _rightEncoder.getDistance();
    }

    public double getAvgDistance() {
        return (Math.abs(getLeftDistance()) + Math.abs(getRightDistance())) / 2.0;
    }
}