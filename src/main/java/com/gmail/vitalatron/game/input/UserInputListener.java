package com.gmail.vitalatron.game.input;

import java.awt.*;

public interface UserInputListener {

    public void keyPressed(KeyboardButton button);
    public void keyReleased(KeyboardButton button);
    public void mouseButtonPressed(MouseButton button);
    public void mouseButtonReleased(MouseButton button);
    public void mouseMoved(Point from, Point to);
    public void mouseWheelMoved(int amount);
}
