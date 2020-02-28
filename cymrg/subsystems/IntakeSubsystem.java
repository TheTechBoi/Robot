package team.cymrg.subsystems;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import team.cymrg.Constants;


public class IntakeSubsystem extends SubsystemBase {
    private final static IntakeSubsystem INSTANCE = new IntakeSubsystem();

    // Değişkenlerin Tanımlanması
    private PWMTalonSRX redlineIntake = new PWMTalonSRX(Constants.Redline.portRedline_Intake);

    public IntakeSubsystem() {
        //
    }

    public static IntakeSubsystem getInstance() {
        return INSTANCE;
    }

    public void intakeStart() {
        /* Intake motorunun çalışma hızı belirlendi
           1.00  = Motor: 100%
           0.75  = Motor: 75%
           0.50  = Motor: 50%
           0.25  = Motor: 25%
           0.00  = Motor: 00%
        */
        redlineIntake.set(0.500);
    }

    public void intakeStop() {
        /* Intake motorunun çalışma hızı 0'a ayarlandı */
        redlineIntake.set(0);
    }

}

