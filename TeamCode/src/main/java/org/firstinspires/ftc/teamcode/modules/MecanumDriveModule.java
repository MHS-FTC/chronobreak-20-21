package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.rebot.module.ModuleProperties;
import org.macrobotics.rebot.modules.general.DirectionalDriveModule;

import java.util.EnumSet;

/**
 * A Module designed to control a mecanum drive system.
 * Uses four motors, one on each corner with Mecanum wheels attached to provide omnidirectional
 * movement, as well as turning.
 */
public class MecanumDriveModule extends DirectionalDriveModule {

    private double wheelDiameter = 100.0;
    private double ticksPerMotorRev = 383.6;
    private double gearReduction = 2;

    public enum MotorPosition {
        LEFT_FRONT,
        LEFT_BACK,
        RIGHT_FRONT,
        RIGHT_BACK
    }

    private final DcMotor left_front, left_back, right_front, right_back;

    private boolean running = false;

    /**
     * Create a new MecanumDriveModule using the four strings as the motor names.
     * @param hwMap Hardware map that contains the motors
     * @param lf Left back motor name
     * @param lb Left back motor name
     * @param rf Right front motor name
     * @param rb Right back motor name
     */
    public MecanumDriveModule(HardwareMap hwMap,
                              String lf, String lb,
                              String rf, String rb) {
        this.left_front  = hwMap.dcMotor.get(lf);
        this.left_back   = hwMap.dcMotor.get(lb);
        this.right_front = hwMap.dcMotor.get(rf);
        this.right_back  = hwMap.dcMotor.get(rb);

        left_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void setMotorDirection(MotorPosition pos, DcMotorSimple.Direction dir) {
        switch (pos) {
            case LEFT_FRONT:
                left_front.setDirection(dir);
                break;
            case LEFT_BACK:
                left_back.setDirection(dir);
                break;
            case RIGHT_FRONT:
                right_front.setDirection(dir);
                break;
            case RIGHT_BACK:
                right_back.setDirection(dir);
                break;
        }
    }

    /**
     * Sets the power of all the motors this drive system uses.
     * @param lf Left front motor power
     * @param lb Left back motor power
     * @param rf Right front motor power
     * @param rb Right back motor power
     */
    public void setPowerRaw(double lf, double lb,
                            double rf, double rb) {
        left_front.setPower(lf);
        left_back.setPower(lb);
        right_front.setPower(rf);
        right_back.setPower(rb);
    }

    public void drive(double dx, double dy, double turn) {
        double r = Math.hypot(dx, dy);
        double theta = Math.atan2(dy, dx) - Math.PI / 4;

        setPowerRaw(r * Math.cos(theta) + turn, r * Math.sin(theta) + turn,
                r * Math.sin(theta) - turn, r * Math.cos(theta) - turn);
    }

    public void driveDistance(double distance) {
        int tickTarget = (int) (distance * gearReduction * ticksPerMotorRev / (wheelDiameter * Math.PI));

        left_front.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_front.setTargetPosition(tickTarget);
        left_back.setTargetPosition(tickTarget);
        right_front.setTargetPosition(tickTarget);
        right_back.setTargetPosition(tickTarget);

        setPowerRaw(speed, speed, speed, speed);

        left_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        running = true;
    }

    @Override
    public void update() {
        if (running) {
            if (left_front.isBusy() && left_back.isBusy() &&
                    right_front.isBusy() && right_back.isBusy()) {
                getRobot().getTelemetry().addData("Pos", left_back.getCurrentPosition());
                getRobot().getTelemetry().addData("TPos", left_back.getTargetPosition());
            } else {
                setPowerRaw(0, 0, 0, 0);
                left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                running = false;
            }
        }
    }

    @Override
    public void stop() {
        setPowerRaw(0, 0, 0, 0);
    }

    public EnumSet<ModuleProperties> getProperties() {
        return EnumSet.of(ModuleProperties.NEEDS_UPDATE);
    }
}
