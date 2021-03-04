package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.macrobotics.rebot.Module;

public class WobbleGoalArm extends Module {

    Servo servo;

    DcMotor arm;

    public WobbleGoalArm(HardwareMap hwMap, String servoName, String armName) {
        servo = hwMap.servo.get(servoName);
        arm = hwMap.dcMotor.get(armName);
    }

    public void setPowerRaw(double power) {
        arm.setPower(power);
    }

    public void setPositionRaw(double pos) {
        servo.setPosition(pos);
    }
}
