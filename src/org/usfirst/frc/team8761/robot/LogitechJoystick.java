package org.usfirst.frc.team8761.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Created by jiahpang on 20/06/2016.
 */
public class LogitechJoystick extends DriveControl{

    private Joystick stick;

    public LogitechJoystick()
    {
        stick = new Joystick(0);
    }

    /**
     * Joystick implementation of the core behaviour of a DriveControl.
     *
     * @param robot
     */
    public void giveCommands(Robot robot) {
        drivingCommands(robot);
        //armMovements(robots);

    }

    /**
     * Read the stick values to determine the speed and direction to drive the robot.
     * Leverage the throttle position to determine speed.
     *
     * @param robot
     */
    private void drivingCommands(Robot robot) {
        //myRobot.arcadeDrive(stick);
        double side = stick.getX();
        double speed = stick.getY();
        double throttle = stick.getThrottle();
        //LOG.debug("teleopPeriodic: raw [side:" + side + "][speed:" + speed + "][throttle:" + throttle + "]");

        Robot.displayValue("RAW side", ""+side);
        Robot.displayValue("RAW speed", ""+speed);

        throttle = (throttle - 1)/2;
        speed = speed * throttle;
        side = side * throttle;

        double appliedSpeed = (speed * throttle);

        //LOG.debug("teleopPeriodic: [side:" + side + "][speed:" + speed + "][throttle:" + throttle + "]");
        Robot.displayValue("side", ""+side);
        Robot.displayValue("speed", ""+speed);
        Robot.displayValue("throttle", ""+throttle);


        double leftMotorPower = -speed - side ;
        double rightMotorPower = (speed - side);

        // tell the robot to drive using the calculated power for the left and right motors
        robot.drive(leftMotorPower, rightMotorPower);
//        robot.drive(.5, -.5);
  }
    private void scoopMovements(Robot robot){
        if (stick.getRawButton(12) == true)  // button 12 is pressed
        {
            //driver wants to raise the scoop
            robot.raiseScoop();
        }
        // see if driver wants to lower the scoop
        else if (stick.getRawButton(11) == true) // Button 11 is pressed
        {
            // driver wants to lower the arm
            robot.lowerScoop();
        }
        else //no button is pressed
        {
            // the driver has no arm movement commands to process
            robot.stopScoop();
        }
    }
    private void flywheelMovements(Robot robot)    {
        if (stick.getRawButton(1) == true)  // button 1 is pressed
        {
            //driver wants to trigger the flywheels
            robot.flywheelGo(0.5);

        }
        else //no button is pressed
        {
            // the driver has no arm movement commands to process
            robot.flywheelStop();
        }
    }
    private void shooterArmMovements(Robot robot) {
        if (stick.getRawButton(6) == true)  // button 1 is pressed
        {
            //driver wants to lower the shooter
            robot.lowerShooter(0.5);

        }
        else if (stick.getRawButton(7) == true) {
            //driver wants to raise the shooter
            robot.raiseShooter(0.5);
        }
        else //no button is pressed
        {
            // the driver has no arm movement commands to process
            robot.stopShooter();
        }
    }

}
