package com.gmail.vitalatron.game.meh.elements;

import com.gmail.vitalatron.game.visual.Drawable;

import java.awt.*;

public class Well implements Drawable {
    protected final int x;
    protected final int y;
    protected final int width;
    protected final int height;
    protected final Block[][] level;
    protected final Image block;

    protected Tetraminoe tetraminoe;

    public Well(int x, int y, int width, int height, Image block) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.block = block;

        this.level = new Block[height][width];

        level[10][0] = new Block();
        level[10][2] = new Block();
        level[10][4] = new Block();
        level[10][6] = new Block();
        level[10][8] = new Block();
    }

    public void putTetramioe(Tetraminoe tm) {
        if (tm != null) {
            Point coords = new Point((width - tm.getSide()) / 2, -tm.getSide());
            tm.setCoordinates(coords);
        }

        this.tetraminoe = tm;
    }

    public boolean canTetraminoeBeMoved(int dx, int dy) {
        if (tetraminoe != null) {
            int tx = tetraminoe.getCoordinates().x + dx;
            int ty = tetraminoe.getCoordinates().y + dy;
            for (int row = tetraminoe.getSide() - 1; row >= 0; row--) {
                for (int col = 0; col < tetraminoe.getSide(); col++) {
                    int x = tx + col;
                    int y = ty + row;
                    if (tetraminoe.getBlockAt(col, row) != null
                            && (((y >= height) || (y >= 0 && level[y][x] != null)
                                || (x >= width) || (x < 0) || (y >= 0 && level[y][x] != null)
                    ))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void applyTetraminoe() {
        if (tetraminoe != null) {
            int tx = tetraminoe.getCoordinates().x;
            int ty = tetraminoe.getCoordinates().y;
            for (int row = 0; row < tetraminoe.getSide(); row++) {
                for (int col = 0; col < tetraminoe.getSide(); col++) {
                    int x = tx + col;
                    int y = ty + row;
                    if (tetraminoe.getBlockAt(col, row) != null) {
                        level[y][x] = tetraminoe.getBlockAt(col, row);
                    }
                }
            }
        }

        findAndRemoveFullRows();
    }

    protected void findAndRemoveFullRows() {
        System.out.println("looking for rows");
    }

    @Override
    public void draw(Graphics2D g) {
        int blockWidth = block.getWidth(null);
        int blockHeight = block.getHeight(null);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (level[y][x] != null) {
                    g.drawImage(block, this.x + x * blockWidth, this.y + y * blockHeight, null);
                }
            }
        }
        if (tetraminoe != null) {
            int tx = tetraminoe.getCoordinates().x;
            int ty = tetraminoe.getCoordinates().y;
            for (int row = 0; row < tetraminoe.getSide(); row++) {
                for (int col = 0; col < tetraminoe.getSide(); col++) {
                    if (tetraminoe.getBlockAt(col, row) != null
                            && (tx + col >= 0) && (tx + col < width)
                            && (ty + row >= 0) && (ty + row < height)) {
                        g.drawImage(block, this.x + (tx + col) * blockWidth, this.y + (ty + row) * blockHeight, null);
                    }
                }
            }
        }
    }
}
