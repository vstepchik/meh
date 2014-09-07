package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.input.KeyboardButton;
import com.gmail.vitalatron.game.input.UserInputAdapter;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.meh.input.*;

import java.util.EnumMap;
import java.util.EnumSet;

import static com.gmail.vitalatron.game.input.KeyboardButton.*;

public class MehInputHandler extends UserInputAdapter {
    protected final MehBrain brain;
    protected final EnumMap<KeyboardButton, Action> actionMap = new EnumMap<>(KeyboardButton.class);
    protected final UserInputHandler handler;

    public MehInputHandler(MehBrain brain, UserInputHandler handler) {
        this.brain = brain;
        this.handler = handler;

        Action exit = new ExitAction();
        Action pause = new PauseAction(brain);
        Action start = new StartAction(brain);
        Action rotate = new RotateAction(brain);

        actionMap.put(ESC, exit);
        actionMap.put(Q, exit);
        actionMap.put(P, pause);
        actionMap.put(PAUSE, pause);
        actionMap.put(ENTER, start);
        actionMap.put(SPACE, start);

        actionMap.put(UP, rotate);
        actionMap.put(W, rotate);
    }

    @Override
    public void keyPressed(KeyboardButton button) {
        Action mappedAction = actionMap.get(button);
        if (mappedAction != null) {
            mappedAction.perform();
        }
        notifyBrainDirection();
    }

    @Override
    public void keyReleased(KeyboardButton button) {
        notifyBrainDirection();
    }

    protected void notifyBrainDirection() {
        KeyboardButton button = handler.getLastButtonPressedOf(EnumSet.of(LEFT, DOWN, RIGHT, S, A, D));

        MoveDirection direction = MoveDirection.NONE;
        if (button != null) {
            switch (button) {
                case DOWN:
                case S:
                    direction = MoveDirection.DOWN;
                    break;
                case RIGHT:
                case D:
                    direction = MoveDirection.RIGHT;
                    break;
                case LEFT:
                case A:
                    direction = MoveDirection.LEFT;
                    break;
            }
        }

        brain.setMoveDirection(direction);
    }
}
