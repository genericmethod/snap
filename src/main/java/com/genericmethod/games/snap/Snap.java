package com.genericmethod.games.snap;

import com.genericmethod.games.framework.CardGame;
import com.genericmethod.games.framework.card.Card;
import com.genericmethod.games.framework.deck.Deck;
import com.genericmethod.games.framework.player.CardPlayer;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.exception.SnapException;
import com.genericmethod.games.snap.util.PlayerUtil;
import com.genericmethod.games.snap.util.SnapUtil;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Snap extends CardGame {

    private Set<Deck> decks;
    private Stack<Card> pile = new Stack<Card>();
    private MatchMode matchMode;
    private CardPlayer winner;
    private int totalNumberOfCards;

    public Snap(Map<String, CardPlayer> players, Set<Deck> decks, MatchMode matchMode) throws SnapException {

        super(players);

        if (players == null || decks == null || matchMode == null) {
            throw new SnapException("Invalid parameters. Please make sure all parameters are defined");
        }

        if(players.size() <= 1){
            throw new SnapException("Snap requires a minimum of 2 players");
        }

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
     * @param player The player that is currently playing his turn.
     * @return
     */
    public boolean executePlayerTurn(CardPlayer player) {

        if (player.hasCards()) {

            System.out.println("******" + player.getPlayerName() + " is playing his turn *******");
            System.out.println(player.getPlayerName() + " number of cards BEFORE turn = " + player.getCards().size());
            System.out.println("Number of Cards in the Middle Pile is " + pile.size());

            Card topCard = getTopCard();

            Card playedCard = player.playCard();
            pile.push(playedCard);

            if (SnapUtil.isSnap(matchMode, topCard, playedCard)) {
                //TODO: randomize the player that calls snap.
                //if the top card matches the played card
                // ive the player all the cards in the pile
                //and remove all the cards from the middle pile
                final CardPlayer randomPlayer = PlayerUtil.getRandomPlayer(getPlayers());
                randomPlayer.addCards(pile);
                pile.removeAllElements();
                System.out.println(randomPlayer.getPlayerName() + " called SNAP!");
            }

            //if the player has all the cards
            //then the game is finished and he is the winner
            if (playerHasAllCards(player)) {
                setGameToFinished();
                winner = player;
                System.out.println(player.getPlayerName() + " is the WINNER");
                return true;
            }

            //if the pile has all the cards then no one has won the game
            //then deal the cards again and remove them from the middle pile
            if (pile.size() == totalNumberOfCards){
                dealCards();
                pile.removeAllElements();
                System.out.println("No Winner :( - Cards Dealt Again");
            }

            System.out.println(player.getPlayerName() + " number of cards AFTER turn = " + player.getCards().size());
            System.out.println("Number of Cards in the Middle Pile is " + pile.size());
            System.out.println("******" + player.getPlayerName() + " is FINISHED playing his turn *******");

        }

        return false;
    }

    /**
     * Get the card at the top of the middle pile
     * @return {@link Card}
     */
    private Card getTopCard() {
        Card topCard = null;
        if (pile.size() != 0) {
            topCard = pile.peek();
        }
        return topCard;
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
