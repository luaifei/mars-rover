package com.thoughtworks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarsRoverTest {
    @Test
    void should_create_mars_rover_given_rover_state() {
        RoverState roverState = new RoverState(0, 0, Direction.E);
        MarsRover marsRover = new MarsRover(roverState);
        assertNotNull(marsRover);
    }

    @Test
    void should_return_E_when_turn_right_given_direction_is_N() {
        Direction start = Direction.N;
        Direction end = start.getRight();
        assertEquals(Direction.E, end);
    }

    @Test
    void should_return_S_when_turn_right_given_direction_is_E() {
        Direction start = Direction.E;
        Direction end = start.getRight();
        assertEquals(Direction.S, end);
    }

    @Test
    void should_return_W_when_turn_right_given_direction_is_S() {
        Direction start = Direction.S;
        Direction end = start.getRight();
        assertEquals(Direction.W, end);
    }

    @Test
    void should_return_N_when_turn_right_given_direction_is_W() {
        Direction start = Direction.W;
        Direction end = start.getRight();
        assertEquals(Direction.N, end);
    }

    @Test
    void should_return_W_when_turn_left_given_direction_is_N() {
        Direction start = Direction.N;
        Direction end = start.getLeft();
        assertEquals(Direction.W, end);
    }

    @Test
    void should_return_S_when_turn_left_given_direction_is_W() {
        Direction start = Direction.W;
        Direction end = start.getLeft();
        assertEquals(Direction.S, end);
    }

    @Test
    void should_return_E_when_turn_left_given_direction_is_S() {
        Direction start = Direction.S;
        Direction end = start.getLeft();
        assertEquals(Direction.E, end);
    }

    @Test
    void should_return_N_when_turn_left_given_direction_is_E() {
        Direction start = Direction.E;
        Direction end = start.getLeft();
        assertEquals(Direction.N, end);
    }

    @Test
    void should_x_increase_when_mars_rover_execute_move_cmd_given_direction_is_E() {
        RoverState start = new RoverState(0, 0, Direction.E);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Collections.singletonList(new MoveCmd()));
        assertEquals(new RoverState(1, 0, Direction.E), end);
    }

    @Test
    void should_x_decrease_when_mars_rover_execute_move_cmd_given_direction_is_W() {
        RoverState start = new RoverState(0, 0, Direction.W);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Collections.singletonList(new MoveCmd()));
        assertEquals(new RoverState(-1, 0, Direction.W), end);
    }

    @Test
    void should_y_increase_when_mars_rover_execute_move_cmd_given_direction_is_N() {
        RoverState start = new RoverState(0, 0, Direction.N);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Collections.singletonList(new MoveCmd()));
        assertEquals(new RoverState(0, 1, Direction.N), end);
    }

    @Test
    void should_y_decrease_when_mars_rover_execute_move_cmd_given_direction_is_S() {
        RoverState start = new RoverState(0, 0, Direction.S);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Collections.singletonList(new MoveCmd()));
        assertEquals(new RoverState(0, -1, Direction.S), end);
    }

    @Test
    void should_direction_is_E_when_mars_rover_execute_turn_right_cmd_given_direction_is_N() {
        RoverState start = new RoverState(0, 0, Direction.N);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Collections.singletonList(new TurnRightCmd()));
        assertEquals(new RoverState(0, 0, Direction.E), end);
    }

    @Test
    void should_direction_is_W_when_mars_rover_execute_turn_left_cmd_given_direction_is_N() {
        RoverState start = new RoverState(0, 0, Direction.N);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Collections.singletonList(new TurnLeftCmd()));
        assertEquals(new RoverState(0, 0, Direction.W), end);
    }

    @Test
    void should_direction_is_W_and_x_decrease_1_when_mars_rover_execute_turn_left_and_move_cmd_given_direction_is_N() {
        RoverState start = new RoverState(0, 0, Direction.N);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Arrays.asList(new TurnLeftCmd(), new MoveCmd()));
        assertEquals(new RoverState(-1, 0, Direction.W), end);
    }

    @Test
    void should_direction_is_E_and_x_increase_1_when_mars_rover_execute_turn_right_and_move_cmd_given_direction_is_N() {
        RoverState start = new RoverState(0, 0, Direction.N);
        MarsRover marsRover = new MarsRover(start);
        RoverState end = marsRover.execute(Arrays.asList(new TurnRightCmd(), new MoveCmd()));
        assertEquals(new RoverState(1, 0, Direction.E), end);
    }
}
