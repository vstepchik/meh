package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.TimedLoop;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.meh.elements.PauseMessage;
import com.gmail.vitalatron.game.meh.elements.PressStartButtonMessage;
import com.gmail.vitalatron.game.meh.elements.TetraminoeDispenser;
import com.gmail.vitalatron.game.visual.GameWindow;
import com.gmail.vitalatron.game.visual.Sprite;

import java.awt.*;
import java.util.Map;

public class MehBrain {

    protected final GameWindow gameWindow;
    protected final TimedLoop gameLoop;
    protected final UserInputHandler userInputHandler;
    protected final Map<String, Image> imageMap;
    protected final TetraminoeDispenser tetraminoeDispenser;

    protected final PressStartButtonMessage pressStartButtonMessage;
    protected final PauseMessage pauseMessage;

    protected boolean paused = false;
    protected int score = 0;

    public MehBrain(GameWindow gameWindow, UserInputHandler userInputHandler, Map<String, Image> imageMap) {
        this.gameWindow = gameWindow;
        this.userInputHandler = userInputHandler;
        this.imageMap = imageMap;

        this.gameLoop = new ExecutorGameLoop();
        this.pressStartButtonMessage = new PressStartButtonMessage(117, 184);
        this.pressStartButtonMessage.setBlinking(true);
        this.pauseMessage = new PauseMessage(116, 154);
        this.pauseMessage.setVisible(paused);
        this.tetraminoeDispenser = new TetraminoeDispenser(TetraminoeLoader.loadTetraminoeDefinitions("/tetraminoes"));

        userInputHandler.addListener(new MehInputHandler(this));
        gameWindow.addDrawableItem(makeBackgroundSprite());
        gameWindow.addDrawableItem(pressStartButtonMessage);
        gameWindow.addDrawableItem(pauseMessage);
    }

    protected Sprite makeBackgroundSprite() {
        return new Sprite(imageMap.get("background"));
    }

    public void start() {

    }

    public void pause() {
        paused = !paused;
        this.pauseMessage.setVisible(paused);
    }

    public void moveBlockLeft() {

    }

    public void moveBlockRight() {

    }

    public void rotateBlock() {

    }

    public void dropBlock() {

    }

}
