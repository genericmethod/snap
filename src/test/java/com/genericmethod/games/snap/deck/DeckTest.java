package com.genericmethod.games.snap.deck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    @Test
    public void testDeck(){
        Deck deck = new Deck();
        assertEquals(52, deck.getUnshuffledCardsCards().size());
        assertEquals(null, deck.getShuffledCards());
    }

    @Test
    public void testShuffledDeck(){
        Deck deck = new Deck();
        deck.shuffle();
        assertEquals(52, deck.getShuffledCards().size());
    }

}
