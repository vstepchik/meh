package com.gmail.vitalatron.game.input;

import java.awt.*;
import java.awt.event.*;

public class SwingUserInputHandler extends AbstractUserInputHandler
        implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private final Component inputSource;

    public SwingUserInputHandler(Component inputSource) {
        this.inputSource = inputSource;
        inputSource.addKeyListener(this);
        inputSource.addMouseListener(this);
        inputSource.addMouseMotionListener(this);
        inputSource.addMouseWheelListener(this);
    }

    public Component getInputSource() {
        return inputSource;
    }

    // AWT LISTENER METHODS BELOW

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        processKeyboardButtonPressed(KeyboardButton.get(e.getKeyCode()));
        e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        processKeyboardButtonReleased(KeyboardButton.get(e.getKeyCode()));
        e.consume();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
        processMouseButtonPressed(MouseButton.get(e.getButton()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        processMouseButtonReleased(MouseButton.get(e.getButton()));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // nothing
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // nothing
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        processMouseMoved(e.getPoint());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        processMouseWheelMoved(e.getWheelRotation());
    }
}
