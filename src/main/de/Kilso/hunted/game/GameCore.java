package main.de.Kilso.hunted.game;

import main.de.Kilso.hunted.game.field.RawField;

public class GameCore {

    private RawField gameField;

    private GameCore() {

    }

    public static GameCore create() {
        return new GameCore();
    }
}
