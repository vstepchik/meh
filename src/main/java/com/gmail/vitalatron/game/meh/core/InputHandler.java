package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.input.KeyboardButton;
import com.gmail.vitalatron.game.input.UserInputAdapter;
import com.gmail.vitalatron.game.meh.input.Action;
import com.gmail.vitalatron.game.meh.input.ExitAction;

import java.util.EnumMap;

public class InputHandler extends UserInputAdapter {
    protected final EnumMap<KeyboardButton, Action> actionMap = new EnumMap<KeyboardButton, Action>(KeyboardButton.class);

    public InputHandler() {
        actionMap.put(KeyboardButton.ESC, new ExitAction());
    }

    @Override
    public void keyPressed(KeyboardButton button) {
        Action mappedAction = actionMap.get(button);
        if (mappedAction != null) {
            mappedAction.perform();
        }
    }
}
