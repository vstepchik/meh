package com.gmail.vitalatron.game.meh.input;

import com.gmail.vitalatron.game.meh.core.MehBrain;

public class PauseAction extends Action {
    protected final MehBrain brain;

    public PauseAction(MehBrain brain) {
        this.brain = brain;
    }

    @Override
    public void perform() {
        brain.pause();
    }
}
