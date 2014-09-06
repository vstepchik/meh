package com.gmail.vitalatron.game.meh.elements;

public class TetraminoeDefinition {
    public static final int TETRAMINOE_SIDE = 4;
    public static final int TETRAMINOE_SPACE = TETRAMINOE_SIDE * TETRAMINOE_SIDE;

    protected boolean tetraminoePattern[][] = new boolean[TETRAMINOE_SIDE][TETRAMINOE_SIDE];
    protected String stringView;

    public TetraminoeDefinition(boolean... pattern) {
        if (pattern.length != TETRAMINOE_SPACE) {
            throw new IllegalArgumentException("Tetraminoe must consist of " + TETRAMINOE_SPACE + " blocks");
        }
        int counter = 0;
        for (boolean b : pattern) {
            tetraminoePattern[counter / TETRAMINOE_SIDE][counter % TETRAMINOE_SIDE] = b;
            counter++;
        }
    }

    public Tetraminoe constructBlock() {
        return new Tetraminoe();
    }

    @Override
    public String toString() {
        if (stringView == null) {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < tetraminoePattern[0].length; y++) {
                for (int x = 0; x < tetraminoePattern.length; x++) {
                    sb.append(tetraminoePattern[y][x] ? '#' : ' ');
                }
                sb.append('\n');
            }
            stringView = sb.toString();
        }
        return stringView;
    }
}