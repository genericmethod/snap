package com.genericmethod.games.framework;

import com.genericmethod.games.framework.player.CardPlayer;

public class GameState {

    private boolean finished;
    private CardPlayer currentPlayer;

    public CardPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(CardPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean isFinished) {
        this.finished = isFinished;
    }
}
