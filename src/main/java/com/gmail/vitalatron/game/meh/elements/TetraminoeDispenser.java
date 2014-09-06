package com.gmail.vitalatron.game.meh.elements;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TetraminoeDispenser {
    protected List<TetraminoeDefinition> definitionList;
    protected TetraminoeDefinition next;

    public TetraminoeDispenser(List<TetraminoeDefinition> definitions) {
        definitionList = definitions;
        next = pickRandom();
    }

    protected TetraminoeDefinition pickRandom() {
        return definitionList.get(ThreadLocalRandom.current().nextInt(definitionList.size()));
    }

    public Tetraminoe peek() {
        return next.constructBlock();
    }

    public Tetraminoe next() {
        Tetraminoe result = next.constructBlock();
        next = pickRandom();
        return result;
    }
}
