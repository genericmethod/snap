package com.genericmethod.games.framework;

import com.genericmethod.games.framework.exceptions.CardGameException;
import com.genericmethod.games.framework.player.CardPlayer;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * Implement any Card Game by extending this class
 */
public abstract class CardGame implements Playable{

    private Map<String, CardPlayer> players;
    private GameState gameState;

    protected CardGame(Map<String, CardPlayer> players) throws CardGameException {

        if (MapUtils.isEmpty(players)){
            throw new CardGameException("At least one player is required");
        }
        this.players = players;
        gameState = new GameState();
        gameState.setFinished(false);
    }

    /**
     * Use this method to perform any initial tasks related to the game being implemented,
     * such as dealing cards to the players.
     */
    protected abstract void init();

    /**
     * Use this method to implement the rules related to the game being implemented.
     * If the  player has won the game at his turn return true, otherwise return false.
     */
    protected abstract void playTurn();

    /**
     * Define any logic related to be executed before the player takes his turn
     */
    protected abstract void preTurn();

    /**
     * Define any logic related to be executed after the player takes his turn
     */
    protected abstract void postTurn();

    /**
     * Define any logic executed before the round starts
     */
    protected abstract void preRound();

    /**
     * Define any logic to be executed after the round
     */
    protected abstract void postRound();

    /**
     * Plays a round. A round consists of all the players taking their turn.
     */
    protected void playRound(){
        getPlayers().values().forEach(cardPlayer -> {
            getGameState().setCurrentPlayer(cardPlayer);
            preTurn();
            playTurn();
            postTurn();
        });
    }

    /**
     * Runs the Game.
     * After running the init method, each player takes his turn at the game.
     * The game is stopped once the game is finished.
     */
    public void play() {
        init();
        while (!getGameState().isFinished()) {
            preRound();
            playRound();
            postRound();
        }
    }

    public Map<String, CardPlayer> getPlayers() {
        return players;
    }

    /**
     * Sets the game to finished
     */
    public void setGameToFinished() {
        this.gameState.setFinished(true);
    }

    public boolean isGameFinished(){
        return gameState.isFinished();
    }

    public boolean gameIsNotFinished(){
        return !isGameFinished();
    }

    public GameState getGameState() {
        return gameState;
    }
}
