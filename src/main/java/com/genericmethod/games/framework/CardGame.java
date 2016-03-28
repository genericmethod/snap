package com.genericmethod.games.framework;

import com.genericmethod.games.framework.player.CardPlayer;

import java.util.Map;

/**
 * Implement any Card Game by extending this class
 */
public abstract class CardGame {

    private Map<String, CardPlayer> players;
    private boolean gameIsFinished;

    protected CardGame(Map<String, CardPlayer> players) {
        this.players = players;
        this.gameIsFinished = false;
    }

    /**
     * Use this method to perform any initial tasks related to the game being implemented,
     * such as dealing cards to the players.
     */
    protected abstract void init();

    /**
     * Use this method to implement the rules related to the game being implemented.
     * If the  player has won the game at his turn return true, otherwise return false.
     * @param player The player that is currently playing his turn.
     * @return True if the player has won the game at his turn
     */
    protected abstract boolean executePlayerTurn(CardPlayer player);

    /**
     * Runs the Game.
     * After running the init method, each player takes his turn at the game.
     * The game is stopped one the game is finished.
     */
    public void play() {
        init();
        System.out.println("Gameplay started!");
        while (gameIsNotFinished()) {
            for (CardPlayer player : getPlayers().values()) {
                executePlayerTurn(player);
            }
        }
    }

    public Map<String, CardPlayer> getPlayers() {
        return players;
    }

    /**
     * Returns true if the game has ended,
     * otherwise returns false.
     * @return true or false
     */
    public boolean isGameFinished() {
        return gameIsFinished;
    }

    /**
     * Returns true if the game is still in play,
     * otherwise returns false.
     * @return true or false
     */
    public boolean gameIsNotFinished() {
        return !isGameFinished();
    }

    /**
     * Sets the game to finished
     */
    public void setGameToFinished() {
        this.gameIsFinished = true;
    }
}
