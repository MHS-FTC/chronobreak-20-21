package org.macrobotics.rebot;

import org.macrobotics.rebot.module.ModuleProperties;

import java.util.EnumSet;

public abstract class Module {

    public final EnumSet<ModuleProperties> properties = EnumSet.noneOf(ModuleProperties.class);

    /**
     * Override this to update module private information.
     */
    public abstract void update();

    /**
     * Override this for stopping and shutting down module activities.
     */
    public abstract void stop();


}
