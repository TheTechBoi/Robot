/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import jaci.pathfinder.followers.EncoderFollower;
//import edu.wpi.first.wpilibj.Notifier;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PathFollower extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
   RobotMap.PF_TIME_STEP, RobotMap.Max_Speed, RobotMap.Max_Acceleration, RobotMap.Max_Jerk);


  Waypoint[] points = new Waypoint[] {
          new Waypoint(-4, -1, Pathfinder.d2r(-45)),
          new Waypoint(-2, -2, 0),
          new Waypoint(0, 0, 0)
  };

  Trajectory trajectory = Pathfinder.generate(points, config);

  // Wheelbase Width = 0.5m
  TankModifier modifier = new TankModifier(trajectory).modify(0.5);

  // Do something with the new Trajectories...
  Trajectory left = modifier.getLeftTrajectory();
  Trajectory right = modifier.getRightTrajectory();

  EncoderFollower f_left = new EncoderFollower(left);
  EncoderFollower f_right = new EncoderFollower(right);
/*
  Notifier m_follower_notifier = new Notifier(this::followPath);
  m_follower_notifier.startPeriodic(left.get(0).dt);

  burayı bilmiyorum
*/


  @Override
  public void initDefaultCommand() {

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void configureFollowers()
  {
    f_left.configureEncoder(Robot.m_encoders.leftEncoder.get() , RobotMap.PULSE_PER_REV, 0.5);
    f_left.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.7, 0);
  
  
    f_right.configureEncoder(Robot.m_encoders.rightEncoder.get() , RobotMap.PULSE_PER_REV, 0.5);
    f_right.configurePIDVA(1.0, 0.0, 0.0, 1 / 1.7, 0);
  }

  public void followPath() {

      double left_speed = f_left.calculate(Robot.m_encoders.leftEncoder.get());
      double right_speed = f_right.calculate(Robot.m_encoders.rightEncoder.get());
      double heading = Robot.m_gyro.gyro.getAngle();
      double desired_heading = Pathfinder.r2d(f_left.getHeading());
      double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
      double turn =  0.8 * (-1.0/80.0) * heading_difference;
      Robot.m_DriveTrainSub.m_drive.tankDrive(left_speed + turn, right_speed - turn);
    }

  /* burası da öyle bilmiyorum

  public void followPath() {
    if (m_left_follower.isFinished() || m_right_follower.isFinished()) {
      m_follower_notifier.stop();
    } else {
      double left_speed = f_left.calculate(Robot.m_encoders.leftEncoder.get());
      double right_speed = f_right.calculate(Robot.m_encoders.rightEncoder.get());
      double heading = Robot.m_gyro.gyro.getAngle();
      double desired_heading = Pathfinder.r2d(f_left.getHeading());
      double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
      double turn =  0.8 * (-1.0/80.0) * heading_difference;

      Robot.m_DriveTrainSub.m_drive.tankDrive(left_speed + turn, right_speed - turn);       
      ------------------ üstteki ya da alttaki
      Robot.m_DriveTrainSub.L_Spark.set(left_speed + turn);
      Robot.m_DriveTrainSub.R_spark.set(right_speed - turn);
    }
  }
  */



}
