package com.genericmethod.games.snap;

import com.genericmethod.games.framework.deck.Deck;
import com.genericmethod.games.framework.exceptions.CardGameException;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.exception.SnapException;
import com.genericmethod.games.framework.player.CardPlayer;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SnapTest {

    @Test
    public void testSnapInit() throws SnapException, CardGameException {

        Map<String, CardPlayer> players = new HashMap<>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        Set<Deck> decks = new HashSet<Deck>();
        decks.add(new Deck());
        decks.add(new Deck());

        Snap snap = new Snap(players, decks, MatchMode.RANK);
        snap.dealCards();

        assertEquals(52, snap.getPlayers().get("matt").getCards().size());
        assertEquals(52, snap.getPlayers().get("chris").getCards().size());

        assertEquals(104, snap.getTotalNumberOfCards());
    }

    @Test(expected = SnapException.class)
    public void testSnapOnePlayer() throws SnapException, CardGameException {

        Map<String,CardPlayer> players = new HashMap<>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);

        Set<Deck> decks = new HashSet<>();
        decks.add(new Deck());
        decks.add(new Deck());

        Snap snap = new Snap(players, decks, MatchMode.RANK);
    }

    @Test(expected = CardGameException.class)
    public void testSnapInitNoPlayers() throws SnapException, CardGameException {

        Set<Deck> decks = new HashSet<>();
        decks.add(new Deck());
        decks.add(new Deck());

        Snap snap = new Snap(null, decks, MatchMode.RANK);
    }

    @Test(expected = SnapException.class)
    public void testSnapInitNoDecks() throws SnapException, CardGameException {

        Map<String,CardPlayer> players = new HashMap<String, CardPlayer>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        Snap snap = new Snap(players, null, MatchMode.RANK);


    }

    @Test(expected = SnapException.class)
    public void testSnapInitNoMatchMode() throws SnapException, CardGameException {

        Map<String,CardPlayer> players = new HashMap<>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        Set<Deck> decks = new HashSet<>();
        decks.add(new Deck());
        decks.add(new Deck());

        Snap snap = new Snap(players, decks, null);
    }

    @Test
    public void testSnapPlay() throws SnapException, CardGameException {

        Map<String,CardPlayer> players = new HashMap<>();
        CardPlayer playerOne = new CardPlayer("matt");
        players.put(playerOne.getPlayerName(), playerOne);
        CardPlayer playerTwo = new CardPlayer("chris");
        players.put(playerTwo.getPlayerName(), playerTwo);

        Set<Deck> decks = new HashSet<>();
        decks.add(new Deck());
        decks.add(new Deck());

        Snap snap = new Snap(players, decks, MatchMode.RANK);
        snap.play();
    }
}
