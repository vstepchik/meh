package com.gmail.vitalatron.game.meh.elements;

import java.util.ArrayList;
import java.util.List;

public class TetraminoeDefinition {
    public static final int TETRAMINOE_SIDE = 4;
    public static final int TETRAMINOE_SPACE = TETRAMINOE_SIDE * TETRAMINOE_SIDE;

    protected List<boolean[][]> tetraminoeRotationPatterns = new ArrayList<>();
    protected String stringView;

    public TetraminoeDefinition(List<boolean[]> rotationPatterns) {
        if (rotationPatterns.isEmpty()) {
            throw new IllegalArgumentException("At least one pattern should be provided");
        }
        if (rotationPatterns.get(0).length != TETRAMINOE_SPACE) {
            throw new IllegalArgumentException("Tetraminoe must consist of " + TETRAMINOE_SPACE + " blocks");
        }
        for (boolean[] pattern : rotationPatterns) {
            int counter = 0;
            boolean[][] tetraminoePattern = new boolean[TETRAMINOE_SIDE][TETRAMINOE_SIDE];
            for (boolean b : pattern) {
                tetraminoePattern[counter / TETRAMINOE_SIDE][counter % TETRAMINOE_SIDE] = b;
                counter++;
            }
            tetraminoeRotationPatterns.add(tetraminoePattern);
        }
    }

    public Tetraminoe constructBlock() {
        Block[][][] rotationSet = new Block[tetraminoeRotationPatterns.size()][][];
        for (int i = 0; i < tetraminoeRotationPatterns.size(); i++) {
            boolean[][] rotationPattern = tetraminoeRotationPatterns.get(i);
            Block[][] rotPatternBlocks = new Block[TETRAMINOE_SIDE][TETRAMINOE_SIDE];
            for (int y = 0; y < TETRAMINOE_SIDE; y++) {
                for (int x = 0; x < TETRAMINOE_SIDE; x++) {
                    rotPatternBlocks[y][x] = rotationPattern[y][x] ? new Block() : null;
                }
            }
            rotationSet[i] = rotPatternBlocks;
        }

        return new Tetraminoe(rotationSet);
    }
}