package main.de.d0rin.hunted.game.misc;

public enum Direction {
    NORTH((byte) 0,(byte) 1),
    EAST((byte) 1,(byte) 0),
    SOUTH((byte) 0,(byte) -1),
    WEST((byte) -1,(byte) 0);


    private byte    xMultiplier,
                    yMultiplier;

    Direction(byte xMultiplier, byte yMultiplier) {
        this.xMultiplier = xMultiplier;
        this.yMultiplier = yMultiplier;
    }

    public byte getXDirectionMultiplier() {
        return xMultiplier;
    }

    public byte getYDirectionMultiplier() {
        return yMultiplier;
    }
}
