package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.macrobotics.rebot.opmode.AutonomousOpMode;
import org.macrobotics.rebot.pathing.Step;

import java.util.ArrayList;
import java.util.List;

@Autonomous
public class RebotAutonomous extends AutonomousOpMode {

    private static final List<Step> stepList = new ArrayList<>();

    public RebotAutonomous() {
        super(stepList, new HardwareTest());
    }
}
