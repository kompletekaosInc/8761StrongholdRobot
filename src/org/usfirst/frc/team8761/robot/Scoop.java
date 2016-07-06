package org.usfirst.frc.team8761.robot;
import edu.wpi.first.wpilibj.Spark;


public class Scoop {

    private Spark scoopMC = null;

    public void Arm() {
        scoopMC = new Spark(9);
    }

    public void init(){

    }

    public void lower(){
        scoopMC.set(-0.4);
    }

    public void raise(){
        scoopMC.set(0.4);
    }
    public void stop(){
        scoopMC.set(0);
    }
}
