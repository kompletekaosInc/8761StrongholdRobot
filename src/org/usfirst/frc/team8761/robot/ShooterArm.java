package org.usfirst.frc.team8761.robot;
import edu.wpi.first.wpilibj.Spark;

public class ShooterArm {

    Spark ShooterArmSpark;

    public void init(){
        ShooterArmSpark = new Spark(3);

    }

    public void lower(double speed){
        ShooterArmSpark.set(speed);
    }
    public void raise(double speed){
        ShooterArmSpark.set(-speed);
    }
    public void stop() {
        ShooterArmSpark.set(0);
    }
}
