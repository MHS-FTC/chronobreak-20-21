package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.macrobotics.rebot.RobotConfig;

@TeleOp(name = "Test Teleop")
class TestTeleop extends OpMode {

    RobotConfig robot = new HardwareTest();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        robot.update();
    }
}
