package com.genericmethod.games.snap.util;

import com.genericmethod.games.snap.card.Card;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.enums.Rank;
import com.genericmethod.games.snap.enums.Suit;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SnapUtilTest {

    @Test
    public void testCheckSnapWithMatchingRank(){
        assertTrue(SnapUtil.isSnap(MatchMode.RANK, new Card(Rank.ACE, Suit.DIAMONDS), new Card(Rank.ACE, Suit.SPADES)));
        assertFalse(SnapUtil.isSnap(MatchMode.RANK, new Card(Rank.ACE, Suit.SPADES), new Card(Rank.FIVE, Suit.SPADES)));
    }

    @Test
    public void testCheckSnapWithMatchingSuit(){
        assertTrue(SnapUtil.isSnap(MatchMode.SUIT, new Card(Rank.ACE, Suit.SPADES), new Card(Rank.FIVE, Suit.SPADES)));
        assertFalse(SnapUtil.isSnap(MatchMode.SUIT, new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.FIVE, Suit.SPADES)));
    }

    @Test
    public void testCheckSnapWithMatchingCard(){
        assertTrue(SnapUtil.isSnap(MatchMode.BOTH, new Card(Rank.ACE, Suit.SPADES), new Card(Rank.ACE, Suit.SPADES)));
        assertFalse(SnapUtil.isSnap(MatchMode.BOTH, new Card(Rank.ACE, Suit.SPADES), new Card(Rank.FIVE, Suit.SPADES)));
    }

}