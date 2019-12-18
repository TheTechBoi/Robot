/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int R_MDRIVE = 0;
  public static int L_MDRIVE = 1;

  public static int L_ENCODER_CA = 1;
  public static int L_ENCODER_CB = 2;
  public static int R_ENCODER_CA = 3;
  public static int R_ENCODER_CB = 4;
  
  public static int ANALOG_GYRO_PORT = 0;

  public static double DIST_PER_REV = 18.84;  // guestimate from your code
  public static int PULSE_PER_REV = 1024;     // for an AS5145B Magnetic Encoder
  public static double DIST_PER_PULSE = DIST_PER_REV / PULSE_PER_REV;

  public static double PF_TIME_STEP = 0.02;
  public static double Max_Speed = 1.7; // m/s
  public static double Max_Acceleration = 2.0; //  m/s/s
  public static double Max_Jerk = 60.0 ; //   m/s/s/s




}
