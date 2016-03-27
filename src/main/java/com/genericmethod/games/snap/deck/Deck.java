package com.genericmethod.games.snap.deck;

import com.genericmethod.games.snap.card.Card;
import com.genericmethod.games.snap.enums.Rank;
import com.genericmethod.games.snap.enums.Suit;

import java.util.*;

/**
 * Represents a Deck of {@link Card}
 */
public class Deck {

    private List<Card> unshuffledCards;
    private Stack<Card> shuffledCards;

    public Deck() {
        //initialise a set of 52 cards
        unshuffledCards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for(Rank rank: Rank.values()){
                unshuffledCards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffle(){
        shuffledCards = new Stack<Card>();
        Collections.shuffle(unshuffledCards);
        for (Card card : unshuffledCards) {
            shuffledCards.push(card);
        }
    }

    public List<Card> getUnshuffledCardsCards() {
        return unshuffledCards;
    }

    public Stack<Card> getShuffledCards() {
        return shuffledCards;
    }
}
