package com.lightningrobotics.common.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.lightningrobotics.common.logging.CommandLogger;

/**
 * A command that writes to {@link com.lightningrobotics.common.logging.CommandLogger CommandLogger} during execution.
 */
public abstract class LoggedCommand extends CommandBase {
    protected CommandLogger logger = new CommandLogger(getClass().getSimpleName());

    @Override
    public void initialize() {
        logger.reset();
    }

    @Override
    public void execute() {
        logger.write();
    }

    @Override
    public void end(boolean interrupted) {
        logger.drain();
        logger.flush();
    }
}
