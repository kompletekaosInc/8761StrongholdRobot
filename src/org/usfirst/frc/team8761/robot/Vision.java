package org.usfirst.frc.team8761.robot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Vision {

    static final Logger LOG = LoggerFactory.getLogger(Vision.class);

    int width;
    int height;
    /**
     * Create a Drivetrain.
     */
    public Vision() {
        LOG.info("<constructor>");

    }

    public void teleopInit()
    {
    }

    public void teleopPeriodic()
    {

    }

    public int shoot()
    {
        //Flywheel.enable(1.00);

        return 0;
    }

}
