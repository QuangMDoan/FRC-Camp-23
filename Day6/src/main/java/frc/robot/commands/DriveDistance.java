package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase {
    private final Drivetrain _drivetrain;
    private final double _distanceToTravelCm;

    public DriveDistance(Drivetrain drivetrain, double distanceToTravelInches) {
        _drivetrain = drivetrain;
        _distanceToTravelCm = distanceToTravelInches * Drivetrain.kInchToCm;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        _drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        _drivetrain.setMotors(0.25, 0.25);
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
