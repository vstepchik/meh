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

    TILDE(KeyEvent.VK_BACK_QUOTE, "~", "`"),
    MINUS(KeyEvent.VK_MINUS, "-", "_", "minus", "dash", "underscore"),
    EQUALS(KeyEvent.VK_EQUALS, "=", "equals", "+", "plus"),
    SEMICOLON(KeyEvent.VK_SEMICOLON, ";", ":"),
    QUOTE(KeyEvent.VK_QUOTE, "'", "\""),
    LESS(KeyEvent.VK_COMMA, "<", ","),
    GREATER(KeyEvent.VK_PERIOD, ">", "."),
    SLASH(KeyEvent.VK_SLASH, "/"),
    BACKSLASH(KeyEvent.VK_BACK_SLASH, "\\"),
    SQBRACKET_LEFT(KeyEvent.VK_OPEN_BRACKET, "[", "{"),
    SQBRACKET_RIGHT(KeyEvent.VK_CLOSE_BRACKET, "]", "}"),

    INSERT(KeyEvent.VK_INSERT, "insert", "ins"),
    DELETE(KeyEvent.VK_DELETE, "delete", "del"),
    HOME(KeyEvent.VK_HOME, "home"),
    END(KeyEvent.VK_END, "end"),
    PAGE_UP(KeyEvent.VK_PAGE_UP, "pageup", "pgup", "pg_up", "prior"),
    PAGE_DOWN(KeyEvent.VK_PAGE_DOWN, "pagedown", "pgdn", "pg_dn", "next"),
    PRINT_SCREEN(KeyEvent.VK_PRINTSCREEN, "printscreen", "prtsc", "prtscr", "print_screen"),
    PAUSE(KeyEvent.VK_PAUSE, "pause"),

    NUM_DIVIDE(KeyEvent.VK_DIVIDE, "num_divide", "gray_divide", "num_slash", "divide"),
    NUM_MULTIPLY(KeyEvent.VK_MULTIPLY, "num_multiply", "gray_multiply", "num_asterisk", "asterisk", "star"),
    NUM_MINUS(KeyEvent.VK_SUBTRACT, "num_minus", "gray_minus", "num_subtract", "subtract"),
    NUM_PLUS(KeyEvent.VK_ADD, "num_plus", "gray_plus", "num_add", "add"),
    NUM_1(KeyEvent.VK_NUMPAD1, "num_1", "num1"),
    NUM_2(KeyEvent.VK_NUMPAD2, "num_2", "num2"),
    NUM_3(KeyEvent.VK_NUMPAD3, "num_3", "num3"),
    NUM_4(KeyEvent.VK_NUMPAD4, "num_4", "num4"),
    NUM_5(KeyEvent.VK_NUMPAD5, "num_5", "num5"),
    NUM_6(KeyEvent.VK_NUMPAD6, "num_6", "num6"),
    NUM_7(KeyEvent.VK_NUMPAD7, "num_7", "num7"),
    NUM_8(KeyEvent.VK_NUMPAD8, "num_8", "num8"),
    NUM_9(KeyEvent.VK_NUMPAD9, "num_9", "num9"),
    NUM_0(KeyEvent.VK_NUMPAD0, "num_0", "num0"),
    NUM_DOT(KeyEvent.VK_DECIMAL, "num_dot", "num_decimal"),

    SPACE(KeyEvent.VK_SPACE, "space", "spacebar"),
    BACKSPACE(KeyEvent.VK_BACK_SPACE, "backspace"),
    TAB(KeyEvent.VK_TAB, "tab"),
    SHIFT(KeyEvent.VK_SHIFT, "shift"),
    CTRL(KeyEvent.VK_CONTROL, "ctrl", "control"),
    ALT(KeyEvent.VK_ALT, "alt"),
    ENTER(KeyEvent.VK_ENTER, "enter", "return"),
    ESC(KeyEvent.VK_ESCAPE, "esc", "escape"),

    UP(KeyEvent.VK_UP, "up", "arrow_up"),
    RIGHT(KeyEvent.VK_RIGHT, "right", "arrow_right"),
    DOWN(KeyEvent.VK_DOWN, "down", "arrow_down"),
    LEFT(KeyEvent.VK_LEFT, "left", "arrow_left"),

    NUM_LOCK(KeyEvent.VK_NUM_LOCK, "numlock", "num_lock", "numberlock"),
    SCROLL_LOCK(KeyEvent.VK_SCROLL_LOCK, "scrolllock", "scroll_lock"),
    CAPS_LOCK(KeyEvent.VK_CAPS_LOCK, "capslock", "caps_lock");

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
