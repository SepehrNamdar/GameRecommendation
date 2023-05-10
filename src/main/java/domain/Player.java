package domain;

import java.util.List;

public class Player {

    private final String name;
    private final List<String> playedGames;

    public Player(String name, List<String> playedGames) {
        this.name = name;
        this.playedGames = playedGames;
    }

    public boolean hasNotPlayed(Game game) {
        return !playedGames.contains(game.getName());
    }
}
