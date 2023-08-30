package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnDegrees extends CommandBase {
    private final Drivetrain _drivetrain;
    private final double _angleDegToTurn;
    private final double _distanceToTravelCm;

    public TurnDegrees(Drivetrain drivetrain, double angleToTurnDegrees) {
        _drivetrain = drivetrain;
        _angleDegToTurn = angleToTurnDegrees;
        _distanceToTravelCm = _angleDegToTurn * Drivetrain.kCentimetersPerDegree;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        _drivetrain.resetEncoders();
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
       if(_drivetrain.getAvgDistance() > _distanceToTravelCm) {
            return true;
       }
       return false;
    }

}


