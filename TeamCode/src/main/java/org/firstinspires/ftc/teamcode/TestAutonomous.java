package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareTest;
import org.macrobotics.rebot.RobotConfig;

@Autonomous(name = "Test Autonomous")
public class TestAutonomous extends OpMode {

    RobotConfig robot = new HardwareTest();

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.setTelemetry(telemetry);
    }

    @Override
    public void loop() {

    }
}
