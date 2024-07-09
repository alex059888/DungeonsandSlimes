package engine.entities.tiles.Terain.walls;

import org.joml.Vector2i;

import java.util.List;

public class WallTexSettings {

    private static List<WallTexSettings> wallSettings = List.of(
            new WallTexSettings(new Vector2i(0, 0), new Vector2i(0, 4), new Vector2i(1, 4), new Vector2i(0, 5), new Vector2i(1, 5),
                    new Vector2i(1, 0),new Vector2i(2, 0),new Vector2i(0, 2), new Vector2i(1, 2), new Vector2i(1, 3), new Vector2i(0, 3),
                    new Vector2i(3, 0), new Vector2i(2, 1), new Vector2i(1, 1), new Vector2i(3, 1), new Vector2i(4, 0), new Vector2i(5, 0),
                    new Vector2i(4, 1), new Vector2i(5, 1), new Vector2i(0, 1), new Vector2i(7, 1), new Vector2i(7, 0), new Vector2i(6, 0),
                    new Vector2i(6, 1), new Vector2i(3, 5), new Vector2i(5, 5), new Vector2i(2, 5), new Vector2i(4, 5), new Vector2i(6, 2), new Vector2i(7, 2), new Vector2i(4, 3),
                    new Vector2i(4, 4), new Vector2i(4, 2), new Vector2i(5, 3), new Vector2i(5, 4), new Vector2i(5, 2), new Vector2i(3, 3),
                    new Vector2i(3, 4), new Vector2i(3, 2), new Vector2i(2, 3), new Vector2i(2, 4), new Vector2i(2, 2), new Vector2i(6, 3),
                    new Vector2i(7, 3), new Vector2i(7, 4), new Vector2i(6, 4), 0)
    );

    public static WallTexSettings getWallSetting(int id) {
        return wallSettings.get(id);
    }

    private final int id;
    private final Vector2i fullWall,
            wallLeft, wallRight, wallUp, wallDown,
            wallUD, wallLR, wallUL, wallUR, wallDR, wallDL,
            wallRUL, wallURD, wallDLU, wallRDL,
            cornerUL, cornerUR,
            cornerDL, cornerDR,
            cornerAll, cornerLUR, cornerULD, cornerURD, cornerLDR, cornerL, cornerR, cornerU, cornerD, cornerURDL, cornerULDR,
            wallLcornerU, wallLcornerD, wallLcornerUD,
            wallRcornerU, wallRcornerD, wallRcornerUD,
            wallUcornerL, wallUcornerR, wallUcornerLR,
            wallDcornerL, wallDcornerR, wallDcornerLR,
            wallULcorner, wallURcorner, wallDRcorner, wallDLcorner;

    public WallTexSettings(Vector2i fullWall, Vector2i wallLeft, Vector2i wallRight, Vector2i wallUp, Vector2i wallDown, Vector2i wallUD, Vector2i wallLR, Vector2i wallUL, Vector2i wallUR, Vector2i wallDR, Vector2i wallDL, Vector2i wallRUL, Vector2i wallURD, Vector2i wallDLU, Vector2i wallRDL, Vector2i cornerUL, Vector2i cornerUR, Vector2i cornerDL, Vector2i cornerDR, Vector2i cornerAll, Vector2i cornerLUR, Vector2i cornerULD, Vector2i cornerURD, Vector2i cornerLDR, Vector2i cornerL, Vector2i cornerR, Vector2i cornerU, Vector2i cornerD, Vector2i cornerURDL, Vector2i cornerULDR, Vector2i wallLcornerU, Vector2i wallLcornerD, Vector2i wallLcornerUD, Vector2i wallRcornerU, Vector2i wallRcornerD, Vector2i wallRcornerUD, Vector2i wallUcornerL, Vector2i wallUcornerR, Vector2i wallUcornerLR, Vector2i wallDcornerL, Vector2i wallDcornerR, Vector2i wallDcornerLR, Vector2i wallULcorner, Vector2i wallURcorner, Vector2i wallDRcorner, Vector2i wallDLcorner, int id) {
        this.id = id;
        this.fullWall = fullWall;
        this.wallLeft = wallLeft;
        this.wallRight = wallRight;
        this.wallUp = wallUp;
        this.wallDown = wallDown;
        this.wallUD = wallUD;
        this.wallLR = wallLR;
        this.wallUL = wallUL;
        this.wallUR = wallUR;
        this.wallDR = wallDR;
        this.wallDL = wallDL;
        this.wallRUL = wallRUL;
        this.wallURD = wallURD;
        this.wallDLU = wallDLU;
        this.wallRDL = wallRDL;
        this.cornerUL = cornerUL;
        this.cornerUR = cornerUR;
        this.cornerDL = cornerDL;
        this.cornerDR = cornerDR;
        this.cornerAll = cornerAll;
        this.cornerLUR = cornerLUR;
        this.cornerULD = cornerULD;
        this.cornerURD = cornerURD;
        this.cornerLDR = cornerLDR;
        this.cornerL = cornerL;
        this.cornerR = cornerR;
        this.cornerU = cornerU;
        this.cornerD = cornerD;
        this.cornerURDL = cornerURDL;
        this.cornerULDR = cornerULDR;
        this.wallLcornerU = wallLcornerU;
        this.wallLcornerD = wallLcornerD;
        this.wallLcornerUD = wallLcornerUD;
        this.wallRcornerU = wallRcornerU;
        this.wallRcornerD = wallRcornerD;
        this.wallRcornerUD = wallRcornerUD;
        this.wallUcornerL = wallUcornerL;
        this.wallUcornerR = wallUcornerR;
        this.wallUcornerLR = wallUcornerLR;
        this.wallDcornerL = wallDcornerL;
        this.wallDcornerR = wallDcornerR;
        this.wallDcornerLR = wallDcornerLR;
        this.wallULcorner = wallULcorner;
        this.wallURcorner = wallURcorner;
        this.wallDRcorner = wallDRcorner;
        this.wallDLcorner = wallDLcorner;
    }

