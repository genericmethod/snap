package com.genericmethod.games.snap.card;

import com.genericmethod.games.snap.enums.Rank;
import com.genericmethod.games.snap.enums.Suit;

/**
 * Represents a Card within a deck of cards.
 * Each card consists of a {@link Rank} and a {@link Suit}
 */
public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
