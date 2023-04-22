package domain;

import java.util.Objects;

public class Game {

    private final Gender gender;
    private final String name;
    private final int note;

    public Game(Gender gender, String name, int note) {
        this.gender = gender;
        this.name = name;
        this.note = note;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return note == game.note;
    }

    @Override
    public int hashCode() {
        return Objects.hash(note);
    }
}
