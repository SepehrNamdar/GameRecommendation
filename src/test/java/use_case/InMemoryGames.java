package use_case;

import domain.Game;
import domain.Games;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGames implements Games {

    private final List<Game> games;

    public InMemoryGames() {
        games = new ArrayList<>();
    }

    @Override
    public void add(Game game) {
        games.add(game);
    }

    @Override
    public List<Game> findAllGames() {
        return games;
    }

}
