package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.rebot.Module;

public class BeltIntakeModule extends Module {

    DcMotor beltMotor;

    public BeltIntakeModule(HardwareMap hwMap, String beltMotorName) {
        beltMotor = hwMap.dcMotor.get(beltMotorName);
    }

    public void setPowerRaw(double power) {
        beltMotor.setPower(power);
    }
}
