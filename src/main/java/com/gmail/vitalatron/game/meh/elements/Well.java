package com.gmail.vitalatron.game.meh.elements;

public class Well {
    protected final Block[][] level;

    public Well(int width, int height) {
        this.level = new Block[width][height];
    }
}
