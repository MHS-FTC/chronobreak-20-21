package org.macrobotics.rebot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;

public abstract class RobotConfig {

    private ArrayList<Module> modules = new ArrayList<>();

    /**
     * Override this to initialize the robot and add modules.
     * The only
     *
     * @param hwMap Robot hardware map for initialization.
     */
    public abstract void init(HardwareMap hwMap);

    /**
     * Adds a module to the robot.
     *
     * @param m The module to add.
     */
    private void addModule(Module m) {
        modules.add(m);
    }

    /**
     * Returns a specified Module from the robot, or null if that module doesn't exist.
     *
     * @param c Module type.
     * @return  The robot module of the provided class.
     */
    public <T extends Module> T getModule(Class<T> c) {
        for (Module m : modules) {
            if (c.isInstance(m)) {
                return c.cast(m); // Avoid unsafe cast by using Class.cast()
            }
        }
        return null;
    }
}