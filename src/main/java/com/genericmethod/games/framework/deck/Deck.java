package com.genericmethod.games.framework.deck;

import com.genericmethod.games.framework.card.Card;
import com.genericmethod.games.framework.enums.Rank;
import com.genericmethod.games.framework.enums.Suit;

import java.util.*;

/**
 * Represents a Deck of {@link Card}
 */
public class Deck {

    private List<Card> unshuffledCards;
    private Stack<Card> shuffledCards;

    /**
     * Initialises a deck of cards
     */
    public Deck() {
        //initialise a set of 52 cards
        unshuffledCards = new ArrayList<Card>();
        shuffledCards = new Stack<Card>();
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

    /**
     * Returns a card from the top of the stack of cards
     * @return {@link Card}
     */
    public Card dealCard(){
        return shuffledCards.pop();
    }

    /**
     * Return the cards in the unshuffled state.
     * @return
     */
    public List<Card> getUnshuffledCards() {
        return unshuffledCards;
    }

    /**
     * Return the cards in the shuffled state.
     * @return {@link Stack} of {@link Card} objects
     */
    public Stack<Card> getShuffledCards() {
        return shuffledCards;
    }

    /**
     * Returns true if the there are no cards left in the shuffled stack
     * @return true or false
     */
    public boolean isEmpty() {
        return shuffledCards.empty();
    }

    /**
     * Returns true if the there are cards left in the shuffled stack
     * @return true or false
     */
    public boolean isNotEmpty(){
        return !isEmpty();
    }
}