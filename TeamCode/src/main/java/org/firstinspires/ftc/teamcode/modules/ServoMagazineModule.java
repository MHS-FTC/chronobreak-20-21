package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

import org.macrobotics.rebot.Module;

public class ServoMagazineModule extends Module {

    private CRServo servo;

    public ServoMagazineModule(HardwareMap hwMap, String magServo) {
        this.servo = hwMap.crservo.get(magServo);
    }

    public void setPowerRaw(double power) {
        servo.setPower(power);
    }
}
