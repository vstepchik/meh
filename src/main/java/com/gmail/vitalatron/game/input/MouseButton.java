package com.gmail.vitalatron.game.input;

import java.awt.event.MouseEvent;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum MouseButton {
    LEFT(MouseEvent.BUTTON1),
    RIGHT(MouseEvent.BUTTON2),
    MIDDLE(MouseEvent.BUTTON3);

    private final int code;
    private final static Map<Integer, MouseButton> codeToItemMap = new HashMap<>();
    private MouseButton(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public static MouseButton get(Integer code) {
        return codeToItemMap.get(code);
    }

    static {
        for (MouseButton btn : EnumSet.allOf(MouseButton.class)) {
            codeToItemMap.put(btn.code, btn);
        }
    }
}
