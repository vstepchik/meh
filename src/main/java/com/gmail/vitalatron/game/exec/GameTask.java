package com.gmail.vitalatron.game.exec;

public abstract class GameTask implements Runnable {

    public abstract void execute(double delta);

    @Override
    public void run() {
        this.execute(1D); // FIXME
    }
}
