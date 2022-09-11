package com.vti.entity;

public enum Type {
    DEVELOPER('D'), TESTER('T'), SCRUM_MASTER('S'), PROJECT_MANAGER('P');

    private final char code;

    Type(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Type toType(char code) {
        if (code == 'D' || code == 'd') {
            return DEVELOPER;
        }
        if (code == 'T' || code == 't') {
            return TESTER;
        }
        if (code == 'S' || code == 's') {
            return SCRUM_MASTER;
        }
        if (code == 'P' || code == 'p') {
            return PROJECT_MANAGER;
        }
        throw new UnsupportedOperationException("This code is unsupported!");
    }
}
