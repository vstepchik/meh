package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.input.SwingUserInputHandler;
import com.gmail.vitalatron.game.input.UserInputHandler;
import com.gmail.vitalatron.game.res.ImageResourceLoader;
import com.gmail.vitalatron.game.visual.GameWindow;
import com.gmail.vitalatron.game.visual.SwingGameWindow;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MehGame {
    public static final String GAME_TITLE = "Meh";
    protected final GameWindow gameWindow;
    protected final UserInputHandler userInputHandler;
    protected final Map<String, Image> imageMap = new HashMap<>();

    protected MehBrain mehBrain;

    public MehGame() {
        SwingGameWindow swingGameWindow = new SwingGameWindow(GAME_TITLE, new Dimension(150, 190));
        this.gameWindow = swingGameWindow;
        this.userInputHandler = new SwingUserInputHandler(swingGameWindow.getFrame());
    }

    protected void loadResources() {
        imageMap.put("background", ImageResourceLoader.loadImage("/bg.png"));
        imageMap.put("icon", ImageResourceLoader.loadImage("/icon.png"));
        imageMap.put("block", ImageResourceLoader.loadImage("/block.png"));
        imageMap.put("block_small", ImageResourceLoader.loadImage("/block_small.png"));
        imageMap.put("digits", ImageResourceLoader.loadImage("/digits.png"));
    }

    public void start() {
        loadResources();

        gameWindow.setIcon(imageMap.get("icon"));
        mehBrain = new MehBrain(gameWindow, userInputHandler, imageMap);

        gameWindow.show();
    }
}
