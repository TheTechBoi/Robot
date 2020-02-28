package team.cymrg.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.IntakeSubsystem;


public class intakeStop extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;

    public intakeStop(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intakeSubsystem.intakeStop();
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
