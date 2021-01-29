package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.modules.MecanumDriveModule;
import org.firstinspires.ftc.teamcode.modules.ServoMagazineModule;
import org.firstinspires.ftc.teamcode.modules.YeeterModule;
import org.macrobotics.rebot.RobotConfig;
import org.macrobotics.rebot.vuforia.VuforiaModule;
import org.macrobotics.rebot.vuforia.VuforiaTrackableSet;

@TeleOp(name = "Test Teleop")
public class TestTeleop extends OpMode {

    double nudgeSpeed = 0.1;

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

    @Override
    public void start() {
        robot.start();
        //robot.getModule(VuforiaModule.class).setUpTrackableSet(VuforiaTrackableSet.ULTIMATE_GOAL);
    }

    @Override
    public void loop() {
        robot.update();
        robot.getModule(MecanumDriveModule.class).drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);

        robot.getModule(ServoMagazineModule.class).setPowerRaw((gamepad1.dpad_up ? 1 : 0) - (gamepad1.dpad_down ? 1 : 0));

        robot.getModule(YeeterModule.class).setPowerRaw((gamepad1.right_trigger > 0.5 ? 1 : 0)
            + (gamepad1.right_bumper ? nudgeSpeed : 0)   // right nudge
            - (gamepad1.left_bumper  ? nudgeSpeed : 0)); // left nudge
    }

    @Override
    public void stop() {
        robot.stop();
    }
}
