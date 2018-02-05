package main.de.d0rin.hunted.game.entities;

import main.de.d0rin.hunted.game.misc.Direction;
import main.de.d0rin.hunted.game.exceptions.IDException;
import main.de.d0rin.hunted.game.exceptions.NoUsesLeftException;
import main.de.d0rin.hunted.game.field.Step;

import java.awt.*;
import java.util.HashMap;

public abstract class Entity {

    protected Thread roundThread;
    protected Point locationpoint;
    protected HashMap<Integer, Step> possibleSteps;

    protected EntityType entityType;


    protected Entity(Point startCoordinates, HashMap<Integer, Step> startSteps) {
        possibleSteps = startSteps;
        locationpoint = startCoordinates;
    }

    public void setRoundThread(Thread t) {
        roundThread = t;
    }

    public Thread getRoundThread() {
        return roundThread;
    }

    public EntityType getGraphicKey() {
        return entityType;
    }

    public void go(Direction d, int id) throws IDException {

        try {
            locationpoint.setLocation(getNewPointByDirection(d, getStepById(id)));
        } catch (NoUsesLeftException nule) {

        }
    }

    public Point getLocationpoint() {
        return locationpoint;
    }

    private Step getStepById(int id) {
        return possibleSteps.get(id);
    }

    private Point getNewPointByDirection(Direction d, Step step) throws NoUsesLeftException {
        int stepAmount = step.useStep();
        locationpoint.setLocation(d.getXDirectionMultiplier() * stepAmount, d.getYDirectionMultiplier() * stepAmount);
        return locationpoint;
    }
}
