package main.de.Kilso.hunted.initialization.png;

import main.de.Kilso.hunted.game.field.FieldTile;
import main.de.Kilso.hunted.game.field.RawField;
import main.de.Kilso.hunted.game.field.Ground;
import main.de.Kilso.hunted.game.field.Wall;
import main.de.Kilso.hunted.main.config.ReferenceColors;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MapInterpreter {

    private BufferedImage fieldImage;

    private RawField interpretedImage;

    private Point playerPosition;

    private Point finishPosition;

    private ArrayList<Point>[] enemyLists;



    private MapInterpreter(BufferedImage fieldImage) {
        this.fieldImage = fieldImage;
        enemyLists = new ArrayList[ReferenceColors.COLOR_ENEMIES.length];

        interpretedImage = interpreteMapImage();
    }

    public static MapInterpreter createMapInterpreterByImage(BufferedImage fieldImage) {
        return new MapInterpreter(fieldImage);
    }



    private RawField interpreteMapImage() {
        RawField gameField = RawField.createByDimension(fieldImage.getWidth(), fieldImage.getHeight());
        FieldTile[][] fieldTileArray = gameField.getField();

        for (int x = 0; x < fieldTileArray.length; x++) {
            for (int y = 0; y < fieldTileArray[x].length; y++) {
                fieldTileArray[x][y] = getFieldObjByColor(fieldImage.getRGB(x, y));

                if (fieldImage.getRGB(x, y) == ReferenceColors.COLOR_PLAYER) {
                    playerPosition = new Point(x, y);
                } else if (fieldImage.getRGB(x, y) == ReferenceColors.COLOR_FINISH) {
                    finishPosition = new Point(x, y);
                }

                for (int i = 0; i < enemyLists.length; i++) {
                    if (fieldImage.getRGB(x, y) == ReferenceColors.COLOR_ENEMIES[i]) {
                        enemyLists[i].add(new Point(x, y));
                    }
                }
            }
        }

        gameField.setField(fieldTileArray);

        return gameField;
    }

    private FieldTile getFieldObjByColor(int rgb) {
        if (rgb == ReferenceColors.COLOR_WALL) {
            return new Wall();
        } else {
            return new Ground();
        }
    }

    private static Point[] appendToField(Point[] oldField, Point newPoint) {
        Point[] returnField = new Point[oldField.length + 1];
        for (int i = 0; i < oldField.length; i++) {
            returnField[i] = oldField[i];
        }
        returnField[returnField.length-1] = newPoint;

        return returnField;
    }

    public ArrayList<Point>[] getEnemiePositions() {
        return enemyLists;
    }

    public RawField getInterpretedImage() {
        return interpretedImage;
    }

    public Point getPlayerPosition() {
        return playerPosition;
    }

    public Point getFinishPosition() {
        return finishPosition;
    }
}