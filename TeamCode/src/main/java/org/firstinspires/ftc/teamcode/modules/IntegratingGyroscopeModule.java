package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.macrobotics.rebot.Module;
import org.macrobotics.rebot.module.ModuleProperties;

import java.util.EnumSet;

public class IntegratingGyroscopeModule extends Module {

    private final IntegratingGyroscope gyro;

    public IntegratingGyroscopeModule(HardwareMap hwMap, String gyroName) {
        gyro = hwMap.get(IntegratingGyroscope.class, gyroName);
    }

    @Override
    public EnumSet<ModuleProperties> getProperties() {
        return EnumSet.of(ModuleProperties.PROVIDES_ORIENTATION);
    }

    /**
     * Gets the current gyroscope orientation in radians with XYZ axis order.
     * @return Current orientation
     */
    public Orientation getOrientation() {
        return gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ,
                AngleUnit.RADIANS);
    }
}
