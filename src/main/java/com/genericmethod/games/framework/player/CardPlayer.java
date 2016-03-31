package com.genericmethod.games.framework.player;

import com.genericmethod.games.framework.card.Card;
import com.genericmethod.games.framework.CardPile;

import java.util.Stack;

/**
 * Represents a player in a game of cards
 */
public class CardPlayer extends Player {

    private Stack<Card> cards;

    public CardPlayer(String playerName) {
        super(playerName);
        cards = new Stack<>();
    }

    /**
     * Add a card to the player's stack of cards
     * @param card The {@link Card} to be added
     */
    public void addCard(Card card){
        cards.push(card);
    }

    /**
     * Player plays a card.
     * This removes a card from the top of the stack
     * @return the card that the player has played
     */
    public Card playCard(){
        return cards.pop();
    }

    /**
     * Returs all the players cards
     * @return {@link Stack} of {@link Card} objects
     */
    public Stack<Card> getCards() {
        return cards;
    }

    /**
     * Adds a stack of cards to the player's current stack
     * @param cards {@link Stack} of {@link Card} objects
     */
    public void addCards(Stack<Card> cards) {
        this.cards.addAll(cards);
    }

    /**
     * Adds a stack of cards to the player's current stack
     * @param pile {@link CardPile}
     */
    public void addCards(CardPile pile) {
        this.cards.addAll(pile.getCards());
    }

    /**
     * Returns true if the player has cards in his stack
     * otherwise returns false
     * @return true or false
     */
    public boolean hasCards(){
        return getCards().size() != 0;
    }

    /**
     * Returns true if the player has no cards in his stack
     * otherwise returns false
     * @return true or false
     */
    public boolean hasNoCards(){
        return !hasCards();
    }
}
