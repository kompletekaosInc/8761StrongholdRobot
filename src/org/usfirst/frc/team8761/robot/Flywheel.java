package org.usfirst.frc.team8761.robot;
import edu.wpi.first.wpilibj.Spark;

/**
 * Created by jiahpang on 1/07/2016.
 */


public class Flywheel {

    Spark flywheelSpark;

    public void init(){
        flywheelSpark = new Spark(2);

    }

    public void enable(double speed){
        flywheelSpark.set(speed );

    }
}
