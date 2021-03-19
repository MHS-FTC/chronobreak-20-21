package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.modules.MecanumDriveModule;
import org.macrobotics.rebot.RobotConfig;

@Autonomous(name = "Test Autonomous")
public class TestAutonomous extends OpMode {

    RobotConfig robot = new HardwareTest();

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.setTelemetry(telemetry);

        robot.getModule(MecanumDriveModule.class).setMotorDirection(
                MecanumDriveModule.MotorPosition.LEFT_FRONT, DcMotorSimple.Direction.REVERSE);
        robot.getModule(MecanumDriveModule.class).setMotorDirection(
                MecanumDriveModule.MotorPosition.LEFT_BACK, DcMotorSimple.Direction.REVERSE);
    }

    public void start() {
        robot.getModule(MecanumDriveModule.class).driveDistance(1854);
    }

    @Override
    public void loop() {
        robot.update();
    }
}
