package com.genericmethod.games.snap.deck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testDealCard(){
        Deck deck = new Deck();
        deck.shuffle();
        deck.dealCard();
        assertEquals(51, deck.getShuffledCards().size());
    }

    @Test
    public void testIsNotEmpty(){
        Deck deck = new Deck();
        deck.shuffle();
        deck.dealCard();
        assertTrue(deck.isNotEmpty());
    }

    @Test
    public void testIsEmpty(){
        Deck deck = new Deck();
        assertTrue(deck.isEmpty());
    }

}
