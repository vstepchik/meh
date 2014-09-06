package com.gmail.vitalatron.game.meh.elements;

import com.gmail.vitalatron.game.res.ImageResourceLoader;
import com.gmail.vitalatron.game.visual.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Score implements Drawable {
    protected int x;
    protected int y;
    protected boolean visible = true;

    protected int score = 0;
    protected int size = 7;
    protected Map<Integer, BufferedImage> digitSprites = new HashMap<>();

    public Score(int x, int y) {
        this.x = x;
        this.y = y;

        prepareSprites();
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    protected void prepareSprites() {
        BufferedImage digits = (BufferedImage) ImageResourceLoader.loadImage("/digits.png");
        for (int i = 0; i <= 9; i++) {
            digitSprites.put(i, digits.getSubimage(i * 4, 0, 4, 7));
        }
    }

    protected Integer[] getScoreDigits() {
        Integer[] digits = new Integer[size];
        int score = this.score;

        for (int i = 0; i < size; i++) {
            digits[size - i - 1] = score % 10;
            score /= 10;
        }

        for (int i = 0; (i < size - 1) && (digits[i] == 0); i++) {
            digits[i] = null;
        }

        return digits;
    }

    @Override
    public void draw(Graphics2D g) {
        if (!visible) {
            return;
        }

        Integer[] scoreDigite = getScoreDigits();
        for (int i = 0; i < size; i++) {
            g.drawImage(digitSprites.get(scoreDigite[i]), x + i * 5, y, null);
        }
    }
}
