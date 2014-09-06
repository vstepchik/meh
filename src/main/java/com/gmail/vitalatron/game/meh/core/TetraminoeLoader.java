package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.meh.elements.TetraminoeDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class TetraminoeLoader {
    public static final String EMPTY_SPACE_CHAR = "~";
    public static final String BLOCK_CHAR = "#";
    protected static final Pattern TETRAMINOE_SYMBOLS = Pattern.compile("[" + EMPTY_SPACE_CHAR + BLOCK_CHAR + "]");

    private TetraminoeLoader() {
        // no subclasses, no instances
    }

    public static List<TetraminoeDefinition> loadTetraminoeDefinitions(String path) {
        Scanner scanner = new Scanner(TetraminoeLoader.class.getResourceAsStream(path));
        scanner.useDelimiter("\\s*");

        List<TetraminoeDefinition> result = new ArrayList<>();

        int counter = 0;
        boolean[] pattern = new boolean[TetraminoeDefinition.TETRAMINOE_SPACE];

        while (scanner.hasNext(TETRAMINOE_SYMBOLS)) {
            String symbol = scanner.next(TETRAMINOE_SYMBOLS);
            pattern[counter] = BLOCK_CHAR.equals(symbol);

            if (++counter == pattern.length) {
                result.add(new TetraminoeDefinition(pattern));
                counter = 0;
            }
        }
        return result;
    }
}
