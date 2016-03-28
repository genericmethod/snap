package com.genericmethod.games.framework.exceptions;

public class CardGameException extends Exception {
    public CardGameException() {
    }

    public CardGameException(String message) {
        super(message);
    }

    public CardGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
