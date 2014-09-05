package com.gmail.vitalatron.game.visual;

import com.gmail.vitalatron.game.exec.GameTask;

import javax.swing.*;
import java.awt.*;

public class SwingGameWindow extends AbstractGameWindow {
    public static final Dimension DEFAULT_FRAME_SIZE = new Dimension(400, 400);
    private final JFrame frame;

    public SwingGameWindow(String title) {
        this(title, DEFAULT_FRAME_SIZE);
    }

    public SwingGameWindow(String title, Dimension size) {
        final Canvas canvas = new Canvas();
        frame = createGameFrame(title, size, canvas);

        repaintTask = new GameTask() {
            private Canvas c = canvas;

            @Override
            public void execute(double delta) {
                Graphics2D g = (Graphics2D) c.getGraphics();
                for (Drawable item : drawableItems) {
                    item.draw(g);
                }
            }
        };
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


    @Override
    public void setIcon(Image icon) {
        frame.setIconImage(icon);
    }

    public JFrame getFrame() {
        return frame;
    }

    protected static JFrame createGameFrame(String title, Dimension size, Component screenComponent) {
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
        screenComponent.setFocusable(false);

        // placing components
        frame.getContentPane().add(screenComponent);

        return frame;
    }
}
