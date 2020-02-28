/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.cymrg;
import team.cymrg.commands.*;
import team.cymrg.commands.shooter.shooterStart;
import team.cymrg.subsystems.*;

import team.cymrg.commands.intake.*;
import team.cymrg.commands.shooter.*;
import team.cymrg.commands.magazine.*;
import team.cymrg.commands.tankdrive.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    //  Subsystems
    private final ExampleSubsystem      exampleSubsystem    = new ExampleSubsystem();
    private final TankdriveSubsystem    tankdriveSubsystem  = TankdriveSubsystem.getInstance();
    private final IntakeSubsystem       intakeSubsystem     = IntakeSubsystem.getInstance();
    private final MagazineSubsystem     magazineSubsystem   = MagazineSubsystem.getInstance();
    private final ShooterSubsystem      shooterSubsystem    = ShooterSubsystem.getInstance();
    //  Controllers
    public static Joystick          controllerLogitech = new Joystick(Constants.Controller.controllerLogitech);
    public static XboxController    controllerXbox360  = new XboxController(Constants.Controller.controllerXbox360);
    public static Joystick          controllerJoystick = new Joystick(Constants.Controller.controllerJoystick);
    //  Commands
    private final ExampleCommand autonomousCommand = new ExampleCommand     (exampleSubsystem);
    //Intake
    private final intakeStart       intakeStart    = new intakeStart        (intakeSubsystem);
    private final intakeStop        intakeStop     = new intakeStop         (intakeSubsystem);
    //Tankdrive
    private final ResetEncoder      resetEncoder   = new ResetEncoder       (tankdriveSubsystem);
    //Magazine
    private final magazineStart     magazineStart  = new magazineStart      (magazineSubsystem);
    private final magazineStop      magazineStop   = new magazineStop       (magazineSubsystem);
    //Shooter
    private final shooterStart      shooterStart   = new shooterStart       (shooterSubsystem);
    private final shooterStop       shooterStop    = new shooterStop        (shooterSubsystem);

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer()
    {
        LetsDrive letsDrive = new LetsDrive(tankdriveSubsystem);
        // Xbox360              Logitech F310               Logitech Joystick
        configureButton_Xbox(); configureButton_Logitech(); configureButton_Joystick();
        // Tankdrive stick ayarları
        tankdriveSubsystem.setDefaultCommand(letsDrive);
    }

    private void configureButton_Xbox(){
        // Intake: Çalıştır - A Tuşu
        Button D1 = new JoystickButton(controllerXbox360, 1); D1.whenPressed(intakeStart);
        // Intake: Durdur   - B Tuşu
        Button D2 = new JoystickButton(controllerXbox360, 2); D2.whenPressed(intakeStop);
        // Magazine Stop    - X Tuşu
        Button D3 = new JoystickButton(controllerXbox360, 3); D3.whenPressed(magazineStart);
        // Magazine Start   - Y Tuşu
        Button D4 = new JoystickButton(controllerXbox360, 4); D4.whenPressed(magazineStop);
        // Shooter: Start   - RB Tuşu - Basılı
        Button D5_H = new JoystickButton(controllerXbox360, 5); D5_H.whenHeld(shooterStart);
        // Shooter: Start   - RB Tuşu - Bırakıldı
        Button D5_R = new JoystickButton(controllerXbox360, 5); D5_R.whenReleased(shooterStop);
        // Reset Encoder    - LB Tuşu
        Button D6 = new JoystickButton(controllerXbox360, 6); D6.whenPressed(resetEncoder);
    }

    private void configureButton_Logitech() {
        //
        //
    }

    private void configureButton_Joystick() {
        //
        //
    }


    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return autonomousCommand;
    }
}
