package com.gmail.vitalatron.game.exec;

public interface TimedLoop {
    public static final int DEFAULT_DELAY = 33; // 30 fps

    public void addTask(GameTask task);
    public void removeTask(GameTask task);
    public void removeAllTasks();

    public void setTimeout(int milliseconds);
    public void setIterationsPerSecond(int fps);

    public void setPaused(boolean paused);
    public void stop();
}
