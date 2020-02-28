package team.cymrg.subsystems;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import team.cymrg.Constants;


public class ShooterSubsystem extends SubsystemBase {
    private final static ShooterSubsystem INSTANCE = new ShooterSubsystem();

    // Değişkenlerin Tanımlanması
    private PWMTalonSRX redlineShooter1 = new PWMTalonSRX(Constants.Redline.portRedline_Shooter1);
    private PWMTalonSRX redlineShooter2 = new PWMTalonSRX(Constants.Redline.portRedline_Shooter2);

    public ShooterSubsystem() {
        //
    }

    public static ShooterSubsystem getInstance() {
        return INSTANCE;
    }

    public void shooterStart() {
        /* Intake motorunun çalışma hızı belirlendi
           1.00  = Motor: 100%
           0.75  = Motor: 75%
           0.50  = Motor: 50%
           0.25  = Motor: 25%
           0.00  = Motor: 00%
        */
        redlineShooter1.set(0.500);
        redlineShooter2.set(0.500);
    }

    public void shooterStop() {
        /* Intake motorunun çalışma hızı 0'a ayarlandı */
        redlineShooter1.set(0);
        redlineShooter2.set(0);
    }

}

