package team.cymrg.commands.tankdrive;

import team.cymrg.Constants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.TankdriveSubsystem;


public class LetsDrive extends CommandBase {
    private final TankdriveSubsystem tankdriveSubsystem;

    public static Joystick          controllerLogitech  = new Joystick(Constants.Controller.controllerLogitech);
    public static XboxController    controllerXbox360   = new XboxController(Constants.Controller.controllerXbox360);

    public LetsDrive(TankdriveSubsystem tankdriveSubsystem) {
        this.tankdriveSubsystem = tankdriveSubsystem;
        addRequirements(tankdriveSubsystem);
    }

    @Override
    public void initialize() {
        tankdriveSubsystem.tankDrive(   controllerLogitech.getAxisType(1)   , controllerLogitech.getAxisType(0) );
        tankdriveSubsystem.tankDrive(   controllerXbox360.getRawAxis(1)     , controllerXbox360.getRawAxis(0)   );
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
