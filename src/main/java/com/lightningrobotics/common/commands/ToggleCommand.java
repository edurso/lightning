package com.lightningrobotics.common.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Toggles from one command to another
 */
public class ToggleCommand extends CommandBase {
    Command cmdA;
    Command cmdB;
    boolean toggle = true;

    public ToggleCommand(Command a, Command b) {
        cmdA = a;
        cmdB = b;
    }

    @Override
    public void initialize() {
        if (toggle) {
            cmdA.initialize();
        } else {
            cmdB.initialize();
        }
        toggle = !toggle;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}


