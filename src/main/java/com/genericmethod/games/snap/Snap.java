package com.genericmethod.games.snap;

import com.genericmethod.games.snap.card.Card;
import com.genericmethod.games.snap.deck.Deck;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.player.Player;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Snap {

    private Map<String, Player> players;
    private Set<Deck> decks;
    private Stack<Card> pile = new Stack<Card>();
    private MatchMode matchMode;
    private boolean gameIsFinished;
    private Player winner;
    private int totalNumberOfCards;

    public Snap(Map<String, Player> players, Set<Deck> decks, MatchMode matchMode) {
        //validate
        //Number of players must be greater than 2
        //Number of decks must not be null and greater than 1
        //Match mode must be defined

        this.matchMode = matchMode;
        this.players = players;
        this.decks = decks;
        this.gameIsFinished = false;
        dealCards();
    }

    /**
     * Deals the cards to the players
     */
    private void dealCards() {

        //for each deck, deal cards to the players until the deck is empty
        for (Deck deck : decks) {
            deck.shuffle();
            while (deck.isNotEmpty())
                for (Player player : players.values()) {
                    player.addCard(deck.dealCard());
                    totalNumberOfCards++;
                }
        }
    }

    /**
     * Play the game
     */
    public void play() {

        while (!gameIsFinished) {

            for (Player player : players.values()) {
                Card topCard = pile.peek();
                Card playedCard = player.playCard();

                if (isSnap(matchMode, topCard, playedCard)) {
                    //if the top card matches the played card
                    //and remove all the cards from the middle pile
                    player.addCards(pile);
                    pile.removeAllElements();
                }

                if(playerHasAllCards(player)){
                    gameIsFinished = true;
                    winner = player;

                }
            }
        }
    }

    private boolean playerHasAllCards(Player player) {
        return player.getCards().size() == getTotalNumberOfCards();
    }

    private boolean isSnap(MatchMode matchMode, Card topCard, Card playedCard) {

        switch (matchMode) {
            case RANK:
                return topCard.getRank() == playedCard.getRank();
            case SUIT:
                return topCard.getSuit() == playedCard.getSuit();
            case BOTH:
                return topCard.equals(playedCard);
            default:
                return topCard.getRank() == playedCard.getRank();
        }
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public int getTotalNumberOfCards() {
        return totalNumberOfCards;
    }

    public Player getWinner() {
        return winner;
    }
}