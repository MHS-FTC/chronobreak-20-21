package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareTest;
import org.firstinspires.ftc.teamcode.modules.MecanumDriveModule;
import org.macrobotics.rebot.RobotConfig;

@Autonomous(name = "Test Autonomous")
public class TestAutonomous extends OpMode {

    RobotConfig robot = new HardwareTest();

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.setTelemetry(telemetry);
    }

    public void start() {
        robot.getModule(MecanumDriveModule.class).driveDistance(2134, 1);
    }

    @Override
    public void loop() {

    }
}
