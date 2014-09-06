package com.gmail.vitalatron.game.meh.core;

public enum MoveDirection {
    NONE(0, 0),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    public final int dx;
    public final int dy;

    MoveDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
