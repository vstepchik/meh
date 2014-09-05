package com.gmail.vitalatron.game.input;

import java.awt.*;
import java.util.EnumSet;

public interface UserInputHandler {

    public void addListener(UserInputListener listener);
    public void removeListener(UserInputListener listener);

    public boolean isKeyDown(KeyboardButton btn);
    public KeyboardButton getLastButtonPressed();
    public KeyboardButton getLastButtonPressedOf(EnumSet<KeyboardButton> buttons);

    public boolean isMouseButtonDown(MouseButton btn);
    public MouseButton getLastMouseButtonPressed();
    public MouseButton getLastMouseButtonPressedOf(EnumSet<MouseButton> buttons);
    public Point getMousePosition();
}
