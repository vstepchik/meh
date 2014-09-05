package com.gmail.vitalatron.game.visual;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class DrawableSet implements Drawable {
    private final List<Drawable> drawableItems = new ArrayList<>();

    @Override
    public void draw(Graphics2D g) {
        for (Drawable d : drawableItems) {
            d.draw(g);
        }
    }

    public void add(Drawable drawable) {
        drawableItems.add(drawable);
    }

    public void remove(Drawable drawable) {
        drawableItems.remove(drawable);
    }

    public void clear() {
        drawableItems.clear();
    }
}
