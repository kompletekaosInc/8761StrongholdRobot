package org.usfirst.frc.team8761.robot;
import edu.wpi.first.wpilibj.Spark;

public class Flywheel {

    private Spark flywheelSpark;

    public Flywheel(){
        flywheelSpark = new Spark(3);
    }

    public void go(double speed){
        flywheelSpark.set(speed);
    }
    public void stop() {
        flywheelSpark.set(0);
    }
}
