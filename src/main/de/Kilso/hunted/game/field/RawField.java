package main.de.Kilso.hunted.game.field;

import java.awt.*;
import java.util.Set;
import java.util.TreeSet;

public class RawField {

    private FieldTile[][] field;
    

    private RawField(int width, int height) {
        field = new FieldTile[width][height];
    }
    private RawField(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public static RawField createByDimension(int width, int height) {
        return new RawField(width, height);
    }
    public static RawField createByDimension(Dimension d) {
        return new RawField(d);
    }



    public void setField(FieldTile[][] newFieldTile) {
        field = new FieldTile[newFieldTile.length][newFieldTile[0].length];

        for (int x = 0; x < newFieldTile.length; x++) {
            for (int y = 0; y < newFieldTile[x].length; y++) {
                field[x][y] = newFieldTile[x][y];
            }
        }
    }


    public FieldTile[][] getField() {
        return field;
    }

    public FieldTile get(int x, int y) {
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
