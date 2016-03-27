package com.genericmethod.games.snap.exception;

public class SnapException extends Exception {

    public SnapException(String message) {
        super(message);
    }

    public SnapException(String message, Throwable cause) {
        super(message, cause);
    }
}
