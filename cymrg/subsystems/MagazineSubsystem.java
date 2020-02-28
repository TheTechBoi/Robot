package team.cymrg.subsystems;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.cymrg.Constants;


public class MagazineSubsystem extends SubsystemBase {
    private final static MagazineSubsystem INSTANCE = new MagazineSubsystem();

    // Değişkenlerin Tanımlanması
    private PWMTalonSRX redlineMagazine1 = new PWMTalonSRX(Constants.Redline.portRedline_Magazine1);
    private PWMTalonSRX redlineMagazine2 = new PWMTalonSRX(Constants.Redline.portRedline_Magazine2);

    public MagazineSubsystem() {
        //
    }

    public static MagazineSubsystem getInstance() {
        return INSTANCE;
    }

    public void magazineStart() {
        /* Intake motorunun çalışma hızı belirlendi
           1.00  = Motor: 100%
           0.75  = Motor: 75%
           0.50  = Motor: 50%
           0.25  = Motor: 25%
           0.00  = Motor: 00%
        */
        redlineMagazine1.set(0.500);
        redlineMagazine2.set(-0.500);

    }

    public void magazineStop() {
        /* Intake motorunun çalışma hızı 0'a ayarlandı */
        redlineMagazine1.set(0);
        redlineMagazine2.set(0);
    }

}

