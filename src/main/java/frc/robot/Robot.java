// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.hal.PWMJNI;
import edu.wpi.first.wpilibj.Joystick;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /*Before usage confirm that all PWM channels are alligned with the corresponding motor and Controller inputs with the corresponding axis.
  Each joystick axis can be found in the driver station  */


  // Define Motor controller output
  private Spark leftMotor1 = new Spark(5);
  private Spark leftMotor2 = new Spark(6);
  private Spark RightMotor1 = new Spark(2);
  private Spark RightMotor2 = new Spark(3);
  
  //Define controller
  private Joystick Joystick1 = new Joystick(0);
 
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    //Set speed limit percentage
    double drive_speed_limit = 0.6;
    double rotation_speed_limit = 0.4;

    //Define joystick axis
    double drive = Joystick1.getRawAxis(4)*drive_speed_limit;
    double rotation = -Joystick1.getRawAxis(1)*rotation_speed_limit;

    //Quick maffs
    double left_motor_speed = drive + rotation;
    double right_motor_speed = drive - rotation;

    //Set motor speed
    leftMotor1.set(left_motor_speed);
    leftMotor2.set(left_motor_speed);
    RightMotor1.set(right_motor_speed);
    RightMotor2.set(right_motor_speed);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
