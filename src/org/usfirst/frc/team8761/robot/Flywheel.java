package org.usfirst.frc.team8761.robot;
import edu.wpi.first.wpilibj.Spark;

public class Flywheel {

    Spark FlywheelSpark;

    public void init(){
        FlywheelSpark = new Spark(3);

    }

    public void go(double speed){
        FlywheelSpark.set(speed);
    }
    public void stop() {
        FlywheelSpark.set(0);
    }
}
