package com.genericmethod.games.snap.player;

import com.genericmethod.games.snap.card.Card;

import java.util.Stack;

/**
 * Represents a player in a game of cards
 */
public class CardPlayer extends Player{

    private Stack<Card> cards;

    public CardPlayer(String playerName) {
        super(playerName);
        cards = new Stack<Card>();
    }

    /**
     * Give the player a card
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

    public Stack<Card> getCards() {
        return cards;
    }

    public void addCards(Stack<Card> pile) {
        cards.addAll(pile);
    }

    public boolean hasCards(){
        return getCards().size() != 0;
    }

    public boolean hasNoCards(){
        return !hasCards();
    }
}
