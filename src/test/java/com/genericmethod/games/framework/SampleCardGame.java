package com.genericmethod.games.framework;

import com.genericmethod.games.framework.exceptions.CardGameException;
import com.genericmethod.games.framework.player.CardPlayer;

import java.util.Map;

public class SampleCardGame extends CardGame {

    protected SampleCardGame(Map<String, CardPlayer> players) throws CardGameException {
        super(players);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void playTurn() {
    }

    @Override
    protected void postTurn() {

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

}
