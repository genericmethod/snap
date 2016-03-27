package com.genericmethod.games.snap;

import com.genericmethod.games.snap.player.CardPlayer;

import java.util.Map;

public abstract class CardGame {

    private Map<String, CardPlayer> players;
    private boolean gameIsFinished;

    protected CardGame(Map<String, CardPlayer> players) {
        this.players = players;
        this.gameIsFinished = false;
    }

    public void play() {
        init();
        while (gameIsNotFinished()) {
            for (CardPlayer player : getPlayers().values()) {
                executePlayerTurn(player);
            }
        }
    }

    protected abstract void init();
    protected abstract boolean executePlayerTurn(CardPlayer player);

    public Map<String, CardPlayer> getPlayers() {
        return players;
    }

    public boolean isGameIsFinished() {
        return gameIsFinished;
    }

    public boolean gameIsNotFinished() {
        return gameIsFinished;
    }

    public void setGameIsFinished(boolean gameIsFinished) {
        this.gameIsFinished = gameIsFinished;
    }
}
