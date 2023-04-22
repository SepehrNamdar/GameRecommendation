package use_case;

import domain.Game;
import domain.Games;
import domain.Player;
import domain.Recommendation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.Gender.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class NewlyCreatedPlayerShould {

    public static final String ACTION_GAME_1 = "action_game_1";
    public static final String ACTION_GAME_2 = "action_game_2";
    public static final String ADVENTURE_GAME_1 = "adventure_game_1";
    public static final String ADVENTURE_GAME_2 = "adventure_game_2";
    public static final String STRATEGY_GAME_1 = "strategy_game_1";
    public static final String STRATEGY_GAME_2 = "strategy_game_2";
    private Games games;

    @BeforeEach
    void setUp() {
        initGames();
    }

    @Test
    void get_default_recommendation() {
        Player player = new Player("Mahsa");

        RecommendGames recommendGames = new RecommendGames(player, games);
        Recommendation recommendation = recommendGames.getRecommendations();

        Recommendation expectedRecommendation = new Recommendation();
        expectedRecommendation.put(ACTION, asList(ACTION_GAME_1, ACTION_GAME_2));
        expectedRecommendation.put(STRATEGY, asList(STRATEGY_GAME_1, STRATEGY_GAME_2));
        expectedRecommendation.put(ADVENTURE, asList(ADVENTURE_GAME_2, ADVENTURE_GAME_1));
        assertThat(recommendation).isEqualTo(expectedRecommendation);
    }

    private void initGames() {
        Game action_game_1 = new Game(ACTION, ACTION_GAME_1, 5);
        Game action_game_2 = new Game(ACTION, ACTION_GAME_2, 3);
        Game adventure_game_1 = new Game(ADVENTURE, ADVENTURE_GAME_1, 3);
        Game adventure_game_2 = new Game(ADVENTURE, ADVENTURE_GAME_2, 4);
        Game strategy_game_1 = new Game(STRATEGY, STRATEGY_GAME_1, 5);
        Game strategy_game_2 = new Game(STRATEGY, STRATEGY_GAME_2, 4);
        games = new InMemoryGames();
        games.add(action_game_1);
        games.add(action_game_2);
        games.add(adventure_game_1);
        games.add(adventure_game_2);
        games.add(strategy_game_1);
        games.add(strategy_game_2);
    }
}
