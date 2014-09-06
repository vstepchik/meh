package com.gmail.vitalatron.game.meh.elements;

import java.awt.*;

public class Tetraminoe {
    protected Block[][] blocks;
    protected int side;
    protected Point coordinates = new Point();

    Tetraminoe(Block[][] blocks) {
        if (blocks.length <= 0 || blocks.length != blocks[0].length) {
            throw new IllegalArgumentException("Tetraminoe should consist of square set of > 0 blocks");
        }
        this.blocks = blocks;
        side = blocks.length;
    }

    public void rotate(boolean clockwise) {
        transpose();
        if (clockwise) {
            reverseRows();
        } else {
            reverseCols();
        }
    }

    protected void transpose() {
        for (int y = 0; y < side - 1; y++) {
            for (int x = y + 1; x < side; x++) {
                Block t = blocks[x][y];
                blocks[x][y] = blocks[y][x];
                blocks[y][x] = t;
            }
        }
    }

    protected void reverseCols() {
        for (int y = 0; y < side / 2; y++) {
            for (int x = 0; x < side; x++) {
                Block t = blocks[side - y][x];
                blocks[side - y][x] = blocks[y][x];
                blocks[y][x] = t;
            }
        }
    }

    protected void reverseRows() {
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side / 2; x++) {
                Block t = blocks[y][side - x];
                blocks[y][side - x] = blocks[y][x];
                blocks[y][x] = t;
            }
        }
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
        return blocks[y][x];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                sb.append(blocks[y][x] != null ? '#' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
