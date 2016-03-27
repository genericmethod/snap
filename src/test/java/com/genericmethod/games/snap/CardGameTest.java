package com.genericmethod.games.snap;

import com.genericmethod.games.snap.player.CardPlayer;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardGameTest {

    @Test
    public void testInit() throws Exception {

    }

    @Test
    public void testExecutePlayerTurn() throws Exception {

    }

    @Test
    public void testPlay() throws Exception {

    }

    @Test
    public void testGetPlayers() throws Exception {
        Map<String, CardPlayer> players = new HashMap<String, CardPlayer>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        SampleCardGame sampleCardGame = new SampleCardGame(players);

        assertEquals(2, sampleCardGame.getPlayers().size());
    }

    @Test
    public void testIsGameFinished() throws Exception {
        Map<String, CardPlayer> players = new HashMap<String, CardPlayer>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        SampleCardGame sampleCardGame = new SampleCardGame(players);
        assertFalse(sampleCardGame.isGameFinished());
    }

    @Test
    public void testGameIsNotFinished() throws Exception {
        Map<String, CardPlayer> players = new HashMap<String, CardPlayer>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        SampleCardGame sampleCardGame = new SampleCardGame(players);
        assertTrue(sampleCardGame.gameIsNotFinished());
    }

    @Test
    public void testSetGameToFinished() throws Exception {
        Map<String, CardPlayer> players = new HashMap<String, CardPlayer>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        SampleCardGame sampleCardGame = new SampleCardGame(players);
        sampleCardGame.setGameToFinished();

        assertFalse(sampleCardGame.gameIsNotFinished());
        assertTrue(sampleCardGame.isGameFinished());
    }
}