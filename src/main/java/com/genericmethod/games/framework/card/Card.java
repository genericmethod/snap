package com.genericmethod.games.framework.card;

import com.genericmethod.games.framework.enums.Rank;
import com.genericmethod.games.framework.enums.Suit;
import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card that = (Card) o;

        return Objects.equal(this.rank, that.rank) &&
                Objects.equal(this.suit, that.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rank, suit);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rank", rank)
                .append("suit", suit)
                .toString();
    }
}
