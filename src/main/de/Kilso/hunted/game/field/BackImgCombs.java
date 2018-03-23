package main.de.Kilso.hunted.game.field;

import java.awt.*;

public enum BackImgCombs {
        NONE(0, 0),
        N(0, 3),
        E(1, 0),
        S(0, 1),
        W(3, 0),

        N_E(4, 1),
        E_S(4, 0),
        S_W(5, 0),
        W_N(5, 1),

        N_S(0, 2),
        E_W(2, 0),

        N_E_S(6, 0),
        E_S_W(7, 0),
        S_W_N(7, 1),
        W_N_E(6, 1),

        N_E_S_W(10, 3),
        N_NE_E_SE_S_SW_W_NW(2, 2),

        E_SE_S(1, 1),
        S_SW_W(3, 1),
        W_NW_N(3, 3),
        N_NE_E(1, 3),

        W_NW_N_NE_E(2, 3),
        N_NE_E_SE_S(1, 2),
        E_SE_S_SW_W(2, 1),
        S_SW_W_NW_N(3, 2),

        N_E_SE_S(4, 2),
        E_S_SW_W(5, 2),
        S_W_NW_N(5, 3),
        W_N_NE_E(4, 3),

        S_N_NE_E(6, 2),
        W_E_SE_S(7, 2),
        N_S_SW_W(7, 3),
        E_W_NW_N(6, 3),

        S_W_N_NE_E(8, 0),
        W_N_E_SE_S(9, 0),
        N_E_S_SW_W(9, 1),
        E_S_W_NW_N(8, 1),

        S_SW_W_NW_N_NE_E(8, 2),
        W_NW_N_NE_E_SE_S(9, 2),
        N_NE_E_SE_S_SW_W(9, 3),
        E_SE_S_SW_W_NW_N(8, 3),

        E_S_SW_W_NW_N(10, 0),
        S_W_NW_N_NE_E(11, 0),
        W_N_NE_E_SE_S(11, 1),
        N_E_SE_S_SW_W(10, 1),

        N_NE_E__S_SW_W(10, 2),
        W_NW_N__E_SE_S(11, 2),

        GROUND(11, 3),

        ERROR(-1, -1);

    private static RawField field;

    private Point tileCoords;

    public static BackImgCombs getBackgroundComb(RawField fieldR, Point co) {
        field = fieldR;
        if (    !nextTileIsSolid(co, 0,-1) &&
                !nextTileIsSolid(co, 1,0) &&
                !nextTileIsSolid(co, 0,1) &&
                !nextTileIsSolid(co, -1,0)
                ) {
            return NONE;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return N;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return E;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return S;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return N_E;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return E_S;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return S_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return W_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return N_S;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return E_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return N_E_S;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return E_S_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return S_W_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return W_N_E;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return N_E_S_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return N_NE_E_SE_S_SW_W_NW;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return E_SE_S;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return W_NW_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return N_NE_E;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return W_NW_N_NE_E;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return N_NE_E_SE_S;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return E_SE_S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return S_SW_W_NW_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return N_E_SE_S;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return E_S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return S_W_NW_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return W_N_NE_E;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,0)
                ) {
            return S_N_NE_E;
        } else if (
                !nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0)
                ) {
            return W_E_SE_S;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return N_S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return E_W_NW_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return S_W_N_NE_E;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return W_N_E_SE_S;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return N_E_S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return E_S_W_NW_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return S_SW_W_NW_N_NE_E;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return W_NW_N_NE_E_SE_S;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return N_NE_E_SE_S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return E_SE_S_SW_W_NW_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return E_S_SW_W_NW_N;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return S_W_NW_N_NE_E;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return W_N_NE_E_SE_S;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return N_E_SE_S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        !nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        !nextTileIsSolid(co, -1,-1)
                ) {
            return N_NE_E__S_SW_W;
        } else if (
                nextTileIsSolid(co, 0,-1) &&
                        !nextTileIsSolid(co, 1,-1) &&
                        nextTileIsSolid(co, 1,0) &&
                        nextTileIsSolid(co, 1,1) &&
                        nextTileIsSolid(co, 0,1) &&
                        !nextTileIsSolid(co, -1,1) &&
                        nextTileIsSolid(co, -1,0) &&
                        nextTileIsSolid(co, -1,-1)
                ) {
            return W_NW_N__E_SE_S;
        } else if (!nextTileIsSolid(co, 0,0)) {
            return GROUND;
        } else return ERROR;
    }

    BackImgCombs(int xTileCoord, int yTileCoord) {
        this.tileCoords = new Point(xTileCoord, yTileCoord);
    }

    public Point getTileCoords() {
        return tileCoords;
    }


    private static boolean nextTileIsSolid(Point point ,int xDistance, int yDistance) {
        if (    point.x + xDistance < 0 ||
                point.x + xDistance > field.getWidth() ||
                point.y + yDistance < 0 ||
                point.y + yDistance > field.getHeight()) {
            return true;
        } else {
            return field.get(point.x + xDistance, point.y + yDistance).isSolid();
        }
    }
}