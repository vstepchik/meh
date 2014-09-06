package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.input.KeyboardButton;
import com.gmail.vitalatron.game.input.UserInputAdapter;
import com.gmail.vitalatron.game.meh.input.*;

import java.util.EnumMap;

public class MehInputHandler extends UserInputAdapter {
    protected final MehBrain brain;
    protected final EnumMap<KeyboardButton, Action> actionMap = new EnumMap<KeyboardButton, Action>(KeyboardButton.class);

    public MehInputHandler(MehBrain brain) {
        this.brain = brain;

        Action exit = new ExitAction();
        Action pause = new PauseAction(brain);
        Action start = new StartAction(brain);
        Action moveLeft = new MoveLeftAction(brain);
        Action moveRight = new MoveRightAction(brain);
        Action drop = new DropAction(brain);
        Action rotate = new RotateAction(brain);

        actionMap.put(KeyboardButton.ESC, exit);
        actionMap.put(KeyboardButton.P, pause);
        actionMap.put(KeyboardButton.PAUSE, pause);
        actionMap.put(KeyboardButton.ENTER, start);
        actionMap.put(KeyboardButton.SPACE, start);

        actionMap.put(KeyboardButton.LEFT, moveLeft);
        actionMap.put(KeyboardButton.A, moveLeft);
        actionMap.put(KeyboardButton.RIGHT, moveRight);
        actionMap.put(KeyboardButton.D, moveRight);
        actionMap.put(KeyboardButton.UP, rotate);
        actionMap.put(KeyboardButton.W, rotate);
        actionMap.put(KeyboardButton.DOWN, drop);
        actionMap.put(KeyboardButton.S, drop);
    }

    @Override
    public void keyPressed(KeyboardButton button) {
        Action mappedAction = actionMap.get(button);
        if (mappedAction != null) {
            mappedAction.perform();
        }
    }
}
