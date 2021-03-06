package org.usfirst.frc.team8761.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by jwill on 7/6/2016.
 */
public class Auto1 {
    static final Logger LOG = LoggerFactory.getLogger(Auto1.class);
    private long startTimeMs;
    private Robot robot;

    public Auto1(Robot theRobot) {
        startTimeMs = System.currentTimeMillis();
        SmartDashboard.putString("auto startTimeMs", ""+startTimeMs);
        SmartDashboard.putString("auto currentAutoRunDuration", "0");
        robot = theRobot;

    }
    public void doAutonomous() {
        long currentMs = System.currentTimeMillis();

        long currentAutoRunDuration = currentMs - startTimeMs;

        SmartDashboard.putString("auto currentAutoRunDuration", "" + currentAutoRunDuration);

        //The first two seconds are reserved for the gyro reset in the init

        if (currentAutoRunDuration <= 1000) {
            // in 1 second of auto
            LOG.info("doAutonomous in second 1000");
            robot.drive(0.4, 0.4);
        } else if (currentAutoRunDuration <= 2000) {
            // in 2 second of auto
            LOG.info("doAutonomous in second 2000");
            robot.drive(0.8, 0.8);
        } else if (currentAutoRunDuration <= 3000) {
            // in 3 second of auto
            LOG.info("doAutonomous in second 3000");
            robot.drive(0.8, 0.8);
        } else if (currentAutoRunDuration <= 4000) {
            // in 4 second of auto
            LOG.info("doAutonomous in second 4000");
            //robot.turnGyro(180);
            //robot.stop();
            robot.drive(-0.1, 0.1);
        } else {
            LOG.info("Auto: after 5 seconds");
        }
    }
}
