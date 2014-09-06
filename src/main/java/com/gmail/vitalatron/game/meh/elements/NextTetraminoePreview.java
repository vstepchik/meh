package com.gmail.vitalatron.game.meh.elements;

import com.gmail.vitalatron.game.visual.Drawable;

import java.awt.*;

public class NextTetraminoePreview implements Drawable {
    protected int x;
    protected int y;
    protected boolean visible = true;
    protected Tetraminoe tetraminoe;

    protected final Image block;

    public NextTetraminoePreview(int x, int y, Image block) {
        this.x = x;
        this.y = y;
        this.block = block;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Tetraminoe getTetraminoe() {
        return tetraminoe;
    }

    public void setTetraminoe(Tetraminoe tetraminoe) {
        this.tetraminoe = tetraminoe;
    }

    @Override
    public void draw(Graphics2D g) {
        if (!visible || tetraminoe == null) {
            return;
        }

        int blockWidth = block.getWidth(null) + 1;
        int blockHeight = block.getHeight(null) + 1;
        for (int row = 0; row < tetraminoe.getSide(); row++) {
            for (int col = 0; col < tetraminoe.getSide(); col++) {
                if (tetraminoe.getBlockAt(col, row) != null) {
                    g.drawImage(block, x + col * blockWidth, y + row * blockHeight, null);
                }
            }
        }
    }
}
