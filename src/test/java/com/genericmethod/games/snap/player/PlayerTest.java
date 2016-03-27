package com.genericmethod.games.snap.player;

import com.genericmethod.games.snap.card.Card;
import com.genericmethod.games.snap.enums.Rank;
import com.genericmethod.games.snap.enums.Suit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testPlayerInit(){
        CardPlayer player = new CardPlayer("Matt");
        assertEquals("Matt", player.getPlayerName());
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void testAddCard(){
        CardPlayer player = new CardPlayer("Matt");
        player.addCard(new Card(Rank.ACE, Suit.CLUBS));
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void testPlayCard(){
        CardPlayer player = new CardPlayer("Matt");
        player.addCard(new Card(Rank.ACE, Suit.CLUBS));
        assertEquals(1, player.getCards().size());
        player.playCard();
        assertEquals(0, player.getCards().size());
    }

}