package com.genericmethod.games.snap;

import com.genericmethod.games.framework.CardGame;
import com.genericmethod.games.framework.CardPile;
import com.genericmethod.games.framework.card.Card;
import com.genericmethod.games.framework.deck.Deck;
import com.genericmethod.games.framework.exceptions.CardGameException;
import com.genericmethod.games.framework.player.CardPlayer;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.exception.SnapException;
import com.genericmethod.games.snap.util.PlayerUtil;
import com.genericmethod.games.snap.util.SnapUtil;

import java.util.Map;
import java.util.Set;

public class Snap extends CardGame<SnapGameState> {

    private Set<Deck> decks;
    private CardPile pile;
    private MatchMode matchMode;
    private CardPlayer winner;
    private int totalNumberOfCards;

    public Snap(Map<String, CardPlayer> players,
                Set<Deck> decks,
                MatchMode matchMode) throws SnapException, CardGameException {

        super(players, new SnapGameState());

        if (decks == null || matchMode == null) {
            throw new SnapException("Invalid parameters. Please make sure all parameters are defined");
        }

        if (players.size() <= 1) {
            throw new SnapException("Snap requires a minimum of 2 players");
        }

        pile = new CardPile();
        this.matchMode = matchMode;
        this.decks = decks;
    }

    /**
     * Deals the cards to the players
     */
    public void dealCards() {
        totalNumberOfCards = 0;
        //for each deck, deal cards to the players until the deck is empty
        for (Deck deck : decks) {
            deck.shuffle();
            while (deck.isNotEmpty())
                for (CardPlayer player : getPlayers().values()) {
                    player.addCard(deck.dealCard());
                    totalNumberOfCards++;
                }
        }
    }

    @Override
    protected void init() {
        dealCards();
        System.out.println("Cards dealt!");
    }

    /**
     * At each turn, the player
     * 1. Places one of his cards in the middle pile
     * 2. If the card matches the top card in the middle pile then a player calls Snap!
     * 3. The player that calls out Snap takes the current pile of cards.
     * 4. If the player has all the cards then he has won the game.
     * 5. If both players have no cards then the cards are dealt again.
     * 6. If only one player remains with cards, the player keeps on playing until a match is made
     */
    public void playTurn() {

        CardPlayer player = getGameState().getCurrentPlayer();

        if (player.hasNoCards()) {
            return;
        }

        Card topCard = pile.topCard();
        getGameState().setTopCard(topCard);

        Card playedCard = player.playCard();
        getGameState().setPlayedCard(playedCard);
        pile.add(playedCard);

        if (SnapUtil.isSnap(matchMode, topCard, playedCard)) {
            handleSnap();
            System.out.println("SNAP!");
        }



    }

    @Override
    protected void postTurn() {

        CardPlayer player = getGameState().getCurrentPlayer();

        //if the player has all the cards
        //then the game is finished and is the winner
        if (playerHasAllCards(player)) {
            setGameToFinished();
            winner = player;
            printGameState(player.getPlayerName(), player.getCards().size(), pile.cardCount(),
                    getGameState().getTopCard(), getGameState().getPlayedCard(), false);
            System.out.println(player.getPlayerName() + " is the WINNER");
            return;
        }

        //if the pile has all the cards then no one has won the game
        //then deal the cards again and remove them from the middle pile
        if (pileHasAllCards()) {
            dealCards();
            pile.clear();
            System.out.println("No Winner :( - Cards Dealt Again");
        }

        printGameState(player.getPlayerName(), player.getCards().size(), pile.cardCount(),
                getGameState().getTopCard(), getGameState().getPlayedCard(), false);

    }

    @Override
    protected void preTurn() {

    }

    @Override
    protected void postRound() {

    }

    @Override
    protected void preRound() {

    }

    private boolean pileHasAllCards() {
        return pile.cardCount() == totalNumberOfCards;
    }

    private void printGameState(String playerName, int numberOfPlayerCards, int pileCardCount, Card topCard, Card playedCard, boolean snap) {

        StringBuilder state = new StringBuilder();

        state.append(playerName)
                .append("\t| ")
                .append("number of cards: ")
                .append(numberOfPlayerCards)
                .append("\t| ")
                .append("card pile count : ")
                .append(pileCardCount)
                .append("\t| ")
                .append("top card : ")
                .append(topCard != null ? topCard.toString() : "-----")
                .append("\t| ")
                .append("played card : ")
                .append(playedCard.toString());
        System.out.println(state.toString());

    }

    private void handleSnap() {
        //if the top card matches the played card
        //give a random player all the cards in the pile
        //and remove all the cards from the middle pile
        final CardPlayer randomPlayer = PlayerUtil.getRandomPlayer(getPlayers());
        randomPlayer.addCards(pile);
        pile.clear();
    }

    private boolean playerHasAllCards(CardPlayer player) {
        return player.getCards().size() == getTotalNumberOfCards();
    }

    public int getTotalNumberOfCards() {
        return totalNumberOfCards;
    }

    public CardPlayer getWinner() {
        return winner;
    }
}
