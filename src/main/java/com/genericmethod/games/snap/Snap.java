package com.genericmethod.games.snap;

import com.genericmethod.games.snap.card.Card;
import com.genericmethod.games.snap.deck.Deck;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.exception.SnapException;
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

    public Snap(Map<String, Player> players, Set<Deck> decks, MatchMode matchMode) throws SnapException {
        //validate
        //Number of players must be greater than 2
        //Number of decks must not be null and greater than 1
        //Match mode must be defined

        if (players == null || decks == null || matchMode == null) {
            throw new SnapException("Invalid parameters. Please make sure all parameters are defined");
        }

        if(players.size() <= 1){
            throw new SnapException("Snap requires a minimum of 2 players");
        }

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
        totalNumberOfCards = 0;
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

                if (player.hasCards()) {
                    System.out.println(player.getPlayerName() + " is playing his turn");
                    System.out.println(player.getPlayerName() + " number of cards = " + player.getCards().size());
                    System.out.println("Number of Cards in the Middle Pile is " + pile.size());
                    Card topCard = null;

                    if (pile.size() != 0) {
                        topCard = pile.peek();
                    }

                    Card playedCard = player.playCard();
                    pile.push(playedCard);

                    if (isSnap(matchMode, topCard, playedCard)) {
                        //TODO: randomize the player that calls snap.
                        //if the top card matches the played card
                        //and remove all the cards from the middle pile
                        player.addCards(pile);
                        pile.removeAllElements();
                        System.out.println(player.getPlayerName() + " called SNAP!");
                    }

                    //if the player has all the cards
                    //then the game is finished and he is the winner
                    if (playerHasAllCards(player)) {
                        gameIsFinished = true;
                        winner = player;
                        System.out.println(player.getPlayerName() + " is the WINNER");
                        break;
                    }

                    //if the pile size has all the cards
                    //then deal the cards again
                    if (pile.size() == totalNumberOfCards){
                        dealCards();
                    }

                    System.out.println(player.getPlayerName() + " number of cards = " + player.getCards().size());
                    System.out.println("Number of Cards in the Middle Pile is " + pile.size());
                }
            }
        }
    }

    private boolean playerHasAllCards(Player player) {
        return player.getCards().size() == getTotalNumberOfCards();
    }

    private boolean isSnap(MatchMode matchMode, Card topCard, Card playedCard) {

        if (topCard == null) {
            return false;
        }

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
