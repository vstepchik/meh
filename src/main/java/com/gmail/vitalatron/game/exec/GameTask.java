package com.gmail.vitalatron.game.exec;

public interface GameTask {

    public static GameTask EMPTY = new GameTask() {
        @Override
        public void execute(double delta) {
            // empty
        }
    };

    public abstract void execute(double delta);

}
