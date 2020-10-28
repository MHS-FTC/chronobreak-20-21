package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.rebot.Module;

public class TestModule extends Module {

    public DcMotor motor;

    public TestModule(HardwareMap hwMap, String motorName) {
        motor = hwMap.dcMotor.get(motorName);

        motor.setPower(1);
    }

    @Override
    public void stop() {
        motor.setPower(0);
    }
}
