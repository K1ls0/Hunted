package main.de.Kilso.hunted.main.config;

import java.awt.*;

public class Constants {
    public static final String GAMENAME = "Hunted by creative Studios";

    public static final String VERSION = "0.001 Prealpha";

    public static final Dimension FRAMEDIMENSION = createDimensionFromScreenSize();

    public static final char MAX_ACTION_AMOUNT = 10;



    private static Dimension createDimensionFromScreenSize() {
        final double FRAME_FACTOR = 0.7;

        int width = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() * FRAME_FACTOR);
        int height = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * FRAME_FACTOR);

        return new Dimension(width, height);
    }
}
