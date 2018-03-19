package main.de.Kilso.hunted.game.field;

import main.de.Kilso.hunted.game.entities.Finish;
import main.de.Kilso.hunted.game.entities.Player;
import main.de.Kilso.hunted.game.entities.enemies.Enemy;

import java.awt.*;
import java.util.HashMap;

public class FieldData {
    private GameField field;

    private Dimension planeDimension;

    private Player player;

    private Finish finish;

    private HashMap<Integer, Enemy> enemies;



    private FieldData(Dimension mapDimension) {
        field = GameField.createByDimension(mapDimension);
        planeDimension = new Dimension(1, 1);

        enemies = new HashMap<>();
    }

    private FieldData(GameField field) {
        this.field = field;
        planeDimension = new Dimension(1, 1);

        enemies = new HashMap<>();
    }

    public static FieldData createFromfieldDimension(int x, int y) {
        return FieldData.createFromfieldDimension(x, y);
    }

    public static FieldData createFromfieldDimension(Dimension d) {
        return new FieldData(d);
    }

    public static FieldData crateByGameField(GameField field) {
        return new FieldData(field);
    }



    public void setGameField(GameField field) {
        this.field = field;
    }

    public void setPlayer(Player p) {
        this.player = p;
    }

    public void setFinish(Finish f) {
        this.finish = f;
    }

    public void setEnemies(HashMap<Integer, Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setPlaneDimension(Dimension planeDimension) {
        this.planeDimension = planeDimension;
    }



    public GameField getField() {
        return field;
    }

    public Player getPlayer() {
        return player;
    }

    public Finish getFinish() {
        return finish;
    }

    public Dimension getPlaneDimension() {
        return planeDimension;
    }

    public HashMap<Integer, Enemy> getEnemies() {
        return enemies;
    }

    public Enemy getEnemyByKey(int key) {
        return enemies.get(key);
    }
}