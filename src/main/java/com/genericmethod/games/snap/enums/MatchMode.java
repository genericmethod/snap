package com.genericmethod.games.snap.enums;

public enum MatchMode {

    SUIT("1"),
    RANK("2"),
    BOTH("3");

    private String code;

    MatchMode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
