package org.usfirst.frc.team8761.robot;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechJoystickRamped extends DriveControl{

    private Joystick stick;

    public LogitechJoystickRamped()
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
    private void drivingCommands( Robot robot ) {
        //myRobot.arcadeDrive(stick);
        double side = stick.getX();
        double speed = stick.getY();
        double throttle = stick.getThrottle();
        double[] powerArray;
        powerArray = new double[2];
        //LOG.debug("teleopPeriodic: raw [side:" + side + "][speed:" + speed + "][throttle:" + throttle + "]");

        Robot.displayValue("RAW side", ""+side);
        Robot.displayValue("RAW speed", ""+speed);

        throttle = (throttle - 1)/2;
        speed = speed * throttle;
        side = side * throttle;

        double appliedSpeed = (speed * throttle);

        powerArray = rampMotors(speed, side, 0.5);

        //all maths must be done before this point.
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

    private double[] rampMotors(double speed, double side, double exponent) {
        double[] powerArray;
        powerArray = new double[2];

        speed = Math.pow(speed, exponent);
        side = Math.pow(side, exponent);

        powerArray[0] = speed;
        powerArray[1] = side;

        return powerArray;
    }

}
