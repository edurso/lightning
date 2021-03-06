package com.lightningrobotics.common.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj2.command.Command;
import com.lightningrobotics.common.subsystems.LightningDrivetrain;

/**
 * List of {@link com.lightningrobotics.common.auto.Path} objects a robot is configured to follow.
 */
public class Paths {

    /**
     * Map of path objects with the key corresponding to the name of the path.
     */
    private static Map<String, Path> paths = new HashMap<>();

    /**
     * Gets the map of {@link com.lightningrobotics.common.auto.Path} objects.
     * @return Map of path objects
     */
    public static Map<String, Path> getPaths() { return paths; }

    /**
     * Adds a {@link com.lightningrobotics.common.auto.Path} to the list of paths.
     * @param name Name of path to be added.
     * @param path {@link com.lightningrobotics.common.auto.Path} to be added.
     */
    public static void register(String name, Path path) {
        paths.put(name, path);
    }

    /**
     * Adds a {@link com.lightningrobotics.common.auto.Path} to the list of paths.
     * @param path {@link com.lightningrobotics.common.auto.Path} to be added.
     */
    public static void register(Path path) {
        register(path.getName(), path);
    }

    /**
     * Returns the {@link com.lightningrobotics.common.auto.Path} with the specified name
     * @param name Name of path to be retrieved.
     * @return {@link com.lightningrobotics.common.auto.Path} with given name.
     */
    public static Path getPath(String name) {
        return paths.get(name);
    }

    /**
     * Removes the {@link com.lightningrobotics.common.auto.Path} with the specified name
     * @param name Name of path to be removed.
     * @return {@link com.lightningrobotics.common.auto.Path} that was just removed.
     */
    public static Path removePath(String name) {
        return paths.remove(name);
    }

    /**
     * Retrieves the list of {@link edu.wpi.first.wpilibj2.command.RamseteCommand} objects, one
     * for each {@link com.lightningrobotics.common.auto.Path} registered.
     * @param drivetrain Drivetrain for which to create the {@link edu.wpi.first.wpilibj2.command.RamseteCommand} objects.
     * @return A map of all the {@link edu.wpi.first.wpilibj2.command.RamseteCommand} objects.
     */
    public static Map<String, Command> getPathCommands(LightningDrivetrain drivetrain) {
        Map<String, Command> cmds = new HashMap<>();
        List<String> keys = new ArrayList<>(getPaths().keySet());
        for(int i = 0 ; i < getPaths().size() ; ++i) {
            String name = keys.get(i);
            Command cmd = getPathCommand(drivetrain, name);
            cmds.put(name, cmd);
        }
        return cmds;
    }

    /**
     * Retrieves the {@link edu.wpi.first.wpilibj2.command.RamseteCommand} object
     * for the {@link com.lightningrobotics.common.auto.Path} registered.
     * @param drivetrain Drivetrain for which to create the {@link edu.wpi.first.wpilibj2.command.RamseteCommand} object.
     * @param name The name of the {@link com.lightningrobotics.common.auto.Path} to get.
     * @return The {@link edu.wpi.first.wpilibj2.command.RamseteCommand} object.
     */
    public static Command getPathCommand(LightningDrivetrain drivetrain, String name) {
        return getPaths().get(name).getCommand(drivetrain);
    }

}