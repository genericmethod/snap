package com.genericmethod.games.framework.card;

import com.genericmethod.games.framework.enums.Rank;
import com.genericmethod.games.framework.enums.Suit;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {

    @Test
    public void testEquals() throws Exception {
        assertTrue(new Card(Rank.ACE, Suit.CLUBS).equals(new Card(Rank.ACE, Suit.CLUBS)));
        assertFalse(new Card(Rank.EIGHT, Suit.CLUBS).equals(new Card(Rank.ACE, Suit.CLUBS)));
    }
}