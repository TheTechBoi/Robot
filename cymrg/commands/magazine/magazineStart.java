package team.cymrg.commands.magazine;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.MagazineSubsystem;


public class magazineStart extends CommandBase {
    private final MagazineSubsystem magazineSubsystem;

    public magazineStart(MagazineSubsystem magazineSubsystem) {
        this.magazineSubsystem = magazineSubsystem;
        addRequirements(magazineSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        magazineSubsystem.magazineStart();
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
