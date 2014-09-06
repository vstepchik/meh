package com.gmail.vitalatron.game.meh.input;

import com.gmail.vitalatron.game.meh.core.MehBrain;

public class MoveRightAction extends Action {
    protected final MehBrain brain;

    public MoveRightAction(MehBrain brain) {
        this.brain = brain;
    }

    @Override
    public void perform() {
        System.out.println("NOT IMPLEMENTED");
    }
}
