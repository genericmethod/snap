package com.genericmethod.games.snap;

import com.genericmethod.games.snap.deck.Deck;
import com.genericmethod.games.snap.player.Player;

import java.util.Map;
import java.util.Set;

public class Snap {

    private Map<String, Player> players;
    private Set<Deck> decks;

    public Snap(Map<String, Player> players, Set<Deck> decks) {
        this.players = players;
        this.decks = decks;
        dealCards();
    }

    /**
     * Deals the cards to the players
     */
    private void dealCards() {

        //for each deck, deal cards to the players until the deck is empty
        for (Deck deck : decks) {
            deck.shuffle();
            while (deck.isNotEmpty())
                for (Player player : players.values()) {
                    player.addCard(deck.dealCard());
                }
        }
    }

    /**
     * Play the game
     */
    public void play() {
        for (Player player : players.values()) {

        }
    }

    public Map<String, Player> getPlayers() {
        return players;
    }
}
