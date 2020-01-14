package com.thoughtworks;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

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
@Getter
class RoverState {
    private int x;
    private int y;
    private Direction direction;
}

enum Direction {
    N, E, S, W;

    public Direction getRight() {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }

    public Direction getLeft() {
        return Direction.values()[(this.ordinal() + 3) % 4];
    }
}

interface Cmd {
    RoverState execute(RoverState roverState);
}

class MoveCmd implements Cmd {

    @Override
    public RoverState execute(RoverState roverState) {
        int newX = roverState.getX();
        int newY = roverState.getY();
        Direction direction = roverState.getDirection();

        switch (direction) {
            case E: newX += 1; break;
            case N: newY += 1; break;
            case S: newY -= 1; break;
            case W: newX -= 1; break;
        }
        return new RoverState(newX, newY, direction);
    }
}

class TurnLeftCmd implements Cmd {
    @Override
    public RoverState execute(RoverState roverState) {
        return new RoverState(roverState.getX(), roverState.getY(), roverState.getDirection().getLeft());
    }
}

class TurnRightCmd implements Cmd {
    @Override
    public RoverState execute(RoverState roverState) {
        return new RoverState(roverState.getX(), roverState.getY(), roverState.getDirection().getRight());
    }
}