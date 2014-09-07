package com.gmail.vitalatron.game.meh.elements;

import java.awt.*;

public class Tetraminoe {
    protected Block[][][] rotations;
    protected int side;
    protected int rotation = 0;
    protected Point coordinates = new Point();

    Tetraminoe(Block[][] ... rotations) {
        if (rotations.length == 0) {
            throw new IllegalArgumentException("At least one rotation must be passed");
        }
        if (rotations[0].length <= 0 || rotations[0].length != rotations[0][0].length) {
            throw new IllegalArgumentException("Tetraminoe should consist of square set of > 0 rotations");
        }
        this.rotations = rotations;
        side = rotations[0].length;
    }

    public void rotate(boolean clockwise) {
        rotation = (rotation + (clockwise ? +1 : -1)) % rotations.length;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public int getSide() {
        return side;
    }

    public Block getBlockAt(int x, int y) {
        return rotations[rotation][y][x];
    }
}
