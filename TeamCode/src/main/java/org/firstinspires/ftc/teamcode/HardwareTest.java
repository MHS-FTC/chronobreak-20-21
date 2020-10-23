package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.modules.TestModule;
import org.macrobotics.rebot.RobotConfig;

class HardwareTest extends RobotConfig {

    public void init(HardwareMap hwMap) {
        addModule(new TestModule(hwMap, "motor"));
    }
}
