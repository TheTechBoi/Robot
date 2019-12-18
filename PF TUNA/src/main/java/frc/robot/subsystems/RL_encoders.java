/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class RL_encoders extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Encoder leftEncoder = new Encoder(RobotMap.L_ENCODER_CA, RobotMap.L_ENCODER_CB, false, EncodingType.k4X);
  public Encoder rightEncoder = new Encoder(RobotMap.R_ENCODER_CA, RobotMap.R_ENCODER_CB, false, EncodingType.k4X);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
 


  }

  public void setDistPerPulse(){
    leftEncoder.setDistancePerPulse(RobotMap.DIST_PER_PULSE);
    rightEncoder.setDistancePerPulse(RobotMap.DIST_PER_PULSE);
  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();

  }

  public double readRight()
  {
    return(rightEncoder.getDistance());
  }

  public double readLeft()
  {
    return(leftEncoder.getDistance());
  }



}
