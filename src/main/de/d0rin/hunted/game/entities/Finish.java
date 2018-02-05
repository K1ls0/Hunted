package main.de.d0rin.hunted.game.entities;

import java.awt.*;
import java.util.HashMap;

public class Finish extends Entity {
    protected Finish(Point coordinates) {
        super(coordinates, new HashMap<>());
        super.entityType = EntityType.Player;
    }

    public static Finish createByStartCoordinatesAndStartSteps(Point coords) {
        return new Finish(coords);
    }
}
