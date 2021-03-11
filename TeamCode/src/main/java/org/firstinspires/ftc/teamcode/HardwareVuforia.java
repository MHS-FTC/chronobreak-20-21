package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.rebot.RobotConfig;
import org.macrobotics.rebot.modules.vuforia.VuforiaModule;

public class HardwareVuforia extends RobotConfig {

    private static final String API_KEY = "AeUIoo3/////AAABmVdzoxEqEEJnrIBg6CuGkoqIQxJ9oehhG/kr" +
            "LOi8C5dvfPehzrpGN8jkCLYWN+klAXzEiadRjP7JVw3MfuiyvcSKsh7OLUs6GkAibtak12q6+9iYH7W5ty" +
            "yc8s9oUMJBSgYqPraRyjNM90m+29d1E4hEwHUP3cwgDFfDWQxjZ7/7ZMe/LaF5hZur98UUq8PZKlOf8HFq" +
            "NZv8LsgLgy/v6iXORYkGx8/3uSe0J5HTQd6ABRACUM4ajrRp7gSRK1rXEX2FJVk/0u9mh562kEJhOW+wAJ" +
            "xcce3igo7o/+M/NO00+WwCjT2h7hRxMOpU+dioC8lqmTwGLT7/SZSO1/LUZwVB5CYYnAQO6nWRTpxku4OU";

    @Override
    public void init(HardwareMap hwMap) {
        addModule(new VuforiaModule(hwMap, API_KEY));
    }
}
