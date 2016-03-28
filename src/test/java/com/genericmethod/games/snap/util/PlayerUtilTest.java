package com.genericmethod.games.snap.util;

import com.genericmethod.games.framework.player.CardPlayer;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertNotNull;

public class PlayerUtilTest {

    @Test
    public void testGetRandomPlayer() throws Exception {

        Map<String, CardPlayer> players = new HashMap<String, CardPlayer>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        final CardPlayer randomPlayer = PlayerUtil.getRandomPlayer(players);
        assertNotNull(randomPlayer);
    }
}