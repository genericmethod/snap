package com.genericmethod.games.snap;

import com.genericmethod.games.snap.deck.Deck;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.player.Player;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SnapTest {

    @Test
    public void testSnapInit() {

        Map<String,Player> players = new HashMap<String, Player>();
        Player playerOne = new Player("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        Player playerTwo = new Player("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        Set<Deck> decks = new HashSet<Deck>();
        decks.add(new Deck());
        decks.add(new Deck());

        Snap snap = new Snap(players, decks, MatchMode.RANK);

        assertEquals(52, snap.getPlayers().get("matt").getCards().size());
        assertEquals(52, snap.getPlayers().get("chris").getCards().size());

        assertEquals(104, snap.getTotalNumberOfCards());
    }

    @Test
    public void testSnapPlay() {

        Map<String,Player> players = new HashMap<String, Player>();
        Player playerOne = new Player("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        Player playerTwo = new Player("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        Set<Deck> decks = new HashSet<Deck>();
        decks.add(new Deck());
        decks.add(new Deck());

        Snap snap = new Snap(players, decks, MatchMode.RANK);
        snap.play();

    }
}