    public static List<WallTexSettings> getWallSettings() {
        return wallSettings;
    }

    public Vector2i getFullWall() {
        return fullWall;
    }

    public Vector2i getWallLeft() {
        return wallLeft;
    }

    public Vector2i getWallRight() {
        return wallRight;
    }

    public Vector2i getWallUp() {
        return wallUp;
    }

    public Vector2i getWallDown() {
        return wallDown;
    }

    public Vector2i getWallUL() {
        return wallUL;
    }

    public Vector2i getWallUR() {
        return wallUR;
    }

    public Vector2i getWallDR() {
        return wallDR;
    }

    public Vector2i getWallDL() {
        return wallDL;
    }

    public Vector2i getWallRUL() {
        return wallRUL;
    }

    public Vector2i getWallURD() {
        return wallURD;
    }

    public Vector2i getWallDLU() {
        return wallDLU;
    }

    public Vector2i getWallRDL() {
        return wallRDL;
    }

    public Vector2i getCornerUL() {
        return cornerUL;
    }

    public Vector2i getCornerUR() {
        return cornerUR;
    }

    public Vector2i getCornerDL() {
        return cornerDL;
    }

    public Vector2i getCornerDR() {
        return cornerDR;
    }

    public Vector2i getCornerAll() {
        return cornerAll;
    }

    public Vector2i getCornerLUR() {
        return cornerLUR;
    }

    public Vector2i getCornerULD() {
        return cornerULD;
    }

    public Vector2i getCornerURD() {
        return cornerURD;
    }

    public Vector2i getCornerLDR() {
        return cornerLDR;
    }

    public Vector2i getCornerL() {
        return cornerL;
    }

    public Vector2i getCornerR() {
        return cornerR;
    }

    public Vector2i getCornerU() {
        return cornerU;
    }

    public Vector2i getCornerD() {
        return cornerD;
    }

    public Vector2i getCornerURDL() {
        return cornerURDL;
    }

    public Vector2i getCornerULDR() {
        return cornerULDR;
    }

    public Vector2i getWallLcornerU() {
        return wallLcornerU;
    }

    public Vector2i getWallLcornerD() {
        return wallLcornerD;
    }

    public Vector2i getWallLcornerUD() {
        return wallLcornerUD;
    }

    public Vector2i getWallRcornerU() {
        return wallRcornerU;
    }

    public Vector2i getWallRcornerD() {
        return wallRcornerD;
    }

    public Vector2i getWallRcornerUD() {
        return wallRcornerUD;
    }

    public Vector2i getWallUcornerL() {
        return wallUcornerL;
    }

    public Vector2i getWallUcornerR() {
        return wallUcornerR;
    }

    public Vector2i getWallUcornerLR() {
        return wallUcornerLR;
    }

    public Vector2i getWallDcornerL() {
        return wallDcornerL;
    }

    public Vector2i getWallDcornerR() {
        return wallDcornerR;
    }

    public Vector2i getWallDcornerLR() {
        return wallDcornerLR;
    }

    public Vector2i getWallULcorner() {
        return wallULcorner;
    }

    public Vector2i getWallURcorner() {
        return wallURcorner;
    }

    public Vector2i getWallDRcorner() {
        return wallDRcorner;
    }

    public Vector2i getWallDLcorner() {
        return wallDLcorner;
    }

    public Vector2i getWallUD() {
        return wallUD;
    }

    public Vector2i getWallLR() {
        return wallLR;
    }

    public int getId() {
        return id;
    }
}
