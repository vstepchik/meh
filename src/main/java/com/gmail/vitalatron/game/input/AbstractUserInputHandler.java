package com.gmail.vitalatron.game.input;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractUserInputHandler implements UserInputHandler {

    protected final List<UserInputListener> inputListenerList = new CopyOnWriteArrayList<>();
    protected final LinkedHashSet<KeyboardButton> pressedKeys = new LinkedHashSet<>();
    protected final LinkedHashSet<MouseButton> pressedMouseButtons = new LinkedHashSet<>();
    protected Point mousePosition = new Point(0, 0);
    protected Point mousePrevPosition = new Point(mousePosition);

    @Override
    public void addListener(UserInputListener listener) {
        inputListenerList.add(listener);
    }

    @Override
    public void removeListener(UserInputListener listener) {
        inputListenerList.remove(listener);
    }

    protected void processKeyboardButtonPressed(KeyboardButton btn) {
        if (pressedKeys.add(btn)) { // prevents repeated notifications while button is held
            for (UserInputListener listener : inputListenerList) {
                listener.keyPressed(btn);
            }
        }
    }

    protected void processKeyboardButtonReleased(KeyboardButton btn) {
        pressedKeys.remove(btn);
        for (UserInputListener listener : inputListenerList) {
            listener.keyReleased(btn);
        }
    }

    protected void processMouseMoved(Point position) {
        mousePrevPosition = mousePosition;
        mousePosition = position;
        for (UserInputListener listener : inputListenerList) {
            listener.mouseMoved(mousePrevPosition, mousePosition);
        }
    }

    protected void processMouseButtonPressed(MouseButton btn) {
        pressedMouseButtons.add(btn);
        for (UserInputListener listener : inputListenerList) {
            listener.mouseButtonPressed(btn);
        }
    }

    protected void processMouseButtonReleased(MouseButton btn) {
        pressedMouseButtons.remove(btn);
        for (UserInputListener listener : inputListenerList) {
            listener.mouseButtonReleased(btn);
        }
    }

    protected void processMouseWheelMoved(int amount) {
        for (UserInputListener listener : inputListenerList) {
            listener.mouseWheelMoved(amount);
        }
    }

    protected <T extends Enum<T>> T getLastInSet(LinkedHashSet<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }
        LinkedList<T> pressedButtons = new LinkedList<>(items);
        return pressedButtons.getLast();
    }

    protected <T extends Enum<T>> T getLastInSetOf(LinkedHashSet<T> items, Set<T> lookupItems) {
        if (items == null || items.isEmpty() || lookupItems == null || lookupItems.isEmpty()) {
            return null;
        }
        Iterator<T> iterator = new LinkedList<>(items).descendingIterator();
        while (iterator.hasNext()) {
            T btn = iterator.next();
            if (lookupItems.contains(btn)) {
                return btn;
            }
        }
        return null;
    }

    @Override
    public boolean isKeyDown(KeyboardButton btn) {
        return pressedKeys.contains(btn);
    }

    @Override
    public boolean isMouseButtonDown(MouseButton btn) {
        return pressedMouseButtons.contains(btn);
    }

    @Override
    public Point getMousePosition() {
        return new Point(mousePosition);
    }

    @Override
    public KeyboardButton getLastButtonPressed() {
        return getLastInSet(pressedKeys);
    }

    @Override
    public KeyboardButton getLastButtonPressedOf(EnumSet<KeyboardButton> buttons) {
        return getLastInSetOf(pressedKeys, buttons);
    }

    @Override
    public MouseButton getLastMouseButtonPressed() {
        return getLastInSet(pressedMouseButtons);
    }

    @Override
    public MouseButton getLastMouseButtonPressedOf(EnumSet<MouseButton> buttons) {
        return getLastInSetOf(pressedMouseButtons, buttons);
    }
}
