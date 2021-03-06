package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.macrobotics.rebot.modules.vuforia.VuforiaModule;
import org.macrobotics.rebot.modules.vuforia.VuforiaTrackableSet;

import java.util.Arrays;

@TeleOp()
public class VuforiaTeleop extends OpMode {

    HardwareVuforia robot = new HardwareVuforia();

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.setTelemetry(telemetry);
        robot.getModule(VuforiaModule.class).setupTrackableSet(VuforiaTrackableSet.ULTIMATE_GOAL);
    }

    @Override
    public void start() {
        robot.start();
    }

    @Override
    public void loop() {
        robot.update();
        telemetry.addData("pos", robot.getCurrPos());
    }
}
