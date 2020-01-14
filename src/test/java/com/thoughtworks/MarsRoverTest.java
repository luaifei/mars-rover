package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarsRoverTest {
    @Test
    void should_create_mars_rover_given_rover_state() {
        RoverState roverState = new RoverState(0, 0, Direction.E);

        MarsRover marsRover = new MarsRover(roverState);

        assertNotNull(marsRover);
    }
}
