package com.gmail.vitalatron.game.visual;

import javax.swing.*;
import java.awt.*;

public class SwingGameWindow implements GameWindow {
    protected static final String FRAME_TITLE = "Meh";
    protected static final Dimension FRAME_SIZE = new Dimension(200, 300);
    private final JFrame frame;

    public SwingGameWindow() {
        frame = createGameFrame(FRAME_TITLE, FRAME_SIZE);
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

        // TODO: add input listener

        return frame;
    }
}
