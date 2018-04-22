package ru.md.actors.hexagon;

/**
 * Created by Vladimir on 29.11.2017.
 */
public enum Direction {
    Up(0, 1),
    Down(0, -1),
    LeftUp(-1, 1),
    LeftDown(-1, -1),
    RightUp(1, 1),
    RightDown(1, -1),
    Stable(0, 0);

    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNum() throws Exception {
        return this.ordinal();
    }

    public Direction getFromNum(int num) throws Exception {
        if (num < Direction.values().length)
            return Direction.values()[num];
        throw new Exception("Unrexpected Direction.class number: " + num);
    }
}
