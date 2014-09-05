package com.gmail.vitalatron.game.exec;

public interface TimedLoop {
    public void addTask(GameTask task);
    public void removeTask(GameTask task);
    public void removeAllTasks();

    public void setTimeout(int milliseconds);
    public void setFps(int fps);
}
