package io.exercism;

class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    public Robot(GridPosition gridPosition, Orientation orientation) {
        this.gridPosition = gridPosition;
        this.orientation = orientation;
    }

    public Object getOrientation() {
        return orientation;
    }

    public Object getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        // orientation = west
        // values = [north, east, south, west]
        Orientation[] values = Orientation.values();
        // orientation.ordinal() = 3
        // nextOrientationOrdinal = 4 (pour de vrai 0)
        int nextOrientationOrdinal = orientation.ordinal() + 1; // - 1
        // nextOrientation = east
        // pour le cas de west : 4 % 4 = 0
        Orientation nextOrientation = values[nextOrientationOrdinal % values.length];
        // orientation = east
        orientation = nextOrientation;
    }

    public void turnLeft() {
        // orientation = west
        // values = [north, east, south, west]
        Orientation[] values = Orientation.values();
        // orientation.ordinal() = 3
        // nextOrientationOrdinal = 4 (pour de vrai 0)
        int nextOrientationOrdinal = orientation.ordinal() - 1; // - 1
        // nextOrientation = east
        // pour le cas de west : 4 % 4 = 0
        Orientation nextOrientation = values[nextOrientationOrdinal % values.length];
        // orientation = east
        orientation = nextOrientation;
    }

    public void advance() {
        switch (orientation) {
            case NORTH:
                gridPosition = new GridPosition(gridPosition.x, gridPosition.y + 1);
                break;
            case EAST:
                gridPosition = new GridPosition(gridPosition.x + 1, gridPosition.y);
                break;
            case SOUTH:
                gridPosition = new GridPosition(gridPosition.x, gridPosition.y - 1);
                break;
            case WEST:
                gridPosition = new GridPosition(gridPosition.x - 1, gridPosition.y);
                break;
            default:
                throw new RuntimeException("Unknown orientation " + orientation);
        }
    }

    // RAALAL
    public void simulate(String sequence) {
        // command = 'R'
        // command = 'A'
        // command = 'A'
        // ...
        for (char command : sequence.toCharArray()) {
            switch (command) {
                case 'R':
                    turnRight();
                    break;
                case 'A':
                    advance();
                    break;
                case 'L':
                    turnLeft();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }

}

enum Orientation {

    NORTH, EAST, SOUTH, WEST

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

}