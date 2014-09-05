package com.gmail.vitalatron.game.visual;

import javax.swing.*;
import java.awt.*;

public class SwingGameWindow implements GameWindow {
    public static final Dimension DEFAULT_FRAME_SIZE = new Dimension(400, 400);
    private final JFrame frame;

    public SwingGameWindow(String title, Dimension size) {
        frame = createGameFrame(title, size);
    }

    @Override
    public void show() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    @Override
    public void close() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(false);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    protected static JFrame createGameFrame(String title, Dimension size) {
        JFrame frame = new JFrame(title);

        // position
        frame.setLocationRelativeTo(null);

        // size
        frame.setResizable(false);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);
        frame.setPreferredSize(size);

        // input handling
        frame.setFocusTraversalKeysEnabled(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        return frame;
    }
}
