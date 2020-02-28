package team.cymrg.commands.tankdrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.TankdriveSubsystem;


public class ResetEncoder extends CommandBase {
    private final TankdriveSubsystem tankdriveSubsystem;

    public ResetEncoder(TankdriveSubsystem tankdriveSubsystem) {
        this.tankdriveSubsystem = tankdriveSubsystem;
        addRequirements(tankdriveSubsystem);
    }

    @Override
    public void initialize() {
        tankdriveSubsystem.resetEncoders();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
