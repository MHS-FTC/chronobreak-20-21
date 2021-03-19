package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.macrobotics.rebot.Module;

public class WobbleGoalArm extends Module {

    Servo top, bottom;

    DcMotor arm;

    public WobbleGoalArm(HardwareMap hwMap, String topName, String bottomName, String armName) {
        top = hwMap.servo.get(topName);
        bottom = hwMap.servo.get(bottomName);
        arm = hwMap.dcMotor.get(armName);
    }

    public void setPowerRaw(double power) {
        arm.setPower(power);
    }

    public void setPositionRaw(double pos) {
        top.setPosition(pos);
        bottom.setPosition(1 - pos);
    }
}
