package com.gmail.vitalatron.game.meh.elements;

import com.gmail.vitalatron.game.res.ImageResourceLoader;
import com.gmail.vitalatron.game.visual.Sprite;

import java.awt.*;

public class PressStartButtonMessage extends Sprite {

    protected boolean visible = true;
    protected boolean blinking = false;
    protected int blinkSpeed = 1000;

    public PressStartButtonMessage(int x, int y) {
        super(ImageResourceLoader.loadImage("/press_start.png"));
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g) {
        if (!visible) {
            return;
        }
        boolean blinkOn = (System.currentTimeMillis() % (blinkSpeed * 2)) > blinkSpeed;
        if (!blinking || blinkOn) {
            super.draw(g);
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isBlinking() {
        return blinking;
    }

    public void setBlinking(boolean blinking) {
        this.blinking = blinking;
    }

    public int getBlinkSpeed() {
        return blinkSpeed;
    }

    public void setBlinkSpeed(int blinkSpeed) {
        if (blinkSpeed <= 0) {
            throw new IllegalArgumentException("Blink speed should be > 0");
        }
        this.blinkSpeed = blinkSpeed;
    }
}
