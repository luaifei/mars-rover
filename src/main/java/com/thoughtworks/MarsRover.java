package com.thoughtworks;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
public class MarsRover {
    private RoverState state;

    public RoverState execute(List<Cmd> cmdList) {
        cmdList.forEach(cmd -> state = cmd.execute(state));
        return state;
    }
}

@AllArgsConstructor
@EqualsAndHashCode
class RoverState {
    private int x;
    private int y;
    private Direction direction;

    public RoverState move() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case E: newX += 1; break;
            case N: newY += 1; break;
            case S: newY -= 1; break;
            case W: newX -= 1; break;
        }
        return new RoverState(newX, newY, direction);
    }

    public RoverState turnRight() {
        return new RoverState(x, y, direction.turnRight());
    }

    public RoverState turnLeft() {
        return new RoverState(x, y, direction.turnLeft());
    }
}

enum Direction {
    N, E, S, W;

    public Direction turnRight() {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }

    public Direction turnLeft() {
        return Direction.values()[(this.ordinal() + 3) % 4];
    }
}

interface Cmd {
    RoverState execute(RoverState roverState);
}

class MoveCmd implements Cmd {

    @Override
    public RoverState execute(RoverState roverState) {
        return roverState.move();
    }
}

class TurnLeftCmd implements Cmd {
    @Override
    public RoverState execute(RoverState roverState) {
        return roverState.turnLeft();
    }
}

class TurnRightCmd implements Cmd {
    @Override
    public RoverState execute(RoverState roverState) {
        return roverState.turnRight();
    }
}