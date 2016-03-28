package com.genericmethod.games.snap;

import com.genericmethod.games.framework.deck.Deck;
import com.genericmethod.games.snap.enums.MatchMode;
import com.genericmethod.games.snap.exception.SnapException;
import com.genericmethod.games.framework.player.CardPlayer;

import java.util.*;

public class App {
    public static void main(String[] args ) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snap!");
        System.out.println("Please choose the number of decks to be used:");
        Integer numberOfDecks  = scanner.nextInt();
        System.out.println("Please choose the number of players:");
        Integer numberOfPlayers  = scanner.nextInt();
        System.out.println("Please choose the Snap Matching Type:");
        System.out.println("[1] Rank");
        System.out.println("[2] Suit");
        System.out.println("[3] Card (Rank + Suit)");
        Integer matchingType  = scanner.nextInt();

        Set<Deck> decks = new HashSet<Deck>();
        Map<String, CardPlayer> players = new HashMap<String, CardPlayer>();

        for (int i = 0; i <= numberOfPlayers - 1; i++) {
            players.put("Player"+i, new CardPlayer("Player"+i));
        }

        for (int i = 0; i <= numberOfDecks - 1; i++) {
            decks.add(new Deck());
        }

        MatchMode matchMode = MatchMode.RANK;

        if (matchingType == 1){
            matchMode = MatchMode.RANK;
        }
        if (matchingType == 2){
            matchMode = MatchMode.SUIT;
        }
        if (matchingType == 3){
            matchMode = MatchMode.BOTH;
        }

        try {
            System.out.println("Snap started!");
            Snap snap = new Snap(players, decks, matchMode);
            snap.play();
            System.out.println("Snap Finished!");
        } catch (SnapException e) {
            System.out.println("Snap could not be started. Bye!");
            System.out.println("Reason:" + e.getMessage());
        }

    }
}
