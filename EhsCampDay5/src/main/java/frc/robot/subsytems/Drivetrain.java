package frc.robot.subsytems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final Spark _leftMotor = new Spark(0);
    private final Spark _rightMotor = new Spark(1);

    public Drivetrain() {
        _rightMotor.setInverted(true);
    } 

    @Override
    public void periodic() {

    }

    public void drive(double speed) {
        _leftMotor.set(speed);
        _rightMotor.set(speed);
    }

    public void stop() {
        _leftMotor.stopMotor();
        _rightMotor.stopMotor();
    }
}
