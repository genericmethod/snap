package com.genericmethod.games.snap;

import com.genericmethod.games.framework.GameState;
import com.genericmethod.games.framework.card.Card;

public class SnapGameState extends GameState {

    private Card topCard;
    private Card playedCard;

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public Card getPlayedCard() {
        return playedCard;
    }

    public void setPlayedCard(Card playedCard) {
        this.playedCard = playedCard;
    }
}
