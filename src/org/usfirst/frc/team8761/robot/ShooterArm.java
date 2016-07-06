package org.usfirst.frc.team8761.robot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DigitalInput;

public class ShooterArm {

    Spark shooterArmSpark;
    DigitalInput raiseLS;
    DigitalInput lowerLS;

    public ShooterArm(){
        shooterArmSpark = new Spark(3);
        raiseLS = new DigitalInput(0);
        lowerLS = new DigitalInput(1);
    }

    public void lower(double speed){
        shooterArmSpark.set(speed);
    }
    public void raise(double speed){
        shooterArmSpark.set(-speed);
    }
    public void stop() {
        shooterArmSpark.set(0);
    }
    public void checkLimitSwitches() {
        if (lowerLS.get() && shooterArmSpark.get() > 0) {
            stop();
        }
        if (raiseLS.get() && shooterArmSpark.get() < 0) {
            stop();
        }
    }
}
