package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.rebot.Module;

public class YeeterModule extends Module {

    private DcMotor motor;

    public YeeterModule(HardwareMap hwMap, String motorName) {
        this.motor = hwMap.dcMotor.get(motorName);

        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setPowerRaw(double power) {
        motor.setPower(power);
    }
}
