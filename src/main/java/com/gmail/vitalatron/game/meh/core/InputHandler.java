package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.input.KeyboardButton;
import com.gmail.vitalatron.game.input.UserInputAdapter;

public class InputHandler extends UserInputAdapter {

    @Override
    public void keyReleased(KeyboardButton button) {
        System.out.println(button);
    }
}
