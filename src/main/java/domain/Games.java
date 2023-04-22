package domain;

import java.util.List;

public interface Games {

    void add(Game game);

    List<Game> findAllGames();
}

