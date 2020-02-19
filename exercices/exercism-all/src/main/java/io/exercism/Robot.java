package io.exercism;

class Robot {

    public Robot(GridPosition gridPosition, Orientation orientation) {
        // TODO
    }

    public Object getOrientation() {
        // TODO
        return null;
    }

    public Object getGridPosition() {
        // TODO
        return null;
    }

    public void turnRight() {
        // TODO
    }

    public void turnLeft() {
        // TODO
    }

    public void advance() {
        // TODO
    }

    public void simulate(String sequence) {
        // TODO
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