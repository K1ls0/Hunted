package main.de.d0rin.hunted.game;

import main.de.d0rin.hunted.game.field.GameField;

public class GameCore {

    private GameField gameField;

    private GameCore() {

    }

    public static GameCore create() {
        return new GameCore();
    }
}
