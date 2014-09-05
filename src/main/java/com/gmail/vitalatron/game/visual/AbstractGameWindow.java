package com.gmail.vitalatron.game.visual;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.GameTask;
import com.gmail.vitalatron.game.exec.TimedLoop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGameWindow implements GameWindow {
    protected final List<Drawable> drawableItems = new ArrayList<>();
    protected TimedLoop repaintLoop;
    protected GameTask repaintTask = GameTask.EMPTY;

    public AbstractGameWindow() {
        repaintLoop = new ExecutorGameLoop();
        repaintLoop.addTask(repaintTask);
    }

    @Override
    public void setFps(int fps) {
        repaintLoop.setIterationsPerSecond(fps);
    }

    @Override
    public void addDrawableItem(Drawable drawable) {
        drawableItems.add(drawable);
    }

    @Override
    public void removeDrawableItem(Drawable drawable) {
        drawableItems.remove(drawable);
    }

    @Override
    public void clearDrawableItems() {
        drawableItems.clear();
    }
}
