package com.gmail.vitalatron.game.meh.core;

import com.gmail.vitalatron.game.meh.elements.TetraminoeDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class TetraminoeLoader {
    public static final String EMPTY_SPACE_CHAR = "~";
    public static final String BLOCK_CHAR = "#";
    public static final Pattern TETRAMINOE_END_SEQUENCE = Pattern.compile("\\-");
    protected static final Pattern TETRAMINOE_SYMBOLS =
            Pattern.compile("[" + EMPTY_SPACE_CHAR + BLOCK_CHAR + "]");

    private TetraminoeLoader() {
        // no subclasses, no instances
    }

    public static List<TetraminoeDefinition> loadTetraminoeDefinitions(String path) {
        Scanner scanner = new Scanner(TetraminoeLoader.class.getResourceAsStream(path));
        scanner.useDelimiter("\\s*");

        List<TetraminoeDefinition> result = new ArrayList<>();
        List<boolean[]> rotationPatterns = new ArrayList<>();

        int counter = 0;
        boolean[] pattern = new boolean[TetraminoeDefinition.TETRAMINOE_SPACE];

        while (scanner.hasNext(TETRAMINOE_SYMBOLS)) {
            String symbol = scanner.next(TETRAMINOE_SYMBOLS);
            pattern[counter] = BLOCK_CHAR.equals(symbol);

            if (++counter == pattern.length) {
                boolean[] patternCopy = new boolean[pattern.length];
                System.arraycopy(pattern, 0, patternCopy, 0, pattern.length);
                rotationPatterns.add(patternCopy);
                counter = 0;
                if (scanner.hasNext(TETRAMINOE_END_SEQUENCE)) {
                    while (scanner.hasNext(TETRAMINOE_END_SEQUENCE)) {
                        scanner.next(TETRAMINOE_END_SEQUENCE);
                    }
                    result.add(new TetraminoeDefinition(new ArrayList<>(rotationPatterns)));
                    rotationPatterns.clear();
                }
            }
        }

        scanner.close();
        return result;
    }
}
