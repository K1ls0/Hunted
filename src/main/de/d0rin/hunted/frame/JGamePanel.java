package main.de.d0rin.hunted.frame;

import main.de.d0rin.hunted.game.field.BackImgCombs;
import main.de.d0rin.hunted.game.field.FieldData;
import main.de.d0rin.hunted.game.entities.Finish;
import main.de.d0rin.hunted.game.entities.Player;
import main.de.d0rin.hunted.game.entities.enemies.Enemy;
import main.de.d0rin.hunted.game.field.GameField;
import main.de.d0rin.hunted.initialization.GraphicData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class JGamePanel extends JPanel {

    private GraphicData graphicData;
    private FieldData currentFieldData;

    private JGamePanel(GraphicData builderData, FieldData mapData) {
        this.graphicData = builderData;
        updateFieldData(mapData);
    }

    private JGamePanel(GraphicData builderData) {
        this(builderData, null);
    }

    public static JGamePanel createFromGraphicLoader(GraphicData builderData) {
        return new JGamePanel(builderData);
    }

    public static JGamePanel createFromGraphicLoaderAndMapData(GraphicData builderData, FieldData mapData) {
        return new JGamePanel(builderData, mapData);
    }



    public void updateFieldData(FieldData data) {
        currentFieldData = data;
        repaint();
    }

    public void paintComponent(Graphics g) {
        BufferedImage fieldTexture = paintField();
        BufferedImage playerTextures = paintEntities();

        g.drawImage(fieldTexture, 0, 0, null);
        g.drawImage(playerTextures, 0, 0, null);
    }

    private BufferedImage paintField() {
        GameField currentField = currentFieldData.getField();
        Dimension planeDimension = currentFieldData.getPlaneDimension();

        BufferedImage paintedField = new BufferedImage( currentField.getWidth() * planeDimension.width,
                                                        currentField.getHeight() * planeDimension.height,
                                                        BufferedImage.TYPE_INT_RGB);
        if (currentFieldData != null) {
            for (int x = 0; x < currentField.getWidth(); x++) {
                for (int y = 0; y < currentField.getHeight(); y++) {
                    paintedField = paintImageOnCoordinate(new Point(
                            x * planeDimension.width,
                            y * planeDimension.height),
                            paintedField,
                            graphicData.getImageByKey(BackImgCombs.getBackgroundComb(currentField, new Point(x, y))));
                }
            }
        }
        return paintedField;
    }

    private BufferedImage paintEntities() {
        GameField currentField = currentFieldData.getField();
        Dimension planeDimension = currentFieldData.getPlaneDimension();

        Player player = currentFieldData.getPlayer();
        Finish finish = currentFieldData.getFinish();
        HashMap<Integer, Enemy> enemies = currentFieldData.getEnemies();

        BufferedImage paintedField = new BufferedImage( currentField.getWidth() * planeDimension.width,
                                                        currentField.getHeight() * planeDimension.height,
                                                        BufferedImage.TYPE_INT_ARGB);



        paintImageOnCoordinate(player.getLocationpoint(), paintedField, graphicData.getImageByKey(player.getGraphicKey()));

        paintImageOnCoordinate(finish.getLocationpoint(), paintedField, graphicData.getImageByKey(finish.getGraphicKey()));

        enemies.keySet().stream().forEach(cInt -> paintImageOnCoordinate(enemies.get(cInt).getLocationpoint(),
                paintedField,
                graphicData.getImageByKey(enemies.get(cInt).getGraphicKey())
        ));

        return paintedField;
    }

    private BufferedImage paintImageOnCoordinate(Point p, BufferedImage returnImage, BufferedImage partImage) {
        Graphics2D return2d = returnImage.createGraphics();
        return2d.drawImage(partImage, null, p.x, p.y);
        return2d.dispose();

        return returnImage;
    }
}