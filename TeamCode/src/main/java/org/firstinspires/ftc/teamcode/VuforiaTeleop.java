package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.macrobotics.rebot.vuforia.VuforiaModule;
import org.macrobotics.rebot.vuforia.VuforiaTrackableSet;

@TeleOp()
public class VuforiaTeleop extends OpMode {

    HardwareVuforia robot = new HardwareVuforia();

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.setTelemetry(telemetry);
        robot.getModule(VuforiaModule.class).setUpTrackableSet(VuforiaTrackableSet.ULTIMATE_GOAL);
    }

    @Override
    public void start() {
        robot.start();
    }

    @Override
    public void loop() {
        robot.update();
    }
}
