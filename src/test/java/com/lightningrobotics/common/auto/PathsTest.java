package com.lightningrobotics.common.auto;

import org.junit.Test;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class PathsTest {

    @Test
    public void empty() {
        assertEquals((double) com.lightningrobotics.common.auto.Paths.getPaths().size(), 0d, Math.ulp(1d));
    }

    @Test
    public void addRemove() {
        com.lightningrobotics.common.auto.Paths.register("TEST",
                new com.lightningrobotics.common.auto.Path("Name", Arrays.asList(new Pose2d(0d, 0d, Rotation2d.fromDegrees(0d)),
                        new Pose2d(0.75d, 0d, Rotation2d.fromDegrees(0d)))));
        assertEquals(com.lightningrobotics.common.auto.Paths.getPath("TEST").getName(), "Name");
        assertEquals((double) com.lightningrobotics.common.auto.Paths.getPaths().size(), 1d, Math.ulp(1d));
        com.lightningrobotics.common.auto.Paths.removePath("TEST");
        assertEquals((double) com.lightningrobotics.common.auto.Paths.getPaths().size(), 0d, Math.ulp(1d));
    }

}
