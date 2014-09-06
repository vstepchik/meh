package com.gmail.vitalatron.game.res;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageResourceLoader {
    public static Image loadImage(String path) {
        try {
            return ImageIO.read(ImageResourceLoader.class.getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load image \"" + path + "\"");
        }
    }
}
