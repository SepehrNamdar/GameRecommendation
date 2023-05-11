package use_case;

import domain.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static domain.Gender.*;
import static java.util.Collections.singletonList;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.concat;

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
/*        for (Game game : allGames) {
            if (player.hasNotPlayed(game)) {
                if (game.getGender() == ACTION) {
                    actionGames.add(game.getName());
                } else if (game.getGender() == STRATEGY) {
                    strategyGames.add(game.getName());
                } else {
                    adventureGames.add(game.getName());
                }
            }
        }
        recommendation.put(ACTION, actionGames);
        recommendation.put(STRATEGY, strategyGames);
        recommendation.put(ADVENTURE, adventureGames);*/
//        for (Game game : allGames) {
//            if (player.hasNotPlayed(game)) {
//                Gender gender = game.getGender();
//                String name = game.getName();
//                recommendation.putIfAbsent(gender, new ArrayList<>());
//                recommendation.get(gender).add(name);
//            }
//        }

//        Map<Gender, List<String>> genderMap = allGames.stream()
//                .filter(player::hasNotPlayed)
//                .collect(groupingBy(Game::getGender, mapping(Game::getName, toList())));
//        recommendation.putAll(genderMap);

//        Map<Gender, List<String>> genderMap = allGames.stream()
//                .filter(player::hasNotPlayed)
//                .collect(toMap(Game::getGender,
//                        game -> singletonList(game.getName()),
//                        (list1, list2) -> concat(list1.stream(), list2.stream()).limit(2).collect(toList())));
//
//        recommendation.putAll(genderMap);

        recommendation = allGames.stream()
                .filter(player::hasNotPlayed)
                .collect(Recommendation::new,
                        (rec, game) -> rec.putGame(game.getGender(), game.getName()),
                        Map::putAll);
        return recommendation;
    }
}
