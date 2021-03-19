package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.modules.BeltIntakeModule;
import org.firstinspires.ftc.teamcode.modules.MecanumDriveModule;
import org.firstinspires.ftc.teamcode.modules.WobbleGoalArm;
import org.firstinspires.ftc.teamcode.modules.YeeterModule;
import org.macrobotics.rebot.RobotConfig;

@TeleOp(name = "Test Teleop")
public class TestTeleop extends OpMode {

    double nudgeSpeed = 0.1;

    int grabberPos = 0;

    Gamepad gp = gamepad1;
    boolean swapped = false;

    String currentGamepad = "1";

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

        gp = gamepad1;
    }

    @Override
    public void loop() {
        robot.update();

        if (gamepad1.x || gamepad2.x) {
            if (!swapped) {
                if (gp.equals(gamepad1)) {
                    gp = gamepad2;
                    currentGamepad = "2";
                } else {
                    gp = gamepad1;
                    currentGamepad = "1";
                }
            }

            swapped = true;
        } else {
            swapped = false;
        }

        robot.getModule(MecanumDriveModule.class).drive(gp.left_stick_x, -gp.left_stick_y, gp.right_stick_x);

        robot.getModule(BeltIntakeModule.class).setPowerRaw(gamepad1.left_trigger * 0.75 - (gamepad1.y ? 0.75 : 0)
            + gamepad2.left_trigger * 0.75 - (gamepad2.y ? 0.75 : 0));

        robot.getModule(YeeterModule.class).setPowerRaw((gamepad2.right_trigger > 0.5 ? 1 : 0)
            - (gamepad2.right_bumper ? nudgeSpeed : 0)   // right nudge
            + (gamepad2.left_bumper  ? nudgeSpeed : 0)); // left nudge

        robot.getModule(WobbleGoalArm.class).setPowerRaw(((gamepad1.dpad_down ? 0.75 : 0) - (gamepad1.dpad_up ? 0.75 : 0)) * (gamepad1.right_bumper ? 0.5 : 1) );

        if (gamepad1.a) {
            grabberPos = 1;
        } else if (gamepad1.b) {
            grabberPos = -1;
        }

        robot.getModule(WobbleGoalArm.class).setPositionRaw(grabberPos);

        telemetry.addData("Gamepad", currentGamepad);
    }

    @Override
    public void stop() {
        robot.stop();
    }
}
