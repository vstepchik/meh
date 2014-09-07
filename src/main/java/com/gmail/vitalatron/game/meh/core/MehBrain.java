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

    private static final int BASE_SCORE = 100;
    private static final int BONUS_PER_ADDITIONAL_ROW = 150;

    protected final GameWindow gameWindow;
    protected final TimedLoop gameLoop;
    protected final UserInputHandler userInputHandler;
    protected final Map<String, Image> imageMap;
    protected final TetraminoeDispenser tetraminoeDispenser;

    protected final Well well;
    protected final PressStartButtonMessage pressStartButtonMessage;
    protected final PauseMessage pauseMessage;
    protected final Score score;
    protected final NextTetraminoePreview preview;

    protected Tetraminoe fallingTetraminoe;
    protected boolean paused = false;
    protected boolean started = false;
    protected MoveDirection moveDirection = MoveDirection.NONE;

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
        this.preview = new NextTetraminoePreview(112, 40, imageMap.get("block_small"));
        this.well = new Well(5, 5, 10, 20, imageMap.get("block"), this);

        userInputHandler.addListener(new MehInputHandler(this, userInputHandler));
        gameWindow.addDrawableItem(makeBackgroundSprite());
        gameWindow.addDrawableItem(pressStartButtonMessage);
        gameWindow.addDrawableItem(pauseMessage);
        gameWindow.addDrawableItem(score);
        gameWindow.addDrawableItem(preview);
        gameWindow.addDrawableItem(well);
    }

    protected Sprite makeBackgroundSprite() {
        return new Sprite(imageMap.get("background"));
    }

    protected void nextTetraminoe() {
        this.fallingTetraminoe = tetraminoeDispenser.next();
        this.preview.setTetraminoe(tetraminoeDispenser.peek());
        this.well.putTetramioe(fallingTetraminoe);
    }

    public boolean isGameRunning() {
        return !paused && started;
    }

    public void start() {
        if (started) {
            return;
        }
        this.well.clear();
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

    public void gameOver() {
        if (!started) {
            return;
        }
        this.started = false;
        this.pressStartButtonMessage.setVisible(true);
        System.out.println("GAME OVER");
    }

    public void setMoveDirection(MoveDirection moveDirection) {
        this.moveDirection = moveDirection;
    }

    public void moveTetraminoeLeft() {
        if (fallingTetraminoe == null || !isGameRunning()) {
            return;
        }
        if (well.canTetraminoeBeMoved(-1, 0)) {
            fallingTetraminoe.getCoordinates().x--;
        }
    }

    public void moveTetraminoeRight() {
        if (fallingTetraminoe == null || !isGameRunning()) {
            return;
        }
        if (well.canTetraminoeBeMoved(1, 0)) {
            fallingTetraminoe.getCoordinates().x++;
        }
    }

    public void rotateTeraminoe() {
        if (fallingTetraminoe != null && isGameRunning()) {
            fallingTetraminoe.rotate(true);
        }
    }

    public void descendTetraminoe() {
        if (fallingTetraminoe == null || !isGameRunning()) {
            return;
        }
        if (well.canTetraminoeBeMoved(0, 1)) {
            fallingTetraminoe.getCoordinates().y++;
        } else {
            well.applyTetraminoe();
            nextTetraminoe();
        }
    }

    public void rowsFilled(int rowsFilled) {
        if (rowsFilled == 0) {
            return;
        }
        int sc = BASE_SCORE + (rowsFilled - 1) * BONUS_PER_ADDITIONAL_ROW;
        score.setScore(score.getScore() + sc);
    }

    protected class GameStep implements GameTask {
        protected final long INITIAL_TIMEOUT = 100000;
        protected final long INITIAL_SPEED = 5000;
        protected final double SCORE_FACTOR = 2.5;

        protected long timeout = INITIAL_TIMEOUT;

        @Override
        public void execute(double delta) {
            if (!isGameRunning()) {
                return;
            }

            timeout -= delta * INITIAL_SPEED;
            if (timeout < 0) {
                timeout = INITIAL_TIMEOUT - (long)(score.getScore() * SCORE_FACTOR);
                descendTetraminoe();
            }

            switch (moveDirection) {
                case DOWN:
                    descendTetraminoe();
                    break;
                case LEFT:
                    moveTetraminoeLeft();
                    break;
                case RIGHT:
                    moveTetraminoeRight();
                    break;
            }
        }
    }

}
