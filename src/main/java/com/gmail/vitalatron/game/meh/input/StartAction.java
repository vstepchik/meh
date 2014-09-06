package com.gmail.vitalatron.game.meh.input;

import com.gmail.vitalatron.game.meh.core.MehBrain;

public class StartAction extends Action {
    protected final MehBrain brain;

    public StartAction(MehBrain brain) {
        this.brain = brain;
    }

    @Override
    public void perform() {
        brain.start();
    }
}
