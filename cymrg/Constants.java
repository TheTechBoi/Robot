/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.cymrg;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static final class Controller {
        public static final int controllerLogitech   = 0;
        public static final int controllerXbox360    = 1;
        public static final int controllerJoystick   = 2;
    }

    public static final class Drive {

        // Motor Portlarının Belirtilmesi
        public static final int portMotorLeftFront  = 3;
        public static final int portMotorLeftBack   = 4;
        public static final int portMotorRightFront = 5;
        public static final int portMotorRightBack  = 6;

        // Portların Encoder'lara Tanımlanması
        public static final int[]   kLeftEncoderPorts       = new int[]{3, 4};
        public static final int[]   kRightEncoderPorts      = new int[]{5, 6};
        public static final boolean kLeftEncoderReversed    = false;
        public static final boolean kRightEncoderReversed   = true;

        public static final int kEncoderCPR = 1024;
        public static final double kWheelDiameterInches = 6;
        public static final double kEncoderDistancePerPulse = (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;
    }

    public static final class Redline {
        // redline motorları
        /*  INTAKE   */
        public static final int portRedline_Intake = 7;
        /*  MAGAZINE */
        public static final int portRedline_Magazine1 = 8;
        public static final int portRedline_Magazine2 = 9;
        /*  SHOOTER  */
        public static final int portRedline_Shooter1  = 10;
        public static final int portRedline_Shooter2  = 11;

    }
}