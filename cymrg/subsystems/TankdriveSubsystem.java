package team.cymrg.subsystems;
import team.cymrg.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class TankdriveSubsystem extends SubsystemBase {

    private final static TankdriveSubsystem INSTANCE = new TankdriveSubsystem();
    public static TankdriveSubsystem getInstance() { return INSTANCE; }

    private TankdriveSubsystem() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    // Sola dönmek için => Sol motorun gücü %50 yapılır sağ motorun gücü aynıdır.
    // Araç sola dönerken ilerlemiş olur

    // Sağa dönmek için => sağ motorun gücü %50 yapılır sol motorun gücü aynıdır.
    // Araç sağa dönerken ilerlemiş olur

    /** LITTLE LITTLE INTO THE MIDDLE!
     * Just keep in mind, subsystem'lardan direkt olarak komut çağırmak
     * mantıklı bir seçenek değildir!
     *
     * Bu kısmı aslına bakarsak bir komut tanımlama olarak düşünebiliriz
     * Komutlar subsystem'larda tanımlanır, commands kısmında çağırılır ve komut olarak belirtilir
     * ardından {@link team.cymrg.RobotContainer} kısmında commands kısmından çekilerek butonlara atanır
     *
     * Tankdrive kısmında biz axis'ler yerine dpad'e tanımladık ve ileri, geri, sağ, sol için tanımlamalar yaptık.
     **/

    // Sol taraf için driverlar
    public static SpeedControllerGroup cymrgMotorLeft = new SpeedControllerGroup(
            new PWMVictorSPX(Constants.Drive.portMotorLeftFront),
            new PWMVictorSPX(Constants.Drive.portMotorLeftBack)
    );
    // Sağ taraf için driverlar
    public static SpeedControllerGroup cymrgMotorRight = new SpeedControllerGroup(
            new PWMVictorSPX(Constants.Drive.portMotorRightFront),
            new PWMVictorSPX(Constants.Drive.portMotorRightBack)
    );

    public void setMotors(double left, double right) {
        left = scaleLeft(left);
        right = scaleRight(right);

        setMotorsRaw(left, right);
    }

    public void setMotorsRaw(double left, double right) {
        left = safetyTest(left);
        right = safetyTest(right);

        cymrgMotorLeft.set(left);
        cymrgMotorRight.set(right);
    }

    private double safetyTest(double motorValue) {
        motorValue = (motorValue < -1) ? -1 : motorValue;
        motorValue = (motorValue > 1) ? 1 : motorValue;

        return motorValue;
    }

    private double scaleLeft(double left) {
        return 0.500 * left;
    }

    private double scaleRight(double right) {
        return 0.500 * right;
    }

    // Robotun Driveları
    public static DifferentialDrive cymrgDrive = new DifferentialDrive(cymrgMotorLeft, cymrgMotorRight);

    // Sol Taraf - Encoderlar
    private final Encoder cymrgEncoderLeft = new Encoder(
            Constants.Drive.kLeftEncoderPorts[0],
            Constants.Drive.kLeftEncoderPorts[1],
            Constants.Drive.kLeftEncoderReversed
    );

    //Sağ Taraf - Encoderlar
    private final Encoder cymrgEncoderRight = new Encoder(
            Constants.Drive.kRightEncoderPorts[0],
            Constants.Drive.kRightEncoderPorts[1],
            Constants.Drive.kRightEncoderReversed
    );


    // KOMUTLAR

    public void DrivebaseSubsystem() {
        cymrgEncoderLeft.setDistancePerPulse(Constants.Drive.kEncoderDistancePerPulse);
        cymrgEncoderRight.setDistancePerPulse(Constants.Drive.kEncoderDistancePerPulse);
    }

    public void tankDrive(double fwd, double rot) {
        cymrgDrive.tankDrive(fwd, rot);
    }

    public void resetEncoders() {
        cymrgEncoderLeft.reset();
        cymrgEncoderRight.reset();
    }
}

