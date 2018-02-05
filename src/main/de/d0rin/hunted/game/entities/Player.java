package main.de.d0rin.hunted.game.entities;

import main.de.d0rin.hunted.game.field.Step;

import java.awt.*;
import java.util.HashMap;

public class Player extends Entity {
    protected Player(Point startCoordinates, HashMap<Integer, Step> startSteps) {
        super(startCoordinates, startSteps);
        super.entityType = EntityType.Player;
    }

    public static Player createByStartCoordinatesAndStartSteps(Point startCoords, HashMap<Integer, Step> startSteps) {
        return new Player(startCoords, startSteps);
    }
}
