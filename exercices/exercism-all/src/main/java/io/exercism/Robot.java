package io.exercism;

import java.util.Arrays;

import static io.exercism.Orientation.Direction.CLOCKWISE;
import static io.exercism.Orientation.Direction.COUNTER_CLOCKWISE;

class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    public Robot(GridPosition gridPosition, Orientation orientation) {
        this.gridPosition = gridPosition;
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        orientation = orientation.next(CLOCKWISE);
    }

    public void turnLeft() {
        orientation = orientation.next(COUNTER_CLOCKWISE);
    }

    public void advance() {
        gridPosition = new GridPosition(gridPosition.x + orientation.x, gridPosition.y + orientation.y);
    }

    public void simulate(String sequence) {
        sequence.chars().mapToObj(Command::fromInt).forEach(this::simulate);
    }

    public void simulate(Command command) {
        command.simulate(this::turnLeft, this::turnRight, this::advance);
    }

}

enum Orientation {

    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    final int x;
    final int y;

    Orientation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Orientation next(Direction direction) {
        int ordinal = Math.floorMod((this.ordinal() + direction.displacement), values().length);
        return values()[ordinal];
    }

    enum Direction {

        COUNTER_CLOCKWISE(-1),
        CLOCKWISE(1);

        private final int displacement;

        Direction(int displacement) {
            this.displacement = displacement;
        }

    }

}

enum Command {

    LEFT('L') {
        @Override
        void simulate(Runnable left, Runnable right, Runnable advance) {
            left.run();
        }
    },
    RIGHT('R') {
        @Override
        void simulate(Runnable left, Runnable right, Runnable advance) {
            right.run();
        }
    },
    ADVANCE('A') {
        @Override
        void simulate(Runnable left, Runnable right, Runnable advance) {
            advance.run();
        }
    };

    private final char command;

    Command(char command) {
        this.command = command;
    }

    static Command fromInt(int command) {
        return Arrays.stream(values())
                .filter(value -> value.command == command)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unknown command " + command));
    }

    abstract void simulate(Runnable left, Runnable right, Runnable advance);

}

class GridPosition {

    final int x;

    final int y;

    GridPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else if (x != ((GridPosition) obj).x || y != ((GridPosition) obj).y) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}