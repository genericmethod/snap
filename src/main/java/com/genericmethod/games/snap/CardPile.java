package com.genericmethod.games.snap;

import com.genericmethod.games.framework.card.Card;

import java.util.Stack;

/**
 * Represents a pile of cards
 */
public class CardPile {

    private Stack<Card> cards;

    public CardPile() {
        this.cards = new Stack<Card>();
    }

    /**
     * Add a card to the pile
     * @param card The card to be added to the pile
     */
    public void add(Card card){
        cards.add(card);
    }

    /**
     * Clear the pile of cards
     */
    public void clear(){
        cards.clear();
    }

    /**
     * Get the card at the top of the pile
     * @return the card at the top of the pile
     */
    public Card topCard(){
        Card topCard = null;
        if (cards.size() != 0) {
            topCard = cards.peek();
        }
        return topCard;
    }

    /**
     * Get the number of cards in the pile
     * @return the number of cards in the pile
     */
    public int cardCount(){
        return cards.size();
    }

    /**
     * Get the cards in the pile
     * @return the cards in the pile
     */
    public Stack<Card> getCards() {
        return cards;
    }
}
