package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.TimedLoop;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.visual.GameWindow;
import com.gmail.vitalatron.game.visual.Sprite;

import java.awt.*;
import java.util.Map;

public class MehBrain {

    protected final GameWindow gameWindow;
    protected final TimedLoop gameLoop;
    protected final UserInputHandler userInputHandler;
    protected final Map<String, Image> imageMap;

    public MehBrain(GameWindow gameWindow, UserInputHandler userInputHandler, Map<String, Image> imageMap) {
        this.gameWindow = gameWindow;
        this.userInputHandler = userInputHandler;
        this.imageMap = imageMap;

        this.gameLoop = new ExecutorGameLoop();

        userInputHandler.addListener(new MehInputHandler());
        gameWindow.addDrawableItem(makeBackgroundSprite());
    }

    protected Sprite makeBackgroundSprite() {
        return new Sprite(imageMap.get("background"));
    }
}
