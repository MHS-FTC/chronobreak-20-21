package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.modules.BeltIntakeModule;
import org.firstinspires.ftc.teamcode.modules.MecanumDriveModule;
import org.firstinspires.ftc.teamcode.modules.WobbleGoalArm;
import org.firstinspires.ftc.teamcode.modules.YeeterModule;
import org.macrobotics.rebot.RobotConfig;

class HardwareTest extends RobotConfig {

    private static final String API_KEY = "AeUIoo3/////AAABmVdzoxEqEEJnrIBg6CuGkoqIQxJ9oehhG/kr" +
            "LOi8C5dvfPehzrpGN8jkCLYWN+klAXzEiadRjP7JVw3MfuiyvcSKsh7OLUs6GkAibtak12q6+9iYH7W5ty" +
            "yc8s9oUMJBSgYqPraRyjNM90m+29d1E4hEwHUP3cwgDFfDWQxjZ7/7ZMe/LaF5hZur98UUq8PZKlOf8HFq" +
            "NZv8LsgLgy/v6iXORYkGx8/3uSe0J5HTQd6ABRACUM4ajrRp7gSRK1rXEX2FJVk/0u9mh562kEJhOW+wAJ" +
            "xcce3igo7o/+M/NO00+WwCjT2h7hRxMOpU+dioC8lqmTwGLT7/SZSO1/LUZwVB5CYYnAQO6nWRTpxku4OU";

    public void init(HardwareMap hwMap) {
        addModule(new MecanumDriveModule(hwMap, "left_front_drive", "left_back_drive",
                "right_front_drive", "right_back_drive"));

        addModule(new YeeterModule(hwMap, "yeeter"));

        addModule(new BeltIntakeModule(hwMap, "beltIntake"));

        addModule(new WobbleGoalArm(hwMap, "top_grabber", "bottom_grabber", "arm"));

        //addModule(new ServoMagazineModule(hwMap, "magServo"));

        //addModule(new IntegratingGyroscopeModule(hwMap, "gyro"));

        //addModule(new VuforiaModule(hwMap, API_KEY));
    }
}
