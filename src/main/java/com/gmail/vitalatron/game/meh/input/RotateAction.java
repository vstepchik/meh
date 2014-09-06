package com.gmail.vitalatron.game.meh.input;

import com.gmail.vitalatron.game.meh.core.MehBrain;

public class RotateAction extends Action {
    protected final MehBrain brain;

    public RotateAction(MehBrain brain) {
        this.brain = brain;
    }

    @Override
    public void perform() {
        brain.rotateTeraminoe();
    }
}
