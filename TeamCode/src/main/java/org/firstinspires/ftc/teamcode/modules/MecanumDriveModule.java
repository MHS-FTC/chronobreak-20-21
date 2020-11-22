package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.macrobotics.rebot.Module;

/**
 * A Module designed to control a mecanum drive system.
 * Uses four motors, one on each corner with Mecanum wheels attached to provide omnidirectional
 * movement, as well as turning.
 */
public class MecanumDriveModule extends Module {

    public enum MotorPosition {
        LEFT_FRONT,
        LEFT_BACK,
        RIGHT_FRONT,
        RIGHT_BACK
    }

    private final DcMotor left_front, left_back, right_front, right_back;

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

    @Override
    public void stop() {
        setPowerRaw(0, 0, 0, 0);
    }
}
