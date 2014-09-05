package com.gmail.vitalatron.game.input;

import java.awt.event.KeyEvent;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum KeyboardButton {
    A(KeyEvent.VK_A, "a"),
    B(KeyEvent.VK_B, "b"),
    C(KeyEvent.VK_C, "c"),
    D(KeyEvent.VK_D, "d"),
    E(KeyEvent.VK_E, "e"),
    F(KeyEvent.VK_F, "f"),
    G(KeyEvent.VK_G, "g"),
    H(KeyEvent.VK_H, "h"),
    I(KeyEvent.VK_I, "i"),
    J(KeyEvent.VK_J, "j"),
    K(KeyEvent.VK_K, "k"),
    L(KeyEvent.VK_L, "l"),
    M(KeyEvent.VK_M, "m"),
    N(KeyEvent.VK_N, "n"),
    O(KeyEvent.VK_O, "o"),
    P(KeyEvent.VK_P, "p"),
    Q(KeyEvent.VK_Q, "q"),
    R(KeyEvent.VK_R, "r"),
    S(KeyEvent.VK_S, "s"),
    T(KeyEvent.VK_T, "t"),
    U(KeyEvent.VK_U, "u"),
    V(KeyEvent.VK_V, "v"),
    W(KeyEvent.VK_W, "w"),
    X(KeyEvent.VK_X, "x"),
    Y(KeyEvent.VK_Y, "y"),
    Z(KeyEvent.VK_Z, "z"),
    TILDE(KeyEvent.VK_BACK_QUOTE, "~", "`"),
    TAB(KeyEvent.VK_TAB, "tab"),
    F1(KeyEvent.VK_F1, "f1"),
    F2(KeyEvent.VK_F2, "f2"),
    F3(KeyEvent.VK_F3, "f3"),
    F4(KeyEvent.VK_F4, "f4"),
    F5(KeyEvent.VK_F5, "f5"),
    F6(KeyEvent.VK_F6, "f6"),
    F7(KeyEvent.VK_F7, "f7"),
    F8(KeyEvent.VK_F8, "f8"),
    F9(KeyEvent.VK_F9, "f9"),
    F10(KeyEvent.VK_F10, "f10"),
    F11(KeyEvent.VK_F11, "f11"),
    F12(KeyEvent.VK_F12, "f12"),
    F13(KeyEvent.VK_F13, "f13"),
    F14(KeyEvent.VK_F14, "f14"),
    F15(KeyEvent.VK_F15, "f15"),
    ONE(KeyEvent.VK_1, "1", "!", "one"),
    TWO(KeyEvent.VK_2, "2", "@", "two"),
    THREE(KeyEvent.VK_3, "3", "#", "three"),
    FOUR(KeyEvent.VK_4, "4", "$", "four"),
    FIVE(KeyEvent.VK_5, "5", "%", "five"),
    SIX(KeyEvent.VK_6, "6", "^", "six"),
    SEVEN(KeyEvent.VK_7, "7", "&", "seven"),
    EIGHT(KeyEvent.VK_8, "8", "*", "eight"),
    NINE(KeyEvent.VK_9, "9", "(", "nine"),
    ZERO(KeyEvent.VK_0, "0", ")", "zero"),
    MINUS(KeyEvent.VK_MINUS, "-", "_", "minus", "dash", "underscore"),
    EQUALS_ADD(KeyEvent.VK_EQUALS, "=", "+", "plus", "equals"),
    INSERT(KeyEvent.VK_INSERT, "insert", "ins"),
    DEL(KeyEvent.VK_DELETE, "del", "delete"),
    HOME(KeyEvent.VK_HOME, "home"),
    ADD(KeyEvent.VK_ADD, "add"),
    PAGE_UP(KeyEvent.VK_PAGE_UP, "prior", "pageup"),
    PAGE_DOWN(KeyEvent.VK_PAGE_DOWN, "next", "pagedown"),
    NUM_LOCK(KeyEvent.VK_NUM_LOCK, "numlock", "numberlock"),
    SQBRACKET_LEFT(KeyEvent.VK_OPEN_BRACKET, "[", "{"),
    SQBRACKET_RIGHT(KeyEvent.VK_CLOSE_BRACKET, "]", "}"),
    SEMICOLON(KeyEvent.VK_SEMICOLON, ";", ":");

    private static final Map<Integer, KeyboardButton> codeToButtonMap = new HashMap<>();
    private static final Map<String, KeyboardButton> textToButtonMap = new LinkedHashMap<>();
    private final int code;
    private final String text;
    private final String[] lookupValues;
    static {
        for (KeyboardButton type : EnumSet.allOf(KeyboardButton.class)) {
            codeToButtonMap.put(type.code, type);
            textToButtonMap.put(type.text, type);
            for (String key : type.lookupValues) {
                textToButtonMap.put(key, type);
            }
        }
    }

    KeyboardButton(int code, String text, String ... lookupValues) {
        this.code = code;
        this.text = text;
        this.lookupValues = lookupValues;
    }

    public static KeyboardButton get(String text) {
        return textToButtonMap.get(text.toLowerCase());
    }

    public static KeyboardButton get(Integer code) {
        return codeToButtonMap.get(code);
    }

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }

}
