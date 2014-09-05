package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.input.SwingUserInputHandler;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.visual.GameWindow;
import com.gmail.vitalatron.game.visual.SwingGameWindow;

public class MehGame {
    protected final GameWindow gameWindow;
    protected final UserInputHandler inputHandler;

    public MehGame() {
        SwingGameWindow swingGameWindow = new SwingGameWindow();
        this.gameWindow = swingGameWindow;
        this.inputHandler = new SwingUserInputHandler(swingGameWindow.getFrame());
    }

    public void start() {
        gameWindow.show();
    }
}
