package com.vti.entity;

public enum Gender {
    MALE('M'), FEMALE('F');

    private final char code;

    Gender(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Gender toGender(char code) {
        if (code == 'M' || code == 'm') {
            return MALE;
        }
        if (code == 'F' || code == 'f') {
            return FEMALE;
        }
        throw new UnsupportedOperationException("Code is unsupported!");
    }
}
