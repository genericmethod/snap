package com.genericmethod.games.snap.util;

import com.genericmethod.games.framework.player.CardPlayer;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PlayerUtil {

    /**
     * Returns a random player from a list of players.
     * @param players a {@link List} of players to choose from
     * @return a random player from the list
     */
    public static CardPlayer getRandomPlayer(List<CardPlayer> players){
        Validate.notEmpty(players);
        Collections.shuffle(players);
        return players.get(0);
    }

    /**
     * Returns a random player from a list of players.
     * @param players a {@link Map} of players to choose from
     * @return a random player from the map
     */
    public static CardPlayer getRandomPlayer(Map<String,CardPlayer> players){
        Validate.notEmpty(players);
        return PlayerUtil.getRandomPlayer(new ArrayList<CardPlayer>(players.values()));
    }
}
