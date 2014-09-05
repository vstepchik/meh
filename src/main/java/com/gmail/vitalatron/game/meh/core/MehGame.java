package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.TimedLoop;
import com.gmail.vitalatron.game.input.SwingUserInputHandler;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.visual.GameWindow;
import com.gmail.vitalatron.game.visual.SwingGameWindow;

import java.awt.*;

public class MehGame {
    public static final String GAME_TITLE = "Meh";
    protected final GameWindow gameWindow;
    protected final UserInputHandler userInputHandler;
    protected final TimedLoop gameLoop;

    protected final InputHandler inputListener;

    public MehGame() {
        SwingGameWindow swingGameWindow = new SwingGameWindow(GAME_TITLE, new Dimension(200, 300));
        this.gameWindow = swingGameWindow;
        this.userInputHandler = new SwingUserInputHandler(swingGameWindow.getFrame());
        this.gameLoop = new ExecutorGameLoop();
        this.inputListener = new InputHandler();

        this.userInputHandler.addListener(inputListener);
    }

    public void start() {
        gameWindow.show();
    }
}
