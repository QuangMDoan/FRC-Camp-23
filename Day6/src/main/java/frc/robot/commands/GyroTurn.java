package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class GyroTurn extends CommandBase {
    private final Drivetrain _drivetrain;
    private final double _angleToTurnDeg;

    public GyroTurn(Drivetrain drivetrain, double angleToTurnDeg) {
        _drivetrain = drivetrain;
        _angleToTurnDeg = angleToTurnDeg;
        addRequirements(drivetrain);
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
        _drivetrain.setMotors(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
       if(Math.abs(_drivetrain.getGyroAngle()) > _angleToTurnDeg) {
            return true;
       }
       return false;
    }

}

