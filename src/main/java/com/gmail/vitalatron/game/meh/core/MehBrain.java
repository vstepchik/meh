package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.exec.ExecutorGameLoop;
import com.gmail.vitalatron.game.exec.GameTask;
import com.gmail.vitalatron.game.exec.TimedLoop;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.meh.elements.*;
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

    protected final Well well;
    protected final PressStartButtonMessage pressStartButtonMessage;
    protected final PauseMessage pauseMessage;
    protected final Score score;

    protected Tetraminoe fallingTetraminoe;
    protected boolean paused = false;
    protected boolean started = false;

    public MehBrain(GameWindow gameWindow, UserInputHandler userInputHandler, Map<String, Image> imageMap) {
        this.gameWindow = gameWindow;
        this.userInputHandler = userInputHandler;
        this.imageMap = imageMap;

        this.gameLoop = new ExecutorGameLoop();
        this.gameLoop.addTask(new GameStep());
        this.pressStartButtonMessage = new PressStartButtonMessage(117, 184);
        this.pressStartButtonMessage.setBlinking(true);
        this.pauseMessage = new PauseMessage(116, 154);
        this.pauseMessage.setVisible(paused);
        this.tetraminoeDispenser = new TetraminoeDispenser(TetraminoeLoader.loadTetraminoeDefinitions("/tetraminoes"));
        this.score = new Score(111, 18);
        this.score.setVisible(false);
        this.well = new Well(5, 5, 10, 20, imageMap.get("block"));

        userInputHandler.addListener(new MehInputHandler(this));
        gameWindow.addDrawableItem(makeBackgroundSprite());
        gameWindow.addDrawableItem(pressStartButtonMessage);
        gameWindow.addDrawableItem(pauseMessage);
        gameWindow.addDrawableItem(score);
        gameWindow.addDrawableItem(well);
    }

    protected Sprite makeBackgroundSprite() {
        return new Sprite(imageMap.get("background"));
    }

    protected void nextTetraminoe() {
        this.fallingTetraminoe = tetraminoeDispenser.next();
        this.well.putTetramioe(fallingTetraminoe);
    }

    public void start() {
        if (started) {
            return;
        }
        this.score.setScore(0);
        this.score.setVisible(true);
        this.pressStartButtonMessage.setVisible(false);
        nextTetraminoe();

        started = true;
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
        if (fallingTetraminoe != null) {
            fallingTetraminoe.rotate(true);
        }
    }

    public void descendTetraminoe() {
        if (fallingTetraminoe == null) {
            return;
        }
        if (well.canTetraminoeBeMoved(0, 1)) {
            fallingTetraminoe.getCoordinates().y++;
        } else {
            well.applyTetraminoe();
            nextTetraminoe();
        }
    }

    protected class GameStep implements GameTask {
        protected final long INITIAL_TIMEOUT = 100000;
        protected final long INITIAL_SPEED = 5000;
        protected final double SCORE_FACTOR = 0.01;

        protected long timeout = INITIAL_TIMEOUT;

        @Override
        public void execute(double delta) {
            timeout -= delta * INITIAL_SPEED;
            if (timeout < 0) {
                timeout = INITIAL_TIMEOUT - (long)(score.getScore() * SCORE_FACTOR);
                descendTetraminoe();
            }
        }
    }

}
