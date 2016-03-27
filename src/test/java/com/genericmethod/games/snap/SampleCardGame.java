package com.genericmethod.games.snap;

import com.genericmethod.games.snap.player.CardPlayer;

import java.util.Map;

public class SampleCardGame extends CardGame{

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
