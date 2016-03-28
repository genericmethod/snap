package com.genericmethod.games.snap;

import com.genericmethod.games.framework.card.Card;
import com.genericmethod.games.framework.enums.Rank;
import com.genericmethod.games.framework.enums.Suit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardPileTest {

    @Test
    public void testAdd() throws Exception {
        CardPile pile = new CardPile();
        pile.add(new Card(Rank.ACE, Suit.CLUBS));
        assertEquals(1, pile.cardCount());
    }

    @Test
    public void testClear() throws Exception {
        CardPile pile = new CardPile();
        pile.add(new Card(Rank.ACE, Suit.CLUBS));
        assertEquals(1, pile.cardCount());
        pile.clear();
        assertEquals(0, pile.cardCount());
    }

    @Test
    public void testTopCard() throws Exception {
        CardPile pile = new CardPile();
        final Card topCard = new Card(Rank.ACE, Suit.SPADES);
        pile.add(new Card(Rank.ACE, Suit.CLUBS));
        pile.add(topCard);
        assertEquals(topCard, pile.topCard());
    }

    @Test
    public void testGetCards() throws Exception {
        CardPile pile = new CardPile();
        final Card topCard = new Card(Rank.ACE, Suit.SPADES);
        pile.add(new Card(Rank.ACE, Suit.CLUBS));
        pile.add(topCard);
        assertEquals(topCard, pile.getCards().peek());
    }
}