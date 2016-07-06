package org.usfirst.frc.team8761.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    static final Logger LOG = LoggerFactory.getLogger(Robot.class);


    private Drivetrain drivetrain;
    private Scoop scoop;
    private Flywheel flywheel;
    private ShooterArm shooterArm;
    private CameraServer camera1;
    private org.usfirst.frc.team8761.robot.DriverStation driverStation;
    Auto1 auto1;



    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        LOG.info("robotInit: BEGIN");

        drivetrain = new Drivetrain();
        scoop = new Scoop();
        flywheel = new Flywheel();
        shooterArm = new ShooterArm();

        try {
            camera1 = CameraServer.getInstance();
            camera1.setQuality(30);
            camera1.startAutomaticCapture("cam0");
        } catch (Exception e) {
            LOG.error("Camera not installed correctly", e);
        }

        driverStation = new org.usfirst.frc.team8761.robot.DriverStation();

        LOG.info("robotInit: END");
    }

    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
        auto1 = new Auto1(this);
        shooterArm.stop();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        auto1.doAutonomous();
    }

    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit() {

        LOG.info("teleopInit: BEGIN");
        LOG.info("teleopInit: END");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        driverStation.control(this);
        shooterArm.checkLimitSwitches();
    }


    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    /**
     * Display the provided name and value.  This could be done by presenting the name/value to the SmartDashboard
     * as well as logging the information.
     *
     * @param name
     * @param value
     */
    public static void displayValue(String name, Object value) {
        SmartDashboard.putString(name, value.toString());
        LOG.debug("[" + name + ":" + value + "]");
    }
    public void drive(double left, double right) {
        drivetrain.drive(left, right);
    }
    public void raiseScoop() {
        scoop.raise();
    }
    public void lowerScoop() {
        scoop.lower();
    }
    public void stopScoop() {
        scoop.stop();
    }
    public void flywheelGo(double speed) {
        flywheel.go(speed);
    }
    public void flywheelStop() {
        flywheel.stop();
    }
    public void raiseShooter(double speed) {
        shooterArm.raise(speed);
    }
    public void lowerShooter(double speed) {
        shooterArm.lower(speed);
    }
    public void stopShooter() {
        shooterArm.stop();
    }

}