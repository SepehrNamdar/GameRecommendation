package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Recommendation extends TreeMap<Gender, List<String>> {
    public void putGame(Gender gender, String name) {
//        if (this.containsKey(gender)) {
//            List<String> games = this.get(gender);
//            if (games.size() < 2 && !games.contains(name)) {
//                games.add(name);
//            }
//        } else {
//            this.put(gender, new ArrayList<>(Collections.singletonList(name)));
//        }

//        this.computeIfPresent(gender, (k, v) -> {
//            if (v.size() < 2 && !v.contains(name)) {
//                v.add(name);
//            }
//            return v;
//        });
//        this.computeIfAbsent(gender, k -> new ArrayList<>(Collections.singletonList(name)));

        this.computeIfPresent(gender, (k, v) ->
                v.stream()
                        .filter(game -> game.equals(name) || v.size() >= 2)
                        .findFirst()
                        .map(game -> v)
                        .orElseGet(() -> {
                            v.add(name);
                            return v;
                        })
        );
        this.computeIfAbsent(gender, k -> Stream.of(name).collect(toCollection(ArrayList::new)));
    }
}
