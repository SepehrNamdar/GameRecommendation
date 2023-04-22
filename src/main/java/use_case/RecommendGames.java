package use_case;

import domain.Game;
import domain.Games;
import domain.Player;
import domain.Recommendation;

import java.util.LinkedList;
import java.util.List;

import static domain.Gender.*;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;

public class RecommendGames {

    private final Player player;
    private final Games games;

    public RecommendGames(Player player, Games games) {
        this.player = player;
        this.games = games;
    }

    public Recommendation getRecommendations() {
        List<Game> allGames = games.findAllGames();
        allGames.sort(comparingInt(Game::getNote).reversed());
        List<String> actionGames = new LinkedList<>();
        List<String> strategyGames = new LinkedList<>();
        List<String> adventureGames = new LinkedList<>();
        Recommendation recommendation = new Recommendation();
        for (Game game : allGames) {
            if (game.getGender() == ACTION) {
                actionGames.add(game.getName());
            } else if (game.getGender() == STRATEGY) {
                strategyGames.add(game.getName());
            } else {
                adventureGames.add(game.getName());
            }
        }
        recommendation.put(ACTION, actionGames);
        recommendation.put(STRATEGY, strategyGames);
        recommendation.put(ADVENTURE, adventureGames);
        return recommendation;
    }
}
