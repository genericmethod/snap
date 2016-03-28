package com.genericmethod.games.snap.util;

import com.genericmethod.games.framework.card.Card;
import com.genericmethod.games.snap.enums.MatchMode;

public class SnapUtil {

    public static boolean isSnap(MatchMode matchMode, Card topCard, Card playedCard) {

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
}
