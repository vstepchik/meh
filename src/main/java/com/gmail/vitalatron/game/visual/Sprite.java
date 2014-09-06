package com.gmail.vitalatron.game.visual;

import java.awt.*;

public class Sprite implements Drawable {

    protected Image image;
    protected int x;
    protected int y;

    public Sprite(Image image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, x, y, null);
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
}
