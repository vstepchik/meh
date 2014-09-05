package com.gmail.vitalatron.game.visual;

import java.awt.*;

public interface GameWindow {
    public void show();
    public void close();
    public void setIcon(Image icon);

    public void setFps(int fps);

    public void addDrawableItem(Drawable drawable);
    public void removeDrawableItem(Drawable drawable);
    public void clearDrawableItems();
}
