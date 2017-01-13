package org.usfirst.frc2791.MyRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Vector;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.Timer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static Encoder driveTrainLeftQuadratureEncoderLeft;
  public static Victor driveTrainLeftLeftMotor2;
  public static Victor driveTrainLeftLeftMotor;
  public static Victor driveTrainRightRightMotor1;
  public static Victor driveTrainRightRightMotor2;
  public static Victor shooterWheelClose;
  public static Victor shooterWheelFar;
  public static Encoder driveTrainRightQuadratureEncoderRight;
  public static Compressor compressor;
  public static Solenoid solenoid1;
  public static Solenoid solenoid2;
  public static Victor VexMotor;
  public static Encoder armEncoder;
  public static Victor armMotor;
  public static DigitalInput limitSwitch;
  public static DigitalInput limitSwitch2;
  public static Timer timz;
  public static Timer timz2;
  public static Timer timz3;
  public static Timer timz4;
  public static Timer timz5;
  public static Timer timer1;
  public static Timer timzlikeaboss;
  public static AnalogChannel sensor1emitter;
  public static AnalogChannel sensor1detector;
  public static AnalogChannel sensor2emitter;
  public static AnalogChannel sensor2detector;
  public static AnalogChannel distanceSensor;
  public static DigitalInput toggle1;
  public static DigitalInput toggle2;

  public static void init() {
    driveTrainLeftQuadratureEncoderLeft = new Encoder(1, 2, 1, 1, false, EncodingType.k4X); //2nd and 4th
    LiveWindow.addSensor("DriveTrainLeft", "Quadrature Encoder Left", driveTrainLeftQuadratureEncoderLeft);
    driveTrainLeftQuadratureEncoderLeft.setDistancePerPulse(1.0);
    driveTrainLeftQuadratureEncoderLeft.setPIDSourceParameter(PIDSourceParameter.kRate);
    driveTrainLeftQuadratureEncoderLeft.start();
    driveTrainLeftLeftMotor2 = new Victor(1, 10);
    driveTrainLeftLeftMotor = new Victor(1, 2); //1,3

    LiveWindow.addActuator("DriveTrainLeft", "LeftMotor", driveTrainLeftLeftMotor);

    driveTrainRightRightMotor1 = new Victor(1, 3);
    driveTrainRightRightMotor2 = new Victor(1, 1);
    LiveWindow.addActuator("DriveTrainRight", "RightMotor", driveTrainRightRightMotor1);

    driveTrainRightQuadratureEncoderRight = new Encoder(1, 4, 1, 3, false, EncodingType.k4X); //2nd and 4th
    LiveWindow.addSensor("DriveTrainRight", "Quadrature Encoder Right", driveTrainRightQuadratureEncoderRight);
    driveTrainRightQuadratureEncoderRight.setDistancePerPulse(1.0);
    driveTrainRightQuadratureEncoderRight.setPIDSourceParameter(PIDSourceParameter.kRate);
    driveTrainRightQuadratureEncoderRight.start();

    shooterWheelClose = new Victor(1, 7); // 7 is placeholder PWM slot
    shooterWheelFar = new Victor(1, 8); // 8 is placeholder

    compressor = new Compressor(6, 1); //3,1
    solenoid1 = new Solenoid(1);
    solenoid2 = new Solenoid(2);
    armEncoder = new Encoder(1, 7, 1, 8, false, EncodingType.k4X); //1,3,1,4
    armEncoder.start();

    armMotor = new Victor(1, 6); //shoulder, 6

    limitSwitch = new DigitalInput(5);
    limitSwitch2 = new DigitalInput(10);
    VexMotor = new Victor(1, 4);
    timz = new Timer();
    timz2 = new Timer();
    timz3 = new Timer();
    timz4 = new Timer();
    timz5 = new Timer();
    timer1 = new Timer();
    timzlikeaboss = new Timer();
    sensor1emitter = new AnalogChannel(1);
    sensor1detector = new AnalogChannel(2);
    sensor2emitter = new AnalogChannel(3);
    sensor2detector = new AnalogChannel(4);
    distanceSensor = new AnalogChannel(5);
  }
}