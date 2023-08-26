package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsytems.Drivetrain;

public class TimeDrive extends CommandBase {
    private final Drivetrain _drivetrain;
    private final Timer _timer = new Timer();

    public TimeDrive(Drivetrain drivetrain) {
        _drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        _timer.restart();    
    }

    @Override
    public void execute() {
        if (_timer.get() < 2) {
            _drivetrain.drive(0.5);
        } else  {
            _drivetrain.drive(0.2);
        }
    }

    @Override
    public void end(boolean interrupted) {
        _drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        if (_timer.get() > 4) {
            return true;
        }
        return false;
    }


}
