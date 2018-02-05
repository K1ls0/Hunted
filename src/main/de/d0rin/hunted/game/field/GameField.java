package main.de.d0rin.hunted.game.field;

import java.awt.*;
import java.util.Set;
import java.util.TreeSet;

public class GameField {

    private FieldObject[][] field;
    

    private GameField(int width, int height) {
        field = new FieldObject[width][height];
    }
    private GameField(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public static GameField createByDimension(int width, int height) {
        return new GameField(width, height);
    }
    public static GameField createByDimension(Dimension d) {
        return new GameField(d);
    }



    public void setField(FieldObject[][] newField) {
        field = new FieldObject[newField.length][newField[0].length];

        for (int x = 0; x < newField.length; x++) {
            for (int y = 0; y < newField[x].length; y++) {
                field[x][y] = newField[x][y];
            }
        }
    }


    public FieldObject[][] getField() {
        return field;
    }

    public FieldObject get(int x, int y) {
        return field[x][y];
    }

    public int getWidth() {
        return field.length;
    }

    public int getHeight() {
        return field[0].length;
    }

    public Set<Point> geAllCoordinates(boolean solidPlanes) {
        Set<Point> returnSet = new TreeSet();

        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                if (field[x][y].isSolid() == solidPlanes) {
                     returnSet.add(new Point(x, y));
                }
            }
        }
        return returnSet;
    }



    public boolean isPlaneSolid(int x, int y) {
        return get(x, y).isSolid();
    }
}
