package team.cymrg.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.ShooterSubsystem;


public class shooterStart extends CommandBase {
    private final ShooterSubsystem shooterSubsystem;

    public shooterStart(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.shooterSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        shooterSubsystem.shooterStart();
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
