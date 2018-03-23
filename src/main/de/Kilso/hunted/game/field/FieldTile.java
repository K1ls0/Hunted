package main.de.Kilso.hunted.game.field;

public class FieldTile {
    protected boolean solid;

    public boolean equals(Object obj) {
        return (obj instanceof FieldTile) && ((FieldTile)obj).isSolid();
    }

    public int hashCode() {
        return isSolid() ? 35875671 : 17657853;
    }

    public boolean isSolid() {
        return solid;
    }
}