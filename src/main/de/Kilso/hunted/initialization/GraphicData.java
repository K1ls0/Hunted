package main.de.Kilso.hunted.initialization;

import main.de.Kilso.hunted.game.field.BackImgCombs;
import main.de.Kilso.hunted.game.entities.EntityType;
import main.de.Kilso.hunted.game.misc.GUIPart;
import main.de.Kilso.hunted.game.exceptions.IllegalKeyException;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GraphicData {

    private HashMap<BackImgCombs, BufferedImage> mapImages;
    private HashMap<EntityType, BufferedImage> entityImages;
    private HashMap<GUIPart, BufferedImage> GUIImages;

    private GraphicData() {
        mapImages = new HashMap<>();
    }

    public BufferedImage getImageByKey(BackImgCombs key) {
        if (mapImages.containsKey(key)) {
            return mapImages.get(key);
        } else throw new IllegalKeyException();
    }
    public BufferedImage getImageByKey(EntityType key) {
        if (entityImages.containsKey(key)) {
            return entityImages.get(key);
        } else throw new IllegalKeyException();
    }
    public BufferedImage getImageByKey(GUIPart key) {
        if (GUIImages.containsKey(key)) {
            return GUIImages.get(key);
        } else throw new IllegalKeyException();
    }

    public void addToImages(BackImgCombs key, BufferedImage image) {
        mapImages.put(key, image);
    }
    public void addToImages(EntityType key, BufferedImage image) {
        entityImages.put(key, image);
    }
    public void addToImages(GUIPart key, BufferedImage image) {
        GUIImages.put(key, image);
    }

    public HashMap<BackImgCombs, BufferedImage> getBackgroundImages() {
        return mapImages;
    }
    public HashMap<EntityType, BufferedImage> getEntityImages() {
        return entityImages;
    }
    public HashMap<GUIPart, BufferedImage> getMapImages() {
        return GUIImages;
    }

    private <K, V> HashMap<K, V> insertHashMap(HashMap<K, V> insertable, HashMap<? extends K, ? extends V> inserting) {
        for (K currentKey : inserting.keySet()) {
            insertable.put(currentKey, inserting.get(currentKey));
        }
        return insertable;
    }
}