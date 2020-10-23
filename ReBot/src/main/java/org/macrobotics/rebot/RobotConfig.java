package org.macrobotics.rebot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.rebot.module.ModuleProperties;

import java.util.ArrayList;

public abstract class RobotConfig {

    private ArrayList<Module> modules = new ArrayList<>();

    /**
     * Override this to initialize the robot and add modules.
     * The only time this should be called is on robot initialization, it's probably going to break
     * stuff if you call it anywhere else.
     *
     * @param hwMap Robot hardware map for initialization.
     */
    public abstract void init(HardwareMap hwMap);

    /**
     * Adds a module to the robot.
     *
     * @param m The module to add.
     */
    protected void addModule(Module m) {
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

    /**
     * Updates module data.
     * Call every loop to signal module updates - sensors, motors, etc.
     */
    public void update() {
        for (Module m : modules) {
            if (m.properties.contains(ModuleProperties.NEEDS_UPDATE)){
                m.update();
            }
        }
    }

    /**
     * Stops all modules.
     * Should stop everything the robot is doing - if something keeps going, it's that module's
     * fault.
     */
    public void stop() {
        for (Module m : modules) {
            m.stop();
        }
    }
}