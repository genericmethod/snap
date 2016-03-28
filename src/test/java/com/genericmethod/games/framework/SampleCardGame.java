package com.genericmethod.games.framework;

import com.genericmethod.games.framework.player.CardPlayer;

import java.util.Map;

public class SampleCardGame extends CardGame {

    protected SampleCardGame(Map<String, CardPlayer> players) {
        super(players);
    }

    @Override
    protected void init() {

    }

    @Override
    protected boolean executePlayerTurn(CardPlayer player) {
        return false;
    }
}
