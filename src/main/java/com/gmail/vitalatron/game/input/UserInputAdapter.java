package com.gmail.vitalatron.game.input;

import java.awt.*;

public abstract class UserInputAdapter implements UserInputListener {
    @Override
    public void keyPressed(KeyboardButton button) {
        // nothing
    }

    @Override
    public void keyReleased(KeyboardButton button) {
        // nothing
    }

    @Override
    public void mouseButtonPressed(MouseButton button) {
        // nothing
    }

    @Override
    public void mouseButtonReleased(MouseButton button) {
        // nothing
    }

    @Override
    public void mouseMoved(Point from, Point to) {
        // nothing
    }

    @Override
    public void mouseWheelMoved(int amount) {
        // nothing
    }
}
