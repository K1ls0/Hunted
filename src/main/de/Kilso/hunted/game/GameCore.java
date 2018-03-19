package main.de.Kilso.hunted.game;

import main.de.Kilso.hunted.game.field.GameField;

public class GameCore {

    private GameField gameField;

    private GameCore() {

    }

    public static GameCore create() {
        return new GameCore();
    }
}
